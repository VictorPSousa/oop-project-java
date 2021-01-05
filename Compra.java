package farmacia;

public class Compra {

	  private Integer compra_numNF;
	  private Produto produto;
	  private Cliente cliente;
	  private Funcionario funcionario;
	  private String compra_data;
	  private Double compra_valor;
	  private Integer compra_qtd;
	  private String compra_pag;
	  
	  //
	  // Constructors
	  //
	  public Compra () { };
	  
	  //
	  // Methods
	  //


	  //
	  // Accessor methods
	  //

	  /**
	   * Set the value of compra_numNF
	   * @param newVar the new value of compra_numNF
	   */
	  public void setCompra_numNF (Integer newVar) {
	    compra_numNF = newVar;
	  }

	  /**
	   * Get the value of compra_numNF
	   * @return the value of compra_numNF
	   */
	  public Integer getCompra_numNF () {
	    return compra_numNF;
	  }

	  /**
	   * Set the value of produto
	   * @param newVar the new value of produto
	   */
	  public void setProduto (Produto newVar) {
	    produto = newVar;
	  }

	  /**
	   * Get the value of produto
	   * @return the value of produto
	   */
	  public Produto getProduto () {
	    return produto;
	  }

	  /**
	   * Set the value of cliente
	   * @param newVar the new value of cliente
	   */
	  public void setCliente (Cliente newVar) {
	    cliente = newVar;
	  }

	  /**
	   * Get the value of cliente
	   * @return the value of cliente
	   */
	  public Cliente getCliente () {
	    return cliente;
	  }

	  /**
	   * Set the value of funcionario
	   * @param newVar the new value of funcionario
	   */
	  public void setFuncionario (Funcionario newVar) {
	    funcionario = newVar;
	  }

	  /**
	   * Get the value of funcionario
	   * @return the value of funcionario
	   */
	  public Funcionario getFuncionario () {
	    return funcionario;
	  }

	  /**
	   * Set the value of compra_data
	   * @param newVar the new value of compra_data
	   */
	  public void setCompra_data (String newVar) {
	    compra_data = newVar;
	  }

	  /**
	   * Get the value of compra_data
	   * @return the value of compra_data
	   */
	  public String getCompra_data () {
	    return compra_data;
	  }

	  /**
	   * Set the value of compra_valor
	   * @param newVar the new value of compra_valor
	   */
	  public void setCompra_valor (Double newVar) {
	    compra_valor = newVar;
	  }

	  /**
	   * Get the value of compra_valor
	   * @return the value of compra_valor
	   */
	  public Double getCompra_valor () {
	    return compra_valor;
	  }

	  /**
	   * Set the value of compra_qtd
	   * @param newVar the new value of compra_qtd
	   */
	  public void setCompra_qtd (Integer newVar) {
	    compra_qtd = newVar;
	  }

	  /**
	   * Get the value of compra_qtd
	   * @return the value of compra_qtd
	   */
	  public Integer getCompra_qtd () {
	    return compra_qtd;
	  }

	  /**
	   * Set the value of compra_pag
	   * @param newVar the new value of compra_pag
	   */
	  public void setCompra_pag (String newVar) {
	    compra_pag = newVar;
	  }

	  /**
	   * Get the value of compra_pag
	   * @return the value of compra_pag
	   */
	  public String getCompra_pag () {
	    return compra_pag;
	  }

	  //
	  // Other methods
	  //

	  /**
	   */
	  public void efetua()
	  {
	  }


	  /**
	   */
	  public void busca()
	  {
	  }
}
