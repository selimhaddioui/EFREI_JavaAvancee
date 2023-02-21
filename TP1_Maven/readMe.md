
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

  In other words, by using it we can change local repository from .m2 to anything we want so all dependencies we download will be where we want it to be.  

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
  mvn archetype:generate -B "-DarchetypeArtifactId=maven-archetype-quickstart" "-DgroupId=fr.efrei.mavenapps" "-DartifactId=MyApp" "-Dversion=1.0-SNAPSHOT" "-DpackageName=fr.efrei.mavenapps"
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
  [INFO] Parameter: basedir, Value: C:\Users\\%USERNAME%\source\repos\JavaAv\TP1_Maven  
  [INFO] Parameter: package, Value: fr.efrei.mavenapps  
  [INFO] Parameter: groupId, Value: fr.efrei.mavenapps  
  [INFO] Parameter: artifactId, Value: MyApp  
  [INFO] Parameter: packageName, Value: fr.efrei.mavenapps  
  [INFO] Parameter: version, Value: 1.0-SNAPSHOT  
  [INFO] project created from Old (1.x) Archetype in dir: C:\Users\\%USERNAME%\source\repos\JavaAv\TP1_Maven\MyApp  
  [INFO] ------------------------------------------------------------------------  
  [INFO] BUILD SUCCESS  
  [INFO] ------------------------------------------------------------------------  
  [INFO] Total time:  2.935 s  
  [INFO] Finished at: 2023-02-19T16:39:12+01:00  
  [INFO] ------------------------------------------------------------------------  

  Maven created a project using *quickstart template*, domain name called here *groupId*, project name called here *artifactId*, *packageName* and *version* number. Basically there is now a repository *myApp* in the repository we previously created. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/7c2bfec9eafefd120a1251ee2bce86982e624546).

  * What kind of files are download and where are they saved ?  

    *pom.xml*, *App.java*, *AppTest.java* are all files that have been created. *pom.xml* contain the project object model that describe our project and *.java* files contain our code and tests. *pom.xml* is saved in the main repository called with the *artifactId* here *MyApp*. *.java* file are saved in subrepository that respect *groupId* pattern. So they are in  `MyApp\src\(main|test)\java\fr\efrei\mavenapps\`.  

* Analyze *.m2* repository created by Maven at `C:\Users\%USERNAME%\`.  

  This repository is our local repository mentioned in first part. It contains all dependencies and artifacts we download.  

* Analyze *mavenapps* sub-repository.  

  There is no sub-repository named *mavenapps* in *.m2* repository but we can found two of them at the end of both of our path created in *MyApp* repository. Both contain *.java* file, one is about our source code, the other about testing our source code.  

* Edit *App.java* and observe it.  

  ```java  
  package fr.efrei.mavenapps;  

  /**
  * Hello world, this is Minh-Tri!
  *
  */
  public class App
  {
    public static void main( String[] args )
    {
      int age = 20;
      System.out.println( "Hello World, this is Minh-Tri!" );
      System.out.println( "I am " + age + " years old!" );
    }
  }
  ```
  Only thing that we can say is that this is a Java program.

* Edit *TestApp.java* and observe it.

  ```java  
  package fr.efrei.mavenapps;  

  import junit.framework.Test;  
  import junit.framework.TestCase;  
  import junit.framework.TestSuite;  

  /**  
   * Unit test for simple App.  
   */  
  public class AppTest  
      extends TestCase  
  {  
      /**  
       * Create the test case  
       *  
       * @param testName name of the test case  
       */  
      public AppTest( String testName )  
      {  
          super( testName );  
      }  

      /**  
       * @return the suite of tests being tested  
       */  
      public static Test suite()  
      {  
          return new TestSuite( AppTest.class );  
      }  

      /**  
       * Rigourous Test :-)  
       */  
      public void testApp()  
      {  
          int minhTriAge = 20;  
          boolean isMinor = minhTriAge < 18;  
          assertFalse(isMinor);  
      }  
  }   
  ```  
  Only thing we can say is that this is a Java program that contain a test class.

* Analyze *pom.xml*  

  As we say before, *pom.xml* describe through different tags what is the project about and how do we work with it (build, compile, test, execution, ...). We can found in it the arguments that we gave to maven to build it.  

  * What is `scope` tag for in JUnit dependance ?  

    `scope` tag in JUnit is to know where JUnit dependance will be used, in our case it is in test class path.  

  * What others tags can we found in *pom.xml* file ?  

    We can also found `version`, `artifactId` and `groupId` tags in *pom.xml* which are arguments that we gave to maven to build the project.

* Using **command prompt** from *myApp* repository write `mvn compile`.  

  Output :  

  > [INFO] Scanning for projects...  
    [INFO]  
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------  
    [INFO] Building MyApp 1.0-SNAPSHOT  
    [INFO] --------------------------------[ jar ]---------------------------------  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\\%USERNAME%\source\repos\JavaAv\TP1_Maven\MyApp\src\main\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ MyApp ---  
    [INFO] Changes detected - recompiling the module!  
    [WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!  
    [INFO] Compiling 1 source file to C:\Users\\%USERNAME%\source\repos\JavaAv\TP1_Maven\MyApp\target\classes  
    [INFO] ------------------------------------------------------------------------  
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------  
    [INFO] Total time:  1.605 s  
    [INFO] Finished at: 2023-02-19T19:10:40+01:00  
    [INFO] ------------------------------------------------------------------------  

  `MyApp\target\classes\${groupId}\App.class` and `MyApp\target\maven-status\maven-compiler-plugin\compile\default-compile\(created|input)Files.lst` have been created. *createdFiles.lst* contain the list of all created files from the compilation in string format, and *inputFiles.lst* contain the list of all files that have been compiled. *App.class* is the result of the compilation of *App.java*. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/91960bf8ad7b00c279f67197f406bb9de2326a78).  

* Add following section to *pom.xml* to configure compilator with right version.  

  ```xml  
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>2.3.2</version>
        <configuration>
          <source>${your_jdk_version}</source>
          <target>${your_jdk_version}</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
  ```

  See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/cc23d53d112d70e67302f08e9e521e1e1d7fd4ac).

* Again, write `mvn compile`.  

  Output :  
  > [INFO] Scanning for projects...  
    [INFO]  
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------  
    [INFO] Building MyApp 1.0-SNAPSHOT  
    [INFO] --------------------------------[ jar ]---------------------------------  
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/2.3.2/maven-compiler-plugin-2.3.2.pom  
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/2.3.2/maven-compiler-plugin-2.3.2.pom (7.3 kB at 18 kB/s)  
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/2.3.2/maven-compiler-plugin-2.3.2.jar  
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/2.3.2/maven-compiler-plugin-2.3.2.jar (29 kB at 360 kB/s)  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\main\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ MyApp ---  
    [INFO] Nothing to compile - all classes are up to date  
    [INFO] ------------------------------------------------------------------------  
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------  
    [INFO] Total time:  2.257 s  
    [INFO] Finished at: 2023-02-19T21:07:06+01:00  
    [INFO] ------------------------------------------------------------------------   

  We can see that it download from maven online repository the compilator plugin that we just add to *pom.xml*. We also see that compiling did nothing because all classes were up to date even if it was using the new compilator.

* Analyze *myApp/Target* repository that has been created.  

  Already done after explaining what the first `mvn compile` has done but to put it in a nutshell *target* repository contain all file created by Maven.  

* Write `mvn test` in **command prompt**.  

  Output :  

  > [INFO] Scanning for projects...  
    [INFO]  
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------  
    [INFO] Building MyApp 1.0-SNAPSHOT  
    [INFO] --------------------------------[ jar ]---------------------------------  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory   C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\main\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ MyApp ---  
    [INFO] Nothing to compile - all classes are up to date  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory   C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\test\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ MyApp ---  
    [WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!  
    [INFO] Compiling 1 source file to   C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\test-classes  
    [INFO]  
    [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ MyApp ---  
    [INFO] Surefire report directory:   C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\surefire-reports  
    T E S T S  
    Running fr.efrei.mavenapps.AppTest  
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.01 sec  
    Results :  
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0  
    [INFO] ------------------------------------------------------------------------  
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------  
    [INFO] Total time:  1.513 s  
    [INFO] Finished at: 2023-02-19T22:48:48+01:00  
    [INFO] ------------------------------------------------------------------------  

  Test were ran and passed. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/b86d3b3cbcd95132401ce5a94b479fad14e72800).  

  * Again, analyze *myApp/target* repository.  

    We can see that `target\generated-sources\test-annotations\` and `target\surefire-reports\` repository have been created. Also `test-classes\${groupId}\AppTest.class` file contains the output compiled test class.

  * Analyze *myApp/target/surefire-reports* repository.  

    We can see that two files `surefire-reports\${groupdId}.AppTest.txt` and `surefire-reports\TEST-${groupdId}.AppTest.xml` have been created. The first one contain the result of the test, the second one contain the configuration of the test during the run.  

* Write `mvn package` in **command prompt**.  

  Output :  

  > [INFO] Scanning for projects...  
    [INFO]  
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------    
    [INFO] Building MyApp 1.0-SNAPSHOT  
    [INFO] --------------------------------[ jar ]---------------------------------  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\main\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ MyApp ---  
    [INFO] Nothing to compile - all classes are up to date  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\test\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ MyApp ---  
    [INFO] Nothing to compile - all classes are up to date  
    [INFO]    
    [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ MyApp ---  
    [INFO] Surefire report directory: C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\surefire-reports  
     T E S T S  
    Running fr.efrei.mavenapps.AppTest    
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.016 sec    
    Results :  
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0  
    [INFO]  
    [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ MyApp ---  
    [INFO] Building jar: C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\MyApp-1.0-SNAPSHOT.jar   
    [INFO] ------------------------------------------------------------------------   
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------   
    [INFO] Total time:  3.717 s   
    [INFO] Finished at: 2023-02-20T14:20:41+01:00   
    [INFO] ------------------------------------------------------------------------      

  Two files have been created `TP1_Maven/MyApp/target/maven-archiver/pom.properties` and `TP1_Maven/MyApp/target/MyApp-1.0-SNAPSHOT.jar` and test reports have been edited. It look like tests have been run and reports updated. Also a *.jar* has been created.   

   * Again, analyze *myApp/target* repository.  

    We can find in it new file and directory mentioned before. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/8369ddef09cba4aa50cbf595d307b6e803b3a5ee)   

* What is the relation with `mvn compile` ?  

  `mvn package` seem to create a package (here a *.jar*) from compiled code (here *.class* files) and `mvn compile` generate compiled code.   

* Write below command in **command prompt**.  

  ```sh  
  java -cp target/myApp-1.0-SNAPSHOT.jar fr.efrei.mavenapps.App
  ```  

  Output :
  > Hello World, this is Minh-Tri\!  
  I am 20 years old!  

  It seem that the source code has been executed using *.jar* file.  

* Write `mvn install` in **command prompt**.

  Output :  

  > [INFO] Scanning for projects...  
    [INFO]  
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------  
    [INFO] Building MyApp 1.0-SNAPSHOT  
    [INFO] --------------------------------[ jar ]---------------------------------  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\main\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ MyApp ---  
    [INFO] Nothing to compile - all classes are up to date   
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\test\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ MyApp ---  
    [INFO] Nothing to compile - all classes are up to date  
    [INFO]  
    [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ MyApp ---  
    [INFO] Surefire report directory: C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\surefire-reports  
     T E S T S  
    Running fr.efrei.mavenapps.AppTest  
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 sec  
    Results :  
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0  
    [INFO]  
    [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ MyApp ---  
    [INFO]  
    [INFO] --- maven-install-plugin:2.4:install (default-install) @ MyApp ---  
    [INFO] Installing C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\MyApp-1.0-SNAPSHOT.jar to   C:\Users\selim\.m2\repository\fr\efrei\mavenapps\MyApp\1.0-SNAPSHOT\MyApp-1.0-SNAPSHOT.jar  
    [INFO] Installing C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\pom.xml to   C:\Users\selim\.m2\repository\fr\efrei\mavenapps\MyApp\1.0-SNAPSHOT\MyApp-1.0-SNAPSHOT.pom  
    [INFO] ------------------------------------------------------------------------  
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------  
    [INFO] Total time:  1.513 s  
    [INFO] Finished at: 2023-02-20T22:39:12+01:00  
    [INFO] ------------------------------------------------------------------------  

  Some edit in *surefire-reports* directory happened. Also a repository has been added to *.m2* local repository. It contain our project. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/bfb835f52bc815df4772021556020630fecad441)

* What is a local repository ?  

  A local repository contains all dependencies and artifacts that have been download and needed for the user in his projects. It can be dependencies that was made by the user or someone else. In the preview question we installed our program in our local repository  

* Where is the default local repository ?  

  The default local repository is called *.m2* and can be found at `C:\Users\%USERNAME%\`. Default path to local repository can be found in `localRepository` tag in `%MAVEN_HOME%\conf\settings.xml` file.

* How to switch it ?  

  In order to switch it we've to edit `localRepository` tag from *settings.xml* file.  

* Show that the jar of the app is now in the local repository and where exactly.  

  When we write `mvn install` a repository is created at `%USER_HOME%/.m2/repository` and in our case we can see that the jar is saved in `%USER_HOME%/.m2/repository/${groupId}/MyApp/1.0-SNAPSHOT/` with `%USER_HOME` the path for `C:\Users\%USERNAME`.  

* Write `mvn clean` in **command prompt**.  

  Output :  

  > [INFO] Scanning for projects...  
    [INFO]  
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------  
    [INFO] Building MyApp 1.0-SNAPSHOT  
    [INFO] --------------------------------[ jar ]---------------------------------  
    [INFO]  
    [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ MyApp ---  
    [INFO] Deleting C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target  
    [INFO] ------------------------------------------------------------------------  
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------  
    [INFO] Total time:  0.223 s  
    [INFO] Finished at: 2023-02-20T22:54:53+01:00  
    [INFO] ------------------------------------------------------------------------   

  *target* directory has been deleted. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/ceca708655f517b6e641f10fd2b2dce82c212b3d).  

* Write `mvn clean install` in **command prompt**.  

  Output :  

  > [INFO] Scanning for projects...   
    [INFO]    
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------  
    [INFO] Building MyApp 1.0-SNAPSHOT  
    [INFO] --------------------------------[ jar ]---------------------------------  
    [INFO]  
    [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ MyApp ---  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ MyApp ---  
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\main\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:compile (default-compile) @ MyApp ---  
    [WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!  
    [INFO] Compiling 1 source file to C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\classes  
    [INFO]  
    [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ MyApp ---   
    [WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!  
    [INFO] skip non existing resourceDirectory C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\src\test\resources  
    [INFO]  
    [INFO] --- maven-compiler-plugin:2.3.2:testCompile (default-testCompile) @ MyApp ---  
    [WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!  
    [INFO] Compiling 1 source file to C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\test-classes   
    [INFO]  
    [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ MyApp ---  
    [INFO] Surefire report directory: C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\surefire-reports    
     T E S T S  
    Running fr.efrei.mavenapps.AppTest  
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.017 sec  
    Results :  
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0  
    [INFO]  
    [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ MyApp ---  
    [INFO] Building jar: C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\MyApp-1.0-SNAPSHOT.jar  
    [INFO]  
    [INFO] --- maven-install-plugin:2.4:install (default-install) @ MyApp ---  
    [INFO] Installing C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\target\MyApp-1.0-SNAPSHOT.jar to C:\Users\selim\.m2\repository\fr\efrei\mavenapps\MyApp\1.0-SNAPSHOT\MyApp-1.0-SNAPSHOT.jar  
    [INFO] Installing C:\Users\selim\source\repos\JavaAv\TP1_Maven\MyApp\pom.xml to C:\Users\selim\.m2\repository\fr\efrei\mavenapps\MyApp\1.0-SNAPSHOT\MyApp-1.0-SNAPSHOT.pom  
    [INFO] ------------------------------------------------------------------------  
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------  
    [INFO] Total time:  2.187 s  
    [INFO] Finished at: 2023-02-20T23:04:44+01:00  
    [INFO] ------------------------------------------------------------------------  

  Maven started by cleaning the project then compiled it, ran test, package it and finally installed it in local repository. See [commit](https://github.com/selimhaddioui/EFREI_JavaAvancee/commit/7a64695e2d0e5702c80f14842099ae64809a46d3).

---

## Third Part  

* Add below code to *pom.xml*  

```xml  
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-site-plugin</artifactId>
  <version>3.0-beta-3</version>
  <configuration>
    <reportPlugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-project-info-reports-plugin</artifactId>
        <version>2.0.1</version>
      </plugin>
    </reportPlugins>
  </configuration>
