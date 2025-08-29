package com.carlospoma.proyecto1;

/**
 * Representa un pájaro disponible en la tienda.
 * <p>
 * Un pájaro tiene especie, color y precio de venta.
 * </p>
 *
 * @author Carlos
 * @version 1.0
 */
public class Pajaro {
    private String especie;
    private String color;
    private double precio;

    /**
     * Constructor para crear un pájaro.
     *
     * @param especie especie del pájaro (ejemplo: canario, periquito).
     * @param color   color del plumaje.
     * @param precio  precio de venta.
     */
    public Pajaro(String especie, String color, double precio){
        this.especie = especie;
        this.color = color;
        this.precio = precio;
    }

    /**
     * Obtiene la especie del pájaro.
     *
     * @return especie del pájaro.
     */
    public String getEspecie(){
        return especie;
    }

    /**
     * Obtiene el color del pájaro.
     *
     * @return color del plumaje.
     */
    public String getColor(){
        return color;
    }

    /**
     * Establece un nuevo precio para el pájaro.
     *
     * @param precio precio actualizado.
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * Devuelve una representación en texto del pájaro.
     *
     * @return cadena con especie, color y precio.
     */
    @Override
    public String toString() {
        return especie + " | Color: " + color + " | Precio: " + precio + " €";
    }
}

