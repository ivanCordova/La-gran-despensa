CREATE DATABASE bd_LGD;
GO
USE bd_LGD;
GO
--Creación de tablas y relaciones
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
precioVenta float NOT NULL,
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
contraseña VARCHAR(20) NOT NULL
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
id_cierrecaja INT CONSTRAINT pk_cierrecaja PRIMARY KEY,
id_venta VARCHAR(25) NOT NULL REFERENCES Ventas,
fechaCierre DATE NOT NULL,
sumaFinalCierre FLOAT NOT NULL
);