</plugin>  
```   

* Write `mvn site`

  Maven is downloading the new plugin then throw an error that have more than 500 lines. For the well-being of this readme we wont put it there.

* Delete `version` tag then write `mvn site` again.

  Output :

  > [INFO] Scanning for projects...   
    [WARNING]    
    [WARNING] Some problems were encountered while building the effective model for fr.efrei.mavenapps:MyApp:jar:1.0-SNAPSHOT   
    [WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-site-plugin is missing. @ line 29, column 15  
    [WARNING] Reporting configuration should be done in <reporting> section, not in maven-site-plugin <configuration> as reportPlugins parameter. @ line 32, column 24  
    [WARNING]    
    [WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.    
    [WARNING]    
    [WARNING] For this reason, future Maven versions might no longer support building such malformed projects.   
    [WARNING]     
    [INFO]    
    [INFO] ----------------------< fr.efrei.mavenapps:MyApp >----------------------   
    [INFO] Building MyApp 1.0-SNAPSHOT   
    [INFO] --------------------------------[ jar ]---------------------------------   
    [INFO]   
    [INFO] --- maven-site-plugin:3.3:site (default-site) @ MyApp ---  
    [INFO] configuring report plugin org.apache.maven.plugins:maven-project-info-reports-plugin:2.0.1  
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-project-info-reports-plugin/2.0.1/maven-project-info-reports-plugin-2.0.1.pom  
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-project-info-reports-plugin/2.0.1/maven-project-info-reports-plugin-2.0.1.pom (4.8 kB at 197 B/s)    
     ... Download ...    
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.0-alpha-8/doxia-decoration-model-1.0-alpha-8.jar (40 kB at 69 kB/s)  
    Downloaded from central: https://repo.maven.apache.org/maven2/velocity/velocity-dep/1.4/velocity-dep-1.4.jar (518 kB at 818 kB/s)  
    [INFO] Relativizing decoration links with respect to project URL: http://maven.apache.org  
    Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/skins/maven-default-skin/1.0/maven-default-skin-1.0.jar  
    Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/skins/maven-default-skin/1.0/maven-default-skin-1.0.jar (8.2 kB at 263 kB/s)  
    [INFO] Rendering site with org.apache.maven.skins:maven-default-skin:jar:1.0 skin.  
    [INFO] Generating "Continuous Integration" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "Dependencies" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "Issue Tracking" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "Project License" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "Mailing Lists" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "About" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "Project Summary" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "Source Repository" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] Generating "Project Team" report    --- maven-project-info-reports-plugin:2.0.1  
    [INFO] ------------------------------------------------------------------------  
    [INFO] BUILD SUCCESS  
    [INFO] ------------------------------------------------------------------------  
    [INFO] Total time:  32.856 s  
    [INFO] Finished at: 2023-02-21T12:03:58+01:00  
    [INFO] ------------------------------------------------------------------------  

    * What happened ?  

        `target\site` has been created and contain web files (html, css, images). `mvn site` created a site representing the documentation of our project.

    * How is it related to *pom.xml*  

        *pom.xml* contain plugin's information, if we put the wrong version of the plugin Maven will not find the plugin then will throw an error.  

* ?
