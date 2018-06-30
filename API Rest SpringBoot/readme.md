## Using MySQL in Spring Boot via Spring Data JPA and Hibernate

Installation

Java 8: 
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Chose Java SE Development Kit 8u172 for your system
Install it
After the installation create a Path JAVA_HOME=C:\Program Files\Java\jdk1.8.0_172
And update your Path to take the variable %JAVA_HOME%
So now your is set for the next steps

Check java installation by opening a cmd command and type: java -version

Result:
java version "1.8.0_172"
Java(TM) SE Runtime Environment (build 1.8.0_172-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.172-b11, mixed mode)

Maven > 3.0
https://maven.apache.org/download.cgi Take the apache-maven-3.5.4-bin.zip
Follow steps at https://maven.apache.org/install.html
Check if in your path a variable was created C:\Users\XXXXXXXXXXXX\apache-maven-3.5.4-bin\apache-maven-3.5.4\bin
If not created it like the same for %JAVA_HOME%

Check maven installation by opening a cmd command and type: mvn -v
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T20:33:14+02:00)
Maven home: C:\Users\xxxxxxxxxxxx\apache-maven-3.5.4-bin\apache-maven-3.5.4\bin\..
Java version: 1.8.0_172, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk1.8.0_172\jre
Default locale: fr_FR, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

Don't forget to have a SQL or MySQL server running with the database target created before-hand
If you don't have it the simple way to do it, just install https://dev.mysql.com/downloads/workbench/?utm_source=tuicool
Don't modify anything just let default configurations.

MySqlWorkbench server and other tools.

Log with root login and set the password to root.
Create an sql server at localhost with default port. Log in with MySql Workbench and create a database named: rnm
After this everything is setup you can launch the command mvn spring-boot:run into root folder of project API Rest SpringBoot

If localhost or port modify, and root login or password set by your modify the application.properties of the project.

### Build and run

#### Configurations

Open the `application.properties` file and set your own configurations.

#### Prerequisites

- Java 8
- Maven > 3.0

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

- Run the application and go on http://localhost:8080/
- Use the following urls to invoke controllers methods and see the interactions
  with the database:
  
	Method for user:
	/user/all 														"Return Json"
	/user/create?password=<password>&name=<name>
	/user/delete?id=<id>
	/user/update?id=<id>&password=<password>&name=<name>
	/user/get-by-name?name=<name>
	
	
	Method for itemshop:
	/itemshop/all														"Return Json"
	/itemshop/create?name=<name>&username=<username>
	/itemshop/delete?id=<id>
	/itemshop/update?id=<id>&name=<name>&username=<username>
	/itemshop/get-by-name?name=<name>
	
	
	
	Method for itembasket:
	/itembasket/all 														"Return Json"
	/itembasket/create?name=<name>&username=<username>
	/itembasket/delete?id=<id>
	/itembasket/update?id=<id>&name=<name>&username=<username>
	/itembasket/get-by-name?name=<name>