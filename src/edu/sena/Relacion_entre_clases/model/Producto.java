package edu.sena.Relacion_entre_clases.model;

public class Producto {
    private int codigo;
    private String nombre;
    public static double precio;
    private static int ultimoCodigo;

// Constructor
    public Producto(String nombre, double precio){
        ultimoCodigo++;
        this.codigo = ultimoCodigo;
        this.nombre = nombre;
        Producto.precio = precio;
    }

// Get y Set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        Producto.precio = precio;
    }

    public static int getUltimoCodigo() {
        return ultimoCodigo;
    }

    public static void setUltimoCodigo(int ultimoCodigo) {
        Producto.ultimoCodigo = ultimoCodigo;
    }

// To String
    @Override
    public String toString() {

        return codigo +
                "\t" + nombre +
                "\t" + precio;
    }
}
