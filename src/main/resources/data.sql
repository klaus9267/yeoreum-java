INSERT INTO Major(name) values ('컴소');
INSERT INTO Major(name) values ('항공');
INSERT INTO Major(name) values ('전기');

insert into users(username, gender, major_id ,hashed_password) values ('user2', 0, 1L,'passworddddddd');
insert into users(username, gender, major_id ,hashed_password) values ('user3', 0, 2L,'passworddddddd');
insert into users(username, gender, major_id ,hashed_password) values ('user1', 1, 1L,'passworddddddd');

insert into Authority(authority_name) values ('ROLE_USER');
insert into Authority(authority_name) values ('ROLE_ADMIN');

-- insert into USERS
