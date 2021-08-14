CREATE DATABASE Motocycle_Management
use Motocycle_Management
GO
CREATE TABLE TblUser(
	userID varchar(10) not null,
	fullName nvarchar(50),
	password varchar(50),
	status bit
	PRIMARY KEY (userID)
)
GO
CREATE TABLE TblBrand(
	brandID varchar(10) not null,
	brandName varchar(50),
	country nvarchar(50),
	description nvarchar(200),
	PRIMARY KEY (brandID)
)
GO
CREATE TABLE TblMotocycle(
	motocycleID varchar(10),
	model nvarchar(50),
	year date,
	condition varchar(50),
	price float,
	quantity int,
	warranty nvarchar(50),
	brandID varchar(10)
	PRIMARY KEY (motocycleID)
	FOREIGN KEY (brandID) REFERENCES TblBrand(brandID)
)
use Motocycle_Management
go
INSERT INTO TblBrand(brandID,brandName,country, description) VALUES ('HD', 'Honda', 'Japan', 'many product')
INSERT INTO TblBrand(brandID,brandName,country, description) VALUES ('YMH', 'Yamaha', 'Korea', 'many product')
INSERT INTO TblBrand(brandID,brandName,country, description) VALUES ('SZ', 'Suzuki', 'Japan', 'many product')
INSERT INTO TblBrand(brandID,brandName,country, description) VALUES ('DT', 'Ducati', 'French', 'many product')

INSERT INTO TblMotocycle(motocycleID,model,year,condition,price,quantity, warranty, brandID) 
VALUES ('M01','Blade','2020','new', 150, 15, '1 year', 'HD')
INSERT INTO TblMotocycle(motocycleID,model,year,condition,price,quantity, warranty, brandID) 
VALUES ('M02','Cup','2020','new', 100, 5, '2 year', 'HD')
INSERT INTO TblMotocycle(motocycleID,model,year,condition,price,quantity, warranty, brandID) 
VALUES ('M03','Excenter','2019','80%', 140, 9, '2 year', 'YMH')
INSERT INTO TblMotocycle(motocycleID,model,year,condition,price,quantity, warranty, brandID) 
VALUES ('M04','I85','2021','70%', 2, 2, '6 month', 'SZ')
INSERT INTO TblMotocycle(motocycleID,model,year,condition,price,quantity, warranty, brandID) 
VALUES ('M05','SZ35','2020','new', 17, 5, '30.000 KM', 'SZ')

INSERT INTO TblUser(userID,fullName,password,status) VALUES ('tan','tan nguyen', '123', 1)

