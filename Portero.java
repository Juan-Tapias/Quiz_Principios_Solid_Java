
package CodigoInical;


class Portero extends Jugador {
    
    public Portero(String nombre) {
        super(nombre);
    }

    @Override
    public void calcularBonificacion() {
        System.out.println("Calculando bonificación estándar para Portero: " + getNombre());
    }
    
}
