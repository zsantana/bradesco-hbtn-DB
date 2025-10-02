-- Tabela Professor
CREATE TABLE Professor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nomeCompleto TEXT NOT NULL,
    matricula TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL
);

-- Tabela Aluno
CREATE TABLE Aluno (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nomeCompleto TEXT NOT NULL,
    matricula TEXT NOT NULL UNIQUE,
    nascimento DATE,
    email TEXT NOT NULL
);

-- Tabela Endereco
CREATE TABLE Endereco (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    rua TEXT,
    numero TEXT,
    cidade TEXT,
    estado TEXT,
    aluno_id INTEGER NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);

-- Tabela Telefone
CREATE TABLE Telefone (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    numero TEXT,
    aluno_id INTEGER NOT NULL,
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);

-- Tabela Curso
CREATE TABLE Curso (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    professor_id INTEGER NOT NULL,
    FOREIGN KEY (professor_id) REFERENCES Professor(id)
);

-- Tabela MaterialCurso
CREATE TABLE MaterialCurso (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao TEXT,
    curso_id INTEGER NOT NULL UNIQUE, -- UNIQUE para garantir 1:1 curso-material
    FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

-- Tabela de Associação Curso_Aluno (muitos-para-muitos)
CREATE TABLE curso_aluno (
    curso_id INTEGER NOT NULL,
    aluno_id INTEGER NOT NULL,
    PRIMARY KEY (curso_id, aluno_id),
    FOREIGN KEY (curso_id) REFERENCES Curso(id),
    FOREIGN KEY (aluno_id) REFERENCES Aluno(id)
);