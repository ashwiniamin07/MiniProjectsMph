create database power_tracker;
use power_tracker;
create table Customer(customerId int primary key,name varchar(100) not null,address varchar(200) not null,phoneNo varchar(15) not null,email varchar(100) unique); 
insert into Customer values(1,'Ravi Kumar','Bangalore','7795132529','ravi@gmail.com');
insert into Customer values(2,'Anita Rao','Mangalore','9945432529','anita@gmail.com');
insert into Customer values(3,'Anvitha Amin','Chennai','8296551043','anvitha@gmail.com');
insert into Customer values(4,'Prathith Chandra','Hyderabad','9743172274','prathith@gmail.com');
insert into Customer values(5,'Shekhar Amin','Mumbai','8754902348','shekhar@gmail.com');

create table Meter(meterId int primary key,customerId int,installationDate date not null,lastReadingDate date not null,foreign key(customerId) references Customer(customerId) on delete cascade);
insert into Meter values(101,1,'2024-01-10','2024-02-10');
insert into Meter values(102,2,'2024-02-15','2024-03-01');
insert into Meter values(103,3,'2024-03-19','2024-04-10');
insert into Meter values(104,4,'2025-04-17','2025-06-09');
insert into Meter values(105,5,'2025-05-19','2025-06-18');

create table ElectricityUsage(usageId int primary key,meterId int,readindDate date not null,usageUnits numeric check(usageUnits>=0),foreign key(meterId) references Meter(meterId) on delete cascade);
insert into ElectricityUsage values(1,101,'2024-02-10',250);
insert into ElectricityUsage values(2,101,'2024-02-01',180);
insert into ElectricityUsage values(3,102,'2024-03-01',300);
insert into ElectricityUsage values(4,103,'2024-04-10',320);
insert into ElectricityUsage values(5,104,'2025-06-09',120);

create table Bill(billId int primary key,meterId int,billDate Date not null,amountDue numeric check(amountDue>=0),dueDate date not null,paid int not null default 0 check (paid in (0,1)),
foreign key(meterId) references Meter(meterId) on delete cascade);
insert into Bill values(501,101,'2024-02-11',1200,'2024-02-25',0);
insert into Bill values(502,102,'2024-03-02',1500,'2024-02-18',1);
insert into Bill values(503,103,'2024-04-07',1700,'2024-05-18',1);
insert into Bill values(504,104,'2024-05-07',1700,'2024-06-18',0);
insert into Bill values(505,105,'2024-06-07',1890,'2024-07-18',0);

create table Payment(paymentId int primary key,billId int,paymentDate date not null,amountPaid numeric check(amountPaid>=0),foreign key(billId) references Bill(billId) on delete cascade);
insert into Payment values(9001,501,'2024-03-05',1200);
insert into Payment values(9002,502,'2024-04-05',1500);
insert into Payment values(9003,503,'2024-05-05',1700);
insert into Payment values(9004,504,'2024-06-05',1700);
insert into Payment values(9005,505,'2024-07-05',1890);

Select * from Customer;
Select * from Meter;
select * from ElectricityUsage;
select * from Bill;
select * from Payment;

select meterId,sum(usageUnits) as totalUsage from ElectricityUsage group by meterId having sum(usageUnits)>200;

select c.name,sum(b.amountDue) as totalUnpaid from Customer c join Meter m on c.customerId=m.customerId join Bill b on m.meterId=b.meterId where b.paid=0 group by c.customerId order by totalUnpaid desc;

select b.billId,b.meterId,b.billDate,b.amountDue,
	case when b.paid=1 then 'paid' else 'pending' end as status from Bill b 
    order by b.billDate asc;
    
select distinct c.* from Customer c join Meter m on c.customerId=m.customerId where m.installationDate>'2023-12-31';

select m.meterId,m.lastReadingDate,sum(e.usageunits) as totalUsage from Meter m
join ElectricityUsage e on m.meterId=e.meterId group by m.meterId,m.lastReadingDate order by totalUsage desc;
    