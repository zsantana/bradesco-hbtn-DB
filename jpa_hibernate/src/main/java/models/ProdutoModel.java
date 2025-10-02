package models;

import entities.Produto;
import javax.persistence.*;
import java.util.*;

public class ProdutoModel {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void create(Produto p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao criar o produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void update(Produto p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Produto p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, p.getId());
            if (produto != null) {
                em.remove(produto);
                System.out.println("Produto removido!");
            } else {
                System.out.println("Produto não encontrado.");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Produto findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
        } finally {
            em.close();
        }
        return produto;
    }

    public List<Produto> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos;
        try {
            produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        } finally {
            em.close();
        }
        return produtos;
    }
}