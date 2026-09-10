INSERT INTO user_details(id, name, birth_date)
VALUES
    (1001, 'Adarsh', '1995-05-15'),
    (1002, 'John', '1990-08-20'),
    (1003, 'Markus', '1888-12-12');


insert into post(id, description, user_id)
values (2001, 'I want to learn SpringBoot', 1001);

insert into post(id, description, user_id)
values (2002, 'I want to learn Cloud', 1001);

insert into post(id, description, user_id)
values (2003, 'I want to learn Cyber security', 1002);

insert into post(id, description, user_id)
values (2004, 'I want to learn AWS', 1003);