CREATE DATABASE farmacia;

CREATE TABLE `cliente`(
  `clie_cpf` VARCHAR(14) PRIMARY KEY NOT NULL,
  `clie_nome` VARCHAR(64) NOT NULL,
  `clie_rg` VARCHAR(12) NOT NULL,
  `clie_sexo` VARCHAR(1) NOT NULL,
  `clie_planosaude` VARCHAR(30),
  `clie_desconto` VARCHAR(3),
  `clie_tel` VARCHAR(12) NOT NULL,
  `clie_cep` VARCHAR(9) NOT NULL,
  `clie_rua` VARCHAR(30) NOT NULL,
  `clie_numero` VARCHAR(5) NOT NULL,
  `clie_bairro` VARCHAR(30) NOT NULL
);

CREATE TABLE `compra` (
  `compra_numnf` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `prod_codigo` INT(11) NOT NULL,
  `clie_cpf` VARCHAR(14) NOT NULL,
  `func_cpf` VARCHAR(14) NOT NULL,
  `compra_data` VARCHAR(10) NOT NULL,
  `compra_valor` DECIMAL(10, 2) NOT NULL,
  `compra_qtd` INT(11) NOT NULL,
  `compra_pag` VARCHAR(30) NOT NULL
);

CREATE TABLE `farmaceutico` (
  `farma_crf` VARCHAR(5) PRIMARY KEY NOT NULL,
  `func_cpf` VARCHAR(14) NOT NULL
);

CREATE TABLE `funcionario`(
  `func_cpf` VARCHAR(14) PRIMARY KEY NOT NULL,
  `func_rg` VARCHAR(12) NOT NULL,
  `func_dtnascimento` DATE NOT NULL,
  `func_sexo` VARCHAR(1) NOT NULL,
  `func_nome` VARCHAR(64) NOT NULL,
  `func_cep` VARCHAR(9) NOT NULL,
  `func_rua` VARCHAR(30) NOT NULL,
  `func_bairro` VARCHAR(30) NOT NULL,
  `func_numero` VARCHAR(5) NOT NULL
);

CREATE TABLE `produto`(
  `prod_codigo` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `prod_nome` VARCHAR(50) NOT NULL,
  `prod_categoria` VARCHAR(50) NOT NULL,
  `prod_estoque` INT(11) NOT NULL,
  `prod_fornecedor` VARCHAR(50) NOT NULL,
  `prod_preco` DECIMAL(10, 2) NOT NULL,
  `prod_marca` VARCHAR(50) NOT NULL,
  `prod_dtvalidade` DATE NOT NULL
);

ALTER TABLE `farmaceutico` ADD CONSTRAINT func_cpf
FOREIGN KEY (`func_cpf`) REFERENCES `funcionario` (`func_cpf`);

ALTER TABLE `compra` ADD CONSTRAINT produto_compra_fk
FOREIGN KEY (`prod_codigo`) REFERENCES `produto` (`prod_codigo`);

ALTER TABLE `compra` ADD CONSTRAINT cliente_compra_fk
FOREIGN KEY (`clie_cpf`) REFERENCES `cliente` (`clie_cpf`);

ALTER TABLE `compra` ADD CONSTRAINT funcionario_compra_fk
FOREIGN KEY (`func_cpf`) REFERENCES `funcionario` (`func_cpf`);

INSERT INTO `cliente` (`clie_cpf`, `clie_nome`, `clie_rg`, `clie_sexo`, `clie_planosaude`, `clie_desconto`, `clie_tel`, `clie_cep`, `clie_rua`, `clie_numero`, `clie_bairro`) VALUES
('111.111.111-11', 'Claudio Cabral', '11.111.111-1', 'M', '', '', '1111-1111', '11111-11', 'Rua do DBA', '0001', 'ADM de BD'),
('123.456.789-0X', 'Debora Miyake', '12.345.678-9', 'F', 'Saude +', '10', '1234-5678', '12345678', 'Rua das Rosas', '0123', 'Jd. das Flores'),
('999.888.777-55', 'Victor Sousa', '99.888.777-5', 'M', '', '', '9988-7755', '99887722', 'R. Jose Rei das Ceramicas', '9988', 'São Treze'),
('X09.876.543-21', 'Gabriela Duarte', '98.765.432-1', 'F', 'Vida Longa', '5', '9876-5432', '87654321', 'Av. Tiradentes', '9876', 'Liberdade');

INSERT INTO `farmaceutico` (`farma_crf`, `func_cpf`) VALUES ('89561', '314.793.311-39');

INSERT INTO `funcionario` (`func_cpf`, `func_rg`, `func_dtnascimento`, `func_sexo`, `func_nome`, `func_cep`, `func_rua`, `func_bairro`, `func_numero`) VALUES
('314.793.311-39', '22.931.928-2', '1980-08-27', 'F', 'Eduarda Isabelle Dias', '58055-710', 'Rua Dineza Carneiro Monteiro', 'Mangabeira', '234C'),
('688.540.376-80', '24.668.927-4', '1988-03-06', 'F', 'Simone Nunes', '84060-270', 'Rua Osório Subtil Marçal', 'Contorno', '100'),
('698.856.281-85', '10.057.146-3', '1991-07-13', 'M', 'Luiz Henrique Gomes', '69313-688', 'Avenida Rui Baraúna', 'Jardim Caranã', '814A');

INSERT INTO `produto` (`prod_codigo`, `prod_nome`, `prod_categoria`, `prod_estoque`, `prod_fornecedor`, `prod_preco`, `prod_marca`, `prod_dtvalidade`) VALUES
(1, 'Sulfato de Neomicina 15g', 'Medicamento', 1000, 'Remedicos LTDA', '9.82', 'Medley', '2022-12-01'),
(2, 'Dorflex - 10 cápsulas', 'Medicamento', 99, 'Med+ SA', '5.50', 'Sanofi', '2023-06-16'),
(3, 'Creme Dental Colgate Total 12', 'Higiene', 500, 'ColBras Transp', '9.99', 'Colgate', '2022-01-01'),
(4, 'Creme Hidratante Facial', 'Beleza', 10, 'Nivea do Brasil', '25.50', 'Nivea', '2024-02-02');
