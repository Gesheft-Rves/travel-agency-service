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

INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (1, 1, '');
INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (2, 2, '');

INSERT INTO travel_agency (abbreviated_name, address, phone_number, email_address) values ('asd', 'asd', '654', 'asd');
INSERT INTO travel_agency (abbreviated_name, address, phone_number, email_address) values ('asd', 'asd', '654', 'asd');

INSERT INTO travel_agent (travel_agency_id, name, phone_number) VALUES (1, 'test', '123456');
INSERT INTO travel_agent (travel_agency_id, name, phone_number) VALUES (2, 'test', '123456');

INSERT INTO tour (name, description, price, tour_category_id) VALUES ('test', 't',3233,1);
INSERT INTO tour (name, description, price, tour_category_id) VALUES ('test2', '33',32323,3);

INSERT INTO tour_schedule (tour_id, starting_date_time, ending_date_time, transport_id) VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (1, 23232, 'ss', 'ss', 'ss', 'ss', 'sss');
INSERT INTO client (document_type_id, document_series_number, name, surname, patronymic, address, phone_number) VALUES (1, 232232, 'ss', 'ss', 'ss', 'ss', 'sss');

INSERT INTO tour_schedule (tour_id, starting_date_time, ending_date_time, transport_id) values (1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 2 );

INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (1, 2, '22');

INSERT INTO purchase (tour_schedule_id, travel_agent_id, client_id, transport_id, transport_seat_id, operation_date) VALUES (1, 1, 1, 1, 1, CURRENT_TIMESTAMP );

INSERT INTO travel_agent_ledger (travel_agent_id, operation_date, purchase_id, amount) VALUES (1, CURRENT_TIMESTAMP,1, 22222);
