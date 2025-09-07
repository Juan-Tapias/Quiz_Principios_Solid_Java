
package CodigoInical;

abstract class Jugador {
    private String nombre;
    
    public Jugador(String nombre) { this.nombre = nombre;}
    
    public String getNombre() { return nombre; } 
    
    public abstract void calcularBonificacion();
    
}
