insert into department (name) values ('West');
insert into department (name) values ('East');
insert into department (name) values ('South');
insert into department (name) values ('North');

INSERT INTO travel_agency (abbreviated_name, address, phone_number, site, email_address) VALUES ('name_1','addres_1',1,'site_1','email_1');
INSERT INTO travel_agency (abbreviated_name, address, phone_number, site, email_address) VALUES ('name_2','addres_2',2,'site_2','email_2');
INSERT INTO travel_agency (abbreviated_name, address, phone_number, site, email_address) VALUES ('name_3','addres_3',3,'site_3','email_3');
INSERT INTO travel_agency (abbreviated_name, address, phone_number, site, email_address) VALUES ('name_4','addres_4',4,'site_4','email_4');
INSERT INTO travel_agency (abbreviated_name, address, phone_number, site, email_address) VALUES ('name_5','addres_5',5,'site_5','email_5');

INSERT INTO travel_agent (travel_agency_id, name, surname, patronymic, enabled, phone_number, limit_amount) VALUES (1,'agent_surname_1','agent_name_1','agent_patronymic_1','true','111','10');
INSERT INTO travel_agent (travel_agency_id, name, surname, patronymic, enabled, phone_number, limit_amount) VALUES (2,'agent_surname_2','agent_name_2','agent_patronymic_2','true','222','10');
INSERT INTO travel_agent (travel_agency_id, name, surname, patronymic, enabled, phone_number, limit_amount) VALUES (3,'agent_surname_3','agent_name_3','agent_patronymic_3','true','333','10');
INSERT INTO travel_agent (travel_agency_id, name, surname, patronymic, enabled, phone_number, limit_amount) VALUES (4,'agent_surname_4','agent_name_4','agent_patronymic_4','true','444','10');
INSERT INTO travel_agent (travel_agency_id, name, surname, patronymic, enabled, phone_number, limit_amount) VALUES (5,'agent_surname_5','agent_name_5','agent_patronymic_5','true','555','10');

insert into app_permission (name) values ('permission_1');
insert into app_permission (name) values ('permission_2');
insert into app_permission (name) values ('permission_3');
insert into app_permission (name) values ('permission_4');

insert into app_role (name) values ('appRole_1');
insert into app_role (name) values ('appRole_2');
insert into app_role (name) values ('appRole_3');
insert into app_role (name) values ('appRole_4');
insert into app_role (name) values ('appRole_5');

insert into app_role_permission (app_role_id,app_permission_id) values (1,1);
insert into app_role_permission (app_role_id,app_permission_id) values (2,2);
insert into app_role_permission (app_role_id,app_permission_id) values (3,3);
insert into app_role_permission (app_role_id,app_permission_id) values (4,4);

INSERT INTO app_user (name, surname, email, login, password, travel_agent_id) VALUES ('app_user_name_1', 'app_user_surname_1', 'app_user_1@email.ru', 'app_user_login_1', 'app_user_password_1', 1);
INSERT INTO app_user (name, surname, email, login, password, travel_agent_id) VALUES ('app_user_name_2', 'app_user_surname_2', 'app_user_2@email.ru', 'app_user_login_2', 'app_user_password_2', 2);
INSERT INTO app_user (name, surname, email, login, password, travel_agent_id) VALUES ('app_user_name_3', 'app_user_surname_3', 'app_user_3@email.ru', 'app_user_login_3', 'app_user_password_3', 3);
INSERT INTO app_user (name, surname, email, login, password, travel_agent_id) VALUES ('app_user_name_4', 'app_user_surname_4', 'app_user_4@email.ru', 'app_user_login_4', 'app_user_password_4', 4);

INSERT INTO app_user_role (app_user_id ,  role_id) VALUES (2,2);
INSERT INTO app_user_role (app_user_id ,  role_id) VALUES (3,3);
INSERT INTO app_user_role (app_user_id ,  role_id) VALUES (4,4);

INSERT INTO document_type (name) VALUES ('document_type_1');
INSERT INTO document_type (name) VALUES ('document_type_2');
INSERT INTO document_type (name) VALUES ('document_type_3');
INSERT INTO document_type (name) VALUES ('document_type_4');
INSERT INTO document_type (name) VALUES ('document_type_5');

INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (1,'01', 'client_name_1', 'client_surname_1', 'client_patronymic_1', 'client_address_1', 1);
INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (2,'02', 'client_name_2', 'client_surname_2', 'client_patronymic_2', 'client_address_2', 2);
INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (3,'03', 'client_name_3', 'client_surname_3', 'client_patronymic_3', 'client_address_3', 3);
INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (4,'04', 'client_name_4', 'client_surname_4', 'client_patronymic_4', 'client_address_4', 4);
INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (4,'05', 'client_name_5', 'client_surname_5', 'client_patronymic_5', 'client_address_5', 5);
INSERT INTO`department` (name) VALUES ('West');
INSERT INTO`department` (name) VALUES ('East');
INSERT INTO`department` (name) VALUES ('South');
INSERT INTO`department` (name) VALUES ('North');

INSERT INTO customer (name, department_id) VALUES ('Jack',  1);
INSERT INTO customer (name, department_id) VALUES ('Piter1',  2);
INSERT INTO customer (name, department_id) VALUES ('Piter2',  2);
INSERT INTO customer (name, department_id) VALUES ('Piter3',  2);
INSERT INTO customer (name, department_id) VALUES ('Green', 3);
INSERT INTO customer (name, department_id) VALUES ('Floyd', 4);

INSERT INTO tour_category (name) VALUES ('1');
INSERT INTO tour_category (name) VALUES ('2');
INSERT INTO tour_category (name) VALUES ('3');
INSERT INTO tour_category (name) VALUES ('4');

INSERT INTO document_type (name) values ('1');

INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('1','2', 3);
INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('4','5', 6);
INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('7', '8', 9);
INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('10', '11', 12);

INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (1, 1, '22');
INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (1, 2, '23');
INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (2, 2, '24');

INSERT INTO travel_agency (abbreviated_name, address, phone_number, email_address) values ('asd', 'asd', '654', 'asd');
INSERT INTO travel_agency (abbreviated_name, address, phone_number, email_address) values ('asd', 'asd', '654', 'asd');

INSERT INTO travel_agent (travel_agency_id, name, phone_number) VALUES (1, 'test1', '123456');
INSERT INTO travel_agent (travel_agency_id, name, phone_number) VALUES (2, 'test', '123456');

INSERT INTO tour (name, description, price, tour_category_id) VALUES ('test', 't',3233,1);
INSERT INTO tour (name, description, price, tour_category_id) VALUES ('test2', '33',32323,3);

INSERT INTO tour_schedule (tour_id, starting_date_time, ending_date_time, transport_id) VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (1, 23232, 'ss', 'ss', 'ss', 'ss', 'sss');
INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (1, 232232, 'ss', 'ss', 'ss', 'ss', 'sss');

INSERT INTO tour_schedule (tour_id, starting_date_time, ending_date_time, transport_id) values (1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 2 );

INSERT INTO purchase (tour_schedule_id, travel_agent_id, client_id, transport_id, transport_seat_id, operation_date) VALUES (1, 1, 1, 1, 1, CURRENT_TIMESTAMP );

INSERT INTO travel_agent_ledger (travel_agent_id, operation_date, purchase_id, amount) VALUES (1, CURRENT_TIMESTAMP,1, 22222);
