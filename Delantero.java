
package CodigoInical;

 class Delantero extends Jugador{
    
    public Delantero(String nombre) {
        super(nombre);
    }

    @Override
    public void calcularBonificacion() {
        System.out.println("Calculando bonificación alta para Delantero: " + getNombre());

    }
}
