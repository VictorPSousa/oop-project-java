package farmacia;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Produto {
	  private Integer prod_codigo;
	  private String prod_nome;
	  private String prod_categoria;
	  private Integer prod_estoque;
	  private String prod_fornecedor;
	  private Double prod_preco;
	  private String prod_marca;
	  private String prod_dtvalidade;
	  
	  public Produto(){ };
	  
	  public void setProd_codigo (Integer newVar) {
	    prod_codigo = newVar;
	  }
	  
	  public Integer getProd_codigo () {
		return prod_codigo;
	  }
	  
	  public void setProd_nome (String newVar) {
		prod_nome = newVar;
	  }
	  
	  public String getProd_nome () {
	    return prod_nome;
	  }

	  public void setProd_categoria (String newVar) {
	    prod_categoria = newVar;
	  }

	  public String getProd_categoria () {
	    return prod_categoria;
	  }

	  public void setProd_estoque (Integer newVar) {
	    prod_estoque = newVar;
	  }

	  public Integer getProd_estoque () {
	    return prod_estoque;
	  }

	  public void setProd_fornecedor (String newVar) {
	    prod_fornecedor = newVar;
	  }

	  public String getProd_fornecedor () {
	    return prod_fornecedor;
	  }

	  public void setProd_preco (Double newVar) {
	    prod_preco = newVar;
	  }

	  public Double getProd_preco () {
	    return prod_preco;
	  }

	  public void setProd_marca (String newVar) {
	    prod_marca = newVar;
	  }

	  public String getProd_marca () {
	    return prod_marca;
	  }

	  public void setProd_dtvalidade (String newVar) {
	    prod_dtvalidade = newVar;
	  }

	  public String getProd_dtvalidade () {
	    return prod_dtvalidade;
	  }

	  public void cadastra(Produto prod) throws SQLException{
		  String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	      String Sql = "INSERT INTO `produto`(`prod_nome`, `prod_categoria`, `prod_estoque`,"
	      		+ " `prod_fornecedor`, `prod_preco`, `prod_marca`, `prod_dtvalidade`) VALUES"
	      		+ " ("+prod.getProd_nome()+","+prod.getProd_categoria()+","
	      		+ " "+prod.getProd_estoque()+","+prod.getProd_fornecedor()+","
	      		+ " "+prod.getProd_preco()+","+prod.getProd_marca()+","
	      		+ " "+prod.getProd_dtvalidade()+")";
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      
	      ResultSet resultado = comando.executeQuery();
	      
	      if(resultado != null && resultado.next()){
	    	  JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
          }
	      
	      resultado.close();
	      comando.close();
	      conn.close();
	  }

	  public void deleta()
	  {
	  }

	  public void busca()
	  {
	  }

	  public void lista()
	  {
	  }

	  public void atualiza()
	  {
	  }
}
