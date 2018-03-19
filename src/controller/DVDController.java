package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DVD;
import model.DVD;
import model.DVD;
import repository.DVDRepository;
import repository.DVDRepository;

public class DVDController {
	

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfProdutor;

    @FXML
    private TextField tfDiretor;

    @FXML
    private TextField tfAno;

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfPreco;
    @FXML
    private Button btnSalvarDVD;

    @FXML
    private TableView<DVD> tblDVDs;

    @FXML
    private TableColumn<DVD, String> tblDVDsCodigo;

    @FXML
    private TableColumn<DVD, String> tblDVDsDiretor;

    @FXML
    private TableColumn<DVD, String> tblDVDsTitulo;
    
    @FXML
    private TableColumn<DVD, Integer> tblDVDsAno;
    
    @FXML
    private TableColumn<DVD, String> tblDVDsProdutor;

    @FXML
    private TableColumn<DVD, Double> tblDVDsPreco;
    
    private ObservableList<DVD> obsListaDVDs;
    
	public void initialize(URL url, ResourceBundle rb)
    {
    	carregarDVDs();
    }
    
    public void carregarDVDs()
    {
    	
    	tblDVDsCodigo.setCellValueFactory(new PropertyValueFactory<>("cod"));
    	tblDVDsDiretor.setCellValueFactory(new PropertyValueFactory<>("diretor"));
    	tblDVDsPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
    	tblDVDsTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    	tblDVDsAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
    	tblDVDsProdutor.setCellValueFactory(new PropertyValueFactory<>("produtor"));
    	
    	DVDRepository lr = new DVDRepository();
    	List<DVD> DVDs = lr.all();
    	obsListaDVDs = FXCollections.observableArrayList(DVDs);
    	tblDVDs.setItems(obsListaDVDs);
    }
    
	public void salvarDVD(ActionEvent event)
	{
		DVDRepository lr = new DVDRepository();
		DVD DVD = new DVD();
		DVD.setCod(this.tfCodigo.getText());
		DVD.setAno(Integer.parseInt(this.tfAno.getText()));
		DVD.setDiretor(this.tfDiretor.getText());
		DVD.setPreco(Double.parseDouble(this.tfPreco.getText()));
		DVD.setProdutor(this.tfProdutor.getText());
		DVD.setTitulo(this.tfTitulo.getText());
		lr.store(DVD);
		this.carregarDVDs();
	}
	
	public void removerDVD(ActionEvent event)
	{
		DVD DVD_selecionado = (DVD)tblDVDs.getSelectionModel().getSelectedItem();
		DVDRepository lr = new DVDRepository();
		lr.remove(DVD_selecionado.getCod());
		this.carregarDVDs();
	}
	
	public void carregarDVD(ActionEvent event)
	{
		DVD DVD_selecionado = (DVD)tblDVDs.getSelectionModel().getSelectedItem();
		this.tfCodigo.setText(DVD_selecionado.getCod());
		this.tfAno.setText(Integer.toString(DVD_selecionado.getAno()));
		this.tfDiretor.setText(DVD_selecionado.getDiretor());
		this.tfPreco.setText(Double.toString(DVD_selecionado.getPreco()));
		this.tfProdutor.setText(DVD_selecionado.getProdutor());
		this.tfTitulo.setText(DVD_selecionado.getTitulo());
	}
	
	public void atualizarDVD(ActionEvent event)
	{
		DVDRepository lr = new DVDRepository();
		DVD DVD = new DVD();
		DVD.setCod(this.tfCodigo.getText());
		DVD.setAno(Integer.parseInt(this.tfAno.getText()));
		DVD.setDiretor(this.tfDiretor.getText());
		DVD.setPreco(Double.parseDouble(this.tfPreco.getText()));
		DVD.setProdutor(this.tfProdutor.getText());
		DVD.setTitulo(this.tfTitulo.getText());
		lr.update(DVD);
		this.carregarDVDs();
	}
}
