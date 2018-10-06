SELECT * FROM `springsopraninja_bd`.`users`;

SELECT * FROM `springsopraninja_bd`.`user_roles`;

/* 
   PARA CREAR UN USUARIO PRIMERO OBTENEMOS SU PASSWORD ENCRIPTADO HACIENDO 'RUN AS JAVA APPLICATION'
   EN LA CLASE DE JAVA 'TestCrypt.java'. UNA VEZ OBTENIDO EL PASSWORD ENCRIPTADO PROCEDEMOS A DAR DE
   ALTA EL USUARIO HACIENDO EL PRIMER INSERT CON SU USERNAME, ENABLED 0=NO 1=SI Y SU PASSWORD YA ENCRIPTADO.
   Y A CONTINUACION REALIZAMOS EL SEGUNDO INSERT CON SU USERNAME Y SU ROL Y COMPROBAMOS QUE SE HA INTRODUCIDO
   CORRECTAMENTE REALIZANDO DE NUEVO LAS 2 SELECTS DE LAS PRIMERAS LINEAS DE ESTA HOJA SQL
*/

-- CREACION USUARIO admin -- 
-- INSERT 1 -- TABLA 'users' -- usuario 'admin' -- password 'admin' -- password encriptado -- '' --
INSERT INTO `springsopraninja_bd`.`users` (`username`, `enabled`, `password`) VALUES ('admin', 1, '$2a$10$oxZnBLUw9PwmYUw96HHw4OqL1i4dadDK6QLeqD0wGotpmkiAr5HMW');

-- INSERT 2 -- TABLA 'user_roles' -- usuario 'admin' -- role 'ROLE_USER' 
INSERT INTO `springsopraninja_bd`.`user_roles`(`username`, `role`) VALUES ('admin', 'ROLE_USER');



-- CREACION USUARIO juan -- 
-- INSERT 1 -- TABLA 'users' -- usuario 'juan' -- password 'jkgzenna' -- password encriptado -- '$2a$10$jFcSzq2iqj6IrApTOMyzGeGYR.K5oFXihwrtgYklcNQ/X.X8oopai --
INSERT INTO `springsopraninja_bd`.`users` (`username`, `enabled`, `password`) VALUES ('juan', 1, '$2a$10$jFcSzq2iqj6IrApTOMyzGeGYR.K5oFXihwrtgYklcNQ/X.X8oopai');

-- INSERT 2 -- TABLA 'user_roles' -- usuario 'juan' -- role 'ROLE_USER' 
INSERT INTO `springsopraninja_bd`.`user_roles`(`username`, `role`) VALUES ('juan', 'ROLE_USER');