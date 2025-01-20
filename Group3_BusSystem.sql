
USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'PRJ301_Group3_BusSystem')
BEGIN
	ALTER DATABASE PRJ301_Group3_BusSystem SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE PRJ301_Group3_BusSystem SET ONLINE;
	DROP DATABASE PRJ301_Group3_BusSystem;
END


GO
Create database PRJ301_Group3_BusSystem
GO
USE PRJ301_Group3_BusSystem
GO
--chứa thông tin về role:
create table [Role](
RoleID int not null primary key,
RoleName nvarchar(50) not null,
)
INSERT INTO [Role](RoleID, RoleName) VALUES
(1,'ADMIN'),
(0,'EMPLOYEE')

--Chứa thông tin về người dùng (nhân viên, admin):
create table [User](
UserID int IDENTITY(1,1) not null primary key,
UserName nvarchar(50) not null,
[Password] nvarchar(255) not null,
RoleID int not null references [Role](RoleID),
)
INSERT INTO [User] ( UserName, [Password],RoleID) VALUES
('admin', 'admin',1),
('admin1', 'admin',1),
('admin1', 'admin',1),
('admin1', 'admin',1),
('pctra266', '266',1),

('employee1', '123456',0),
('employee2', '123456',0),
('employee3', '123456',0),
('employee4', '123456',0),
('employee5', '123456',0),
('employee6', '123456',0),
('employee7', '123456',0),
('employee8', '123456',0),
('employee9', '123456',0),
('nhanvien', '266',0)

--Chứa thông tin về xe buýt:
create table Bus(
BusID int IDENTITY(1,1) not null primary key,
BusNumber nvarchar(20) not null,
)
INSERT INTO Bus (BusNumber) VALUES
('Bus01'),
('Bus02'),
('Bus03'),
('Bus04'),
('Bus05'),
('Bus06'),
('Bus07'),
('Bus08'),
('Bus09'),
('Bus10'),
('Bus11'),
('Bus12'),
('Bus13')


--Chứa thông tin về tuyến xe:
create table [Route](
RouteID int IDENTITY(1,1) not null primary key,
RouteName nvarchar(200) not null,
StartPoint nvarchar(100) not null,
[EndPoint] nvarchar(100) not null,
StartTime time(0) not null,
EndTime time(0) not null,
Frequency nvarchar(50) not null,
)
INSERT INTO [Route] ( RouteName, StartPoint, [EndPoint], StartTime, EndTime, Frequency) VALUES
('Route Name 01','StartPoint 1', 'EndPoint 1', '05:00', '22:00', N'15 minute frequency'),
('Route Name 02','StartPoint 2', 'EndPoint 2', '05:30', '21:30', N'20 minute frequency'),
('Route Name 03','StartPoint 3', 'EndPoint 3', '05:15', '22:00', N'15 minute frequency'),
('Route Name 04','StartPoint 4', 'EndPoint 4', '05:15', '22:00', N'20 minute frequency'),
('Route Name 05','StartPoint 5', 'EndPoint 5', '05:15', '22:00', N'16 minute frequency'),
('Route Name 06','StartPoint 6', 'EndPoint 6', '05:15', '22:00', N'17 minute frequency'),
('Route Name 07','StartPoint 7', 'EndPoint 7', '05:15', '22:00', N'25 minute frequency')


--Chứa danh sách các trạm dừng:
create table BusStop(
StopID int IDENTITY(1,1) not null primary key,
StopName nvarchar(100) not null,
)
INSERT INTO BusStop ( StopName) VALUES
(N'Bus Stop 1'),
( N'Bus Stop 2'),
(N'Bus Stop 3'),
(N'Bus Stop 4'),
(N'Bus Stop 5'),
(N'Bus Stop 6'),
( N'Bus Stop 7'),
( N'Bus Stop 8'),
(N'Bus Stop 9')


--Chứa mối quan hệ giữa tuyến xe và các trạm dừng:
create table RouteStop(
RouteStopID int IDENTITY(1,1) not null primary key,
RouteID int not null references [Route](RouteID) ,
StopID int not null references BusStop(StopID),
StopOrder int not null,
)
INSERT INTO RouteStop ( RouteID, StopID, StopOrder) VALUES
( 1, 1, 1),
(1, 2, 2),
( 1, 3, 3),

( 2, 4, 1),
( 2, 5, 2),
( 2, 6, 3),

( 3, 7, 1),
( 3, 8, 2),
( 3, 9, 3),

( 4, 1, 1),
( 4, 4, 2),
( 4, 7, 3),

( 5, 2, 1),
( 5, 5, 2),
( 5, 8, 3),

( 6, 3, 1),
( 6, 6, 2),
( 6, 9, 3),

( 7, 2, 1),
( 7, 6, 2),
( 7, 8, 3),
( 7, 4, 3)


--Chứa thông tin về các xe buýt chạy trên từng tuyến:
create table BusRoute(
BusRouteID int IDENTITY(1,1) not null primary key,
BusID int not null references Bus(BusID),
RouteID int not null references [Route](RouteID),
)
INSERT INTO BusRoute ( BusID, RouteID) VALUES
( 1, 1),
( 2, 1),
( 3, 1),

( 4, 2),
( 5, 2),
( 6, 2),

( 7, 3),
( 8, 3),
( 9, 3),
( 10, 4),
( 11, 5),
( 12, 6),
( 13, 7)

