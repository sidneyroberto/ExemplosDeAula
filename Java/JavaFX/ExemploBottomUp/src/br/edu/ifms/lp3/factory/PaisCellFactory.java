/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp3.factory;

import br.edu.ifms.lp3.model.Pais;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author sidneysousa
 */
public class PaisCellFactory implements Callback<ListView<Pais>, ListCell<Pais>> {

    @Override
    public ListCell<Pais> call(ListView<Pais> param) {
        return new ListCell<Pais>() {
            @Override
            public void updateItem(Pais item, boolean empty) {
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

