import java.util.ArrayList;

public class CriptoMercado {

    private ArrayList<Cartera> carteras;
    private static CriptoMercado mercado;

    private CriptoMercado(){
        carteras = new ArrayList<Cartera>();
    }

    public static CriptoMercado getInstance(){
        if(mercado == null){ mercado = new CriptoMercado();}
		return mercado;
    }

    public void add(Cartera c){
        carteras.add(c);
    }

    /**
     * Esta función busca en el mercado todas las carteras
     * del propietario y calcula su capital en euros.
     * @param proprietario
     * @return capital en euros del propietario.
     */
    public double capitalEnEuros(String propietario){
        /**
			FUNCIONALIDAD A IMPLEMENTAR
        **/
        return 0;
    }

    /**
     * Esta función busca en el mercado todas las carteras
     * de un tipo de moneda y calcula el volumen total de capital de
     * esa moneda en el mercado.
     * @param moneda
     * @return capital total en circulación de la criptomoneda (en euros).
     */
    public double capitalMoneda(Criptomoneda moneda){
        /**
			FUNCIONALIDAD A IMPLEMENTAR
        **/
        return 0;
    }

    @Override
    public String toString() {
        String ret = "";
        for(Cartera p : this.carteras){
            ret += p.toString() + "\n";
        }
        return ret;
    }

}
