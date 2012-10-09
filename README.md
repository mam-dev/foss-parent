Parent POM for 1-and-1 open source projects. 

Contains common configuration for projects that use github and Sonatype OSS Repository Hosting.
Default License is Apache 2.0.


Releasing a project
-------------------

... to [Maven Central](http://maven.apache.org/guides/mini/guide-central-repository-upload.html ) via [Sonatype OSS Repository Hosting](https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide):

* add the following to your settings (see [general instructions](http://maven.apache.org/plugins/maven-site-plugin/examples/site-deploy-to-sourceforge.net.html)):

>     <settings>
>       <servers>
>         <server>
>           <id>sonatype-nexus-snapshots</id>
>           <username>sonatype-user</username>
>           <password>sonatype-pwd</password>
>         </server>
>         <server>
>           <id>sonatype-nexus-staging</id>
>           <username>sonatype-user</username>
>           <password>sonatype-pwd</password>
>         </server>
>       </servers>
>       <profiles>
>         <profile>
>           <id>release-properties</id>
>           <activation>
>             <property>
>               <name>performRelease</name>
>               <value>true</value>
>             </property>
>           </activation>
>         </profile>
>       </profiles>
>     </settings>

* `mvn release:prepare`
* `mvn release:perform`
* close and release staging repository: https://oss.sonatype.org/index.html#stagingRepositories

TODO: http://www.sonatype.com/books/nexus-book/reference/staging-sect-managing-plugin.html

Deploy site to github
---------------------

Add 

>     <servers>
>       <server>
>         <id>github</id>
>         <username>GitHubLogin</username>
>         <password>GitHubPassw0rd</password>
>       </server>
>     </servers>

to your settings.xml and run

>     mvn site com.github.github:site-maven-plugin:site


Adjust license headers
----------------------

>     mvn com.mycila.maven-license-plugin:maven-license-plugin:format

