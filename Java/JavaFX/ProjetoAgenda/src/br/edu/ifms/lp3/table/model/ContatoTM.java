/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp3.table.model;

import br.edu.ifms.lp3.model.Contato;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author sidsu
 */
public class ContatoTM {
    
    private SimpleStringProperty nome;
    
    private SimpleStringProperty telefone1;
    
    private SimpleStringProperty telefone2;
    
    private SimpleStringProperty email;

    public ContatoTM(Contato contato) {
        nome = new SimpleStringProperty(contato.getNome());
        telefone1 = new SimpleStringProperty(contato.getTelefone1());
        telefone2 = contato.getTelefone2() != null ? new SimpleStringProperty(contato.getTelefone2()) : new SimpleStringProperty("");
        email = contato.getEmail() != null ? new SimpleStringProperty(contato.getEmail()) : new SimpleStringProperty("");
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getTelefone1() {
        return telefone1.get();
    }

    public void setTelefone1(String telefone1) {
        this.telefone1.set(telefone1);
    }

    public String getTelefone2() {
        return telefone2.get();
    }

    public void setTelefone2(String telefone2) {
        this.telefone2.set(telefone2);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    
    
}
