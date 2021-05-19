/*
Nombre de la base de datos: bd_LGD
Fecha de creacion: 01/05/2021
Fecha de entrega: 06/05/2021
Numero de equipo: 4
*/

------------ Creaci�n de la base de datos --------------------------
CREATE DATABASE bd_LGD;
GO
USE bd_LGD;
GO

----------- Creaci�n de las tablas conforme a su dise�o ------------
CREATE TABLE Marcas(
id_marca INT CONSTRAINT pk_marca PRIMARY KEY,
nombre_marca VARCHAR(25) NOT NULL
);
GO

CREATE TABLE Categorias(
id_categoria INT CONSTRAINT pk_categoria PRIMARY KEY,
nombre_categoria VARCHAR(30) NOT NULL
);
GO

CREATE TABLE Medidas(
id_medida INT CONSTRAINT pk_medidas PRIMARY KEY,
nombre_medida VARCHAR(20) NOT NULL
);
GO

CREATE TABLE Proveedores(
id_proveedor INT CONSTRAINT pk_proveedores PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
telefono VARCHAR(10) NOT NULL,
empresa VARCHAR(50) NOT NULL,
fechaRegistro DATE NOT NULL,
direccion VARCHAR(100) NOT NULL
);
GO

CREATE TABLE Productos(
id_producto INT CONSTRAINT pk_producto PRIMARY KEY,
id_marca INT NOT NULL REFERENCES Marcas,
id_categoria INT NOT NULL REFERENCES Categorias,
id_medida INT NOT NULL REFERENCES Medidas,
id_proveedor INT NOT NULL REFERENCES Proveedores,
nombre VARCHAR(50) NOT NULL,
precioVenta FLOAT NOT NULL,
imagen VARCHAR(100) NOT NULL,
);
GO

CREATE TABLE Inventario(
id_inventario INT CONSTRAINT pk_inventarios PRIMARY KEY,
id_producto INT NOT NULL REFERENCES Productos,
existencia SMALLINT NOT NULL,
precioUnitario FLOAT NOT NULL,
filaAlmacen SMALLINT NOT NULL
);
GO

CREATE TABLE RolUsuarios(
id_rol VARCHAR(8) CONSTRAINT pk_rolUsuarios PRIMARY KEY,
tipo VARCHAR(50) NOT NULL,
);
GO

CREATE TABLE Usuarios(
id_usuario INT CONSTRAINT pk_usuario PRIMARY KEY,
id_rol VARCHAR(8) NOT NULL REFERENCES RolUsuarios,
nombre VARCHAR(50) NOT NULL,
ape_paterno VARCHAR(100) NOT NULL,
ape_materno VARCHAR(100) NOT NULL,
direccion VARCHAR(100) NOT NULL,
telefono VARCHAR(10) NOT NULL,
sexo CHAR(1) NOT NULL,
foto VARCHAR(100) NOT NULL,
contrase�a VARCHAR(20) NOT NULL
);
GO

CREATE TABLE Ventas(
id_venta VARCHAR(25) CONSTRAINT pk_ventas PRIMARY KEY,
id_usuario INT NOT NULL REFERENCES Usuarios,
fechaVenta DATE NOT NULL,
sumaFinalV FLOAT NOT NULL
);
GO

CREATE TABLE ProductosVendidos(
id_proventa INT IDENTITY(1,1) CONSTRAINT pk_proventas PRIMARY KEY,
id_venta VARCHAR(25) NOT NULL REFERENCES Ventas,
id_producto INT NOT NULL REFERENCES Productos,
cantidad SMALLINT NOT NULL
);
GO

CREATE TABLE CierreCaja(
id_cierrecaja INT IDENTITY(1,1) CONSTRAINT pk_cierrecaja PRIMARY KEY,
id_venta VARCHAR(25) NOT NULL REFERENCES Ventas,
fechaCierre DATE NOT NULL,
sumaFinalCierre FLOAT NOT NULL
);
GO

--------- Las tablas tiene diez registros cada una con el comando "INSERT" -----------

INSERT INTO Marcas (id_marca,nombre_marca) VALUES 
(1,'Sabritas'),(2,'Bimbo'),(3,'Gamesa'),(4,'CocaCola'),(5,'LaLa'),
(6,'Ricolino'),(7,'Alpura'),(8,'Nestle'),(9,'Moderna'),(10,'Jumex');
GO

