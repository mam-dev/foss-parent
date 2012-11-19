File file = new File( basedir, "build.log" );
assert file.exists();

String buildLog = file.getText("UTF-8");
assert !buildLog.contains('org.apache.maven.project.ProjectBuildingException');

assert new File( basedir, "target/cpd.xml" ).exists();
assert new File( basedir, "target/site/cpd.html" ).exists();

assert new File( basedir, "target/pmd.xml" ).exists();
assert new File( basedir, "target/site/pmd.html" ).exists();

assert new File( basedir, "target/findbugs.xml" ).exists();
assert new File( basedir, "target/site/findbugs.html" ).exists();

assert new File( basedir, "target/checkstyle-result.xml" ).exists();
assert new File( basedir, "target/site/checkstyle.html" ).exists();

assert new File( basedir, "target/site/cobertura/index.html" ).exists();
assert new File( basedir, "target/site/cobertura/coverage.xml" ).exists();

assert new File( basedir, "target/site/xref/index.html" ).exists();

assert new File( basedir, "target/apidocs/index.html" ).exists();
assert new File( basedir, "target/site/apidocs/index.html" ).exists();

assert new File( basedir, "target/site/github-report.html").exists();

return true;
