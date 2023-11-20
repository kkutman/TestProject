INSERT INTO managers (id, full_name, phone_number)
VALUES (1,'Касеийнов Кутман','+996704830408'),
       (2,'Баланчаев Тукунчо','+996777888999');
INSERT INTO user_info (id, manager_id, password, role, username)
VALUES (1,1,'$2a$12$trsXom/jC0BCHrMc/ED6WeIeBHbsnx2X7R7VxAhebm/3jfnCXFchS','MANAGER','manager1@gmail.com'), --password : manager1234
       (2,2,'$2a$12$xfdNNUJK.IfKckan93D.fuTAizoCwXab.buFqkoZaUq/ktHeQYFWu','MANAGER','kutman123@gmail.com'); --password : kutman123

INSERT INTO apartment_location (id, name)
VALUES (1, 'Kochmon City'),
       (2, 'Prime City'),
       (3, 'Baytik'),
       (4,'Все');

INSERT INTO apartments (id, apartment_number, contract_number, date, floor, price, apartment_location_id, manager_id,
                        client_full_name, status, status_apartment)
VALUES (1,120,130,'2023-11-10',3,20000,1,1,'kutman1 ','RESERVATION','Бронь до 12.05.23   14:00'),
       (2,130,140,'2022-11-10',4,30000,2,2,'kutman2','RESERVATION','Бронь до 12.05.23   14:00'),
       (3,140,150,'2023-11-10',5,40000,2,2,'kutman3','BARTER','Бронь до 12.05.23   14:00'),
       (4,150,160,'2022-11-10',6,50000,1,1,'kutman','BARTER','');