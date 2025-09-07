package CodigoInical;

import java.util.ArrayList;
import java.util.List;

public class GestorCampeonato {
    private List<Equipo> equipos = new ArrayList<>();
    private List<Arbitro> arbitros = new ArrayList<>();
    
    private RegistrarParticipantes registro = new RegistrarParticipantes();
    private GeneradorReportes generadorReportes = new GeneradorReportes();
    
    public GestorCampeonato() {
        // Registrar formatos disponibles
        generadorReportes.registrarFormato("TEXTO", new ReporteTexto());
        generadorReportes.registrarFormato("HTML", new ReporteHtml());
    }
    
    public void registrarParticipantes(){
        registro.registrarEquipos(equipos);
        registro.registrarArbitro(arbitros);
    }
/**
* Calcula las bonificaciones para los jugadores.
*/  
public void calcularBonificaciones() {
    System.out.println("\n--- Calculando Bonificaciones de Jugadores ---");
    for (Equipo equipo : equipos) {
        for (Jugador jugador : equipo.getJugadores()) {
            jugador.calcularBonificacion();
    }}
}
/**
* Genera y muestra en consola diferentes tipos de reportes.
*/
    public void generarReportes(String formato) {
        generadorReportes.generar(formato, equipos, arbitros);
    }
    
// Método principal para simular la ejecución del módulo
public static void main(String[] args) {
    GestorCampeonato gestor = new GestorCampeonato();
    gestor.registrarParticipantes();
    gestor.calcularBonificaciones();
    System.out.println("\n--- Generando Reportes ---");
    System.out.println("\n--- Generando Reportes ---");
    gestor.generarReportes("TEXTO");
    System.out.println("\n--- Generando más Reportes ---");
    gestor.generarReportes("HTML");
    }
}
