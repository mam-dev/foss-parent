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
File file = new File( basedir, "build.log" );
assert file.exists();

String buildLog = file.getText("UTF-8");
//assert !buildLog.contains('org.apache.maven.project.ProjectBuildingException');

assert buildLog.contains('Skipping JaCoCo execution')

assert !new File( basedir, "target/cpd.xml" ).exists();

assert !new File( basedir, "target/pmd.xml" ).exists();

assert !new File( basedir, "target/findbugs.xml" ).exists();

assert !new File( basedir, "target/checkstyle-result.xml" ).exists();

assert !new File( basedir, "target/checkstyle-result.xml" ).exists();

return true;
