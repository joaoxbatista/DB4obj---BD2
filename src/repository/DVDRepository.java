package repository;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.db4o.ObjectSet;

import database.Conexao;
import model.DVD;

public class DVDRepository {

	
	/*
	 * Method: store
	 * Return: DVD 
	 * Description: Salva um DVD no banco de dados e retorna o objeto salvo
	 */
	public DVD store(DVD DVD)
	{
		try {
			Conexao.getInstance().store(DVD);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar DVD no banco de dados. Erro: " + e.getMessage());
			return null;
		}
		Conexao.close();
		System.out.println("[LOG] - DVDRespository -> DVD salvo com sucesso! \n");
		return DVD;
	}
	
	/*
	 * Method: update
	 * Return: DVD 
	 * Description: Atualiza os atributos de um DVD
	 */
	public DVD update(DVD DVD)
	{
		DVD DVDResultado = null;
		DVD DVDBusca = new DVD();
		DVDBusca.setCod(DVD.getCod());
		
		try {
			
			ObjectSet resultObject = Conexao.getInstance().queryByExample(DVDBusca);
			DVDResultado = (DVD) resultObject.next();
			
			DVDResultado.setAno(DVD.getAno());
			DVDResultado.setDiretor(DVD.getDiretor());
			DVDResultado.setProdutor(DVD.getProdutor());
			DVDResultado.setTitulo(DVD.getTitulo());
			Conexao.getInstance().store(DVDResultado);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar DVD no banco de dados. Erro: " + e.getMessage());
		}
		
		Conexao.close();
		System.out.println("[LOG] - DVDRespository -> DVD atualizado com sucesso! \n");
		return DVDResultado;
	}
	
	/*
	 * Method: all
	 * Return: ArrayList<DVD> 
	 * Description: Retorna uma lista com os DVDs cadastrados
	 */
	public ArrayList<DVD> all()
	{
		ArrayList<DVD> listaDVDs = new ArrayList<>();
		try {
			ObjectSet resultObject = Conexao.getInstance().queryByExample(DVD.class);
			
			for (Object DVD: resultObject)
			{
				listaDVDs.add((DVD)DVD);
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[LOG] - DVDRespository -> Erro ao obter DVDs do banco de dados. Erro: " + e.getMessage());
		}
		Conexao.close();
		System.out.println("[LOG] - DVDRespository -> DVDs obtidos com sucesso! \n");
		return listaDVDs;
	}
	
	/*
	 * Method: find
	 * Return: DVD 
	 * Description: Procura um DVD pelo código do DVD no banco de dados
	 */
	public DVD find(DVD DVD)
	{	
		DVD DVDResultado = null;
		try
		{
			ObjectSet resultObject = Conexao.getInstance().queryByExample(DVD);
			DVDResultado = (DVD) resultObject.next();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[LOG] - DVDRespository -> Erro ao procurar DVD do banco de dados. Erro: " + e.getMessage());
		}
		Conexao.close();
		System.out.println("[LOG] - DVDRespository -> DVD obtido com sucesso! \n");
		return DVDResultado;
	}
	
	/*
	 * Method: remove
	 * Return: DVD 
	 * Description: Remove um DVD do banco de dados
	 */
	public DVD remove(String cod)
	{
		DVD DVD = new DVD();
		DVD DVDResultado = null;
		try
		{
			DVD.setCod(cod);
			ObjectSet resultObejct = Conexao.getInstance().queryByExample(DVD);
			DVDResultado = (DVD) resultObejct.next();
			
			if(DVDResultado != null)
			{
				Conexao.getInstance().delete(DVDResultado);
				System.out.println("[LOG] - DVDRespository -> DVD removido com sucesso! \n");
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "[LOG] - DVDRespository -> Erro ao remover DVD do banco de dados. Erro: " + e.getMessage());
		}
		Conexao.close();
		
		return DVDResultado;
	}
}
