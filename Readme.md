# Setup Config
application.properties:
spring.datasource.url=root for your db
spring.datasource.username=username of user
spring.datasource.password=password for your user

# Create table
create table messages
(
id int auto_increment,
name_of_user varchar(20) not null,
message varchar(50) not null,
date_of_creation timestamp null,
date_of_update timestamp null,
constraint messages_pk
primary key (id)
);