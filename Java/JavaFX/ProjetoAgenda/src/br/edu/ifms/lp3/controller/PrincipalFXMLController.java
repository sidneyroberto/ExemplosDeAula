/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.lp3.controller;

import br.edu.ifms.lp3.dao.ContatoDAO;
import br.edu.ifms.lp3.model.Contato;
import br.edu.ifms.lp3.table.mapper.ContatoMapper;
import br.edu.ifms.lp3.table.model.ContatoTM;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author sidsu
 */
public class PrincipalFXMLController implements Initializable {

    @FXML
    private Button botaoProximaPagina;

    @FXML
    private Button botaoSalvar;

    @FXML
    private TableColumn<ContatoTM, String> colunaTelefone2;

    @FXML
    private Button botaoPrimeiraPagina;

    @FXML
    private TableColumn<?, ?> colunaAcao;

    @FXML
    private Button botaoFiltrar;

    @FXML
    private TableColumn<ContatoTM, String> colunaEmail;

    @FXML
    private Button botaoPaginaAnterior;

    @FXML
    private TextField campoTelefone2;

    @FXML
    private TextField campoTelefone1;

    @FXML
    private TableColumn<ContatoTM, String> colunaTelefone1;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private Button botaoUltimaPagina;

    @FXML
    private TextField campoFiltro;

    @FXML
    private TableColumn<ContatoTM, String> colunaNome;

    @FXML
    private TableView<ContatoTM> tabelaContatos;

    private final static int QUANTIDADE_POR_PAGINA = 7;

    private int pagina;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaTelefone1.setCellValueFactory(new PropertyValueFactory<>("telefone1"));
        colunaTelefone2.setCellValueFactory(new PropertyValueFactory<>("telefone2"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        pagina = 1;

        preencheTabela();
        botaoSalvar.setOnAction((ActionEvent e) -> {
            String nome = campoNome.getText().trim();
            String telefone1 = campoTelefone1.getText().trim();
            String resposta = "";
            if (nome.isEmpty()) {
                resposta += "\nO nome deve ser preenchido!";
            }
            if (telefone1.isEmpty()) {
                resposta += "\nO telefone 1 deve ser preenchido!";
            }

            if (!resposta.isEmpty()) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setHeaderText(null);
                alerta.setTitle("Aviso");
                alerta.setContentText(resposta);
                alerta.showAndWait();
            } else {
                String telefone2 = campoTelefone2.getText().trim();
                String eMail = campoEmail.getText().trim();
                Contato contato = new Contato(nome, telefone1);
                contato.setTelefone1(telefone1);
                contato.setTelefone2(telefone2);
                contato.setEmail(eMail);
                contato.setNome(nome);

                ContatoDAO dao = new ContatoDAO();
                if (dao.salva(contato)) {
                    pagina = 1;
                    preencheTabela();
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setHeaderText(null);
                    alerta.setContentText("Contato salvo com sucesso!");
                    alerta.setTitle("Sucesso");
                    alerta.showAndWait();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setHeaderText(null);
                    alerta.setContentText("Ocorreu um erro ao tentar salvar o contato");
                    alerta.setTitle("Erro");
                    alerta.showAndWait();
                }
            }
        });

        botaoFiltrar.setOnAction((ActionEvent e) -> {
            preencheTabela();
        });

        botaoPaginaAnterior.setOnAction((ActionEvent e) -> {
            if (pagina > 1) {
                pagina--;
                preencheTabela();
            }
        });

        botaoProximaPagina.setOnAction((ActionEvent e) -> {
            int numeroPaginas = numeroPaginas();
            System.out.println("Nro paginas: " + numeroPaginas);
            if (pagina < numeroPaginas) {
                pagina++;
                preencheTabela();
            }
        });
        
        botaoPrimeiraPagina.setOnAction((ActionEvent e) -> {
            if (pagina != 1) {
                pagina = 1;
                preencheTabela();
            }
        });
        
        botaoUltimaPagina.setOnAction((ActionEvent e) -> {
            int numeroPaginas = numeroPaginas();
            System.out.println("Nro paginas: " + numeroPaginas);
            if (pagina < numeroPaginas) {
                pagina = numeroPaginas;
                preencheTabela();
            }
        });
    }

    public void preencheTabela() {
        int inicio = (pagina - 1) * QUANTIDADE_POR_PAGINA;
        ContatoDAO dao = new ContatoDAO();
        System.out.println("Inicio: " + inicio);
        List<Contato> contatos = dao.recuperaPorNome(campoFiltro.getText(), inicio, QUANTIDADE_POR_PAGINA);
        ObservableList<ContatoTM> contatosTM = FXCollections.observableArrayList(ContatoMapper.mapearLista(contatos));
        tabelaContatos.setItems(contatosTM);
    }

    private int numeroPaginas() {
        return (int) (new ContatoDAO().contaQuantidade(campoFiltro.getText()) / QUANTIDADE_POR_PAGINA) + 1;
    }

}
