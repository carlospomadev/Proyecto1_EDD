/**
 * Representa un cliente dentro del sistema.
 * <p>
 * Un cliente tiene nombre, DNI, teléfono y correo electrónico.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
public class Cliente {
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    /**
     * Constructor para crear un cliente con todos sus datos.
     *
     * @param nombre   nombre del cliente.
     * @param dni      documento de identidad (solo números).
     * @param telefono número de teléfono de 9 dígitos.
     * @param email    correo electrónico del cliente.
     */
    public Cliente(String nombre, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el cliente.
     *
     * @param nombre nombre actualizado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return dni;
    }


    /**
     * Obtiene el teléfono del cliente.
     *
     * @return número de teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return dirección de email.
     */
    public String getEmail() {
        return email;
    }
}

