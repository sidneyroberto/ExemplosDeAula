/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.NamedQueries;

/**
 *
 * @author sidneysousa
 */
@Entity
@Table(name = "city")
@NamedQueries(value = {
    @NamedQuery(name = Cidade.RECUPERA_POR_PAIS, query = "from Cidade where pais.codigo = :codigo order by nome")
})
public class Cidade {
    
    public static final String RECUPERA_POR_PAIS = "Cidade.recuperaPorPais";
    
    @Id
    private Long id;
    
    @Column(name = "name")
    private String nome;
    
    @Column(name = "district")
    private String estadoOuDistrito;
    
    @Column(name ="population")
    private Integer populacao;
    
    @ManyToOne
    @JoinColumn(name = "countrycode")
    private Pais pais;

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

    public String getEstadoOuDistrito() {
        return estadoOuDistrito;
    }

    public void setEstadoOuDistrito(String estadoOuDistrito) {
        this.estadoOuDistrito = estadoOuDistrito;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
