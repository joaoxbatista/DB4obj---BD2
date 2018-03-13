package model;

public class Livro extends Midia{
    private String ISBN;
    private String autor;
    
    public Livro() {}
    
    public Livro(String ISBN, String autor, String cod, String titulo, int ano) {
        super(cod, titulo, ano);
        this.ISBN = ISBN;
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

	@Override
	public String toString() {
		return "Livro [ISBN=" + ISBN + ", autor=" + autor + "]";
	}

    
    
}
