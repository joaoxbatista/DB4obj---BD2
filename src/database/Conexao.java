package database;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Conexao {
    
    private static ObjectContainer instance = null;
    
    //Singleton Pattern
    public static ObjectContainer getInstance(){
        if(Conexao.instance == null)
        {
        	Conexao.instance = Db4oEmbedded.openFile("Banco");
        }
        
//        System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        return Conexao.instance;
    }
    
    //Close connection and clear
    public static void close(){
        Conexao.instance.close();
        Conexao.instance = null;
//        System.out.println("Conexão com o banco de dados finalizada!");
    }
    
}