import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneradorReportes {
    private final Map<String, IReporte> formatos = new HashMap<>();

    public void registrarFormato(String clave, IReporte reporte) {
        formatos.put(clave.toUpperCase(), reporte);
    }

    public void generar(String formato, List<Equipo> equipos, List<Arbitro> arbitros) {
        IReporte reporte = formatos.get(formato.toUpperCase());
        if (reporte != null) {
            reporte.generar(equipos, arbitros);
        } else {
            System.out.println("❌ Formato de reporte no soportado: " + formato);
        }
    }
}