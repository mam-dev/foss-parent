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
