INSERT INTO Major(name) values ('컴소');
INSERT INTO Major(name) values ('항공');
INSERT INTO Major(name) values ('전기');

insert into authentication(email, hashed_password) values ('1@1.com', '1111');
insert into users(nickname, gender, major_id, authentication_id) values ('nickname1', 1, 1L, 1L);
insert into authentication(email, hashed_password) values ('2@1.com', '1111');
insert into users(nickname, gender, major_id, authentication_id) values ('nickname2', 0, 1L, 2L);
insert into authentication(email, hashed_password) values ('3@1.com', '1111');
insert into users(nickname, gender, major_id, authentication_id) values ('nickname3', 0, 2L, 3L);

-- insert into USERS
