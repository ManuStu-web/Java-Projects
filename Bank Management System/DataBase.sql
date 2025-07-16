create database bankmanagmentsystem;

use bankmanagmentsystem;

create table signup(
 Formno varchar(20),
 Name varchar(20),
 Father_name varchar(20),
 Dob varchar(20),
 Gender varchar(20),
 Email varchar(40),
 Marital_status varchar(20),
 Address varchar(50),
 City varchar(20),
 State varchar(20),
 Pincode varchar(20)
 );

show tables;
CREATE TABLE signuptwo(
  Formno VARCHAR(20),
  Religion VARCHAR(20),
  Category VARCHAR(20),
  Income VARCHAR(20),
  Education VARCHAR(40),
  Occupation VARCHAR(20),
  Senior_Citizen VARCHAR(50),
  Existing_Account VARCHAR(20),
  Adhaar_Number VARCHAR(20),
  Pan_Number VARCHAR(20)
);

create table login(
Formno varchar(20),
Card_Num varchar(25),
Pin_Num varchar(20)
);

create table signupthree(
  Formno VARCHAR(20),
  Account_type VARCHAR(40),
  Card_Num VARCHAR(25),
  Pin_Num VARCHAR(20),
  Facility VARCHAR(100)
  );

create table bank(
Pin_Num varchar(10),
Date varchar(50),
Type varchar(20),
Amount varchar(20));

select * from signup;
select * from signuptwo;
select * from signupthree;
select * from bank;
select * from login;

