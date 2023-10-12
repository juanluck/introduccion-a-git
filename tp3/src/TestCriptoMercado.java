public class TestCriptoMercado {
    public static void main(String[] args) {

        //Creation de criptomonedas
        Criptomoneda bitcoin  = new Criptomoneda("btc", 50000);
        Criptomoneda ethereum = new Criptomoneda("eth", 2000);

        //Creation de carteras
        Cartera antonioBtc = new Cartera(bitcoin,  10, "Antonio");
        Cartera antonioEth = new Cartera(ethereum, 10, "Antonio");
        Cartera aliciaBtc  = new Cartera(bitcoin,   5, "Alicia"  );

        //Creation del mercado
        CriptoMercado mercado = CriptoMercado.getInstance();
        mercado.add(antonioBtc);
        mercado.add(antonioEth);
        mercado.add(aliciaBtc);

        //Transferencia de monedas entre carteras
        aliciaBtc.transferenciaDivisa(antonioBtc, 2);
        aliciaBtc.transferenciaDivisa(antonioBtc, 10); 
        aliciaBtc.transferenciaDivisa(antonioEth, 1); 

        //Test Carteras
        System.out.print("Test Cartera transferenciaDivisa \t ...");
        if (antonioBtc.getMontante() == 12 && aliciaBtc.getMontante() == 3)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");
        
        //Compra de Monedas
        aliciaBtc.compraDivisa(25000);
        antonioBtc.compraDivisa(-200000);
        
        System.out.print("Test Cartera compraDivisa    \t\t ...");
        if (antonioBtc.getMontante() == 12 && aliciaBtc.getMontante() == 3.5)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");

        //Test Mercado 
        //Test capitalEnEuros
        double capitalAntonio  = mercado.capitalEnEuros("Antonio");
        double capitalAlicia   = mercado.capitalEnEuros("Alicia");
        
        System.out.print("Test CriptoMercado capitalEnEuros \t ...");
        if (capitalAntonio == 620000 && capitalAlicia == 175000)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");

        //Test capitalMoneda
        double capitalBtc = mercado.capitalMoneda(bitcoin);
        double capitalEth = mercado.capitalMoneda(ethereum);

        System.out.print("Test CriptoMercado capitalMoneda \t ...");
        if (capitalBtc == 775000 && capitalEth == 20000)
            System.out.println(" OK");
        else
            System.out.println(" FAIL");

    }
}
