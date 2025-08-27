public class Pajaro {
    private String especie;
    private String color;
    private double precio;

    public Pajaro(String especie, String color, double precio){
        this.especie = especie;
        this.color = color;
        this.precio = precio;
    }

    public String getEspecie(){
        return especie;
    }
    public String getColor(){
        return color;
    }
    public double getPrecio(){
        return precio;
    }

    @Override
    public String toString() {
        return especie + " | Color: " + color + " | Precio: " + precio + " €";
    }
}

