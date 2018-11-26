/*
 * Copyright 1&1 Internet AG, https://github.com/1and1/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// File basedir = new File( "." );
File file = new File( basedir, "build.log" );
assert file.exists();

String buildLog = file.getText("UTF-8");
//assert !buildLog.contains('org.apache.maven.project.ProjectBuildingException');

assert !buildLog.contains('net.sourceforge.cobertura.reporting.xml.XMLReport');

assert new File( basedir, "target/failsafe-reports/failsafe-summary.xml").exists();
assert new File( basedir, "target/site/failsafe-report.html").exists();

assert new File( basedir, "target/cpd.xml" ).exists();
assert new File( basedir, "target/site/cpd.html" ).exists();

assert new File( basedir, "target/pmd.xml" ).exists();
assert new File( basedir, "target/site/pmd.html" ).exists();

assert new File( basedir, "target/spotbugsXml.xml" ).exists();
assert new File( basedir, "target/site/spotbugs.html" ).exists();

assert new File( basedir, "target/checkstyle-result.xml" ).exists();
assert new File( basedir, "target/site/checkstyle.html" ).exists();

assert new File( basedir, "target/site/jacoco/index.html" ).exists();
assert new File( basedir, "target/site/jacoco/jacoco.xml" ).exists();

assert new File( basedir, "target/site/xref/index.html" ).exists();

assert new File( basedir, "target/apidocs/index.html" ).exists();
assert new File( basedir, "target/site/apidocs/index.html" ).exists();

if (System.getenv('CI') == null) {
    assert new File( basedir, "target/site/github-report.html").exists();
}

File[] files = new File( basedir, "target/repo/net/oneandone/maven/poms/sample-project-jacoco/3000-SNAPSHOT/").listFiles();
assert files.toString().findAll("sample-project-jacoco-3000-.*-sources\\.jar").size()>0;
assert files.toString().findAll("sample-project-jacoco-3000-.*-javadoc\\.jar").size()>0;

return true;
