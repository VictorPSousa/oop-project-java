package farmacia;

public class Farmaceutico extends Funcionario{
	  private String farma_crf;
	  
	  public Farmaceutico () { };

	  /**
	   * Set the value of farma_crf
	   * CRF do farmacêutico
	   * 
	   * @param newVar the new value of farma_crf
	   */
	  public void setFarma_crf (String newVar) {
	    farma_crf = newVar;
	  }

	  /**
	   * Get the value of farma_crf
	   * CRF do farmacêutico
	   * 
	   * @return the value of farma_crf
	   */
	  public String getFarma_crf () {
	    return farma_crf;
	  }

	  //
	  // Other methods
	  //

	  /**
	   */
	  public void cadastra()
	  {
	  }


	  /**
	   */
	  public void deleta()
	  {
	  }
}
