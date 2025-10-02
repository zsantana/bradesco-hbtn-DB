package entities;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    // getters e setters
}