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
File file = new File(basedir, "build.log")
File targetDir = new File(basedir, "target")

assert file.exists()
assert targetDir.exists()

[
    'failsafe-reports/failsafe-summary.xml',
    'failsafe-reports/failsafe-summary.xml',
    'cpd.xml',
    'pmd.xml',
    'spotbugsXml.xml',
    'checkstyle-result.xml',
    'jacoco.exec',
    'surefire-reports/TEST-net.oneandone.maven.poms.sampleprojectspringboot.SpockTest.xml'
].forEach {
    assert new File(targetDir, it).exists()
}

File[] files = targetDir.listFiles()
assert files.toString().findAll("sample-project-spring-boot-3000-SNAPSHOT-sources\\.jar").size() > 0
assert files.toString().findAll("sample-project-spring-boot-3000-SNAPSHOT\\.jar").size() > files.toString().findAll("sample-project-spring-boot-3000-SNAPSHOT\\.jar\\.original").size()
return true
