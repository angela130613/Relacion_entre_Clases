package edu.sena.Relacion_entre_clases.model;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private static int ultimoCodigo;

    public Producto(String nombre, double precio){
        ultimoCodigo++;
        this.codigo = ultimoCodigo;
        this.nombre = nombre;
        this.precio = precio;
    }

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
        this.precio = precio;
    }

    public static int getUltimoCodigo() {
        return ultimoCodigo;
    }

    public static void setUltimoCodigo(int ultimoCodigo) {
        Producto.ultimoCodigo = ultimoCodigo;
    }

    @Override
    public String toString() {

        return codigo +
                "\t" + nombre +
                "\t" + precio;
    }
}
