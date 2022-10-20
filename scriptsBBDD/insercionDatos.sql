insert into usuario values('joseF','b',1000.0,'Inversor');
insert into usuario values('carloslv','sIG',175.0,'Inversor');
insert into usuario values('pepeS','de',default,'Inversor');
insert into usuario values('APerez','a',0.0,'Regulador');
insert into usuario values('NInfor','UndEn',1000.0,'Empresa');
insert into usuario values('QLCiberSec','RSiMP',975.50,'Empresa');
insert into usuario values('ImpeTelf','c',1000.0,'Empresa');

insert into regulador values('APerez',1.50,default);
insert into inversor values('joseF','35678965F','José','Fernández','González','C. Santiago de Chile','646888322');
insert into inversor values('carloslv','35772251B','Carlos','Lacosta','Vicente','C. Rosalía de Castro','777362313');
insert into inversor values('pepeS','35752950D','Pepe','Sánchez',null,'Santa Comba','656821934');

insert into empresa values('NInfor','A76546258','Nirvana Informática','Rúa da Rosa','658367013',default,default);
insert into empresa values('QLCiberSec','A88210424','QuantumLeapSeguridad','Calle del Pez','677900163',200.0,1);
insert into empresa values('ImpeTelf','B5560321','Imperio teléfono','Plaza de Santa Marta','644017798',default,default);

insert into prerregistro values(date '2021-03-20' - interval '2 days','JaiVazq','blEtY','Inversor');
insert into datos values(date '2021-03-20' - interval '2 days', 'id:JaiVazq');
insert into datos values(date '2021-03-20' - interval '2 days','dni:35662751H');
insert into datos values(date '2021-03-20' - interval '2 days','nombre:Jaime');
insert into datos values(date '2021-03-20' - interval '2 days','ap1:Vázquez');
insert into datos values(date '2021-03-20' - interval '2 days','ap2:null');
insert into datos values(date '2021-03-20' - interval '2 days','direccion:Rúa Compostela');
insert into datos values(date '2021-03-20' - interval '2 days','tlf:629955212');

insert into tenerParticipaciones values('QLCiberSec','QLCiberSec',80);
insert into tenerParticipaciones values('NInfor','NInfor',20);
insert into tenerParticipaciones values('carloslv','QLCiberSec',15);
insert into tenerParticipaciones values('ImpeTelf','ImpeTelf',50);
insert into tenerParticipaciones values('joseF','ImpeTelf',2);
insert into tenerParticipaciones values('carloslv','ImpeTelf',40);

insert into prerregistro values(date '2021-04-01','KWPc','NiTio','Empresa');
insert into datos values(date '2021-04-01','id:KWPc');
insert into datos values(date '2021-04-01','cif:B6510629');
insert into datos values(date '2021-04-01','nombre:Kiwi Ordenadores');
insert into datos values(date '2021-04-01','direccion:Rúa Irmáns Insua');
insert into datos values(date '2021-04-01','tlf:689054230');

insert into baja values('carloslv',current_timestamp);
insert into baja values('pepeS',date '2021-03-02');

insert into mercado values('QLCiberSec','QLCiberSec',current_timestamp,1.75,70,200);
insert into mercado values('NInfor','NInfor',current_timestamp,default,15,25);
insert into mercado values('NInfor','NInfor',current_timestamp + interval '1 day',1.25,5,20);

insert into informacionBeneficios values('QLCiberSec',current_timestamp + interval '1 day',20.0,10,1,1);

insert into stacking values(current_timestamp,'carloslv','ImpeTelf',5,default);

insert into ofertaPacto values('2021-05-03 09:59:44.020434','joseF','QLCiberSec',5,10,'2021-05-20',2);
insert into ofertaPacto values('2021-05-04 09:59:44.020434','carloslv','NInfor',5,10,'2021-05-25',2);
insert into acuerdoPacto values('2021-05-03 09:59:44.020434','joseF','QLCiberSec','carloslv');
