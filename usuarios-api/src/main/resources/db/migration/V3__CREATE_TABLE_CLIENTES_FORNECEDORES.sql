CREATE TABLE IF NOT EXISTS `tb_clientes`(
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `cpf` VARCHAR(11) NOT NULL UNIQUE,
    `data_nascimento` DATE NOT NULL,
    `usuario_id` BIGINT NOT NULL,
    FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuarios`(id)
);
