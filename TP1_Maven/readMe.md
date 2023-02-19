
# Discovering Maven  

---

## First part  

* What is *bin/m2.conf* file about ?  

  *m2.conf* file is used to configure Maven.  
  When we go into the file it look like this is a script that load `.jar` files and set variables.  
  We also can see inside *mvn* file, which contain the script of the same name command, that m2.conf is executed during `mvn` command.  

* Analyze *conf* repository.  

  *conf* repository contain *settings.xml*, *toolchains.xml* and *simplelogger.properties* which are three files that allow to edit default configuration such as path of the local repository, mirror repository, and a lot of others configs.  

* <a name="localRepository"></a> What is `localRepository` tag used for in *settings.xml* file ?  

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

  They are #TODO  

* Create a repository, launch **command prompt** from it and write below command.  

  ```sh  
  mvn archetype:generate -B -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=fr.efrei.mavenapps -DartifactId=MyApp -Dversion=1.0-SNAPSHOT -DpackageName=fr.efrei.mavenapps
  ```  

 Output :  

 > Here is the output  

 Several things happen such as #TODO

  * What king of files are download and where are they stored ?  

    #TODO files are download and they are stored #TODO  

* Analyze *.m2* repository created by Maven at `C:\Users\%USERNAME%\`.  

  This repository is our local repository mentioned in [first part](#localRepository). It store all dependances we download.  

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