package br.edu.ifms.lp3.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = Contato.RECUPERA_POR_NOME, query = "from Contato where lower(nome) like :nome order by nome"),
    @NamedQuery(name = Contato.CONTA_QUANTIDADE, query = "select count(*) from Contato where lower(nome) like :nome")
})
public class Contato implements Serializable {
    
    public static final String RECUPERA_POR_NOME = "Contato.recuperaPorNome";
    
    public static final String CONTA_QUANTIDADE = "Contato.contaQuantidade";
    
    public Contato(){}

    public Contato(String nome, String telefone1) {
        this.nome = nome;
        this.telefone1 = telefone1;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String telefone1;
    
    private String telefone2;
    
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
