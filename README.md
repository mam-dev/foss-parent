Parent POM for 1-and-1 open source projects.


Usage Tips:

* deploy site to github: Add 

   <servers>
     <server>
       <id>github</id>
       <username>GitHubLogin</username>
       <password>GitHubPassw0rd</password>
     </server>
   </servers>

  to your settings.xml and run

     mvn site com.github.github:site-maven-plugin:site
