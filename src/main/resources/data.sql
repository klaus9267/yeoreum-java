INSERT INTO Major(name) values ('컴소');
INSERT INTO Major(name) values ('항공');
INSERT INTO Major(name) values ('전기');

insert into authentication(username, hashed_password) values ('user1', '1111');
insert into users(nickname, gender, major_id, authentication_id) values ('nickname1', 1, 1L, 1L);
insert into authentication(username, hashed_password) values ('user2', '1111');
insert into users(nickname, gender, major_id, authentication_id) values ('nickname2', 0, 1L, 2L);
insert into authentication(username, hashed_password) values ('user3', '1111');
insert into users(nickname, gender, major_id, authentication_id) values ('nickname3', 0, 2L, 3L);

insert into Authority(authority_name) values ('ROLE_USER');
insert into Authority(authority_name) values ('ROLE_ADMIN');

-- insert into USERS
