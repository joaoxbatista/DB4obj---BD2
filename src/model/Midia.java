package model;
public class Midia {
    
    protected String cod;
    protected String titulo;
    protected int ano;
    protected double preco;
    
    public Midia() {}
    
    public Midia(String cod, String titulo, int ano, double preco) {
        this.cod = cod;
        this.titulo = titulo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

    
}
