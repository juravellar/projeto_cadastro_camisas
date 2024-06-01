drop table produtos;

CREATE TABLE produtos (
    pro_id SERIAL PRIMARY KEY,
    pro_nomeProduto VARCHAR(100) NOT NULL,
    pro_tamanho VARCHAR(10) NOT NULL,
    pro_cor VARCHAR(20) NOT NULL,
    pro_tipo VARCHAR(20) NOT NULL
);
