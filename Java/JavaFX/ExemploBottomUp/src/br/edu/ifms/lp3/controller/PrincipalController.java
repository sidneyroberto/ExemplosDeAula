/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp3.controller;

import br.edu.ifms.lp3.factory.CidadeCellFactory;
import br.edu.ifms.lp3.factory.PaisCellFactory;
import br.edu.ifms.lp3.model.Cidade;
import br.edu.ifms.lp3.model.Pais;
import br.edu.ifms.lp3.model.dao.CidadeDAO;
import br.edu.ifms.lp3.model.dao.PaisDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 *
 * @author sidneysousa
 */
public class PrincipalController implements Initializable {

    @FXML
    private ComboBox<Pais> comboPais;

    @FXML
    private ComboBox<Cidade> comboCidade;

    private PaisDAO paisDAO;

    private CidadeDAO cidadeDAO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paisDAO = new PaisDAO();
        comboPais.getItems().addAll(new FilteredList<>(FXCollections.observableArrayList(paisDAO.recuperaTudo())));
        PaisCellFactory paisCellFactory = new PaisCellFactory();
        comboPais.setButtonCell(paisCellFactory.call(null));
        comboPais.getSelectionModel().selectFirst();
        comboPais.setCellFactory(paisCellFactory);
        
        Pais primeiroPaisDaLista = comboPais.getValue();
        cidadeDAO = new CidadeDAO();
        comboCidade.getItems().addAll(FXCollections.observableArrayList(cidadeDAO.recuperaPorPais(primeiroPaisDaLista)));
        CidadeCellFactory cidadeCellFactory = new CidadeCellFactory();
        comboCidade.setButtonCell(cidadeCellFactory.call(null));
        comboCidade.getSelectionModel().selectFirst();
        comboCidade.setCellFactory(cidadeCellFactory);
        
        comboPais.setOnAction((ActionEvent e) -> {
            Pais paisSelecionado = comboPais.getValue();
            comboCidade.getItems().clear();
            comboCidade.getItems().addAll(FXCollections.observableArrayList(FXCollections.observableArrayList(cidadeDAO.recuperaPorPais(paisSelecionado))));
            comboCidade.getSelectionModel().selectFirst();
        });
    }

}
