create table usuario
(
	id varchar(10) not null primary key,
	clave varchar(30) not null,
	saldoDisponible float default 0.0 check (saldoDisponible >= 0.0),
	tipoUsuario varchar(15) check (tipoUsuario in ('Inversor','Empresa','Regulador'))
);

create table empresa
(
	usuario varchar(10) not null,
	cif varchar(9) not null,
	nombre varchar(20) not null,
	direccion varchar(40),
	telefono varchar(10),
	saldoBloqueado float default 0.0 check(saldoBloqueado >= 0.0),
	partiBloqueadas integer default 0,

	primary key(usuario),
	foreign key(usuario) references usuario(id)
		on delete cascade on update cascade
);

create table inversor
(
	usuario varchar(10) not null,
	dni varchar(9) not null,
	nombre varchar(20) not null,
	apellido1 varchar(15) not null,
	apellido2 varchar(15),
	direccion varchar(40),
	telefono varchar(10),

	primary key(usuario),
	foreign key(usuario) references usuario(id)
		on delete cascade on update cascade
);

create table regulador
(
	usuario varchar(10) not null,
	comision float default 1.0 check(comision > 0.0),
	interes float default 1.0 check(interes > 0.0),

	primary key(usuario),
	foreign key(usuario) references usuario(id)
		on delete cascade on update cascade
);

create table prerregistro
(
	marcaTemporal timestamp without time zone not null primary key,
	id varchar(10) not null,
	clave varchar(30) not null,
	tipoUsuario varchar(15) check (tipoUsuario IN ('Inversor', 'Empresa'))
);

create table datos
(
	marcaTemporalPrerregistro timestamp without time zone not null,
	dato varchar(150) not null,

	primary key(marcaTemporalPrerregistro,dato),
	foreign key(marcaTemporalPrerregistro) references prerregistro(marcaTemporal)
		on delete cascade on update cascade

);

create table baja
(
	usuario varchar(10) not null,
	marcaTemporal timestamp without time zone not null,

	primary key(usuario),
	foreign key(usuario) references usuario(id)
		on delete cascade on update cascade
);

create table mercado
(
	usuario varchar(10) not null,
	empresa varchar(10) not null,
	marcaTemporal timestamp without time zone not null,
	comisionVenta float default 1.0 check(comisionVenta > 0.0),
	cantidadParticipaciones integer not null,
	precioParticipacion float not null,

	primary key(usuario,marcaTemporal),
	foreign key(usuario) references usuario(id)
		on delete cascade on update cascade,
	foreign key(empresa) references empresa(usuario)
		on delete cascade on update cascade
);

create table tenerParticipaciones
(
	usuario varchar(10) not null,
	empresa varchar(10) not null,
	cantidad integer default 0,

	primary key(usuario,empresa),
	foreign key(usuario) references usuario(id)
		on delete cascade on update cascade,
	foreign key(empresa) references empresa(usuario)
		on delete cascade on update cascade
);

create table informacionBeneficios(
	empresa varchar(10) not null,
	fechaPago timestamp without time zone not null,
	importePorParticipacion float,
	cantidadParticipaciones integer,
	participacionesPorUsuario integer,
	usuariosConParticipaciones integer,

	foreign key(empresa) references empresa(usuario)
		on delete cascade on update cascade
);

create table stacking
(
	marcaTemporal timestamp  without time zone not null,
	usuario varchar(10) not null,
	empresa varchar(10) not null,
	cantidad integer default 0,
	interesStacking float default 1.0 check(interesStacking > 0.0),

	primary key(marcaTemporal,usuario,empresa),
	foreign key(usuario,empresa) references tenerParticipaciones(usuario,empresa)
		on delete cascade on update cascade
);

create table ofertaPacto
(
	marcaTemporal timestamp without time zone not null,
	comprador varchar(10) not null,
	empresa varchar(10) not null,
	cantidad integer not null,
	precio float not null,
	fechaVenta timestamp without time zone not null,
	comisionPacto float not null,

	primary key(marcaTemporal,comprador,empresa),
	foreign key(comprador) references usuario(id)
		on delete cascade on update cascade,
	foreign key(empresa) references empresa(usuario)
		on delete cascade on update cascade
);

create table acuerdoPacto
(
	marcaTemporal timestamp without time zone not null,
	comprador varchar(10) not null,
	empresa varchar(10) not null,
	vendedor varchar(10) not null,

	primary key(marcaTemporal,comprador,empresa),
	foreign key(marcaTemporal,comprador,empresa) references ofertaPacto(marcaTemporal,comprador,empresa)
		on delete cascade on update cascade,
	foreign key(vendedor,empresa) references tenerParticipaciones(usuario,empresa)
		on delete cascade on update cascade
);
