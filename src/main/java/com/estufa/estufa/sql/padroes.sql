--Usuario
insert into pessoa(idpessoa,nome) values(-1,'Administrador');
insert into pessoa_usuario(idpessoausuario,idpessoa,login,senha)values(-1,-1,'adm@estufaplus.com','2626');
insert into pessoa_dadoscontato(idpessoa) values(-1);


insert into dynamic(route,sql,tablebase)values('mnu_cidade','select cidade.id, cidade.nome,estado.uf,ibge
from cidade	inner join estado on estado.id = cidade.idestado','cidade ');

--menu_nutrientes
insert into dynamic(route,sql,tablebase)values('mnu_nutrientes','select id, descricao from nutrientes ','nutrientes ');

--menu_plantas
insert into dynamic(route,sql,tablebase)values('menu_plantas','select id, nome, nomecientifico,familia from plantas ','plantas ');


--menu_fases
insert into dynamic(route,sql,tablebase)values('menu_fases','SELECT id, descricao FROM fases_crecimento ','fases_crecimento ');

--menu_estufas
insert into dynamic(route,sql,tablebase)values('menu_estufas','select * from vw_estufas ','vw_estufas ');

--expl_cidades
insert into dynamic(route,sql,tablebase)values('expl_cidades','select * from vw_cidades ','vw_cidades ');


--menu_usuarios
insert into dynamic(route,sql,tablebase)values('menu_usuarios','select * from vw_usuaios ','vw_usuaios ');


--expl_nutrientes
insert into dynamic(route,sql,tablebase)values('expl_nutrientes','select id, descricao from nutrientes ','nutrientes ');





