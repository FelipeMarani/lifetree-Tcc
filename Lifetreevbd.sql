use [lifetree-tcc]

create table Funcionario
(	
   id   BIGINT IDENTITY,
   Nome VARCHAR(100)not null,
   Email VARCHAR(100) unique not null, 
   Senha VARCHAR(100)not null,
   NivelAcess varchar(10)null,
   PRIMARY KEY (id)
)

insert Funcionario(Nome, Email, Senha, NivelAcess)
values('João Pedro', 'jpshawty@gmail.com', '123456Mln@', 'ADMIN')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Ana Silva', 'ana.silva@gmail.com', 'Senha1@', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Pedro Santos', 'pedro.santos@email.com', 'AbCdEfG1#', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Maria Oliveira', 'maria.oliveira@email.com', 'P@ssw0r', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('João Pereira', 'joao.pereira@email.com', 'L3tM3In!', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Sofia Rodrigues', 'sofia.rodrigues@email.com', 'Secr3t@1', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Rafael Ferreira', 'rafael.ferreira@email.com', 'Qwerty12#', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Laura Martins', 'laura.martins@email.com', '5tR0ng!P', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Tiago Sousa', 'tiago.sousa@email.com', 'Pa$$w0&', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Carolina Gonçalves', 'carolina.goncalves@email.com', 'H@ckM3N0', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Daniel Fernandes', 'daniel.fernandes@email.com', '7est&Pass', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Beatriz Cardoso', 'beatriz.cardoso@email.com', 'N0w1sTh3T1m!', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Miguel Almeida', 'miguel.almeida@email.com', 'L3arn&Gr0w', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Inês Costa', 'ines.costa@email.com', '$3cur1ty!', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Bruno Santos', 'bruno.santos@email.com', 'Myp@ss1', 'FUNC')
insert Funcionario(Nome, Email, Senha, NivelAcess)
values('Sofia Mendes', ' sofia.mendes@email.com', 'P@ssw0#rd', 'FUNC')

create table tpProduto
(	id BIGint identity,
	TpProduto varchar(150)not null,
	primary key(id)
)

insert into tpProduto(TpProduto)
values('Chá e Infusões')
insert into tpProduto(TpProduto)
values('Vitaminas e Suplementos');
insert into tpProduto(TpProduto)
values('Mercearia e Empório');
insert into tpProduto(TpProduto)
values('Bem-estar e Beleza');
insert into tpProduto(TpProduto)
values('Refrigerados');
insert into tpProduto(TpProduto)
values('Promoções');
insert into tpProduto(TpProduto)
values('Grãos');


create table mcProduto
(	id bigint identity,
	Marca varchar(100)not null,
	primary key(id)
)

insert into mcProduto(Marca)
values('Leão')
insert into mcProduto(Marca)
values('coca-cola')
insert into mcProduto(Marca)
values('Maizena')
insert into mcProduto(Marca)
values('Nestlé')
insert into mcProduto(Marca)
values('Aurora')
insert into mcProduto(Marca)
values('PepsiCo')
insert into mcProduto(Marca)
values('Kraft Heinz')
insert into mcProduto(Marca)
values('Kellogg s')
insert into mcProduto(Marca)
values('General Mills')
insert into mcProduto(Marca)
values('Mars')
insert into mcProduto(Marca)
values('Mondelez International')
insert into mcProduto(Marca)
values('Unilever')
insert into mcProduto(Marca)
values('Procter & Gamble (P&G)')
insert into mcProduto(Marca)
values('Danone')
insert into mcProduto(Marca)
values('Campbell Soup Company')
insert into mcProduto(Marca)
values('Hershey s')
insert into mcProduto(Marca)
values('Conagra Brands')
insert into mcProduto(Marca)
values('Frito-Lay')
insert into mcProduto(Marca)
values('JBS')
insert into mcProduto(Marca)
values('Tyson Foods')
insert into mcProduto(Marca)
values('Cargill')
insert into mcProduto(Marca)
values('Campbell s')
insert into mcProduto(Marca)
values('Grupo Bimbo')
insert into mcProduto(Marca)
values('Mãe Terra')
insert into mcProduto(Marca)
values('Max Titaniun')



create table Produto
(	id bigint identity,
	Nome varchar(100)not null,
	Preco decimal(10,2)not null,
	Imagem varbinary(MAX),
	Quantidade int,
	Destaque varchar(3),
	StatusProd varchar(20),
	tpProduto_id bigint not null,
	mcProduto_id bigint not null,
	Complemento varchar(250)not null
	primary key(id),
	foreign key(tpProduto_id)
		references tpProduto(id),
	foreign key(mcProduto_id)
		references mcProduto(id)
)

create table Form_Pagamento
(	id bigint identity,
	Fm_pagamento varchar(50)not null,
	StatusPg varchar(20)null,
	primary key(id)
)
insert Form_Pagamento(Fm_pagamento)
values('Cart�o de Debito')
insert Form_Pagamento(Fm_pagamento)
values('Cart�o de Credito')
insert Form_Pagamento(Fm_pagamento)
values('Pix')
insert Form_Pagamento(Fm_pagamento)
values('Boleto 3x')
insert Form_Pagamento(Fm_pagamento)
values('Dinheiro')


create table Venda
(	id bigint identity,
	TT_compra decimal(10,2)not null,
	Dt_Venda date not null,
	Pagamento_id bigint not null,
	primary key(id),
	foreign key(Pagamento_id) 
		references Form_pagamento(id)
)

	create table ItemVenda(
	id bigint identity,
	Quant int not null,
	StatusItem varchar(20) not null,
	Produto_id bigint not null,
	Venda_id bigint not null,
	primary key(id),
	foreign key(Produto_id)
		references Produto(id),
	foreign key(Venda_id)
		references Venda(id)
)

