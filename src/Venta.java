import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Venta {
    private Cliente cliente;
    private ArrayList<Pajaro> pajaros = new ArrayList<>();
    private LocalDateTime fechaVenta;

    public Venta(Cliente cliente){
        this.cliente = cliente;
        this.pajaros = new ArrayList<>();
        this.fechaVenta = LocalDateTime.now();
    }
    public void añadirPajaro(Pajaro p){
        pajaros.add(p);
    }
    public double calcularTotal(){
        double total = 0;
        for (Pajaro p : pajaros){
            total += p.getPrecio();
        }
        return total;
    }
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

