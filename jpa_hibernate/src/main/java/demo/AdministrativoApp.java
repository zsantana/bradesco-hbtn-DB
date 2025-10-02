package demo;

import models.ProdutoModel;
import models.PessoaModel;
import entities.Produto;
import entities.Pessoa;
import java.util.*;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        // Produto
        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        produtoModel.create(p1);

        // Listando todos os produtos
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        // Update
        if (!produtos.isEmpty()) {
            Produto prod = produtos.get(0);
            prod.setPreco(350.0);
            produtoModel.update(prod);
        }

        // FindById
        Produto buscado = produtoModel.findById(p1.getId());
        System.out.println("Produto encontrado: " + (buscado != null ? buscado.getNome() : "Nenhum"));

        // Delete
        if (!produtos.isEmpty()) {
            produtoModel.delete(produtos.get(0));
        }

        // Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João Silva");
        pessoa.setEmail("joao@exemplo.com");

        pessoaModel.create(pessoa);

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas: " + pessoas.size());

        // Update
        if (!pessoas.isEmpty()) {
            Pessoa p = pessoas.get(0);
            p.setEmail("joao.novo@exemplo.com");
            pessoaModel.update(p);
        }

        // FindById
        Pessoa buscada = pessoaModel.findById(pessoa.getId());
        System.out.println("Pessoa encontrada: " + (buscada != null ? buscada.getNome() : "Nenhuma"));

        // Delete
        if (!pessoas.isEmpty()) {
            pessoaModel.delete(pessoas.get(0));
        }

        System.out.println("CRUD concluído!");
    }
}