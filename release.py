#!/usr/bin/env python3
import json
import os
import sys
import urllib.request
import urllib.parse
import urllib.error

ORG_AND_PROJECT = os.environ.get("ORG_AND_PROJECT", "1and1/foss-parent")

class GithubApi(object):

    def __init__(self, org_and_project, milestone):
        self._base_url = "https://api.github.com/repos/{}".format(org_and_project)
        self._milestone = milestone
        self.milestone_info = None
        self._fetch_milestone_info()

    def retrieve_open_issues(self):
        """
        >>> GithubApi(ORG_AND_PROJECT, 49).retrieve_open_issues()
        []
        """
        return self._retrieve_issues("open")

    def retrieve_closed_issues(self):
        """
        >>> len(GithubApi(ORG_AND_PROJECT, 49).retrieve_closed_issues())
        2
        """
        return self._retrieve_issues("closed")

    def _retrieve_issues(self, state):
        milestone_ = "{}/issues?milestone={}&state={}".format(self._base_url, self._milestone, state)
        with urllib.request.urlopen(milestone_) as h:
            return json.load(h)

    def _fetch_milestone_info(self):
        """
        >>> gh = GithubApi(ORG_AND_PROJECT, 49); mi = gh.milestone_info; mi['title'], mi['open_issues'], mi['closed_issues']
        ('1.5.12', 0, 2)
        """
        milestones = "{}/milestones/{}".format(self._base_url, self._milestone)
        with urllib.request.urlopen(milestones) as h:
            self.milestone_info = json.load(h)

    def has_open_issues(self):
        """
        >>> gh = GithubApi(ORG_AND_PROJECT, 49); gh.has_open_issues()
        False
        """
        return self.milestone_info["open_issues"] > 0

    def formatted_issues(self, formatstring, issues):
        ftitle = formatstring.format(self._milestone, self.milestone_info["title"])
        return "{}:\n{}".format(
            ftitle,
            "\n".join("#{number} {title}".format(**issue) for issue in issues)
        )

if __name__ == "__main__":
    if os.environ.get("GPG_AGENT_INFO") is None:
        sys.exit("GPG_AGENT not started")
    if len(sys.argv) != 3:
        sys.exit("Usage: %s previousVersion milestone, e.g. %s 1.3.10 20" % (sys.argv[0], sys.argv[0]))
    previous_version = sys.argv[1]
    milestone = sys.argv[2]
    gh = GithubApi(ORG_AND_PROJECT, milestone)
    if gh.has_open_issues():
        open_issues = gh.retrieve_open_issues()
        sys.exit(gh.formatted_issues(
            "Found open issues on github for milestone {} (title: {})",
            open_issues
        ))
    else:
        closed_issues = gh.retrieve_closed_issues()
        print((gh.formatted_issues(
            "Found closed issues on github for milestone {} (title: {})",
            closed_issues
        )))
    release_version = gh.milestone_info["title"]
    cmd = """\
mvn \
-Darguments="-DpreviousVersion={previous_version} -Dmilestone={milestone}" \
-DdevelopmentVersion=1-SNAPSHOT \
-DreleaseVersion={release_version} \
-DpushChanges=false \
-DlocalCheckout=true \
-Dgoals="deploy changes:announcement-generate@default-announcement-generate" \
release:prepare release:perform
    """.format(**locals())
    commands = [cmd, "git push --tags", "mvn release:clean", "git reset origin/master", "git checkout ."]
    input("About to execute:\n%s\nHit enter to proceed, CTRL+D to cancel" % commands)
    for command in commands:
        rc = os.system(command)
        if rc != 0:
            sys.exit(rc)
