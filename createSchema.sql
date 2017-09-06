
DROP TABLE Plate;

create sequence plateid_sequence start with 1;

CREATE TABLE Plate (
    PlateID INTEGER primary key DEFAULT plateid_sequence.NEXTVAL,
    State CHAR(2),
    PlateNumber VARCHAR(10),
    Owner VARCHAR(100),
    Address VARCHAR(1000),
    ImageURL VARCHAR(1000)
);



quit;
