insert into categoria (id, preco, descricao) values (1, 45000, 'pobres');
insert into categoria (id, preco, descricao) values (2, 90000, 'esforçados');
insert into categoria (id, preco, descricao) values (3, 140000, 'patrão');

insert into veiculo (marca, id_categoria, modelo, ano) values ('ford focus', 2, 'ford', 2005);
insert into veiculo (marca, id_categoria, modelo, ano) values ('vw fusca', 1, 'fusca', 2005);
insert into veiculo (marca, id_categoria, modelo, ano) values ('bmw serie x', 3, 'bmw', 2015);
insert into veiculo (marca, id_categoria, modelo, ano) values ('mercedes a3', 3, 'mercedes', 2011);

insert into avaria (descricao) values ('quebra parabrisa');
insert into avaria (descricao) values ('amassado no parachoque');
insert into avaria (descricao) values ('roda empenada');

insert into multa (descricao) values ('avanço de sinal vermelho');
insert into multa (descricao) values ('excesso de velocidade');
insert into multa (descricao) values ('ultrapassagem indevida');

insert into cliente (nome, cpf) values ('fulano', '014.043.155-19');
insert into cliente (nome, cpf) values ('ciclano', '765.344.123-19');
insert into cliente (nome, cpf) values ('beltrano', '212.056.165-19');

insert into funcionario (id, matricula, nome) values (1, 'a120', 'ronaldo');
insert into funcionario (id, matricula, nome) values (2, 'b420', 'gustavo');
insert into funcionario (id, matricula, nome) values (3, 'c720', 'anacleto');

insert into locacao (id_veiculo, id_cliente, id_funcionario_cad, id_funcionario_rec) values (1, 1, 1, null);
insert into locacao (id_veiculo, id_cliente, id_funcionario_cad, id_funcionario_rec) values (1, 2, 1, 2);
insert into locacao (id_veiculo, id_cliente, id_funcionario_cad, id_funcionario_rec) values (2, 2, 2, null);
insert into locacao (id_veiculo, id_cliente, id_funcionario_cad, id_funcionario_rec) values (3, 1, 2, 1);

insert into locacao_avaria (id_locacao, id_avaria) values (1, 1);
insert into locacao_avaria (id_locacao, id_avaria) values (1, 2);
insert into locacao_avaria (id_locacao, id_avaria) values (2, 3);
insert into locacao_avaria (id_locacao, id_avaria) values (3, 1);

insert into locacao_multa (id_locacao, id_multa) values (1, 1);
insert into locacao_multa (id_locacao, id_multa) values (2, 2);
insert into locacao_multa (id_locacao, id_multa) values (3, 3);

