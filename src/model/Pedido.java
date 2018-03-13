package model;

import java.util.Vector;

public class Pedido {
    public int num;
    public Vector<Item> itens;
    
    public Pedido(int num){
        this.num = num;
        this.itens = new Vector<Item>();
    }
    
    public void AdicionaItem(Item m){
        itens.add(m);
    }
    
    public void RemoveItem(int index){
        itens.remove(index);
    }
    
    public void ListarPedido(){
        for (Item item : itens) {
            String temp = item.getM().getTitulo();
            System.out.println(temp);
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Vector<Item> getItens() {
        return itens;
    }

    public void setItens(Vector<Item> itens) {
        this.itens = itens;
    }
    
    
}
