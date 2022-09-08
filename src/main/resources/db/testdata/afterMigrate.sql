set SQL_SAFE_UPDATES=0;

delete from student;
delete from teacher;

set foreign_key_checks = 1;

alter table student auto_increment = 1;
alter table teacher auto_increment = 1;

insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Márcio Martin Fábio Figueiredo', '4135172558', 'marcio.figueiredo@email.com.br', 675.00, 'Rua do Camacuan', 'Curitiba', 'Brasil', '81550360', 'Paraná');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Augusto Arthur Leandro Cavalcanti', '22987362163', 'augusto.cavalcanti@email.com.br', 750.00, 'Rua Rio Grande do Sul', 'Macaé', 'Brasil', '27966072', 'Rio de Janeiro');
insert into student (name, phone, email, fees, street, city, country, postal_code, state)
values ('Samuel Luís Fábio Bernardes', '4927289469', 'samuel.bernardes@email.com.br', 450.00, 'Servidão Tarumã', 'Chapecó', 'Brasil', '89802215', 'Santa Catarina');

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
