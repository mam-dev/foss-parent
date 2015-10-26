File file = new File( basedir, "build.log" );
assert file.exists();

String buildLog = file.getText("UTF-8");
//assert !buildLog.contains('org.apache.maven.project.ProjectBuildingException');

assert !buildLog.contains('net.sourceforge.cobertura.reporting.xml.XMLReport')

return true;
