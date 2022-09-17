set SQL_SAFE_UPDATES=0;
set foreign_key_checks=0;

delete from class_student;
delete from class;
delete from student;
delete from teacher;
delete from user_account;
delete from oauth_client_details;

set foreign_key_checks = 1;

alter table class auto_increment = 1;
alter table student auto_increment = 1;
alter table teacher auto_increment = 1;
alter table user_account auto_increment = 1;

# Student
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Márcio Martin Fábio Figueiredo', '4135172558', 'marcio.figueiredo@email.com.br', 675.00, 'Rua do Camacuan', 'Curitiba', 'Brasil', '81550360', 'Paraná');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Augusto Arthur Leandro Cavalcanti', '22987362163', 'augusto.cavalcanti@email.com.br', 750.00, 'Rua Rio Grande do Sul', 'Macaé', 'Brasil', '27966072', 'Rio de Janeiro');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Samuel Luís Fábio Bernardes', '4927289469', 'samuel.bernardes@email.com.br', 450.00, 'Servidão Tarumã', 'Chapecó', 'Brasil', '89802215', 'Santa Catarina');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Miguel Almeida', '11997312814', 'miguel.almeida@email.com.br', 830.00, 'Rua Augusta, 3000', 'São Paulo', 'Brasil', '01412100', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Laura Sanches', '11997368235', 'laura.sanches@email.com.br', 830.00, 'Rua Pelotas, 209', 'São Paulo', 'Brasil', '04012000', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Heitor Cardoso', '11998965212', 'heitor.cardoso@email.com.br', 830.00, 'Rua Cachoeira, 906', 'São Paulo', 'Brasil', '03024000', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Helena Guimarães', '11971492298', 'helena.guimaraes@email.com.br', 900.00, 'Rua dos Italianos, 708', 'São Paulo', 'Brasil', '01131000', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Gabriel Pedreira', '11998082439', 'gabriel.pedreira@email.com.br', 900.00, 'Rua Solimões, 178', 'São Paulo', 'Brasil', '01138020', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('João Serra', '11998168873', 'joao.serra@email.com.br', 900.00, 'Alameda Dino Bueno, 599', 'São Paulo', 'Brasil', '01216000', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Ricardo Castro', '11972927690', 'ricardo.castro@email.com.br', 950.00, 'Rua Aparecida, 262', 'São Paulo', 'Brasil', '03030090', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Erica Siqueira', '11971882222', 'erica.siqueira@email.com.br', 950.00, 'R. Cel. Morais', 'São Paulo', 'Brasil', '03029000', 'São Paulo');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Rosa Campos', '11997717817', 'rosa.campos@email.com.br', 950.00, 'Rua Marcial, 425', 'São Paulo', 'Brasil', '03169040', 'São Paulo');

# Teacher
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Alex da Silva Brasil', '11938714876', 'alex.brasil@email.com.br', 3200.00, 'R. Joaquim Távora, 1339', 'São Paulo', 'Brasil', '01415002', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Arthur Pacola Neto', '11935682357', 'arthur.neto@email.com.br', 4000.00, 'R. Minerva, 265', 'São Paulo', 'Brasil', '05007031', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Benjamin Melo Grosso', '11938524313', 'benjamin.grosso@email.com.br', 4400.00, 'R. Herculano de Freitas, 74', 'São Paulo', 'Brasil', '01308020', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Castiel Dominguez Ferreira', '11928177465', 'castiel.ferreira@email.com.br', 4400.00, 'R. Mário Araújo, 175', 'São Paulo', 'Brasil', '02020100', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Cauê Barella', '11936201268', 'caue.barella@email.com.br', 3600.00, 'R. da Contagem, 252', 'São Paulo', 'Brasil', '04146100', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Dante Oliveira', '11921675223', 'dante.oliveira@email.com.br', 5000.00, 'Rua Siqueira Bueno, 1757', 'São Paulo', 'Brasil', '03172010', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Leonardo Estevão Gregório', '11930525563', 'leonardo.gregorio@email.com.br', 5000.00, 'R. Rafael Corrêa Sampaio, 422', 'São Caetano do Sul', 'Brasil', '09541250', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Ronaldo Romão Lopez', '24926689594', 'ronaldo.lopez@email.com.br', 4800.00, 'Av. Sete de Setembro, 183', 'Diadema', 'Brasil', '09912010', 'São Paulo');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Higor Correa Filho', '11930119267', 'higor.filho@email.com.br', 5000.00, 'R. Frei Caneca, 8', 'Rio de Janeiro', 'Brasil', '20211030', 'Rio de Janeiro');
insert into teacher (name, phone, email, salary, street, city, country, postal_code, state) 
values ('Isaque Marques de Jesus', '24927313337', 'isaque.jesus@email.com.br', 5000.00, 'R. Atília, 2', 'Rio de Janeiro', 'Brasil', '20220000', 'Rio de Janeiro');

# Class
insert into class (grade, teacher_id) values ('1ª série', 1);
insert into class (grade, teacher_id) values ('2ª série', 2);
insert into class (grade, teacher_id) values ('3ª série', 3);

# Class_Student
insert into class_student (class_id, student_id) values (1, 1);
insert into class_student (class_id, student_id) values (1, 2);
insert into class_student (class_id, student_id) values (1, 3);
insert into class_student (class_id, student_id) values (1, 4);
insert into class_student (class_id, student_id) values (1, 5);
insert into class_student (class_id, student_id) values (1, 6);
insert into class_student (class_id, student_id) values (2, 1);
insert into class_student (class_id, student_id) values (2, 2);
insert into class_student (class_id, student_id) values (2, 3);
insert into class_student (class_id, student_id) values (2, 4);
insert into class_student (class_id, student_id) values (2, 5);
insert into class_student (class_id, student_id) values (2, 6);

# User_Account
insert into user_account (id, name, email, password, registration_date) values
(1, 'Renato Borges Viana', 'renato.admin@email.com', '$2a$12$HL8GQYyCww2O6LB2LC/Ba.lFyINww7kkbltwm1gKPLla6SLk6HhoC', utc_timestamp);

# Oauth_Client_Details
insert into oauth_client_details (
  client_id, resource_ids, client_secret,
  scope, authorized_grant_types, web_server_redirect_uri, authorities,
  access_token_validity, refresh_token_validity, autoapprove
)
values (
  'little-geniuses-app', null, '$2a$12$e9rezz5b29FnwUBY9SIvrehC.1owDd6hozh5d1ZHIhhgAnkdmH0UK',
  'READ,WRITE', 'password,authorization_code', 'http://localhost:8080,http://localhost:8080/swagger-ui/oauth2-redirect.html', null,
  304167, null, null
);