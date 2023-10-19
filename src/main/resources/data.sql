INSERT INTO Major(name) values ('컴소');
INSERT INTO Major(name) values ('항공');
INSERT INTO Major(name) values ('전기');

insert into users(username, major_id ,hashed_password,email) values ('user2',  1L,'passworddddddd','1@1.com');
insert into users(username, major_id ,hashed_password,email) values ('user3', 2L,'passworddddddd','2@1.com');
insert into users(username, major_id ,hashed_password,email) values ('user1',  1L,'passworddddddd','3@1.com');

insert into Authority(authority_name) values ('ROLE_USER');
insert into Authority(authority_name) values ('ROLE_ADMIN');

-- insert into USERS
