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


INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('1','2', 3);
INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('4','5', 6);
INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('7', '8', 9);
INSERT INTO transport (name, description, passenger_seat_qty) VALUES ('10', '11', 12);

INSERT INTO transport_seat (transport_id, seat_no, comment) VALUES (1, 1, '');
INSERT INTO travel_agency (abbreviated_name, address, phone_number, email_address) values ('asd', 'asd', '654', 'asd');
INSERT INTO travel_agent (travel_agency_id, name, phone_number) VALUES (1, 'test', '123456');

-- tour_schedule_id, travel_agent_id, client_id, transport_id, transport_seat_id
-- А в базе на момент вставки нет ничего из полей выше
-- Ладно, дальше лень) В общем если ты тут делаешь инсерт и в нем есть ссылка на другую таблицу, надо чтоб и в другой таблице эта запись была
