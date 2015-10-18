-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema wms_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema wms_db
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema wms_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema wms_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wms_db` DEFAULT CHARACTER SET utf8 ;
USE `wms_db` ;

-- -----------------------------------------------------
-- Table `wms_db`.`obra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`obra` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`obra` (
  `id_obra` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(100) NOT NULL COMMENT '',
  `descricao` VARCHAR(1000) NULL COMMENT '',
  `data_inicio` DATE NULL COMMENT '',
  `data_termino` DATE NULL COMMENT '',
  `data_prevista_termino` DATE NULL COMMENT '',
  `custo_previsto` DECIMAL(10,2) NULL COMMENT '',
  `custo_realizado` DECIMAL(10,2) NULL COMMENT '',
  PRIMARY KEY (`id_obra`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms_db`.`comentario_obra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`comentario_obra` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`comentario_obra` (
  `id_comentario` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `obra_numero_contrato` INT(11) NOT NULL COMMENT '',
  `obra_id_obra` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_comentario`)  COMMENT '',
  INDEX `fk_comentario_obra_obra_idx` (`obra_id_obra` ASC)  COMMENT '',
  CONSTRAINT `fk_comentario_obra_obra`
    FOREIGN KEY (`obra_id_obra`)
    REFERENCES `wms_db`.`obra` (`id_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms_db`.`centro_custo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`centro_custo` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`centro_custo` (
  `id_centro_custo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `id_obra` INT NOT NULL COMMENT '',
  `descricao` VARCHAR(1000) NULL COMMENT '',
  `saldo_atual` DECIMAL(10,2) NULL COMMENT '',
  PRIMARY KEY (`id_centro_custo`)  COMMENT '',
  INDEX `fk_centro_custo_obra1_idx` (`id_obra` ASC)  COMMENT '',
  CONSTRAINT `fk_centro_custo_obra1`
    FOREIGN KEY (`id_obra`)
    REFERENCES `wms_db`.`obra` (`id_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms_db`.`categoria_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`categoria_item` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`categoria_item` (
  `id_categoria_item` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id_categoria_item`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms_db`.`fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`fornecedor` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`fornecedor` (
  `id_fornecedor` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(100) NOT NULL COMMENT '',
  `telefone` VARCHAR(20) NOT NULL COMMENT '',
  `contato` VARCHAR(100) NOT NULL COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `observacao` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_fornecedor`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`subcategoria_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`subcategoria_item` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`subcategoria_item` (
  `id_subcategoria_item` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(45) NULL COMMENT '',
  `id_categoria_item` INT NOT NULL COMMENT '',
  `id_fornecedor` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_subcategoria_item`)  COMMENT '',
  INDEX `fk_subcategoria_item_categoria_item1_idx` (`id_categoria_item` ASC)  COMMENT '',
  INDEX `fk_subcategoria_item_fornecedor1_idx` (`id_fornecedor` ASC)  COMMENT '',
  CONSTRAINT `fk_subcategoria_item_categoria_item1`
    FOREIGN KEY (`id_categoria_item`)
    REFERENCES `wms_db`.`categoria_item` (`id_categoria_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_subcategoria_item_fornecedor1`
    FOREIGN KEY (`id_fornecedor`)
    REFERENCES `wms_db`.`fornecedor` (`id_fornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms_db`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`item` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`item` (
  `id_item` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(45) NULL COMMENT '',
  `id_subcategoria_item` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_item`)  COMMENT '',
  INDEX `fk_item_subcategoria_item1_idx` (`id_subcategoria_item` ASC)  COMMENT '',
  CONSTRAINT `fk_item_subcategoria_item1`
    FOREIGN KEY (`id_subcategoria_item`)
    REFERENCES `wms_db`.`subcategoria_item` (`id_subcategoria_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms_db`.`conta_bancaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`conta_bancaria` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`conta_bancaria` (
  `id_conta_bancaria` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `banco` INT(11) NOT NULL COMMENT '',
  `agencia` VARCHAR(10) NOT NULL COMMENT '',
  `conta_bancaria` VARCHAR(10) NOT NULL COMMENT '',
  `titular` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id_conta_bancaria`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`opcao_pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`opcao_pagamento` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`opcao_pagamento` (
  `id_opcao_pagamento` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `descricao` VARCHAR(45) NULL COMMENT '',
  `a_vista` TINYINT(1) NULL COMMENT '',
  `parcelado` TINYINT(1) NULL COMMENT '',
  PRIMARY KEY (`id_opcao_pagamento`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wms_db`.`conta_pagar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`conta_pagar` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`conta_pagar` (
  `id_conta_pagar` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nota_fiscal` VARCHAR(45) NOT NULL COMMENT '',
  `valor_conta` DECIMAL(10,0) NOT NULL COMMENT '',
  `data_vencimento` DATE NOT NULL COMMENT '',
  `data_pagamento` DATE NOT NULL COMMENT '',
  `tipo_pagamento` INT(11) NOT NULL COMMENT '',
  `tipo_conta` INT(11) NOT NULL COMMENT '',
  `observacao` VARCHAR(255) NULL COMMENT '',
  `n_parcelas` INT(11) NULL DEFAULT NULL COMMENT '',
  `status` TINYINT(1) NOT NULL COMMENT '',
  `id_fornecedor` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_conta_pagar`)  COMMENT '',
  INDEX `fk_conta_pagar_fornecedor1_idx` (`id_fornecedor` ASC)  COMMENT '',
  CONSTRAINT `fk_conta_pagar_fornecedor1`
    FOREIGN KEY (`id_fornecedor`)
    REFERENCES `wms_db`.`fornecedor` (`id_fornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`forma_pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`forma_pagamento` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`forma_pagamento` (
  `id_dados_pagamento` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `descricao` VARCHAR(255) CHARACTER SET 'big5' COLLATE 'big5_bin' NULL COMMENT '',
  `forma_pagamento` INT NULL COMMENT '',
  `data_desconto_cheque` DATE NULL COMMENT '',
  `valor` DECIMAL(10,2) NULL COMMENT '',
  `num_parcelas` INT NULL COMMENT '',
  `data_emissao_boleto` DATE NULL COMMENT '',
  `data_vencimento_boleto` DATE NULL COMMENT '',
  `dia_vencimento_creditol` INT NULL COMMENT '',
  `dia_fechamento_credito` INT NULL COMMENT '',
  `observacao` VARCHAR(255) NULL COMMENT '',
  `id_conta_bancaria` INT(11) NOT NULL COMMENT '',
  `id_opcao_pagamento` INT NOT NULL COMMENT '',
  `id_conta_pagar` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_dados_pagamento`)  COMMENT '',
  INDEX `fk_dados_pagamento_conta_bancaria1_idx` (`id_conta_bancaria` ASC)  COMMENT '',
  INDEX `fk_forma_pagamento_opcao_pagamento1_idx` (`id_opcao_pagamento` ASC)  COMMENT '',
  INDEX `fk_forma_pagamento_conta_pagar1_idx` (`id_conta_pagar` ASC)  COMMENT '',
  CONSTRAINT `fk_dados_pagamento_conta_bancaria1`
    FOREIGN KEY (`id_conta_bancaria`)
    REFERENCES `wms_db`.`conta_bancaria` (`id_conta_bancaria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_forma_pagamento_opcao_pagamento1`
    FOREIGN KEY (`id_opcao_pagamento`)
    REFERENCES `wms_db`.`opcao_pagamento` (`id_opcao_pagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_forma_pagamento_conta_pagar1`
    FOREIGN KEY (`id_conta_pagar`)
    REFERENCES `wms_db`.`conta_pagar` (`id_conta_pagar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `wms_db` ;

-- -----------------------------------------------------
-- Table `wms_db`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`cliente` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome_razao_social` VARCHAR(100) NOT NULL COMMENT '',
  `cpf_cnpj` VARCHAR(20) NOT NULL COMMENT '',
  `nome_fantasia` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  `telefone` VARCHAR(20) NULL COMMENT '',
  `rg` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `cep` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `bairro` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `logradouro` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `numero` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `complemento` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `observacao` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_cliente`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`usuario` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `login` VARCHAR(45) NOT NULL COMMENT '',
  `senha` VARCHAR(45) NOT NULL COMMENT '',
  `perfil` INT(1) NOT NULL COMMENT '',
  PRIMARY KEY (`id_usuario`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`unidade_obra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`unidade_obra` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`unidade_obra` (
  `id_unidade_obra` int(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome_obra` VARCHAR(100) NOT NULL COMMENT '',
  `descricao` VARCHAR(1000) NULL COMMENT '',
  `valor_previsto_venda` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '',
  `valor_realizado_venda` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '',
  `data_inicio` DATE NULL COMMENT '',
  `data_prevista_termino` DATE NULL DEFAULT NULL COMMENT '',
  `data_venda` DATE NULL COMMENT '',
  `data_entrega` DATE NULL DEFAULT NULL COMMENT '',
  `id_cliente` INT(11) NULL COMMENT '',
  `id_usuario` INT(11) NOT NULL COMMENT '',
  `obra_id_obra` INT NOT NULL COMMENT '',
  INDEX `fk_obra_cliente1_idx` (`id_cliente` ASC)  COMMENT '',
  INDEX `fk_obra_usuario1_idx` (`id_usuario` ASC)  COMMENT '',
  PRIMARY KEY (`id_unidade_obra`)  COMMENT '',
  INDEX `fk_unidade_obra_obra1_idx` (`obra_id_obra` ASC)  COMMENT '',
  CONSTRAINT `fk_obra_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `wms_db`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_obra_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `wms_db`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_unidade_obra_obra1`
    FOREIGN KEY (`obra_id_obra`)
    REFERENCES `wms_db`.`obra` (`id_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`conta_receber`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`conta_receber` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`conta_receber` (
  `id_conta` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nota_fiscal` VARCHAR(45) NOT NULL COMMENT '',
  `valor_conta` DECIMAL(10,0) NOT NULL COMMENT '',
  `data_vencimento` DATE NOT NULL COMMENT '',
  `data_pagamento` DATE NOT NULL COMMENT '',
  `tipo_pagamento` INT(11) NOT NULL COMMENT '',
  `tipo_conta` INT(11) NOT NULL COMMENT '',
  `observacao` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `n_parcelas` INT(11) NULL DEFAULT NULL COMMENT '',
  `status` TINYINT(1) NOT NULL COMMENT '',
  `id_dados_pagamento` INT NOT NULL COMMENT '',
  `id_unidade_obra` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_conta`)  COMMENT '',
  INDEX `fk_conta_receber_forma_pagamento1_idx` (`id_dados_pagamento` ASC)  COMMENT '',
  INDEX `fk_conta_receber_unidade_obra1_idx` (`id_unidade_obra` ASC)  COMMENT '',
  CONSTRAINT `fk_conta_receber_forma_pagamento1`
    FOREIGN KEY (`id_dados_pagamento`)
    REFERENCES `wms_db`.`forma_pagamento` (`id_dados_pagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conta_receber_unidade_obra1`
    FOREIGN KEY (`id_unidade_obra`)
    REFERENCES `wms_db`.`unidade_obra` (`id_unidade_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`lancamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`lancamento` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`lancamento` (
  `id_lancamento` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `valor_lancamento` DECIMAL(10,0) NOT NULL COMMENT '',
  `data_lancamento` DATE NOT NULL COMMENT '',
  `observacao` VARCHAR(1000) NULL DEFAULT NULL COMMENT '',
  `id_conta_pagar` INT(11) NULL COMMENT '',
  `id_conta_receber` INT(11) NULL COMMENT '',
  `id_centro_custo` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_lancamento`)  COMMENT '',
  INDEX `fk_lancamento_conta1_idx` (`id_conta_pagar` ASC)  COMMENT '',
  INDEX `fk_lancamento_conta_receber1_idx` (`id_conta_receber` ASC)  COMMENT '',
  INDEX `fk_lancamento_centro_custo1_idx` (`id_centro_custo` ASC)  COMMENT '',
  CONSTRAINT `fk_lancamento_conta1`
    FOREIGN KEY (`id_conta_pagar`)
    REFERENCES `wms_db`.`conta_pagar` (`id_conta_pagar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamento_conta_receber1`
    FOREIGN KEY (`id_conta_receber`)
    REFERENCES `wms_db`.`conta_receber` (`id_conta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lancamento_centro_custo1`
    FOREIGN KEY (`id_centro_custo`)
    REFERENCES `wms_db`.`centro_custo` (`id_centro_custo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`anexo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`anexo` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`anexo` (
  `id_anexo` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(255) NOT NULL COMMENT '',
  `descricao` TEXT NULL COMMENT '',
  `arquivo` BLOB NOT NULL COMMENT '',
  `id_lancamento` INT(11) NULL COMMENT '',
  `id_unidade_obra` INT(11) NULL COMMENT '',
  `id_obra` INT NULL COMMENT '',
  `id_conta_pagar` INT(11) NULL COMMENT '',
  `id_conta_receber` INT(11) NULL COMMENT '',
  PRIMARY KEY (`id_anexo`)  COMMENT '',
  INDEX `fk_anexo_lancamento1_idx` (`id_lancamento` ASC)  COMMENT '',
  INDEX `fk_anexo_unidade_obra1_idx` (`id_unidade_obra` ASC)  COMMENT '',
  INDEX `fk_anexo_obra1_idx` (`id_obra` ASC)  COMMENT '',
  INDEX `fk_anexo_conta_pagar1_idx` (`id_conta_pagar` ASC)  COMMENT '',
  INDEX `fk_anexo_conta_receber1_idx` (`id_conta_receber` ASC)  COMMENT '',
  CONSTRAINT `fk_anexo_lancamento1`
    FOREIGN KEY (`id_lancamento`)
    REFERENCES `wms_db`.`lancamento` (`id_lancamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anexo_unidade_obra1`
    FOREIGN KEY (`id_unidade_obra`)
    REFERENCES `wms_db`.`unidade_obra` (`id_unidade_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anexo_obra1`
    FOREIGN KEY (`id_obra`)
    REFERENCES `wms_db`.`obra` (`id_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anexo_conta_pagar1`
    FOREIGN KEY (`id_conta_pagar`)
    REFERENCES `wms_db`.`conta_pagar` (`id_conta_pagar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anexo_conta_receber1`
    FOREIGN KEY (`id_conta_receber`)
    REFERENCES `wms_db`.`conta_receber` (`id_conta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`empresa` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`empresa` (
  `id_empresa` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `razao_social` VARCHAR(255) NOT NULL COMMENT '',
  `nome_fantasia` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `cnpj` VARCHAR(20) NOT NULL COMMENT '',
  `telefone` VARCHAR(20) NOT NULL COMMENT '',
  `contato` VARCHAR(255) NOT NULL COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`id_empresa`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`fase`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`fase` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`fase` (
  `id_fase` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome_fase` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`id_fase`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`fase_obra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`fase_obra` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`fase_obra` (
  `id_fase_obra` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `valor_previsto` DECIMAL(10,0) NULL DEFAULT NULL COMMENT '',
  `valor_realizado` DECIMAL(10,0) NULL DEFAULT NULL COMMENT '',
  `data_prevista_inicio` DATE NULL DEFAULT NULL COMMENT '',
  `data_inicio` DATE NULL DEFAULT NULL COMMENT '',
  `data_prevista_termino` DATE NULL DEFAULT NULL COMMENT '',
  `data_termino` DATE NULL COMMENT '',
  `observacao` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `status` INT(11) NOT NULL COMMENT '',
  `id_fase` INT(11) NOT NULL COMMENT '',
  `id_unidade_obra` INT(11) NOT NULL COMMENT '',
  `id_conta` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_fase_obra`)  COMMENT '',
  INDEX `fk_fase_obra_fase1_idx` (`id_fase` ASC)  COMMENT '',
  INDEX `fk_fase_obra_unidade_obra1_idx` (`id_unidade_obra` ASC)  COMMENT '',
  INDEX `fk_fase_obra_conta_pagar1_idx` (`id_conta` ASC)  COMMENT '',
  CONSTRAINT `fk_fase_obra_fase1`
    FOREIGN KEY (`id_fase`)
    REFERENCES `wms_db`.`fase` (`id_fase`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fase_obra_unidade_obra1`
    FOREIGN KEY (`id_unidade_obra`)
    REFERENCES `wms_db`.`unidade_obra` (`id_unidade_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fase_obra_conta_pagar1`
    FOREIGN KEY (`id_conta`)
    REFERENCES `wms_db`.`conta_pagar` (`id_conta_pagar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`funcao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`funcao` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`funcao` (
  `id_funcao` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(1000) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_funcao`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '	';


-- -----------------------------------------------------
-- Table `wms_db`.`colaborador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`colaborador` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`colaborador` (
  `id_funcionario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(200) NOT NULL COMMENT '',
  `cpf_cnpj` VARCHAR(20) NOT NULL COMMENT '',
  `telefone` VARCHAR(20) NOT NULL COMMENT '',
  `data_nasc` DATE NULL DEFAULT NULL COMMENT '',
  `rg` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `cep` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `bairro` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  `logradouro` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  `numero` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `complemento` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `carteira_trabalho` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `numero_contrato` INT(11) NOT NULL COMMENT '',
  `id_empresa` INT(11) NOT NULL COMMENT '',
  `id_funcao` INT(11) NOT NULL COMMENT '',
  `salario` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '',
  `obra_id_obra` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_funcionario`)  COMMENT '',
  INDEX `fk_funcionario_funcao1_idx` (`id_funcao` ASC)  COMMENT '',
  INDEX `fk_funcionario_empresa_terceirizada1_idx` (`id_empresa` ASC)  COMMENT '',
  INDEX `fk_colaborador_obra1_idx` (`obra_id_obra` ASC)  COMMENT '',
  CONSTRAINT `fk_funcionario_empresa_terceirizada1`
    FOREIGN KEY (`id_empresa`)
    REFERENCES `wms_db`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_funcao1`
    FOREIGN KEY (`id_funcao`)
    REFERENCES `wms_db`.`funcao` (`id_funcao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_colaborador_obra1`
    FOREIGN KEY (`obra_id_obra`)
    REFERENCES `wms_db`.`obra` (`id_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`parcela`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`parcela` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`parcela` (
  `id_parcela` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `n_parcela` DECIMAL(10,0) NOT NULL COMMENT '',
  `data_vencimento` DATE NOT NULL COMMENT '',
  `valor_parcela` DECIMAL(10,0) NOT NULL COMMENT '',
  `status` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '',
  `id_boleto` INT NULL COMMENT '',
  `id_cartao_credito` INT NULL COMMENT '',
  `id_cheque` INT(11) NULL COMMENT '',
  `id_dados_pagamento` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_parcela`)  COMMENT '',
  INDEX `fk_parcela_forma_pagamento1_idx` (`id_dados_pagamento` ASC)  COMMENT '',
  CONSTRAINT `fk_parcela_forma_pagamento1`
    FOREIGN KEY (`id_dados_pagamento`)
    REFERENCES `wms_db`.`forma_pagamento` (`id_dados_pagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`tarefa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`tarefa` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`tarefa` (
  `id_tarefa` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id_tarefa`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`tarefa_obra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`tarefa_obra` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`tarefa_obra` (
  `id_tarefa_obra` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `progresso` DECIMAL(3,2) NOT NULL COMMENT '',
  `observacao` VARCHAR(1000) NULL DEFAULT NULL COMMENT '',
  `status` INT(11) NOT NULL COMMENT '',
  `id_fase` INT(11) NOT NULL COMMENT '',
  `id_tarefa` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id_tarefa_obra`)  COMMENT '',
  INDEX `fk_tarefa_obra_fase_obra1_idx` (`id_fase` ASC)  COMMENT '',
  INDEX `fk_tarefa_obra_tarefa1_idx` (`id_tarefa` ASC)  COMMENT '',
  CONSTRAINT `fk_tarefa_obra_fase_obra1`
    FOREIGN KEY (`id_fase`)
    REFERENCES `wms_db`.`fase_obra` (`id_fase_obra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarefa_obra_tarefa1`
    FOREIGN KEY (`id_tarefa`)
    REFERENCES `wms_db`.`tarefa` (`id_tarefa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wms_db`.`conta_pagar_has_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wms_db`.`conta_pagar_has_item` ;

CREATE TABLE IF NOT EXISTS `wms_db`.`conta_pagar_has_item` (
  `id_conta_pagar` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `id_item` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_conta_pagar`, `id_item`)  COMMENT '',
  INDEX `fk_conta_pagar_has_item_item1_idx` (`id_item` ASC)  COMMENT '',
  INDEX `fk_conta_pagar_has_item_conta_pagar1_idx` (`id_conta_pagar` ASC)  COMMENT '',
  CONSTRAINT `fk_conta_pagar_has_item_conta_pagar1`
    FOREIGN KEY (`id_conta_pagar`)
    REFERENCES `wms_db`.`conta_pagar` (`id_conta_pagar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_conta_pagar_has_item_item1`
    FOREIGN KEY (`id_item`)
    REFERENCES `wms_db`.`item` (`id_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
