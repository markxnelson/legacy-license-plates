
DROP TABLE Plate;

create sequence plateid_sequence start with 1 increment by 1 nocache;

CREATE TABLE Plate (
    PlateID INTEGER primary key ,
    State CHAR(2),
    PlateNumber VARCHAR(10),
    Owner VARCHAR(100),
    Address VARCHAR(1000),
    ImageURL VARCHAR(1000)
);



quit;
