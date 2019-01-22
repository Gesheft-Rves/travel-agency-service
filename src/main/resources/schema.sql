drop table if exists app_role_permission;
drop table if exists app_user_role;
drop table if exists app_role;
drop table if exists app_permission;
drop table if exists app_user;
drop table if exists travel_agent_ledger;
drop table if exists purchase;
drop table if exists travel_agent;
drop table if exists travel_agency;
drop table if exists client;
drop table if exists client_document;
drop table if exists client_personal_data;
drop table if exists tour_schedule;
drop table if exists tour;
drop table if exists tour_category;
drop table if exists transport_seat;
drop table if exists transport;
drop table if exists customer;
drop table if exists department;
drop table if exists document_type;

create table if not exists department (
  department_id serial primary key ,
  name varchar (45)
);

create table if not exists customer (
  customer_id serial primary key,
  department_id int,
  name varchar (45),
  foreign key (department_id) references department(department_id)
);

create table if not exists app_role (
  app_role_id serial not null primary key,
  name varchar(50)
);

create table if not exists app_permission(
  app_permission_id serial not null primary key,
  name varchar(50)
);

create table if not exists app_role_permission(
  app_role_permission_id serial not null primary key,
  app_role_id int,
  app_permission_id int,
  foreign key (app_permission_id) references app_permission(app_permission_id),
  foreign key (app_role_id) references app_role(app_role_id),
  unique (app_role_id, app_permission_id )

);

create table if not exists travel_agency(
  travel_agency_id serial not null primary key,
  abbreviated_name varchar(50) not null,
  address varchar(50) not null,
  phone_number varchar not null,
  site varchar(50),
  email_address varchar(50) not null
);

create table if not exists travel_agent (
  travel_agent_id  serial not null primary key,
  travel_agency_id  int not null,
  name varchar (50) not null,
  surname varchar (50),
  patronymic varchar (50),
  enabled boolean,
  phone_number varchar not null,
  limit_amount DECIMAL,
  foreign key (travel_agency_id) references travel_agency(travel_agency_id)
);

create table if not exists app_user (
  app_user_id serial not null primary key,
  name varchar(50) not null,
  surname varchar(50) not null,
  email varchar(50),
  login varchar(50) not null,
  password varchar(50) not null,
  travel_agent_id int not null,
  foreign key (travel_agent_id) references travel_agent(travel_agent_id),
  unique (travel_agent_id)
);

create table if not exists app_user_role (
  app_user_role_id serial not null primary key,
  app_user_id int not null,
  role_id int not null,
  foreign key (app_user_id) references app_user(app_user_id),
  foreign key (role_id) references app_role(app_role_id),
  unique (app_user_id, role_id)
);

create table if not exists document_type (
  document_type_id serial primary key ,
  name varchar (50)
);

create table if not exists client (
  client_id serial not null primary key,
  document_type_id int not null,
  document_series_number varchar not null,
  name varchar(50) not null,
  surname varchar(50) not null,
  patronymic varchar(50) not null,
  address  varchar(100) not null,
  phone_number varchar not null,
  foreign key (document_type_id) references document_type(document_type_id),
  UNIQUE (document_type_id, document_series_number)
);

create table if not exists transport(
  transport_id serial not null primary key,
  name varchar(45) not null,
  description varchar (60),
  passenger_seat_qty int not null
);

create table if not exists tour_category(
  tour_category_id serial not null primary key,
  name varchar(45) not null
);

create table if not exists tour(
  tour_id serial not null primary key,
  name varchar(45) not null,
  description varchar(250),
  price decimal(45) not null,
  tour_category_id int not null,
  foreign key (tour_category_id) references tour_category(tour_category_id)
);

create table if not exists tour_schedule(
  tour_schedule_id serial not null primary key,
  tour_id int not null,
  starting_date_time timestamp not null,
  ending_date_time timestamp not null,
  transport_id int not null,
  foreign key (tour_id) references tour(tour_id),
  foreign key (transport_id) references transport(transport_id)
);

create table if not exists transport_seat (
  transport_seat_id serial primary key,
  transport_id int not null,
  seat_no int not null,
  comment varchar(150),
  foreign key (transport_id) references transport (transport_id),
  unique (transport_id, seat_no)
);

create table if not exists purchase (
  purchase_id serial not null primary key,
  tour_schedule_id int not null,
  travel_agent_id int not null,
  client_id int not null,
  transport_id int not null,
  transport_seat_id int not null,
  operation_date TIMESTAMP NOT NULL ,
  foreign key (transport_id) references transport(transport_id),
  foreign key (transport_seat_id) references transport_seat(transport_seat_id),
  foreign key (tour_schedule_id) references tour_schedule(tour_schedule_id),
  foreign key (travel_agent_id) references travel_agent (travel_agent_id),
  foreign key (client_id) references client (client_id),
  unique (tour_schedule_id, transport_seat_id),
  unique (tour_schedule_id, client_id)
);

create table if not exists travel_agent_ledger (
  travel_agent_ledger_id serial primary key ,
  travel_agent_id int not null,
  operation_date TIMESTAMP NOT NULL ,
  purchase_id int,
  amount decimal,
  foreign key (travel_agent_id) references travel_agent(travel_agent_id),
  foreign key (purchase_id) references purchase(purchase_id)
);