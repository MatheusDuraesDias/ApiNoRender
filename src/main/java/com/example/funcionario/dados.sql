-- CriaÃ§Ã£o da tabela Funcionario
CREATE TABLE funcionario (
                             id SERIAL PRIMARY KEY,
                             nome VARCHAR(100) NOT NULL,
                             cargo VARCHAR(100),
                             data_admissao DATE,
                             salario DECIMAL(10, 2),
                             departamento VARCHAR(50)
);

CREATE TABLE funcionario (
                             id SERIAL PRIMARY KEY,
                             nome VARCHAR(100) NOT NULL,
                             cargo VARCHAR(100),
                             data_admissao DATE,
                             salario DECIMAL(10, 2),
                             departamento VARCHAR(50)
);
INSERT INTO funcionario (nome, cargo, data_admissao, salario, departamento) VALUES
                                                                                ('JoÃ£o Silva', 'Analista de RH', '2023-01-10', 5000.00, 'Recursos Humanos'),
                                                                                ('Maria Santos', 'Engenheiro de ProduÃ§Ã£o', '2023-02-15', 6000.00, 'ProduÃ§Ã£o'),
                                                                                ('Pedro Oliveira', 'Operador de MÃ¡quinas', '2023-03-20', 3500.00, 'ProduÃ§Ã£o'),
                                                                                ('Ana Sousa', 'Analista de Qualidade', '2023-04-05', 4800.00, 'Qualidade'),
                                                                                ('Lucas Rodrigues', 'Gerente de LogÃ­stica', '2023-05-12', 8000.00, 'LogÃ­stica');