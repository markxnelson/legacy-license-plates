# Legacy License Plate Java EE Application

This repository contains the legacy on-prem, old-fashioned Java EE applciation
for storing and retreiving license plate information from a database.  This application
is a small part of a larger OOW demo.

## Building

The project uses Maven.  To build, execute:

```
mvn clean package
```

in the project root directory.  The resulting WAR file will be located at:

```
target/licenseplates.war
```

## Environment Setup

You will require an Oracle Database and a WebLogic Server to run this application.   Manual configuration instructions
are as follows:  (note: pre-built container instructions will be added soon)

### Database

Obtain or install the Oracle Database 12c Enterprise Edition.  Recommended approach is to use the image
provided on Docker Store.

* Register for a Docker Store account if you do not already have one.
* On Docker Store, search for Oracle Database and follow the instructions to accept the license.
* Get the image:

```
docker pull store/oracle/database-enterprise:12.1.0.2
```

* Create a "environment" file to inject configuration into the Database image.  A sample is provided in this
repository in:

```
database/ora-db.env
```

* Start the database container.  A sample command is provided in this repository in:

```
database/start-database.sh
```

Please note that it takes about 10 minutes for the datbase to be created.  You can check on progress by tailling
the file:

```
/home/oracle/setup/log/setupDB.log
```

When the database is ready, you will see a message in this file.

* Connect to the database as the admin user and create a normal user to hold the data:

```
sqlplus sys/Welcome1 as sysdba
create user c##mark identified by Welcome1;
grant all privileges to c##mark;
commit;
quit;
```

* Connect to the database using the new user and set up the schema:

```
sqlplus c##mark/Welcome1
CREATE TABLE Plate (
    PlateID INTEGER primary key,
    State CHAR(2),
    PlateNumber VARCHAR(10),
    Owner VARCHAR(100),
    Address VARCHAR(1000),
    ImageURL VARCHAR(1000)
);
create sequence plateid_sequence start with 1;
commit;
quit;
```

Take a note of the IP address the database container was assigned. On the host machine run:

```
docker inspect oracle_database | grep IPAddress
```

This completes the database setup.

## WebLogic Server

Obtain or isntall WebLogic Server. We recommend using the WebLogic Server image from Docker Store.

* Go to Docker Store and search for Oracle WebLogic, accept the license agreement, then download the image:

```
docker pull store/oracle/weblogic:12.2.1.2
```

* Start up the WebLogic Server image

```
docker run -ti -p 7001:7001 store/oracle/weblogic:12.2.1.2
```

Take note of the admin password that is generated!

* Wait for the server to start up, you will see a message saying the server is in state RUNNING when it is done.

* Log in to the Admin Console at http://localhost:7001/console using the username weblogic and the password you noted earlier.

* Create a Data Source:
    * In the menu on the left hand side of the console, expand Services and clikck on Data Sources.
    * Then click on the New button and choose Generic Data Source from the drop down list.
    * In the Name field enter 'mark'.
    * In the JNDI Name filed enter 'jdbc/mark'
    * Click on Next 3 times, accepting the default, until you get the 'Connection Properties' page
    * In the Database Name field enter 'orcl.marnelso.us.oracle.com'
    * In the Host Name field enter the IP address for the database container which you collected earlier.  
    * In the Port field enter '1521'
    * In the Database User Name field enter 'c##mark'
    * In the Password fields enter 'Welcome1'
    * Click on Next.
    * Click on the Test Configuration button. 
    * You shoud get a green message indicating the Connection test succeeded.  If not, go back and correct your entries and try again. 
    * Click on Finish. 

* Deploy the application:
    * In the menu on the let hand side of the console, click on Deployments.
    * Click on the Install button. 
    * Click on the Upload your file link, and then select the WAR file you built earlier. 
    * Click on Next accepting the defaults until Finish is available and then click on Finish.
    * Click on the Control tab, check the box next to your new applciation and Click on Start and choose Services All Requests from the drop down menu. 

## Using the application 

To access the web interface, go to http://localhost:7001/licenseplates/index.jsp

REST endpoints are as follows:

* GET http://localhost:7001/licenseplates/rest/plates/list 
* GET http://localhost:7001/licenseplates/rest/plates/get/:id
* POST http://localhost:7001/licenseplates/rest/plates/add  with Content-Type=Application/json and body:
```
[{"address":"NYC","imageURL":"http://google.com/","owner":"John Adams","plateNumber":"ABCDEF","state":"NY"}]
```


