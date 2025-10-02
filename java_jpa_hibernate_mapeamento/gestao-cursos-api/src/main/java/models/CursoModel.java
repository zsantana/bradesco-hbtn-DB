package models;

import entities.Curso;
import javax.persistence.*;
import java.util.List;

public class CursoModel {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Curso findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Curso curso = em.find(Curso.class, id);
        em.close();
        return curso;
    }

    public List<Curso> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Curso> cursos = em.createQuery("FROM Curso", Curso.class).getResultList();
        em.close();
        return cursos;
    }

    public void update(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            curso = em.find(Curso.class, curso.getId());
            if (curso != null) em.remove(curso);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}