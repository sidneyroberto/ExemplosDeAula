/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp3.factory;

import br.edu.ifms.lp3.model.Cidade;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author sidneysousa
 */
public class CidadeCellFactory implements Callback<ListView<Cidade>, ListCell<Cidade>> {

    @Override
    public ListCell<Cidade> call(ListView<Cidade> param) {
        return new ListCell<Cidade>() {
            @Override
            public void updateItem(Cidade item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    setText(item.getNome());
                    setGraphic(null);
                } else {
                    setText(null);
                }
            }
        };
    }
}

