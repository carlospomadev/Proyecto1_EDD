package com.carlospoma.proyecto1;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Representa una venta realizada en la tienda.
 * <p>
 * Una venta está compuesta por:
 * <ul>
 *   <li>Un cliente asociado.</li>
 *   <li>Una lista de pájaros adquiridos.</li>
 *   <li>La fecha y hora en que se realizó la venta.</li>
 * </ul>
 *
 * Permite añadir pájaros a la venta, calcular el total y mostrar un
 * resumen detallado de la transacción en consola.
 *
 * @author Carlos
 * @version 1.0
 */

public class Venta {
    /** Cliente que realizó la compra. */
    private Cliente cliente;
    /** Lista de pájaros adquiridos en esta venta. */
    private ArrayList<Pajaro> pajaros = new ArrayList<>();
    /** Fecha y hora en que se registró la venta. */
    private LocalDateTime fechaVenta;

    /**
     * Constructor que crea una venta asociada a un cliente
     * y establece la fecha actual como momento de la venta.
     *
     * @param cliente cliente que realiza la compra.
     */
    public Venta(Cliente cliente){
        this.cliente = cliente;
        this.pajaros = new ArrayList<>();
        this.fechaVenta = LocalDateTime.now();
    }

    /**
     * Añade un pájaro a la lista de la venta.
     *
     * @param p objeto {@link Pajaro} que se añade a la venta.
     */
    public void añadirPajaro(Pajaro p){
        pajaros.add(p);
    }

    /**
     * Calcula el precio total de todos los pájaros vendidos.
     *
     * @return total acumulado de la venta.
     */
    public double calcularTotal(){
        double total = 0;
        for (Pajaro p : pajaros){
            total += p.getPrecio();
        }
        return total;
    }

    /**
     * Muestra en consola la información detallada de la venta:
     * <ul>
     *   <li>Nombre del cliente.</li>
     *   <li>Fecha y hora de la transacción.</li>
     *   <li>Listado de pájaros adquiridos con sus datos.</li>
     *   <li>Total de la venta.</li>
     * </ul>
     */
    public void mostrarInfo(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Fecha de venta: " + fechaVenta.format(formato));
        System.out.println("Pajaros vendidos:");
        for (Pajaro p : pajaros){
            System.out.println(" - " + p.getEspecie() + " | Color: " + p.getColor() + " | Precio: " + p.getPrecio());
        }
        System.out.println("Total: " + calcularTotal() + "€");
        System.out.println("------------");
    }
}

