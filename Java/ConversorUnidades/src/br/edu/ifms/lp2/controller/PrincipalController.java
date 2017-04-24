/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp2.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author sidneysousa
 */
public class PrincipalController implements Initializable {
    
   @FXML
    private ComboBox<String> comboVelocidadePara;

    @FXML
    private Button botaoConverterComprimento;

    @FXML
    private ComboBox<String> comboMassaDe;

    @FXML
    private ComboBox<String> comboAreaDe;

    @FXML
    private Label labelResultadoArea;

    @FXML
    private TextField campoComprimento;

    @FXML
    private Button botaoConverterVelocidade;

    @FXML
    private TextField campoArea;

    @FXML
    private ComboBox<String> comboMassaPara;

    @FXML
    private ComboBox<String> comboVelocidadeDe;

    @FXML
    private Button botaoConverterArea;

    @FXML
    private Label labelResultadoVelocidade;

    @FXML
    private TextField campoVelocidade;

    @FXML
    private ComboBox<String> comboComprimentoPara;

    @FXML
    private Button botaoConverterMassa;

    @FXML
    private Label labelResultadoComprimento;

    @FXML
    private TextField campoMassa;

    @FXML
    private ComboBox<String> comboComprimentoDe;

    @FXML
    private Label labelResultadoMassa;

    @FXML
    private ComboBox<String> comboAreaPara;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] comprimentos = {"metro", "quilômetro", "milha", "jarda", "pé"};
        for(String comprimento : comprimentos) {
            comboComprimentoDe.getItems().add(comprimento);
            comboComprimentoPara.getItems().add(comprimento);
        }
        
        String[] areas = {"metro quadrado", "quilômetro quadrado", "hectare", "acre"};
        for(String area : areas) {
            comboAreaDe.getItems().add(area);
            comboAreaPara.getItems().add(area);
        }
        
        String[] massas = {"quilo", "grama", "onça", "libra", "quilate"};
        for(String massa : massas) {
            comboMassaDe.getItems().add(massa);
            comboMassaPara.getItems().add(massa);
        }
        
        String[] velocidades = {"metro por segundo", "quilômetro por hora", "milha por hora", "pé por segundo"};
        for(String velocidade : velocidades) {
            comboVelocidadeDe.getItems().add(velocidade);
            comboVelocidadePara.getItems().add(velocidade);
        }
        
        // Se vire...
    }    
    
}
