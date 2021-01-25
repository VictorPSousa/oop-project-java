package farmacia;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Farmaceutico extends Funcionario{
	  private String farma_crf;
	  
	  public Farmaceutico(){
		  Funcionario func = new Funcionario(1);
	  };

	  public void setFarma_crf (String newVar) {
	    farma_crf = newVar;
	  }

	  public String getFarma_crf(){
	    return farma_crf;
	  }
	  
	  public void cadastra(Farmaceutico farma) throws SQLException{
	      String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	      
	      String Sql = "INSERT INTO `funcionario` (`func_cpf`, `func_rg`, `func_dtnascimento`, "
	      		+ "`func_sexo`, `func_nome`, `func_cep`, `func_rua`, `func_bairro`, `func_numero`)"
	      		+ " VALUES ('"+farma.getFunc_cpf()+"','"+farma.getFunc_rg()+"',"
	      		+ "'"+farma.getFunc_dtnascimento()+"','"+farma.getFunc_sexo()+"',"
	      		+ "'"+farma.getFunc_nome()+"','"+farma.getFunc_cep()+"',"
	      		+ "'"+farma.getFunc_rua()+"','"+farma.getFunc_bairro()+"',"
	      		+ "'"+farma.getFunc_numero()+"')";
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      comando.close();
	      
	      String Sql_farma = "INSERT INTO `farmaceutico`(`farma_crf`, `func_cpf`) VALUES "
	      		+ "('"+farma.getFarma_crf()+"','"+farma.getFunc_cpf()+"');";
		  PreparedStatement comando_farma = (PreparedStatement) conn.prepareStatement(Sql_farma);
		  comando_farma.execute();
		  comando_farma.close();
	      
	      conn.close();
	  }

	  @Override
	  public void deleta(String cpf) throws SQLException{
		  String usuario = "root";
		  String senha = "";
		  String url = "jdbc:mysql://localhost/farmacia";
		  java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		  
		  String del = "SET foreign_key_checks = 0;";
	      PreparedStatement comando_del = (PreparedStatement) conn.prepareStatement(del);
	      comando_del.execute();
	      comando_del.close();
		  
		  String Sql = "DELETE FROM `funcionario` WHERE `func_cpf` = '"+cpf+"';";
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      comando.close();
	      
	      String Sql_farma = "DELETE FROM `farmaceutico` WHERE `func_cpf` = '"+cpf+"';";
	      PreparedStatement comando_farma = (PreparedStatement) conn.prepareStatement(Sql_farma);
	      comando_farma.execute();
	      comando_farma.close();
	      
	      conn.close();
	  }

	  public void atualiza(Farmaceutico farma) throws SQLException{
	      String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	      java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	      
	      String Sql = "UPDATE `funcionario` SET `func_rg`='"+farma.getFunc_rg()+"',"
	      		+ "`func_dtnascimento`='"+farma.getFunc_dtnascimento()+"',`func_sexo`='"+farma.getFunc_sexo()+"',"
	      		+ "`func_nome`='"+farma.getFunc_nome()+"',`func_cep`='"+farma.getFunc_cep()+"',"
	      		+ "`func_rua`='"+farma.getFunc_rua()+"',`func_bairro`='"+farma.getFunc_bairro()+"',"
	      		+ "`func_numero`='"+farma.getFunc_numero()+"' WHERE `func_cpf` = '"+farma.getFunc_cpf()+"'";
	      PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	      comando.execute();
	      comando.close();
	      
	      if(farma.getFarma_crf() != "" && farma.getFarma_crf() != null){
	    	  String Sql_farma = "UPDATE `farmaceutico` SET `farma_crf`='"+farma.getFarma_crf()+"' WHERE `func_cpf` = '"+farma.getFunc_cpf()+"';";
	    	  PreparedStatement comando_farma = (PreparedStatement) conn.prepareStatement(Sql_farma);
	    	  comando_farma.execute();
	    	  comando_farma.close();  
	      }
	      
	      conn.close();
	  }
}
