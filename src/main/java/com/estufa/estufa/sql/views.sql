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

create view vw_plantas_fases_crecimento as
select plantas_fases_crecimento.*, fases_crecimento.descricao
from plantas_fases_crecimento
         inner join fases_crecimento on plantas_fases_crecimento.idfase = fases_crecimento.id

create view vw_planta_nutrientes as
select planta_nutrientes.*, nutrientes.descricao
from planta_nutrientes
         inner join nutrientes on planta_nutrientes.idnutriente = nutrientes.id

create view vw_controladores as
select controladores.*,pessoa.nome estufa, fases_crecimento.descricao,estufa_setor.descricao as setor
from controladores
         inner join pessoa on pessoa.id = idestufa
         inner join fases_crecimento on fases_crecimento.id = controladores.idfase
         inner join estufa_setor on estufa_setor.id = controladores.idsetor

create view vw_controladores_plantas as
SELECT controladores_plantas.*, plantas.nome
FROM controladores_plantas
         inner join plantas on plantas.id = controladores_plantas.idplanta

create view vw_controladores_menu as
select
    controladores.id,
    controladores.nome,
    host,
    pessoa.nome as estufa,
    case ativo when 1 then 'Ativo' else 'Inativo' end as Status
from controladores
         inner join pessoa on idestufa = pessoa.id