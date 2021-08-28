create view vw_estufas as
SELECT pessoa_estufa.idpessoa, pessoa.nome,proprietario, responsavel
FROM pessoa_estufa
         inner join pessoa on pessoa.id = pessoa_estufa.idpessoa


create view vw_cidades as
select cidade.id, cidade.nome,estado.uf
from cidade	inner join estado on estado.id = cidade.idestado


create view vw_usuaios as
SELECT pessoa_usuario.idpessoa, nome, login
FROM pessoa_usuario
         inner join pessoa on pessoa.id = idpessoa
where pessoa.id > 0