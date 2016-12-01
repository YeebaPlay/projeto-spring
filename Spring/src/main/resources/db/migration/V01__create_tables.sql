
-- -----------------------------------------------------
-- table categoria
-- -----------------------------------------------------

create table categoria (
  id int not null auto_increment,
  descricao varchar(100) not null,
  preco decimal(18,2) null,
  primary key (id))
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table veiculo
-- -----------------------------------------------------

create table veiculo (
  id int not null auto_increment,
  id_categoria int not null,
  marca varchar(45) not null,
  modelo varchar(45) not null,
  ano integer null,
  valor decimal(18,2) null,
  observacao varchar(100),
  primary key (id),
  index fk_veiculo_categoria_idx (id_categoria asc),
  constraint fk_veiculo_categoria
    foreign key (id_categoria)
    references categoria (id)
)
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table cliente
-- -----------------------------------------------------

create table cliente (
  id int not null auto_increment,
  cpf varchar(14) not null,
  nome varchar(45) null,
  endereco varchar(60) null,
  telefone varchar(20) null,
  primary key (id))
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table funcionario
-- -----------------------------------------------------

create table funcionario (
  id int not null auto_increment,
  matricula varchar(45) not null,
  nome varchar(45) null,
  endereco varchar(100) null,
  telefone varchar(20) null,
  primary key (id))
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table locacao
-- -----------------------------------------------------

create table locacao (
  id int not null auto_increment,
  id_veiculo int not null,
  id_cliente int not null,
  id_funcionario_cad int not null,
  id_funcionario_rec int null,
  data_locacao timestamp,
  primary key (id),
  index fk_locacao_veiculo1_idx (id_veiculo asc),
  index fk_locacao_cliente1_idx (id_cliente asc),
  index fk_locacao_funcionario1_idx (id_funcionario_cad asc),
  index fk_locacao_funcionario2_idx (id_funcionario_rec asc),
  constraint fk_locacao_veiculo1
    foreign key (id_veiculo)
    references veiculo (id)
    on delete no action
    on update no action,
  constraint fk_locacao_cliente1
    foreign key (id_cliente)
    references cliente (id)
    on delete no action
    on update no action,
  constraint fk_locacao_funcionario1
    foreign key (id_funcionario_cad)
    references funcionario (id)
    on delete no action
    on update no action,
  constraint fk_locacao_funcionario2
    foreign key (id_funcionario_rec)
    references funcionario (id)
    on delete no action
    on update no action)
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table avaria
-- -----------------------------------------------------

create table avaria (
  id int not null auto_increment,
  descricao varchar(100) not null,	
  primary key (id))
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table locacaoavaria
-- -----------------------------------------------------

create table locacao_avaria (
  id_avaria int not null,
  id_locacao int not null,
  primary key (id_avaria, id_locacao),
  index fk_avaria_has_locacao_locacao1_idx (id_locacao asc),
  index fk_avaria_has_locacaoavaria1_idx (id_avaria asc),
  constraint fk_avaria_has_locacaoavaria1
    foreign key (id_avaria)
    references avaria (id)
    on delete no action
    on update no action,
  constraint fk_avaria_has_locacao_locacao1
    foreign key (id_locacao)
    references locacao (id)
    on delete no action
    on update no action)
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table multa
-- -----------------------------------------------------

create table multa (
  id int not null auto_increment,
  descricao varchar(100) not null,
  primary key (id))
engine=innodb default charset=utf8;


-- -----------------------------------------------------
-- table locacaomulta
-- -----------------------------------------------------

create table locacao_multa (
  id_locacao int not null,
  id_multa int not null,
  primary key (id_locacao, id_multa),
  index fk_locacao_has_multa_multa1_idx (id_multa asc),
  index fk_locacao_has_multa_locacao1_idx (id_locacao asc),
  constraint fk_locacao_has_multa_locacao1
    foreign key (id_locacao)
    references locacao (id),
  constraint fk_locacao_has_multa_multa1
    foreign key (id_multa)
    references multa (id)
)
engine=innodb default charset=utf8;