INSERT INTO Categorias (id_categoria, nombre_categoria) VALUES 
(1,'Pan dulce'),(2,'Bebidas'),(3,'Botanas'),(4,'L�cteos'),(5,'Dulces'),
(6,'Pastas'),(7,'Limpieza'),(8,'Cereales'),(9,'Enlatados'),(10,'Bebidas alcoh�licas');
GO

INSERT INTO Medidas (id_medida,nombre_medida) VALUES 
(1,'Kilogramo'),(2,'Gramo'),(3,'Litro'),(4,'Mililitro'),(5,'Metro'),
(6,'Miligramo'),(7,'Centimetro'),(8,'Libra'),(9,'Galon'),(10,'Pulgadas');
GO

INSERT INTO Proveedores (id_proveedor,nombre,telefono,empresa,fechaRegistro,direccion) VALUES
(1,'Coca Cola','2311234534','FEMSA','2021-05-06','AV. INDEPENDENCIA NO. 779'),
(2,'Lala','2311245656','Lala','2021-05-06','CARRETERA A LOMA ALTA S/N.'),
(3,'Bimbo','2314453456','Bimbo','2021-05-06','AV. 20 DE NOVIEMBRE NO. 1060'),
(4,'Sabritas','2314434543','Sabritas','2021-05-06','20 DE NOVIEMBRE NO. 955'),
(5,'Gamesa','2314434543','Gamesa','2021-05-06','CALLE IGNACIO MATIAS NO.6'),
(6,'Jumex','2316656797','Jumex','2021-05-06','CALLE OCAMPO NO. 254'),
(7,'Alpura','231123432','Alpura','2021-05-06','CENTRAL ESQ. BENITO JUAREZ'),
(8,'Nestl�','2311134345','Nestl�','2021-05-06','AV. INDEPENDENCIA NO. 985-A'),
(9,'Grupo Moderna','2314454567','Moderna','2021-05-06','AV. INDEPENDENCIA NO. 1282-A'),
(10,'Ricolino','231445456','Ricolino','2021-05-06','AV. 5 DE MAYO NO. 1652');
GO

INSERT INTO Productos (id_producto,id_marca,id_categoria,id_medida,id_proveedor,nombre,precioVenta,imagen) VALUES
(1,1,3,2,4,'Cheetos',13.0,'C:\ImgProduc\cheetos.jpg'),
(2,2,1,2,3,'Donitas',12.0,'C:\ImgProduc\donitas.jpg'),
(3,3,1,2,5,'Chokis',12.0,'C:\ImgProduc\chokis.jpg'),
(4,4,2,3,1,'CocaCola litro',19.0,'C:\ImgProduc\cocaLitro.jpg'),
(5,5,4,3,2,'Lala 100',23.0,'C:\ImgProduc\lala.jpg'),
(6,6,5,2,10,'Kranky',12.0,'C:\ImgProduc\kranky.jpg'),
(7,7,4,3,7,'Alpura clasica',26.0,'C:\ImgProduc\alpura.jpg'),
(8,8,4,4,8,'Lechera',16.0,'C:\ImgProduc\lechera.jpg'),
(9,9,6,2,9,'Pasta codito',10.0,'C:\ImgProduc\pastaCodito.jpg'),
(10,10,2,4,6,'Jumex Mango',14.0,'C:\ImgProduc\jumexMango.jpg');
GO

INSERT INTO Inventario (id_inventario,id_producto,existencia,precioUnitario,filaAlmacen) VALUES
(1,1,20,13.0,1),
(2,2,20,12.0,1),
(3,3,40,12.0,1),
(4,4,10,19.0,1),
(5,5,10,23.0,1),
(6,6,40,12.0,2),
(7,7,10,26.0,2),
(8,8,15,16.0,2),
(9,9,30,10.0,2),
(10,10,20,14.0,2);
GO

INSERT INTO RolUsuarios (id_rol,tipo) VALUES 
('A0000001','Administrador'),
('C0000001','Cajero'),
('G0000001','Gerente');
GO

