package CodigoInical;

import java.util.ArrayList;
import java.util.List;

public class GestorCampeonato {
    private List<Equipo> equipos = new ArrayList<>();
    private List<Arbitro> arbitros = new ArrayList<>();
    
    private RegistrarParticipantes registro = new RegistrarParticipantes();
    
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
    if (formato.equalsIgnoreCase("TEXTO")) {
        String contenidoReporte = "--- Reporte del Campeonato (TEXTO) ---\n";
        contenidoReporte += "EQUIPOS:\n";
        for (Equipo equipo : equipos) {
            contenidoReporte += "- " + equipo.getNombre() + "\n";
            }
            contenidoReporte += "ÁRBITROS:\n";
        for (Arbitro arbitro : arbitros) {
            contenidoReporte += "- " + arbitro.getNombre() + "\n";
            }
        System.out.println(contenidoReporte);
    } else if (formato.equalsIgnoreCase("HTML")) {
        String contenidoHtml = "<html><body>\n";
        contenidoHtml += " <h1>Reporte del Campeonato</h1>\n";
        contenidoHtml += " <h2>Equipos</h2>\n <ul>\n";
        for (Equipo equipo : equipos) {
            contenidoHtml += " <li>" + equipo.getNombre() + "</li>\n";
            }
            contenidoHtml += " </ul>\n <h2>Árbitros</h2>\n <ul>\n";
        for (Arbitro arbitro : arbitros) {
            contenidoHtml += " <li>" + arbitro.getNombre() + "</li>\n";
            }
        contenidoHtml += " </ul>\n</body></html>";
        System.out.println(contenidoHtml);
        }
}
// Método principal para simular la ejecución del módulo
public static void main(String[] args) {
    GestorCampeonato gestor = new GestorCampeonato();
    gestor.registrarParticipantes();
    gestor.calcularBonificaciones();
    System.out.println("\n--- Generando Reportes ---");
    gestor.generarReportes("TEXTO");
    System.out.println("\n--- Generando más Reportes ---");
    gestor.generarReportes("HTML");
    }
}
