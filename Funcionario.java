package farmacia;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Funcionario {
	 /**
	   * CPF identificador do funcion�rio da farm�cia
	   */
	  private String func_cpf;
	  /**
	   * Registro Geral do Funcion�rio
	   */
	  private String func_rg;
	  /**
	   * Data de nascimento do funcion�rio
	   */
	  private String func_dtnascimento;
	  /**
	   * G�nero do funcion�rio
	   */
	  private char func_sexo;
	  /**
	   * Nome do funcion�rio
	   */
	  private String func_nome;
	  /**
	   * CEP do funcion�rio
	   */
	  private String func_cep;
	  /**
	   * Rua onde o funcion�rio possui moradia
	   */
	  private String func_rua;  /**

	   * Bairro em que o funcion�rio mora
	   *    */

	  private String func_bairro;
	  /**
	   * N�mero do logradouro do funcion�rio
	   */
	  private String func_numero;
	  
	  //
	  // Constructors
	  //
	  public Funcionario () { };
	  
	  //
	  // Methods
	  //


	  //
	  // Accessor methods
	  //

	  /**
	   * Set the value of func_cpf
	   * CPF identificador do funcion�rio da farm�cia
	   * @param newVar the new value of func_cpf
	   */
	  public void setFunc_cpf (String newVar) {
	    func_cpf = newVar;
	  }

	  /**
	   * Get the value of func_cpf
	   * CPF identificador do funcion�rio da farm�cia
	   * @return the value of func_cpf
	   */
	  public String getFunc_cpf () {
	    return func_cpf;
	  }

	  /**
	   * Set the value of func_rg
	   * Registro Geral do Funcion�rio
	   * @param newVar the new value of func_rg
	   */
	  public void setFunc_rg (String newVar) {
	    func_rg = newVar;
	  }

	  /**
	   * Get the value of func_rg
	   * Registro Geral do Funcion�rio
	   * @return the value of func_rg
	   */
	  public String getFunc_rg () {
	    return func_rg;
	  }

	  /**
	   * Set the value of func_dtnascimento
	   * Data de nascimento do funcion�rio
	   * @param newVar the new value of func_dtnascimento
	   */
	  public void setFunc_dtnascimento (String newVar) {
	    func_dtnascimento = newVar;
	  }

	  /**
	   * Get the value of func_dtnascimento
	   * Data de nascimento do funcion�rio
	   * @return the value of func_dtnascimento
	   */
	  public String getFunc_dtnascimento () {
	    return func_dtnascimento;
	  }

	  /**
	   * Set the value of func_sexo
	   * G�nero do funcion�rio
	   * @param newVar the new value of func_sexo
	   */
	  public void setFunc_sexo (char newVar) {
	    func_sexo = newVar;
	  }

	  /**
	   * Get the value of func_sexo
	   * G�nero do funcion�rio
	   * @return the value of func_sexo
	   */
	  public char getFunc_sexo () {
	    return func_sexo;
	  }

	  /**
	   * Set the value of func_nome
	   * Nome do funcion�rio
	   * @param newVar the new value of func_nome
	   */
	  public void setFunc_nome (String newVar) {
	    func_nome = newVar;
	  }

	  /**
	   * Get the value of func_nome
	   * Nome do funcion�rio
	   * @return the value of func_nome
	   */
	  public String getFunc_nome () {
	    return func_nome;
	  }

	  /**
	   * Set the value of func_cep
	   * CEP do funcion�rio
	   * @param newVar the new value of func_cep
	   */
	  public void setFunc_cep (String newVar) {
	    func_cep = newVar;
	  }

	  /**
	   * Get the value of func_cep
	   * CEP do funcion�rio
	   * @return the value of func_cep
	   */
	  public String getFunc_cep () {
	    return func_cep;
	  }

	  /**
	   * Set the value of func_rua
	   * Rua onde o funcion�rio possui moradia
	   * @param newVar the new value of func_rua
	   */
	  public void setFunc_rua (String newVar) {
	    func_rua = newVar;
	  }

	  /**
	   * Get the value of func_rua
	   * Rua onde o funcion�rio possui moradia
	   * @return the value of func_rua
	   */
	  public String getFunc_rua () {
	    return func_rua;
	  }

	  /**
	   * Set the value of func_bairro
	   * Bairro em que o funcion�rio mora
	   * 
	   * @param newVar the new value of func_bairro
	   */
	  public void setFunc_bairro (String newVar) {
	    func_bairro = newVar;
	  }

	  /**
	   * Get the value of func_bairro
	   * Bairro em que o funcion�rio mora
	   * 
	   * @return the value of func_bairro
	   */
	  public String getFunc_bairro () {
	    return func_bairro;
	  }

	  /**
	   * Set the value of func_numero
	   * N�mero do logradouro do funcion�rio
	   * @param newVar the new value of func_numero
	   */
	  public void setFunc_numero (String newVar) {
	    func_numero = newVar;
	  }

	  /**
	   * Get the value of func_numero
	   * N�mero do logradouro do funcion�rio
	   * @return the value of func_numero
	   */
	  public String getFunc_numero () {
	    return func_numero;
	  }

	  //
	  // Other methods
	  //

	  /**
	   * @param        cpf_user
	   * @param        rg_pass
	   * @throws SQLException 
	   */
	  public void login(String cpf_user, String rg_pass) throws SQLException{
		  String usuario = "root";
	      String senha = "";
	      String url = "jdbc:mysql://localhost/farmacia";
	        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	        String Sql = "SELECT func_nome FROM funcionario WHERE func_cpf = " + cpf_user + 
	        		" AND func_rg = " + rg_pass + "";
	        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	        comando.execute();
	        comando.close();
	        JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
	  }


	  /**
	   * @param        func
	   */
	  public void cadastra(Funcionario func)
	  {
	  }


	  /**
	   * @param        func
	   */
	  public void deleta(Funcionario func)
	  {
	  }


	  /**
	   */
	  public void lista()
	  {
	  }


	  /**
	   * @param        func_nome
	   */
	  public void busca(String func_nome)
	  {
	  }


	  /**
	   * @param        func
	   */
	  public void atualiza(Funcionario func)
	  {
	  }
}
