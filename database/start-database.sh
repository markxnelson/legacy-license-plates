#!/bin/bash
docker run -d --env-file $HOME/wow/database/ora-db.env -p 1521:1521 -p 5500:5500 -it --name oracle_database --shm-size="4g" store/oracle/database-enterprise:12.1.0.2 
