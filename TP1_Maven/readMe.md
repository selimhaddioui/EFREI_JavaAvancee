
# Discovering Maven  

---

## First part  

* What is *bin/m2.conf* file about ?  

  *m2.conf* file is used to configure Maven.  
  When we go into the file it look like this is a script that load `.jar` files and set variables.  
  We also can see inside *mvn* file, which contain the script of the same name command, that m2.conf is executed during `mvn` command.  

* Analyze *conf* repository.  

  *conf* repository contain *settings.xml*, *toolchains.xml* and *simplelogger.properties* which are three files that allow to edit default configuration such as path of the local repository, mirror repository, and a lot of others configs.  

* What is `localRepository` tag used for in *settings.xml* file ?  

  As comments in *settings.xml* file say :  

  > The path to the local repository maven will use to store artifacts.  

  In other words, by using it we can change local repository from .m2 to anything we want so all dependance we download will be where we want it to be.  

* Write on **command prompt** `mvn -v`.  

  Output :  

  > Apache Maven 3.8.7 (b89d5959fcde851dcb1c8946a785a163f14e1e29)  
  Maven home: C:\Maven\apache-maven-3.8.7  
  Java version: 1.8.0_311, vendor: Oracle Corporation, runtime: C:\Program   Files\Java\jdk1.8.0_311\jre  
  Default locale: fr_FR, platform encoding: Cp1252  
  OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"  

---

## Second part

