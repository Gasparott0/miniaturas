CREATE TABLE miniature (
	id BIGINT NOT NULL,
	brand VARCHAR(20) NOT NULL,
	model VARCHAR(30) NOT NULL,
	year CHAR(4),
	color VARCHAR(20),
	acceleration VARCHAR(10),
	power VARCHAR(10),
	torque VARCHAR(10),
	max_speed VARCHAR(10),
	consumption VARCHAR(20),
	seats INT,
	weight VARCHAR(10),
	image VARCHAR(255),
	price DECIMAL(10, 2) NOT NULL,

	PRIMARY KEY (id)
);

CREATE TABLE user (
	id BIGINT AUTO_INCREMENT,
	cpf CHAR(11) NOT NULL,
	password VARCHAR(129) NOT NULL,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(60) NOT NULL,
	state CHAR(2) NOT NULL,
	cep CHAR(8) NOT NULL,
	address VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	number VARCHAR(20) NOT NULL,
	date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

	PRIMARY KEY (id)
);

CREATE TABLE cart (
	id BIGINT AUTO_INCREMENT,
	user_id BIGINT NOT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE cart_item (
	id BIGINT AUTO_INCREMENT,
	cart_id BIGINT NOT NULL,
	miniature_id BIGINT NOT NULL,
	quantity INT DEFAULT 1,

	PRIMARY KEY (id),

	FOREIGN KEY (cart_id) REFERENCES cart(id),
	FOREIGN KEY (miniature_id) REFERENCES miniature(id)
);

CREATE TABLE request (
	id BIGINT AUTO_INCREMENT,
	user_id BIGINT NOT NULL,
	date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	status VARCHAR(100),
	value DECIMAL(10.2) NOT NULL,
	
	PRIMARY KEY (id),

	FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE request_item (
	id BIGINT AUTO_INCREMENT,
	request_id BIGINT NOT NULL,
	miniature_id BIGINT NOT NULL,
	quantity INT DEFAULT 1,

	PRIMARY KEY (id),

	FOREIGN KEY (request_id) REFERENCES request(id),
	FOREIGN KEY (miniature_id) REFERENCES miniature(id)
);

CREATE TABLE history (
	id BIGINT AUTO_INCREMENT,
	user_id BIGINT NOT NULL,
	miniature_id BIGINT NOT NULL,
	access_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

	PRIMARY KEY (id),

	FOREIGN KEY (user_id) REFERENCES user(id),
	FOREIGN KEY (miniature_id) REFERENCES miniature(id)
);

-- Inserts
insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (1, 'Lamborghini', 'Murcielago LP670-4 SV', '2009', 'Amarelo', '3,2 Seg', '670Cvs', '67,3KgFm', '342KM/H', '4KM/l', '2', '1737Kg', 'Imagens/murcisv.jpg', 50.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (2, 'Koenigsegg', 'One:1', '2014', 'Cinza', '2,8 Seg', '1360Cvs', '140KgFm', 'Deus sabe', '4KM/l', '2', '1360Kg', 'oneum.jpg', 110.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (3, 'Honda', 'Prelude', '1994', 'Vermelho', '8 Seg', '162Cvs', '21,6KgFm', '215KM/H', '12KM/l', '4', '1265Kg', 'prelude.jpg', 30.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (4, 'Toyota', 'Supra', '1999', 'Preto', '4,6 Seg', '324Cvs', '43,6KgFm', '250KM/H', '7KM/l', '4', '1550Kg', 'supra.jpg', 40.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (5, 'Dodge', 'Viper', '2008', 'Vermelho', '3,7 Seg', '654Cvs', '83KgFm', '323KM/H', '5KM/l', '2', '1537Kg', 'viper.jpg', 40.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (6, 'Aston Martin', 'V12 Vantage S', '2016', 'Amarelo', '3,9 Seg', '573Cvs', '63,2KgFm', '328KM/H', '6KM/l', '4', '1665Kg', 'v12van.jpg', 70.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (7, 'BMW', 'M1 Procar', '1977', 'Branco', '4,5 Seg', '470Cvs', '39KgFm', '310KM/H', '3KM/l', '1', '1020Kg', 'procar.jpg', 90.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (8, 'Alfa Romeo', '33 Stradale', '1969', 'Vermelho', '3,9 Seg', '233Cvs', '22KgFm', '260KM/H', '2KM/l', '2', '700Kg', 'stradale.jpg', 150.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (9, 'Ford', 'Mustang Boss 429', '1969', 'Preto', '6,5 Seg', '294Cvs', '39KgFm', '195KM/H', '5KM/l', '5', '1550Kg', 'mustang.jpg', 40.00);

insert into miniature (id, brand, model, year, color, acceleration, power, torque, max_speed, consumption, seats, weight, image, price) 
values (10, 'Ferrari', 'F50', '1996', 'Vermelha', '3,9 Seg', '513Cvs', '47KgFm', '325KM/H', '5KM/l', '2', '1230Kg', 'f50.jpg', 80.00);

update miniature set image='<asp:ImageButton ID="ibnEdit" runat="server" ImageUrl="/Imagens/murcisv.jpg" />' where id=1;
update miniature set image='/Imagens/oneum.jpg' where id=2;
update miniature set image='/Imagens/prelude.jpg' where id=3;
update miniature set image='/Imagens/supra.jpg' where id=4;
update miniature set image='/Imagens/viper.jpg' where id=5;
update miniature set image='/Imagens/v12van.jpg' where id=6;
update miniature set image='/Imagens/procar.jpg' where id=7;
update miniature set image='/Imagens/stradale.jpg' where id=8;
update miniature set image='/Imagens/mustang.jpg' where id=9;
update miniature set image='/Imagens/f50.jpg' where id=10;

insert into user (cpf, password, name, email, state, cep, address, number, city)
values ('36416918854', 'bianchi', 'Bruno Henrique Bianchi', 'brunohbianchi@hotmail.com', '1', '13076160', 'Rua Otavio Machado', '225 Ap152', 'Hortocity');