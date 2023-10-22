insert into users(username, hashed_password,email,major) values ('user2', 'passworddddddd','1@1.com','무슨 전공할까');
insert into users(username, hashed_password,email,major) values ('user3', 'passworddddddd','2@1.com','무슨 전공할까');
insert into users(username, hashed_password,email,major) values ('user1', 'passworddddddd','3@1.com','무슨 전공할까');

insert into friend(sender_id, receiver_id) values (1L,2L);
insert into friend(sender_id, receiver_id,accepted) values (1L,3L,true);

insert into Authority(authority_name) values ('ROLE_USER');
insert into Authority(authority_name) values ('ROLE_ADMIN');
