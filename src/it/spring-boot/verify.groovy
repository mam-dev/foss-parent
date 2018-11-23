// File basedir = new File( "." );
File file = new File(basedir, "build.log")
assert file.exists()

String buildLog = file.getText("UTF-8")

assert !buildLog.contains('net.sourceforge.cobertura.reporting.xml.XMLReport')

assert new File(basedir, "target/failsafe-reports/failsafe-summary.xml").exists()

assert new File(basedir, "target/cpd.xml").exists()

assert new File(basedir, "target/pmd.xml").exists()

assert new File(basedir, "target/spotbugsXml.xml").exists()

assert new File(basedir, "target/checkstyle-result.xml").exists()

assert new File(basedir, "target/jacoco.exec").exists()

File[] files = new File(basedir, "target/").listFiles()
assert files.toString().findAll("sample-project-spring-boot-3000-SNAPSHOT-sources\\.jar").size() > 0
assert files.toString().findAll("sample-project-spring-boot-3000-SNAPSHOT\\.jar").size() > files.toString().findAll("sample-project-spring-boot-3000-SNAPSHOT\\.jar\\.original").size()
return true
