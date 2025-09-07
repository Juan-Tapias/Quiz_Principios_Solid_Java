import java.util.List;


public class ReporteHtml implements IReporte {
    @Override
    public void generarr(List<Equipo> equipos, List<Arbitro> arbitros) {
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