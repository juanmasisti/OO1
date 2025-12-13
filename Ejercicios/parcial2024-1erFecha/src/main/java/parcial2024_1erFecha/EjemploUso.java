package parcial2024_1erFecha;

import java.time.LocalDate;

public class EjemploUso {
	public static void main(String[] args) {

        // Crear evento presencial
        EventoPresencial evento = new EventoPresencial(
                "Congreso Ambiental 2024",
                LocalDate.of(2024, 12, 20),
                "Cambio climático",
                10000,
                2000
        );
        evento.agregarSede(new Sede("La Plata", 1500, 2)); // 3000
        evento.agregarSede(new Sede("Mar del Plata", 1000, 1)); // 1000

        // Crear usuario
        Usuario juan = new Usuario("Juan Sisti", LocalDate.now());

        // Comprar entrada con seguro
        Entrada entrada = juan.comprarEntrada(evento, true);

        // Mostrar valores
        System.out.println("Evento: " + evento.getNombre());
        System.out.println("Precio asistencia al momento de compra: " + evento.calcularPrecioAsistencia(LocalDate.now()));
        System.out.println("Valor pagado (con seguro): " + entrada.obtenerValorEntrada());

        // Calcular monto total de entradas del mes
        double totalMes = juan.calcularMontoTotalEntradas(LocalDate.now().minusDays(30), LocalDate.now());
        System.out.println("Total gastado este mes: " + totalMes);

        // Calcular posible reembolso
        double reembolso = entrada.calcularMontoARecuperar();
        System.out.println("Monto recuperable: " + reembolso);
    }
}
