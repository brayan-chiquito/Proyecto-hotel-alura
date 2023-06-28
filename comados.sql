ALTER TABLE huespedes
ADD CONSTRAINT fk_idReserva FOREIGN KEY (idReserva)
REFERENCES reservas (id);
SHOW COLUMNS FROM reservas LIKE 'id';
SHOW COLUMNS FROM huespedes LIKE 'id';

select * from reservas;
select * from huespedes;

delete from huespedes;
delete from reservas;

ALTER TABLE reservas AUTO_INCREMENT = 0;
ALTER TABLE huespedes AUTO_INCREMENT = 0;

ALTER TABLE huespedes
DROP FOREIGN KEY fk_idReserva;

ALTER TABLE huespedes
ADD CONSTRAINT fk_idReserva
FOREIGN KEY (idReserva)
REFERENCES reservas(id)
ON DELETE CASCADE;

SELECT LAST_INSERT_ID() AS last_id FROM huespedes;
SELECT LAST_INSERT_ID() AS last_id FROM reservas;

SELECT MAX(id) AS last_id FROM huespedes;
SELECT MAX(id) AS last_id FROM reservas;

SELECT COALESCE(MAX(id), 0) AS last_id FROM huespedes;
SELECT COALESCE(MAX(id), 0) AS last_id FROM reservas;

ALTER TABLE huespedes
DROP FOREIGN KEY fk_idReserva;

alter table medicos add activo tinyint;
update medicos set activo = 1;

alter table huespedes add activo tinyint;
alter table reservas add activo tinyint;
update reservas set activo = 1;

SELECT ID, FECHAENTRADA, FECHASALIDA, VALOR, FORMAPAGO, ACTIVO FROM RESERVAS WHERE ID = 1 and activo = 1;