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