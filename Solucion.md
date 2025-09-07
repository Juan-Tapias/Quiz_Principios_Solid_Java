# ✅ ¿Por qué el nuevo código funciona?

Ambos códigos:

- Registran equipos y árbitros.
- Calculan bonificaciones para los jugadores.
- Generan reportes en formato **TEXTO** y **HTML**.

📌 **Conclusión**:  
**Funcionalmente hacen lo mismo**, pero el **nuevo código** está **mejor estructurado**, siguiendo principios como la **responsabilidad única**, el **bajo acoplamiento** y la **alta cohesión**.

---

# 🔄 ¿Qué se cambió?

## 1. Separación de responsabilidades

| Antes 🟥 | Después ✅ |
|--------|-----------|
| Toda la lógica estaba en `GestorCampeonato` | Se crearon clases dedicadas: |
| - Registro de participantes<br>- Cálculo de bonificaciones<br>- Generación de reportes | - `RegistrarParticipantes`<br>- `GeneradorReportes`<br>- `ReporteTexto`, `ReporteHtml` |

---

# 📐 Principios SOLID aplicados

---

## 1. **S – Single Responsibility Principle (SRP)**  
> Una clase debe tener una sola razón para cambiar.

### 🔴 Antes: `GestorCampeonato` hacía de todo

```java
// Registra participantes
public void registrarParticipantes() {
    Equipo equipoA = new Equipo("Los Ganadores");
    equipoA.agregarJugador(new Jugador("Juan Pérez", "Delantero"));
    equipos.add(equipoA);
    // ...
}

// Calcula bonificaciones
public void calcularBonificaciones() {
    for (Equipo equipo : equipos) {
        for (Jugador jugador : equipo.getJugadores()) {
            if (jugador.getPosicion().equals("Delantero")) {
                System.out.println("Bonificación alta para: " + jugador.getNombre());
            }
            // ...
        }
    }
}

// Genera reportes
public void generarReportes(String formato) {
    if (formato.equalsIgnoreCase("TEXTO")) {
        // lógica texto
    } else if (formato.equalsIgnoreCase("HTML")) {
        // lógica HTML
    }
}
```
#### ✅ Después: responsabilidades delegadas
```java
private RegistrarParticipantes registro = new RegistrarParticipantes();
private GeneradorReportes generadorReportes = new GeneradorReportes();

public void registrarParticipantes() {
    registro.registrarEquipos(equipos);
    registro.registrarArbitro(arbitros);
}

public void generarReportes(String formato) {
    generadorReportes.generar(formato, equipos, arbitros);
}
📌 Cada clase tiene una única responsabilidad clara.
```
## 2. **O – Open/Closed Principle (OCP)**
>El código debe estar abierto a extensión pero cerrado a modificación.

### 🔴 Antes: 

Para agregar un nuevo formato de reporte (ej. PDF), era necesario modificar generarReportes() directamente.

### ✅ Después: El nuevo diseño permite agregar nuevos formatos sin modificar el código existente.
```java
generadorReportes.registrarFormato("PDF", new ReportePdf());
📌 Solo registras una nueva clase que implemente la interfaz común.
No se modifica GestorCampeonato ni GeneradorReportes.
```
## 3. **L – Liskov Substitution Principle (LSP)**
>Las subclases deben poder sustituir a sus clases padre sin alterar el programa.

### ✅ Después: Las clases ReporteTexto y ReporteHtml probablemente implementan una interfaz común como IReporte, y son utilizadas de manera polimórfica:

```java
public interface IReporte {
    void generar(List<Equipo> equipos, List<Arbitro> arbitros);
}

generadorReportes.registrarFormato("TEXTO", new ReporteTexto());
generadorReportes.registrarFormato("HTML", new ReporteHtml());
📌 Puedes reemplazar ReporteTexto por cualquier clase que implemente IReporte sin romper el programa.
```
## 4. **I – Interface Segregation Principle (ISP)**
>No forzar a una clase a implementar métodos que no necesita.

## ✅ Después: Cada clase de reporte (ej. ReporteTexto) implementa solo lo necesario de la interfaz:

```java
public interface IReporte {
    void generar(List<Equipo> equipos, List<Arbitro> arbitros);
}
📌 La interfaz es pequeña, específica, y no obliga a las clases a implementar métodos innecesarios.
```

## 5. **D – Dependency Inversion Principle (DIP)**
>Depender de abstracciones, no de implementaciones concretas.

### ✅ Después: GestorCampeonato no conoce directamente las clases ReporteTexto o ReporteHtml, sino que las registra a través de una abstracción:

```java
generadorReportes.registrarFormato("TEXTO", new ReporteTexto());
generadorReportes.registrarFormato("HTML", new ReporteHtml());
Y GeneradorReportes depende de una interfaz (IReporte), no de clases concretas.
```

# 🟢 **Conclusión**
✅ El nuevo diseño sigue **SOLID** y por eso es:

- Más fácil de mantener
- Extensible sin romper código existente
- Modular y reutilizable
- Preparado para crecer sin caos