INSERT INTO Usuarios (id_usuario,id_rol,nombre,ape_paterno,ape_materno,direccion,telefono,sexo,foto,contrase�a) VALUES
(1,'A0000001','Emmanuel','Miranda','Diaz','AV INDEPENDENCIA 565-A','2311123234','M','Pendiente','12345'),
(2,'G0000001','Ivan','Cordova','Rodriguez','CALLE MATAMOROS NO. 325','2311121232','M','Pendiente','12345'),
(3,'G0000001','Luis Eduardo','Hern�ndez','Gil','CALLE RIVA PALACIOS NO. 465','231445456','M','Pendiente','12345'),
(4,'G0000001','Brandon','Gonz�lez','Crescencio','AV. 20 DE NOVIEMBRE NO. 1291','231445456','M','Pendiente','12345'),
(5,'G0000001','Sergio','Del Carmen','Salazar','5 DE MAYO 1038','231123234','M','Pendiente','12345'),
(6,'C0000001','Oscar','Arreolo','Peregrina','INDEPENDENCIA 748','2314453452','M','Pendiente','12345'),
(7,'C0000001','Enrique','Rodriguez','Cabrera','AV. 20 DE NOVIEMBRE NO. 963','2314457867','M','Pendiente','12345'),
(8,'C0000001','Martha','Chaparro','Anton','AV. 20 DE NOVIEMBRE NO.1896','231120989','F','Pendiente','12345'),
(9,'C0000001','Maria','Pilar','Lopez','OCAMPO 254-B','2315545689','F','Pendiente','12345'),
(10,'C0000001','Estela','Resendiz','Rojo','AV. JESUS CARRANZA NO. 60','231767890','F','Pendiente','12345');
GO

INSERT INTO Ventas (id_venta,id_usuario,fechaVenta,sumaFinalV) VALUES
('2021_05_06_17:36:12',1,'2021-05-06',13.0),
('2021_05_06_17:46:21',2,'2021-05-06',12.0),
('2021_05_06_17:53:20',3,'2021-05-06',12.0),
('2021_05_06_17:26:32',4,'2021-05-06',19.0),
('2021_05_06_17:16:22',5,'2021-05-06',23.0),
('2021_05_06_17:36:25',6,'2021-05-06',12.0),
('2021_05_06_17:36:32',7,'2021-05-06',26.0),
('2021_05_06_17:26:20',8,'2021-05-06',16.0),
('2021_05_06_17:46:10',9,'2021-05-06',10.0),
('2021_05_06_17:26:12',10,'2021-05-06',14.0);
GO

INSERT INTO  ProductosVendidos (id_venta,id_producto,cantidad) VALUES
('2021_05_06_17:36:12',1,1),
('2021_05_06_17:46:21',2,1),
('2021_05_06_17:53:20',3,1),
('2021_05_06_17:26:32',4,1),
('2021_05_06_17:16:22',5,1),
('2021_05_06_17:36:25',6,1),
('2021_05_06_17:36:32',7,1),
('2021_05_06_17:26:20',8,1),
('2021_05_06_17:46:10',9,1),
('2021_05_06_17:26:12',10,1);
GO

INSERT INTO CierreCaja (id_venta,fechaCierre,sumaFinalCierre) VALUES
('2021_05_06_17:36:12','2021-05-06',12200.0),
('2021_05_06_17:46:21','2021-05-05',12032.0),
('2021_05_06_17:53:20','2021-05-04',10123.0),
('2021_05_06_17:26:32','2021-05-03',10123.0),
('2021_05_06_17:16:22','2021-05-02',11298.0),
('2021_05_06_17:36:25','2021-05-01',10127.0),
('2021_05_06_17:36:32','2021-04-30',19112.0),
('2021_05_06_17:26:20','2021-04-29',10822.0),
('2021_05_06_17:46:10','2021-04-28',10118.0),
('2021_05_06_17:26:12','2021-04-27',12912.0);
GO


---------- Utiliza el comando "DELETE" ------------
DELETE FROM CierreCaja WHERE id_cierrecaja = 1;
GO

---------- Utiliza el comando "UPDATE" ------------
UPDATE Proveedores SET nombre = 'Moderna', telefono = '2314454565' WHERE id_proveedor = 9;
GO

--------- Utiliza el comando "SELECT" -------------
SELECT * FROM Ventas
GO
--------- Utiliza el comando "JOIN" ---------------
SELECT v.id_venta, u.nombre, v.fechaVenta, v.sumaFinalV 
FROM Ventas AS v JOIN Usuarios AS u ON v.id_usuario = u.id_usuario
GO

-------- Utiliza el comando "INNER JOIN" ----------
SELECT u.id_usuario, u.nombre, r.tipo FROM Usuarios AS u INNER JOIN RolUsuarios AS r ON u.id_rol = R.id_rol
GO


-------- Procedimiento Almacenado Modificar Proveedor --------
CREATE PROC ModificarProvee (@id int)
AS BEGIN 
SELECT * FROM Proveedores WHERE id=@id
END
GO