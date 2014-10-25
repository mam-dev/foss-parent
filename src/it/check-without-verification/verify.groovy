File file = new File( basedir, "build.log" );
assert file.exists();

String buildLog = file.getText("UTF-8");
assert !buildLog.contains('org.apache.maven.project.ProjectBuildingException');

assert buildLog.contains('Skipping JaCoCo execution')

assert !new File( basedir, "target/cpd.xml" ).exists();

assert !new File( basedir, "target/pmd.xml" ).exists();

assert !new File( basedir, "target/findbugs.xml" ).exists();

assert !new File( basedir, "target/checkstyle-result.xml" ).exists();

assert !new File( basedir, "target/checkstyle-result.xml" ).exists();

return true;
