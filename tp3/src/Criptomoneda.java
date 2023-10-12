public class Criptomoneda{
    private String nombre;
    private double valorDeToken; // Imaginemos en euros

    public Criptomoneda(String nombre, double valorDeToken){
        this.nombre = nombre;
        this.valorDeToken = valorDeToken;
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getValorDeToken() {
        return valorDeToken;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Criptomoneda){
            Criptomoneda cr = (Criptomoneda)obj;
            return (cr.nombre == this.nombre)?true:false;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%5s",nombre)+":"+String.format("%10.1f",valorDeToken);
    }
}
