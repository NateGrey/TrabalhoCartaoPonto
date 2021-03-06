﻿CREATE TABLE Funcionario(
  codigoCartao VARCHAR(6) PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  endereco VARCHAR(100) NOT NULL,
  funcao VARCHAR(50) NOT NULL
);

CREATE TABLE Frequencia(
  id SERIAL PRIMARY KEY,
  cCartao VARCHAR(6) NOT NULL,
  dia DATE NOT NULL,
  entrada TIME,
  intervalo TIME,
  volta TIME,
  saida TIME,
  FOREIGN KEY (cCartao) REFERENCES Funcionario (codigoCartao)
);

DROP TABLE Funcionario;
DROP TABLE Frequencia;

INSERT INTO Funcionario VALUES('123123','Funcionario 01','11111111111','Rua 01','Cargo 01');
INSERT INTO Funcionario VALUES('456456','Funcionario 02','22222222222','Rua 02','Cargo 02');
INSERT INTO Funcionario VALUES('789789','Funcionario 03','33333333333','Rua 03','Cargo 03');


SELECT * FROM Funcionario;

INSERT INTO Frequencia(cCartao,dia,entrada,intervalo,volta,saida) VALUES('123123','2012-10-31','07:58:12','12:00:01','13:59:14','18:01:53');
INSERT INTO Frequencia(cCartao,dia,entrada,intervalo,volta,saida) VALUES('456456','2012-10-31','08:01:14','11:59:11','14:00:14','17:56:32');
INSERT INTO Frequencia(cCartao,dia,entrada,intervalo,volta,saida) VALUES('789789','2012-10-31','07:59:50','12:05:33','13:57:41','18:00:26');
INSERT INTO Frequencia(cCartao,dia,entrada,intervalo,volta,saida) VALUES('123123','2012-11-01','07:58:52','12:01:41','13:59:59','18:00:23');
INSERT INTO Frequencia(cCartao,dia,entrada,intervalo,volta,saida) VALUES('456456','2012-11-01','07:55:00','12:04:33','13:55:15','18:04:45');
INSERT INTO Frequencia(cCartao,dia,entrada,intervalo,volta,saida) VALUES('789789','2012-11-01','08:00:02','11:59:09','14:00:10','18:00:14');

SELECT * FROM Frequencia;


CREATE OR REPLACE FUNCTION Dias_Trabalhados(VARCHAR(6),INTEGER) RETURNS INTEGER AS
$$
  DECLARE
    achou INTEGER;
  BEGIN
    IF ($2<0 OR $2>3) THEN
      RAISE NOTICE 'Entrada inválida!';
      RETURN 0;
    ELSE
      achou:=0;
      SELECT COUNT(*) INTO achou FROM Funcionario WHERE Funcionario.codigoCartao = $1;
      IF (achou<=0) THEN
	RAISE NOTICE 'Funcionário não cadastrado!';
	RETURN 0;
      ELSE
	IF ($2=0) THEN
	  INSERT INTO Frequencia (cCartao,dia,entrada) VALUES ($1,CURRENT_DATE,CURRENT_TIME(0));
	  RETURN 1;
	END IF;
	IF ($2=1) THEN
	  UPDATE Frequencia SET intervalo = CURRENT_TIME(0) WHERE cCartao = $1 AND dia = CURRENT_DATE;
	  RETURN 1;
	END IF;
	IF ($2=2) THEN
	  UPDATE Frequencia SET volta = CURRENT_TIME(0) WHERE cCartao = $1 AND dia = CURRENT_DATE;
	  RETURN 1;
	END IF;
	IF ($2=3) THEN
	  UPDATE Frequencia SET saida = CURRENT_TIME(0) WHERE cCartao = $1 AND dia = CURRENT_DATE;
	  RETURN 1;
	END IF;
      END IF;
    END IF;
 END;
$$
LANGUAGE 'PLPGSQL';

SELECT Dias_Trabalhados('123123',3);
SELECT * FROM Frequencia WHERE cCartao = '123123';

select extract(dow from now());

SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIME(0);
SELECT CURRENT_TIMESTAMP;
SELECT CURRENT_TIMESTAMP(0);

SELECT DATE_PART('DAY', CURRENT_TIMESTAMP) AS dia;
SELECT DATE_PART('MONTH', CURRENT_TIMESTAMP) AS mes;
SELECT DATE_PART('YEAR', CURRENT_TIMESTAMP) AS ano;