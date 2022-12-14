INSERT INTO regiones(id, nombre) VALUES(1, 'Sudamérica');
INSERT INTO regiones(id, nombre) VALUES(2, 'Centroamérica');
INSERT INTO regiones(id, nombre) VALUES(3, 'Norteamérica');
INSERT INTO regiones(id, nombre) VALUES(4, 'Europa');
INSERT INTO regiones(id, nombre) VALUES(5, 'Asia');

INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Felix','Nuñez','felixjavier0@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(2, 'Juan','Madrid','juan23@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Alberto','Acosta','albert33@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(5, 'Miriam','Ledezma','miriam33@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'María','Duarte','maria_a@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(1, 'Fernanda','Avalos','fernanda_cr@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(2, 'Patricia','Martinez','patricia_ma@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(3, 'Uriel','Peña','urielp@gmail.com', NOW());
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES(4, 'Julian','Bañuelos','julianb@gmail.com', NOW());
--DEL 1 al 5--
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('felix', '$2a$10$4geeA9LtqH7nAbYhW9MEQedWRgNhRBxXyBcydEFjrDDCwz.GK3fa6', 'True', 'Felix Javier', 'Nuñez Gonzalez', 'felixjavier0@gmail.com');
INSERT INTO usuarios(username, password, enabled, nombre, apellido, email) VALUES('admin', '$2a$10$0GeY3kP15C4zOl3B6FcfXe2rStMYZ4lIVxfS.Jf.PK56N8QBZTarC', 'True', 'Andres', 'Guzman', 'profesor.andres@gmail.com');

INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles(id_usuario, id_rol) VALUES(1,1);
INSERT INTO usuarios_roles(id_usuario, id_rol) VALUES(2,1);
INSERT INTO usuarios_roles(id_usuario, id_rol) VALUES(2,2);

INSERT INTO productos(nombre, precio, create_at) VALUES('Sillón Gamer', 4000, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES('Apple iPhone 11', 9000, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES('Sony Camara', 7000, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES('Huawei Notebook', 6000, NOW());
INSERT INTO productos(nombre, precio, create_at) VALUES('Cafetera', 2000, NOW());

INSERT INTO facturas(descripcion, observacion, id_cliente, create_at) VALUES('Factura de prueba', null, 1, NOW());
INSERT INTO facturas_items(cantidad, id_factura, id_producto) VALUES(1,1,1);
INSERT INTO facturas_items(cantidad, id_factura, id_producto) VALUES(2,1,4);