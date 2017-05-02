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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sidneysousa
 */
@Entity
@Table(name="country")
@NamedQueries(value = {
    @NamedQuery(name = Pais.RECUPERA_TUDO, query = "from Pais order by nome")
})
public class Pais {
    
    public static final String RECUPERA_TUDO = "Pais.recuperaTudo";
    
    @Id
    @Column(name = "code")
    private String codigo;
    
    @Column(name = "name")
    private String nome;
    
    @Column(name = "continent")
    private String continente;
    
    @Column(name = "region")
    private String regiao;
    
    @Column(name = "population")
    private Integer populacao;
    
    @OneToOne
    @JoinColumn(name="capital")
    private Cidade capital;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public Cidade getCapital() {
        return capital;
    }

    public void setCapital(Cidade capital) {
        this.capital = capital;
    }
    
    
    
}
