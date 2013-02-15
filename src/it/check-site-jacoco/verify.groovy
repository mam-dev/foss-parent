File file = new File( basedir, "build.log" );
assert file.exists();

String buildLog = file.getText("UTF-8");
assert !buildLog.contains('org.apache.maven.project.ProjectBuildingException');

assert !buildLog.contains('net.sourceforge.cobertura.reporting.xml.XMLReport')

assert new File( basedir, "target/jenkins-description.html").exists();

assert new File( basedir, "target/failsafe-reports/failsafe-summary.xml").exists();
assert new File( basedir, "target/site/failsafe-report.html").exists();

assert new File( basedir, "target/cpd.xml" ).exists();
assert new File( basedir, "target/site/cpd.html" ).exists();

assert new File( basedir, "target/pmd.xml" ).exists();
assert new File( basedir, "target/site/pmd.html" ).exists();

assert new File( basedir, "target/findbugs.xml" ).exists();
assert new File( basedir, "target/site/findbugs.html" ).exists();

assert new File( basedir, "target/checkstyle-result.xml" ).exists();
assert new File( basedir, "target/site/checkstyle.html" ).exists();

assert new File( basedir, "target/site/jacoco/index.html" ).exists();
assert new File( basedir, "target/site/jacoco/jacoco.xml" ).exists();

assert new File( basedir, "target/site/xref/index.html" ).exists();

assert new File( basedir, "target/apidocs/index.html" ).exists();
assert new File( basedir, "target/site/apidocs/index.html" ).exists();

assert new File( basedir, "target/site/github-report.html").exists();

return true;
