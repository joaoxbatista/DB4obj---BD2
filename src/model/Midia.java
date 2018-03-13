package model;
public class Midia {
    
    private String cod;
    private String titulo;
    private int ano;
    
    public Midia() {}
    
    public Midia(String cod, String titulo, int ano) {
        this.cod = cod;
        this.titulo = titulo;
        this.ano = ano;
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

    
}
