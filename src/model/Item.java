package model;

public class Item {
    private Midia m;
    private int qtd;

    public Item(Midia m, int qtd) {
        this.m = m;
        this.qtd = qtd;
    }
    
    public Midia getM() {
        return m;
    }

    public void setM(Midia m) {
        this.m = m;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
}
