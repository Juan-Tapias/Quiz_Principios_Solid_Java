
package CodigoInical;

class Defensa extends Jugador {
    
    public Defensa(String nombre) {
        super(nombre);
    }

    @Override
    public void calcularBonificacion() {
        System.out.println("Calculando bonificación base para: " + getNombre());
    }
    
}
