-- Inserir estabelecimento
INSERT INTO estabelecimento (cnpj, nome, conta_bancaria, endereco, pix_copia_cola) VALUES
('15576315825589', 'UM SUSHI', '12345-6', 'Rua dos Camelos', '00020126360014BR.GOV.BCB.PIX0114+5599999999995204000053039865802BR5909UmSUSHI6009SAO62100506abcdef6304A13F');

-- Inserir produtos
INSERT INTO produto (nome, preco, quantidade, descricao) VALUES
('hot crispy poro', 29.80, 10, 'hot philadelphia - de salmão grelhado - coberto com cream cheese e crispy de alho poro'),
('poke', 54.90, 20, 'escolha seus ingredientes favoritos, combine sabores e crie uma refeição única. aproximadamente 450g'),
('rolinho primavera', 15.99, 40, 'rolinho crocante de massa harumaki, recheado'),
('combinado 00', 39.99, 10, 'nosso queridinho e o mais vendido! para quem ama variedade: 05 uramaki salmão, 05 kappamaki, 05 hosomaki grelhado, 04 niguiri skin e 05 hot skin crocantes. uma experiência que você vai querer repetir!'),
('combinado especial hot', 72.99, 5, 'para quem ama fritos crocantes! 05 hot crispy couve, 05 hot skin, 05 hot kani, 05 hot philadelphia e 05 hot roll. o melhor dos nossos hots, com crocância e sabor únicos!');

-- Inserir frete
INSERT INTO frete(nome, preco) VALUES ('Mario Kart', 20.00);