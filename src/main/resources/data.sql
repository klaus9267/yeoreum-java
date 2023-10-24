insert into users(username, hashed_password,email,major) values ('user2', '$2a$10$6Li3xmkviabA/15SVW6mvOc0sBW9fQKPtccxHepx.BOf89Wra47n.','2@1.com','무슨 전공할까');
insert into users(username, hashed_password,email,major) values ('user3', '$2a$10$fLu1yvNoZ/d5QFSVnWus5uD4poekElgOVC48CBIGmJz.FAe/6Hbm.','3@1.com','무슨 전공할까');
insert into users(username, hashed_password,email,major) values ('user1', '$2a$10$BYp50sx0yqYtn3qjfBuBouD1RC5o7syiRIRv.XrzRlNS/kRMd/EQe','1@1.com','무슨 전공할까');
insert into users(username, hashed_password,email,major) values ('user4', '$2a$10$JVqZDdw75tp7E5.dgODHauBxa2Hi0Ihpthmzi3iey/tzzZ.S7qSWa','4@1.com','무슨 전공할까');

insert into friend(sender_id, receiver_id) values (1L,2L);
insert into friend(sender_id, receiver_id,accepted) values (1L,3L,true);

insert into Authority(authority_name) values ('ROLE_USER');
insert into Authority(authority_name) values ('ROLE_ADMIN');
