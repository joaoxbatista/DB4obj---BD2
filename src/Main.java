import database.Conexao;
import model.Item;
import model.Livro;
import model.Midia;
import model.Pedido;
import repository.LivroRepository;
public class Main {

    public static void main(String[] args) {
        
        Livro l1 = new Livro("SA2102-BR", "Author 01", "001231", "Some Title Here", 2017);
       
        //Especifica os parametros de busca
        Livro lbusca = new Livro();
        lbusca.setAno(2017);
        
        LivroRepository lr = new LivroRepository();
        
        //Salvar livro
        System.out.println(lr.store(l1));
        
        //Obter todos os livros do banco
        System.out.println(lr.all());
        
        //Atualizar livro no banco
        l1.setAutor("João Batista");
        System.out.println(lr.update(l1));
        
        //Obter um livro específico
        System.out.println(lr.find(lbusca));
        
        //Remover um livro do banco
        System.out.println(lr.remove("001231"));
    }	
    
}
