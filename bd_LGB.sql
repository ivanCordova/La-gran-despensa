CREATE DATABASE bd_LGD;
GO
USE bd_LGD;
GO
--Creación de tablas y relaciones
CREATE TABLE Marcas(
id_marca int CONSTRAINT pk_marca PRIMARY KEY,
nombre_marca VARCHAR(25) NOT NULL
);
GO
CREATE TABLE Categorias(
id_categoria int CONSTRAINT pk_categoria PRIMARY KEY,
nombre_categoria VARCHAR(30) NOT NULL
);
GO
CREATE TABLE Medidas(
id_medida int CONSTRAINT pk_medidas PRIMARY KEY,
nombre_medida VARCHAR(20) NOT NULL
);
GO
CREATE TABLE Proveedores(
id_proveedor int CONSTRAINT pk_proveedores PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
telefono VARCHAR(10) NOT NULL,
direccion VARCHAR(100) NOT NULL,
fechaVisita VARCHAR(10) NOT NULL
);
GO
CREATE TABLE Productos(
id_producto int CONSTRAINT pk_producto PRIMARY KEY,
id_marca int NOT NULL REFERENCES Marcas,
id_categoria int NOT NULL REFERENCES Categorias,
id_medida int NOT NULL REFERENCES Medidas,
id_proveedor int NOT NULL REFERENCES Proveedores,
nombre VARCHAR(50) NOT NULL,
precioVenta MONEY NOT NULL,
imagen VARCHAR(100) NOT NULL,
);
GO
CREATE TABLE Inventario(
id_inventario int CONSTRAINT pk_inventarios PRIMARY KEY,
id_producto int NOT NULL REFERENCES Productos,
existencia SMALLINT NOT NULL,
precioUnitario MONEY NOT NULL,
filaAlmacen SMALLINT NOT NULL
);
GO
CREATE TABLE RolUsuarios(
id_rol VARCHAR(8) CONSTRAINT pk_rolUsuarios PRIMARY KEY,
tipo VARCHAR(50) NOT NULL,
);
GO
CREATE TABLE Usuarios(
id_usuario int CONSTRAINT pk_usuario PRIMARY KEY,
id_rol VARCHAR(8) NOT NULL REFERENCES RolUsuarios,
nombre VARCHAR(50) NOT NULL,
ape_paterno VARCHAR(100) NOT NULL,
ape_materno VARCHAR(100) NOT NULL,
direccion VARCHAR(100) NOT NULL,
telefono VARCHAR(10) NOT NULL,
sexo CHAR(1) NOT NULL,
foto VARCHAR(100) NOT NULL,
contraseña VARCHAR(20) NOT NULL
);
GO
CREATE TABLE ProductosVendidos(
id_Proventa int CONSTRAINT pk_proventas PRIMARY KEY,
id_producto int NOT NULL REFERENCES Productos,
cantidad SMALLINT NOT NULL
);
GO
CREATE TABLE Ventas(
id_venta int CONSTRAINT pk_ventas PRIMARY KEY,
id_usuario int NOT NULL REFERENCES Usuarios,
id_proventa int NOT NULL REFERENCES ProductosVendidos,
fechaVenta VARCHAR(10) NOT NULL,
sumaFinalV MONEY NOT NULL
);
GO
CREATE TABLE CierreCaja(
id_cierrecaja int CONSTRAINT pk_cierrecaja PRIMARY KEY,
id_venta int NOT NULL REFERENCES Ventas,
fechaCierre VARCHAR(10) NOT NULL,
sumaFinalCierre MONEY NOT NULL
);
