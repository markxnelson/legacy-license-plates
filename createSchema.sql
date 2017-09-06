
DROP TABLE Plate;

CREATE TABLE Plate (
    PlateID INTEGER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) primary key ,
    State CHAR(2),
    PlateNumber VARCHAR(10),
    Owner VARCHAR(100),
    Address VARCHAR(1000),
    ImageURL VARCHAR(1000)
);



quit;
