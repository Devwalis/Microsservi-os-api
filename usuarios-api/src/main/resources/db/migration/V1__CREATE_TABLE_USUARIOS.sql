CREATE TABLE IF NOT EXISTS `tb_usuarios`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `nome` VARCHAR(150) NOT NULL,
    `email` VARCHAR(150) NOT NULL UNIQUE,
    `senha` VARCHAR(150) NOT NULL,
    `telefone` VARCHAR(150),
    `celular` VARCHAR(150) NOT NULL,
    `administrador` BIT(1) NOT NULL,
    `colaborador` BIT(1) NOT NULL,
    `usuario_externo` BIT(1) NOT NULL
);