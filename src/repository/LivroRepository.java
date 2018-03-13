package repository;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.db4o.ObjectSet;

import database.Conexao;
import model.Livro;
public class LivroRepository {
	
	/*
	 * Method: store
	 * Return: Livro 
	 * Description: Salva um livro no banco de dados e retorna o objeto salvo
	 */
	public Livro store(Livro livro)
	{
		try {
			Conexao.getInstance().store(livro);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar livro no banco de dados. Erro: " + e.getMessage());
			return null;
		}
		Conexao.close();
		System.out.println("[LOG] - LivroRespository -> Livro salvo com sucesso! \n");
		return livro;
	}
	
	/*
	 * Method: update
	 * Return: Livro 
	 * Description: Atualiza os atributos de um livro
	 */
	public Livro update(Livro livro)
	{
		Livro livroResultado = null;
		Livro livroBusca = new Livro();
		livroBusca.setCod(livro.getCod());
		
		try {
			
			ObjectSet resultObject = Conexao.getInstance().queryByExample(livroBusca);
			livroResultado = (Livro) resultObject.next();
			
			livroResultado.setAno(livro.getAno());
			livroResultado.setAutor(livro.getAutor());
			livroResultado.setISBN(livro.getISBN());
			livroResultado.setTitulo(livro.getTitulo());
			Conexao.getInstance().store(livroResultado);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar livro no banco de dados. Erro: " + e.getMessage());
		}
		
		Conexao.close();
		System.out.println("[LOG] - LivroRespository -> Livro atualizado com sucesso! \n");
		return livroResultado;
	}
	
	/*
	 * Method: all
	 * Return: ArrayList<Livro> 
	 * Description: Retorna uma lista com os livros cadastrados
	 */
	public ArrayList<Livro> all()
	{
		ArrayList<Livro> listaLivros = new ArrayList<>();
		try {
			ObjectSet resultObject = Conexao.getInstance().queryByExample(Livro.class);
			
			for (Object livro: resultObject)
			{
				listaLivros.add((Livro)livro);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[LOG] - LivroRespository -> Erro ao obter livros do banco de dados. Erro: " + e.getMessage());
		}
		Conexao.close();
		System.out.println("[LOG] - LivroRespository -> Livros obtidos com sucesso! \n");
		return listaLivros;
	}
	
	/*
	 * Method: find
	 * Return: Livro 
	 * Description: Procura um livro pelo código do livro no banco de dados
	 */
	public Livro find(Livro livro)
	{	
		Livro livroResultado = null;
		try
		{
			ObjectSet resultObject = Conexao.getInstance().queryByExample(livro);
			livroResultado = (Livro) resultObject.next();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[LOG] - LivroRespository -> Erro ao procurar livro do banco de dados. Erro: " + e.getMessage());
		}
		Conexao.close();
		System.out.println("[LOG] - LivroRespository -> Livro obtido com sucesso! \n");
		return livroResultado;
	}
	
	/*
	 * Method: remove
	 * Return: Livro 
	 * Description: Remove um livro do banco de dados
	 */
	public Livro remove(String cod)
	{
		Livro livro = new Livro();
		Livro livroResultado = null;
		try
		{
			livro.setCod(cod);
			ObjectSet resultObejct = Conexao.getInstance().queryByExample(livro);
			livroResultado = (Livro) resultObejct.next();
			
			if(livroResultado != null)
			{
				Conexao.getInstance().delete(livroResultado);
				System.out.println("[LOG] - LivroRespository -> Livro removido com sucesso! \n");
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[LOG] - LivroRespository -> Erro ao remover livro do banco de dados. Erro: " + e.getMessage());
		}
		Conexao.close();
		
		return livroResultado;
	}
}
