
package CodigoInical;

import java.util.List;

public class RegistrarParticipantes {
    
    public void registrarEquipos(List<Equipo> equipos) {
        Equipo equipoA = new Equipo("Los Ganadores");
        equipoA.agregarJugador(new Delantero("Juan Pérez"));
        equipoA.agregarJugador(new Portero("Pedro Pan"));
        equipos.add(equipoA);
        System.out.println("Equipo 'Los Ganadores' registrado.");
        
        Equipo equipoB = new Equipo("Los Retadores");
        equipoB.agregarJugador(new Defensa("Alicia Smith"));
        equipos.add(equipoB);   
        System.out.println("Equipo 'Los Retadores' registrado.");
    }
    
    public void registrarArbitro(List<Arbitro> arbitros){
        arbitros.add(new Arbitro ("Miguel Diaz"));
        System.out.println("Arbitro Miguel contratado.");
    }
}
