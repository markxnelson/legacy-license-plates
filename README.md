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

You wil require an Oracle Database and a WebLogic Server to run this application.   Manual configuration instructions
are as follows:

### Database

Obtain or install the Oracle Database 12c Enterprise Edition.  Recommended approach is to use the image
provided on Docker Store.

* Register for a Docker Store account if you do not already have one.
* On Docker Store, search for Oracle Database and follow the instructions to accept the license.
* Get the image:

```
docker pull store/oracle/database-enterprise:12.1.0.2
```

* Create a "environment" file to inject configuration into the Database image. 