* Write on **command prompt** `mvn` without any argument. Maven will throw an error and list all available project phase. What are they ?  

  Output :  

  >[INFO] Scanning for projects...  
  [INFO] ------------------------------------------------------------------------  
  [INFO] BUILD FAILURE  
  [INFO] ------------------------------------------------------------------------  
  [INFO] Total time:  0.073 s  
  [INFO] Finished at: 2023-02-19T16:33:13+01:00  
  [INFO] ------------------------------------------------------------------------  
  [ERROR] No goals have been specified for this build. You must specify a valid lifecycle phase or a goal in the format <plugin-prefix>:<goal> or <plugin-group-id>:<plugin-artifact-id>[:<plugin-version>]:<goal>. Available lifecycle phases are: validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy, pre-clean, clean, post-clean, pre-site, site, post-site, site-deploy. -> [Help 1]  
  [ERROR]  
  [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.  
  [ERROR] Re-run Maven using the -X switch to enable full debug logging.  
  [ERROR]  
  [ERROR] For more information about the errors and possible solutions, please read the following articles:  
  [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/NoGoalSpecifiedException.    

  As **command prompt** say, available lifecycle phases are :  

  > validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy, pre-clean, clean, post-clean, pre-site, site, post-site, site-deploy.  

* Create a repository, launch **command prompt** from it and write below command.  

  ```sh  
  mvn archetype:generate -B -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=fr.efrei.mavenapps -DartifactId=MyApp -Dversion=1.0-SNAPSHOT -DpackageName=fr.efrei.mavenapps
  ```  
  Output :  

   > [INFO] Scanning for projects...  
  [INFO]  
  [INFO] ------------------< org.apache.maven:standalone-pom >-------------------  
  [INFO] Building Maven Stub Project (No POM) 1  
  [INFO] --------------------------------[ pom ]---------------------------------  
  [INFO]  
  [INFO] >>> maven-archetype-plugin:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>  
  [INFO]  
  [INFO] <<< maven-archetype-plugin:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<  
  [INFO]  
  [INFO]  
  [INFO] --- maven-archetype-plugin:3.2.1:generate (default-cli) @ standalone-pom ---  
  [INFO] Generating project in Batch mode  
  [INFO] ----------------------------------------------------------------------------  
  [INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.0  
  [INFO] ----------------------------------------------------------------------------  
  [INFO] Parameter: basedir, Value: C:\Users\%USER%\source\repos\Java\TP1_Maven  
  [INFO] Parameter: package, Value: fr.efrei.mavenapps  
  [INFO] Parameter: groupId, Value: fr.efrei.mavenapps  
  [INFO] Parameter: artifactId, Value: MyApp  
  [INFO] Parameter: packageName, Value: fr.efrei.mavenapps  
  [INFO] Parameter: version, Value: 1.0-SNAPSHOT  
  [INFO] project created from Old (1.x) Archetype in dir: C:\Users\%USER%\source\repos\Java\TP1_Maven\MyApp  
  [INFO] ------------------------------------------------------------------------  
  [INFO] BUILD SUCCESS  
  [INFO] ------------------------------------------------------------------------  
  [INFO] Total time:  2.935 s  
  [INFO] Finished at: 2023-02-19T16:39:12+01:00  
  [INFO] ------------------------------------------------------------------------  

  Maven has created a project using *quickstart template*, domain name called here *groupeId*, project name called here *artifactId*, *packageName* and *version* number. Basically there is now a repository *myApp* in the repository we previously created. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/7c2bfec9eafefd120a1251ee2bce86982e624546).

  * What king of files are download and where are they stored ?  

    #TODO files are download and they are stored #TODO  

* Analyze *.m2* repository created by Maven at `C:\Users\%USERNAME%\`.  

  This repository is our local repository mentioned in first part. It store all dependances we download.  

* Analyze *mavenapps* repository.  

  This repository is about #TODO.  

* Edit *App.java* and observe it.  

  Don't know what #TODO there.  

* Edit *TestApp.java* and observe it.

  Still don't know what #TODO.  

* Analyze *pom.xml*

  * What is `scope` tag for in JUnit dependance ?  

    `scope` tag in JUnit is for #TODO.  

  * What others tags can we found in *pom.xml* file ?  

    We can found `#todo`, `#todo` and `#todo` tags in *pom.xml* file that are used for.  

* Using **command prompt** from *myApp* repository write `mvn compile`.  

  Output :  

  > Here is the output  

  #TODO happened.  

* Download then add following section to configure compilator with right version.  

  #TODO copy and paste code from TP file there.  

* Again, write `mvn compile`.  

  Output :  

  > Here is the output.  

  It did this #TODO.  

* Analyze *myApp/Target* repository that has been created.  

  We might see #TODO.  

* Write `mvn test` in **command prompt**.  

  Output :  

  > Here is the output.  

  These happened #TODO.  

  * Again, analyze *myApp/target* repository.  

    We can see #TODO.  

  * Analyze *myApp/target/surefire-reports* repository.  

    We can see #TODO.  

* Write `mvn package` in **command prompt**.  

  Output :  

  > Here is the output.  

  #Todo happened.  

  * Again, analyze *myApp/target* repository.  

    We can find in it #TODO.  

* What is the relation with `mvn compile` ?  

  The relation is about #TODO.  

* Write below command in **command prompt**.  

  ```sh  
  java -cp target/myApp-1.0-SNAPSHOT.jar fr.efrei.mavenapps.App
  ```  

    Output :  

    > Here is the output.  

    #TODO happened.  

* Write `mvn install` in **command prompt**.

  Output :  

  > Here is the output.  

  #TODO happened.  

* What is a local repository ?  

  A local repository store all dependances that has been download and needed for the user in his projects. It can be dependances that was made by the user or someone else.  

* Where is the default local repository ?  

  The default local repository is called *.m2* and can be found at `C:\Users\%USERNAME%\`.  

* How to switch it ?  

  In order to switch it we have to edit `localRepository` tag from *settings.xml* file.  

* Show that the jar of the app is now in the local repository and where exactly.  

  When we write `mvn #todo` a repository is created at `%USER_HOME%/.m2/repository` and in our case we can see that the jar is saved in `%USER_HOME%/.m2/repository/fr/efrei/demomaven` with `%USER_HOME` the path for `C:\Users\%USERNAME`.  

* Write `mvn clean` in **command prompt**.  

  Output :  

  > Here is the output.  

  #TODO happened.  

* Write `mvn clean install` in **command prompt**.  

  Output :  

  > Here is the output.  

  #TODO happened.   

---
