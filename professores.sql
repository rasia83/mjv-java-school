-- CREATE DATABASE IF NOT EXISTS school CHARACTER SET utf8 COLLATE utf8_general_ci;
-- USE school;

CREATE TABLE professores (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  data_nascimento date,
  carga_horaria time,
  valor_hora double,
  estrangeiro tinyint,
  horas_disponiveis int,
  biografia text,
  data_hora_cadastro datetime,
  PRIMARY KEY (id)
) ;

-- usando MySQL
-- carga_horaria estava como date na modelagem, descobrir como o campo sera usado, salvas as horas semanais ou mensais do professor ?
-- boleano para o MySQL vejo que é para registar como tinyint
-- https://dev.mysql.com/doc/refman/8.0/en/other-vendor-data-types.html
-- biografia, avaliar o uso do text, se for uma grande quantidade de texto para ficar armazenado separado da tabela dentro do banco

INSERT INTO professores (nome, data_nascimento, carga_horaria, valor_hora, estrangeiro, horas_disponiveis, biografia, data_hora_cadastro) VALUES
('Albert Einstein', '1879-03-14', '40:00:00', 50.0, 0, 40, 'Albert Einstein foi um físico alemão...', NOW()),
('Marie Curie', '1867-11-07', '35:00:00', 45.0, 0, 35, 'Marie Curie foi uma cientista polonesa...', NOW()),
('Isaac Newton', '1643-01-04', '38:00:00', 55.0, 0, 38, 'Isaac Newton foi um físico e matemático...', NOW()),
('Ada Lovelace', '1815-12-10', '30:00:00', 40.0, 0, 30, 'Ada Lovelace foi uma matemática...', NOW()),
('Nikola Tesla', '1856-07-10', '42:00:00', 60.0, 1, 42, 'Nikola Tesla foi um inventor e engenheiro...', NOW()),
('Rosalind Franklin', '1920-07-25', '32:00:00', 42.5, 0, 32, 'Rosalind Franklin foi uma química e cristalógrafa...', NOW()),
('Alan Turing', '1912-06-23', '36:00:00', 48.75, 0, 36, 'Alan Turing foi um matemático e cientista da computação...', NOW()),
('Grace Hopper', '1906-12-09', '34:00:00', 47.5, 0, 34, 'Grace Hopper foi uma cientista da computação...', NOW()),
('Katherine Johnson', '1918-08-26', '31:00:00', 43.75, 0, 31, 'Katherine Johnson foi uma matemática e cientista espacial...', NOW()),
('Leonardo da Vinci', '1452-04-15', '37:00:00', 52.5, 0, 37, 'Leonardo da Vinci foi um artista e inventor italiano...', NOW());

SELECT * FROM professores;