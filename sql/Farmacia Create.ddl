CREATE TABLE Vale (ID  SERIAL NOT NULL, Fecha date, Hora time(7), PRIMARY KEY (ID));
CREATE TABLE Medicamento (Nombre varchar(255) NOT NULL UNIQUE, Tipo varchar(255) NOT NULL UNIQUE, Descripcion varchar(255), Costo float8 NOT NULL, Cantidad int4 NOT NULL, UMedida varchar(255), Lote int4 NOT NULL, FechaVencimiento date, PRIMARY KEY (Nombre, Tipo));
CREATE TABLE Trabajador (CI varchar(255) NOT NULL UNIQUE, Nombre varchar(255) NOT NULL, PrimerApellido varchar(255) NOT NULL, SegundoApellido varchar(255) NOT NULL, Telefono varchar(255), DirPart varchar(255), Usuario varchar(255) NOT NULL, Contrasenna varchar(255) NOT NULL, Rol varchar(255) NOT NULL, PRIMARY KEY (Usuario));
CREATE TABLE Suscripcion (CI varchar(255) NOT NULL, Nombre varchar(255), PrimerApellido varchar(255), SegundoApellido varchar(255), PRIMARY KEY (CI));
CREATE TABLE Vuelta (ID  SERIAL NOT NULL, Anno int4 NOT NULL, Mes int4, PRIMARY KEY (ID));
CREATE TABLE GestionAlmohadillas (VueltaID int4 NOT NULL, SuscripcionCI varchar(255) NOT NULL, TrabajadorUsuario varchar(255) NOT NULL, PRIMARY KEY (VueltaID, SuscripcionCI));
CREATE TABLE VentaMedicamentos (MedicamentoNombre varchar(255) NOT NULL, MedicamentoTipo varchar(255) NOT NULL, ValeID int4 NOT NULL, TrabajadorUsuario varchar(255) NOT NULL, cantMedicamento int4, PRIMARY KEY (MedicamentoNombre, MedicamentoTipo, ValeID));
CREATE TABLE Reclamacion (Documentoid int4 NOT NULL, datosReales varchar(255), PRIMARY KEY (Documentoid));
CREATE TABLE Documento (id  SERIAL NOT NULL, TrabajadorUsuario varchar(255) NOT NULL, fecha date, datosFactura varchar(255), PRIMARY KEY (id));
CREATE TABLE InformeRecepcion (Documentoid int4 NOT NULL, importe float8, PRIMARY KEY (Documentoid));




ALTER TABLE GestionAlmohadillas ADD CONSTRAINT FKGestionAlm748711 FOREIGN KEY (SuscripcionCI) REFERENCES Suscripcion (CI);
ALTER TABLE GestionAlmohadillas ADD CONSTRAINT FKGestionAlm291767 FOREIGN KEY (VueltaID) REFERENCES Vuelta (ID);
ALTER TABLE Reclamacion ADD CONSTRAINT "Es una" FOREIGN KEY (Documentoid) REFERENCES Documento (id);
ALTER TABLE InformeRecepcion ADD CONSTRAINT "Es un" FOREIGN KEY (Documentoid) REFERENCES Documento (id);
ALTER TABLE VentaMedicamentos ADD CONSTRAINT "Esta en" FOREIGN KEY (MedicamentoNombre, MedicamentoTipo) REFERENCES Medicamento (Nombre, Tipo);
ALTER TABLE VentaMedicamentos ADD CONSTRAINT Tiene FOREIGN KEY (ValeID) REFERENCES Vale (ID);
ALTER TABLE Documento ADD CONSTRAINT Genera FOREIGN KEY (TrabajadorUsuario) REFERENCES Trabajador (Usuario);
ALTER TABLE VentaMedicamentos ADD CONSTRAINT Vende FOREIGN KEY (TrabajadorUsuario) REFERENCES Trabajador (Usuario);
ALTER TABLE GestionAlmohadillas ADD CONSTRAINT Entrega FOREIGN KEY (TrabajadorUsuario) REFERENCES Trabajador (Usuario);

