import java.util.List;

/**
 *
 * @author bri
 */
public class ReporteTexto implements IReporte {
    @Override
    public void generaar(List<Equipo> equipos, List<Arbitro> arbitros) {
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
    }
}
