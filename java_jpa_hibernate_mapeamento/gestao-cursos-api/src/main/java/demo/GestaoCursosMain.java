package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        // Aluno com telefone e endereço
        Aluno aluno = new Aluno();
        aluno.setNome("João Silva");

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das Flores");
        endereco.setNumero("123");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setAluno(aluno);

        Telefone telefone = new Telefone();
        telefone.setNumero("11999999999");
        telefone.setAluno(aluno);

        aluno.getEnderecos().add(endereco);
        aluno.getTelefones().add(telefone);

        alunoModel.create(aluno);

        // Professor
        Professor professor = new Professor();
        professor.setNome("Prof. Roberto");

        // Curso
        Curso curso = new Curso();
        curso.setNome("Java JPA");
        curso.setProfessor(professor);

        // Material do curso
        MaterialCurso material = new MaterialCurso();
        material.setDescricao("Material completo de Java com JPA e Hibernate");
        material.setCurso(curso);

        curso.setMaterial(material);

        // Adiciona aluno ao curso
        curso.getAlunos().add(aluno);

        cursoModel.create(curso);

        // Exemplo de buscar e atualizar
        Aluno fetched = alunoModel.findById(aluno.getId());
        if (fetched != null) {
            fetched.setNome("João Pedro Silva");
            alunoModel.update(fetched);
        }
    }
}