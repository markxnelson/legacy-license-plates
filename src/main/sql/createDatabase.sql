
 ------------------------------------------------------------------------
 -- DISCLAIMER:
 --    This script is provided for educational purposes only. It is NOT
 --    supported by Oracle World Wide Technical Support.
 --    The script has been tested and appears to work as intended.
 --    You should always run new scripts on a test instance initially.
 --
 ------------------------------------------------------------------------

-- Drop existing tables and Constraints
--

DROP TABLE Plate;

CREATE TABLE Plate (
    PlateID INTEGER primary key,
    State CHAR(2),
    PlateNumber VARCHAR(10),
    Owner VARCHAR(100),
    Address VARCHAR(1000),
    ImageURL VARCHAR(1000),
    TS TIMESTAMP
);

create sequence plateid_sequence start with 1;

quit;
