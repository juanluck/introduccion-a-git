public class Cartera {
  private Criptomoneda moneda;
  private double montante; // El número de tokens
  private String propietario;

  public Cartera(Criptomoneda moneda, double montante, String propietario){
      this.moneda       = moneda;
      this.montante     = montante;
      this.propietario  = propietario;
  }

  /**
   * Esta función te permite transferir monedas desde la cartera actual
   * a la cartera de destino por la cantidad indicada. El tipo de moneda
   * (nombre del token) debe ser el mismo en ambas carteras y la cantidad
   * en la cartera actual debe ser mayor o igual a la indicada.
   * @param destino
   * @param cantidadTokens
   * @return true si la transacción se realizó, false en caso contrario.
   */
  public boolean transferenciaDivisa (Cartera destino, double cantidadTokens){
      /**
           FUNCIONALIDAD A IMPLEMENTAR
	  **/
      return false;
  }

  /**
   * Esta función te permite comprar tokens de la criptomoneda
   * en función de su valor en euros. El resultado es el aumento 
   * de los tokens de la criptomoneda.
   * @param cantidadEuros Valor de compra en euros
   * @return true si el monto en euros es mayor o igual a 0
   */
  public boolean compraDivisa (double cantidadEuros){
	/**
           FUNCIONALIDAD A IMPLEMENTAR
	**/
    return false;
  }
  
  /**
   * Valida si el propietario pasado en argumento es el 
   * mismo que posee la cartera
   * @param propietario
   * @return true si el nombre del propietario es correcto
   */
  public boolean esPropietario (String propietario){
        return (propietario.equals(this.propietario))?true:false;
  }

  /**
   * 
   * @return El valor en euros de la cartera. 
   */
   
  public double valorEnEuros(){
      return this.montante * this.moneda.getValorDeToken();
  }

  public String getPropietario() {
      return propietario;
  }

  public Criptomoneda getMoneda() {
      return moneda;
  }

  public double getMontante() {
      return montante;
  }

  @Override
  public String toString() {
      return String.format("%10s",propietario) + " : "
           + String.format("%10.1f", montante)   + " x " 
           + this.moneda.toString()            + " = "
           + String.format("%10.1f", valorEnEuros());
  }

}
