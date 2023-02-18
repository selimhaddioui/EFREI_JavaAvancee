
# Discovering Maven  

## First part  

* What is *bin/m2.conf* file about ?  

  *m2.conf* file is used to configure Maven.  
  When we go into the file it look like this is a script that load `.jar` files and set variables.  
  We also can see inside *mvn* file, which contain the script of the same name command, that m2.conf is executed during `mvn` command.  

* Analyze *conf* repository  

  *conf* repository contain *settings.xml*, *toolchains.xml* and *simplelogger.properties* which are three files that allow to edit default configuration such as path of the local repository, mirror repository, and a lot of other configs.  

* What is `<localRepository>` tag used for in *settings.xml* file ?  

  As comments in *settings.xml* file say :  

  > The path to the local repository maven will use to store artifacts.  

  In other words, by using it we can change local repository from .m2 to anything we want so all dependance we download will be where we want it to be.  

* Write on **command prompt** `mvn -v`  

  Output :  

  > Apache Maven 3.8.7 (b89d5959fcde851dcb1c8946a785a163f14e1e29)  
  Maven home: C:\Maven\apache-maven-3.8.7  
  Java version: 1.8.0_311, vendor: Oracle Corporation, runtime: C:\Program   Files\Java\jdk1.8.0_311\jre  
  Default locale: fr_FR, platform encoding: Cp1252  
  OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"  
