package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import model.Livro;
import repository.LivroRepository;

public class LivroController implements Initializable{
	
    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfAutor;

    @FXML
    private TextField tfIsbn;

    @FXML
    private TextField tfAno;

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfPreco;
    @FXML
    private Button btnSalvarLivro;

    @FXML
    private TableView<Livro> tblLivros;

    @FXML
    private TableColumn<Livro, String> tblLivrosCodigo;

    @FXML
    private TableColumn<Livro, String> tblLivrosIsbn;

    @FXML
    private TableColumn<Livro, String> tblLivrosTitulo;
    
    @FXML
    private TableColumn<Livro, Integer> tblLivrosAno;
    
    @FXML
    private TableColumn<Livro, String> tblLivrosAutor;

    @FXML
    private TableColumn<Livro, Double> tblLivrosPreco;
    
    private ObservableList<Livro> obsListaLivros;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	carregarLivros();
    }
    
    public void carregarLivros()
    {
    	
    	tblLivrosCodigo.setCellValueFactory(new PropertyValueFactory<>("cod"));
    	tblLivrosIsbn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
    	tblLivrosPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
    	tblLivrosTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
    	tblLivrosAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
    	tblLivrosAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
    	
    	LivroRepository lr = new LivroRepository();
    	List<Livro> livros = lr.all();
    	obsListaLivros = FXCollections.observableArrayList(livros);
    	tblLivros.setItems(obsListaLivros);
    }
    
	public void salvarLivro(ActionEvent event)
	{
		LivroRepository lr = new LivroRepository();
		Livro livro = new Livro();
		livro.setCod(this.tfCodigo.getText());
		livro.setAno(Integer.parseInt(this.tfAno.getText()));
		livro.setISBN(this.tfIsbn.getText());
		livro.setPreco(Double.parseDouble(this.tfPreco.getText()));
		livro.setAutor(this.tfAutor.getText());
		livro.setTitulo(this.tfTitulo.getText());
		lr.store(livro);
		this.carregarLivros();
	}
	
	public void removerLivro(ActionEvent event)
	{
		Livro livro_selecionado = (Livro)tblLivros.getSelectionModel().getSelectedItem();
		LivroRepository lr = new LivroRepository();
		lr.remove(livro_selecionado.getCod());
		this.carregarLivros();
	}
	
	public void carregarLivro(ActionEvent event)
	{
		Livro livro_selecionado = (Livro)tblLivros.getSelectionModel().getSelectedItem();
		this.tfCodigo.setText(livro_selecionado.getCod());
		this.tfAno.setText(Integer.toString(livro_selecionado.getAno()));
		this.tfIsbn.setText(livro_selecionado.getISBN());
		this.tfPreco.setText(Double.toString(livro_selecionado.getPreco()));
		this.tfAutor.setText(livro_selecionado.getAutor());
		this.tfTitulo.setText(livro_selecionado.getTitulo());
	}
	
	public void atualizarLivro(ActionEvent event)
	{
		LivroRepository lr = new LivroRepository();
		Livro livro = new Livro();
		livro.setCod(this.tfCodigo.getText());
		livro.setAno(Integer.parseInt(this.tfAno.getText()));
		livro.setISBN(this.tfIsbn.getText());
		livro.setPreco(Double.parseDouble(this.tfPreco.getText()));
		livro.setAutor(this.tfAutor.getText());
		livro.setTitulo(this.tfTitulo.getText());
		lr.update(livro);
		this.carregarLivros();
	}
}

