import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal del sistema de gestión de clientes, pájaros y ventas.
 * <p>
 * Permite:
 * <ul>
 *   <li>Registrar, eliminar, modificar y listar clientes.</li>
 *   <li>Registrar y listar pájaros.</li>
 *   <li>Registrar ventas asociando clientes con pájaros.</li>
 *   <li>Visualizar las ventas realizadas.</li>
 * </ul>
 *
 * Los datos se almacenan en memoria mediante colecciones {@link ArrayList}.
 *
 * @author Carlos
 * @version 1.0
 */

public class Main {

    /** Lista de clientes registrados en el sistema. */
    static ArrayList<Cliente> clientes = new ArrayList<>();
    /** Lista de pájaros disponibles en la tienda. */
    static ArrayList<Pajaro> pajaros = new ArrayList<>();
    /** Lista de ventas realizadas. */
    static ArrayList<Venta> ventas = new ArrayList<>();

    /**
     * Método principal que inicializa el menú de interacción con el usuario.
     *
     * @param args argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n****MENU PRINCIPAL****");
            System.out.println("1.Gestión de clientes");
            System.out.println("2. Gestión de pájaros");
            System.out.println("3.Realizar Venta");
            System.out.println("4.Mostrar Ventas");
            System.out.println("5.Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestionarClientes(sc);
                case 2 -> gestionarPajaros(sc);
                case 3 -> realizarVentas(sc);
                case 4 -> mostrarVentas();
                case 5 -> System.out.println("Saliendo...");
            }
        }while (opcion !=5);
    }
    /**
     * Permite la gestión de clientes: alta, baja, modificación y listado.
     *
     * @param sc objeto {@link Scanner} para la entrada de datos por consola.
     */
    static void gestionarClientes(Scanner sc) {
        System.out.println("\n***Gestión de Clientes***");
        System.out.println("1.Alta");
        System.out.println("2.Baja");
        System.out.println("3.Modificación");
        System.out.println("4.Listado");
        System.out.println("Elige opción");
        int opc = sc.nextInt();sc.nextLine();

        switch (opc){
            case 1 ->{
                System.out.println("Nombre:");
                String nombre = sc.nextLine();

                String dni;
                do {
                    System.out.println("DNI (solo números): ");
                    dni = sc.nextLine();
                    if (!dni.matches("\\d+")){
                        System.out.println("DNI inválido. Digita solo números.");
                    }
                }while (!dni.matches("\\d+"));

                String telefono;
                do {
                    System.out.println("Teléfono (9 dígitos): ");
                    telefono = sc.nextLine();
                    if (!telefono.matches("\\d{9}")){
                        System.out.println("Teléfono inválido. Digita 9 dígitos.");
                    }
                }while (!telefono.matches("\\d{9}"));

                String email;
                do {
                    System.out.println("Email:");
                    email = sc.nextLine();
                    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")){
                    System.out.println("Email inválido. Introduce un formato válido como ejemplo@correo.com ");
                    }
                }while (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$"));

                clientes.add(new Cliente(nombre, dni, telefono, email));
            }
            case 2 -> {
                listarClientes();
                System.out.println("Posición a eliminar: ");
                int pos = sc.nextInt(); sc.nextLine();
                int eliminarNombre = pos -1;
                if (eliminarNombre>=0 && eliminarNombre<clientes.size()) clientes.remove(eliminarNombre);
            }
            case 3 -> {
                listarClientes();
                System.out.println("Posición a modificar: ");
                int pos = sc.nextInt(); sc.nextLine();
                int indice = pos - 1;
                if (indice >= 0 && indice < clientes.size()){
                    Cliente cambioNombre = clientes.get(indice);
                    System.out.println("Nuevo nombre: ");
                    cambioNombre.setNombre(sc.nextLine());
                }
            }
            case 4 -> listarClientes();

        }

    }
    /**
     * Permite la gestión de pájaros: alta y listado.
     *
     * @param sc objeto {@link Scanner} para la entrada de datos por consola.
     */
    static void gestionarPajaros(Scanner sc) {
        System.out.println("\n***Gestión de Pájaros***");
        System.out.println("1.Alta");
        System.out.println("2.Listado");
        int opc = sc.nextInt();
        sc.nextLine();

        switch (opc) {
            case 1 -> {
                System.out.println("Especie: ");
                String especie = sc.nextLine();
                System.out.println("Color: ");
                String color = sc.nextLine();
                System.out.println("Precio: ");
                double precio = sc.nextDouble();
                pajaros.add(new Pajaro(especie, color, precio));
            }
            case 2 -> listarPajaros();
        }
    }
    /**
     * Registra una venta seleccionando un cliente y uno o muchos pájaros.
     *
     * @param sc objeto {@link Scanner} para la entrada de datos por consola.
     */
    static void realizarVentas(Scanner sc){
        if(clientes.isEmpty() || pajaros.isEmpty()) {
            System.out.println("Error. Primero registra clientes y pájaros.");
            return;
        }
        System.out.println("Seleccionar cliente: ");
        listarClientes();
        int posCliente = sc.nextInt(); sc.nextLine();
        int indiceCliente = posCliente - 1;
        if(indiceCliente < 0 || indiceCliente >= clientes.size()) return;
        Cliente clienteseleccionado = clientes.get(indiceCliente);
        Venta venta = new Venta(clienteseleccionado);

        boolean seguir = true;
        while (seguir){
            System.out.println("Selecciona pajaro para añadir: ");
            listarPajaros();
            int posPajaro = sc.nextInt(); sc.nextLine();
            int indicepajaro = posPajaro - 1;
            if (indicepajaro >= 0 && indicepajaro<pajaros.size()){
                venta.añadirPajaro(pajaros.get(indicepajaro));
            }
            System.out.println("¿Añadir otro? (s/n): ");
            seguir = sc.nextLine().equalsIgnoreCase("s");
        }
        ventas.add(venta);
        System.out.println("Venta registrada");
    }
    /**
     * Muestra todas las ventas registradas en el sistema.
     */
    static void mostrarVentas(){
        System.out.println("\n***Ventas registradas***");

        if (ventas.isEmpty()){
            System.out.println("No hay ventas registradas.");
            return;
        }
        for (Venta v : ventas){
            v.mostrarInfo();
        }
    }
    /**
     * Lista en consola los clientes registrados.
     */
    static void listarClientes(){
        for (int i = 0; i < clientes.size(); i++){
            System.out.println((i+1) + "." + clientes.get(i).getNombre());
        }
    }
    /**
     * Lista en consola los pájaros registrados, mostrando especie y características.
     */
    static void listarPajaros(){
        for (int i = 0; i<pajaros.size();i++){
            System.out.println((i+1) + "." + pajaros.get(i).getEspecie() + " - " + pajaros.get(i));
        }
    }

}