-- drop database controle_vendas;
create database controle_vendas;
use controle_vendas;

create table usuarios (
    cod_usuario INT NOT NULL AUTO_INCREMENT,
	nome_usuario VARCHAR(220) NOT NULL,
    email_usuario VARCHAR(220) NOT NULL UNIQUE,
    telefone__usuario VARCHAR(30) NOT NULL,
    cpf_usuario VARCHAR(30) NOT NULL,
    data_cadastro_usuario TIMESTAMP NOT NULL DEFAULT current_timestamp(),
    tipo_usuario ENUM('usuario', 'cliente', 'administrador') NOT NULL DEFAULT 'usuario',
    
    constraint pk_usuarios primary key (cod_usuario)
);

create table administradores (
    cod_usuario INT NOT NULL,
	senha_admin VARCHAR(220) NOT NULL,
    
    constraint pk_administradores primary key (cod_usuario),
    constraint fk_admin_usuarios foreign key (cod_usuario) references usuarios(cod_usuario)
);

create table clientes (
    cod_usuario INT NOT NULL,
	data_nascimento_cliente DATE NOT NULL,
    
    constraint pk_clientes primary key (cod_usuario),
    constraint fk_clientes_usuarios foreign key (cod_usuario) references usuarios(cod_usuario)
);

create table produtos (
    cod_produto INT NOT NULL AUTO_INCREMENT,
	nome_produto VARCHAR(220) NOT NULL,
    preco_produto DOUBLE NOT NULL,
    estoque INT NOT NULL,
    peso_produto DOUBLE NOT NULL,
    largura_produto DOUBLE NOT NULL,
    descricao_produto TEXT,
    data_cadastro_produto TIMESTAMP NOT NULL DEFAULT current_timestamp(),
    
    constraint pk_produtos primary key (cod_produto)
);

create table categorias (
    cod_categoria INT NOT NULL AUTO_INCREMENT,
	nome_categoria VARCHAR(220) NOT NULL UNIQUE,
    descricao_categoria TEXT,
    data_cadastro_categoria TIMESTAMP NOT NULL DEFAULT current_timestamp(),
    
    constraint pk_categorias primary key (cod_categoria)
);

create table produto_categoria (
    cod_produto INT NOT NULL,
    cod_categoria INT NOT NULL,
    
    constraint pk_produto_categoria primary key (cod_produto, cod_categoria),
    constraint fk_produtoCategoria_produtos foreign key (cod_produto) references produtos(cod_produto),
    constraint fk_produtoCategoria_categorias foreign key (cod_categoria) references categorias(cod_categoria)
);

create table pedidos (
    cod_pedido INT NOT NULL AUTO_INCREMENT,
    cod_usuario INT NOT NULL,
    descricao_pedido TEXT,
    total_pedido DOUBLE,
	data_pedido TIMESTAMP NOT NULL DEFAULT current_timestamp(),
    
    constraint pk_pedidos primary key (cod_pedido),
    constraint fk_pedidos_usuarios foreign key (cod_usuario) references usuarios(cod_usuario)
);

create table itens_pedidos (
    cod_pedido INT NOT NULL,
    cod_produto INT NOT NULL,
    
    constraint pk_itens_pedidos primary key (cod_pedido, cod_produto),
    constraint fk_itensPedidos_pedidos foreign key (cod_pedido) references pedidos(cod_pedido),
    constraint fk_itensPedidos_produtos foreign key (cod_produto) references produtos(cod_produto)
);

-- INSERINDO ADMINISTRADOR PARA EFETUAR LOGIN
INSERT INTO usuarios (nome_usuario,cpf_usuario,email_usuario,tipo_usuario,telefone__usuario)
VALUES ("Admin","111.111.111-11","admin@admin.com", "administrador", "(17)99999-999");

INSERT INTO administradores (cod_usuario, senha_admin) VALUES (1,"admin");