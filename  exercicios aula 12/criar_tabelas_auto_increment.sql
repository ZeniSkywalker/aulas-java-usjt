CREATE DATABASE cadastro_clientes;
USE cadastro_clientes;

CREATE TABLE cliente (
  id     SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  nome   VARCHAR(60) NOT NULL,
  fone   CHAR(10),
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE pedido (
  id         SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  data       DATE NOT NULL,
  valor      NUMERIC (10, 2) NOT NULL,
  id_cliente SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

ALTER TABLE pedido ADD FOREIGN KEY (id_cliente)
  REFERENCES cliente (id)
  ON DELETE RESTRICT
  ON UPDATE RESTRICT;
  
INSERT INTO cliente (id, nome, fone) VALUES 
(1, 'Adriano Arruda', '1322444422'),
(2, 'Sonia Costa', '1123456789'),
(3, 'Amanda Pizarro', '1567890098'),
(4, 'Orioles Junior', '6177899987'),
(5, 'Fabio Henrique Silva', '1222344321'),
(6, 'Zelia Amato', '6599554433');

INSERT INTO pedido (data, valor, id_cliente) VALUES 
('2015-10-01', 1045.77, 1),
('2015-10-02', 210.00, 1),
('2015-10-03', 38.90, 1),
('2015-10-04', 12.01, 2),
('2015-10-05', 138.90, 2),
('2015-10-06', 318.90, 2),
('2015-10-07', 381.90, 2),
('2015-10-08', 328.90, 2),
('2015-10-09', 338.90, 2),
('2015-10-10', 3438.90, 3),
('2015-10-10', 1238.90, 4),
('2015-10-11', 3238.90, 5),
('2015-10-12', 308.90, 5),
('2015-10-14', 328.90, 5),
('2015-10-15', 318.90, 5),
('2015-10-16', 138.90, 5),
('2015-10-17', 138.90, 5),
('2015-10-18', 438.90, 6),
('2015-10-19', 538.90, 6),
('2015-10-20', 638.90, 6),
('2015-10-21', 738.90, 6),
('2015-10-22', 838.90, 6),
('2015-10-23', 938.90, 6),
('2015-10-24', 1138.90, 6),
('2015-10-25', 1238.90, 6),
('2015-10-26', 138.90, 6),
('2015-10-27', 238.90, 6),
('2015-10-28', 538.90, 6),
('2015-10-29', 638.90, 6),
('2016-10-18', 438.90, 6),
('2016-10-19', 538.90, 6),
('2016-10-20', 638.90, 6),
('2016-10-21', 738.90, 6),
('2016-10-22', 838.90, 6),
('2016-10-23', 938.90, 6),
('2016-10-24', 1138.90, 6),
('2016-10-25', 1238.90, 6),
('2016-10-26', 138.90, 6),
('2016-10-27', 238.90, 6),
('2016-10-28', 538.90, 6),
('2016-10-29', 638.90, 6);

SELECT c.id, c.nome, c.fone, p.id, p.data, p.valor 
from CLIENTE C, PEDIDO P 
WHERE C.id = P.id_cliente;

