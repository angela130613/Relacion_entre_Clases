package edu.sena.Relacion_entre_clases.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private final int folio;
    private final String descripcion;
    private final Date fecha;
    private final Cliente cliente;
    private final ItemFactura[] items;
    private int indiceItems; // Este índice te permitirá saber cuántos ítems han sido añadidos.
    private static final int MAX_ITEMS = 10; // Define el número máximo de ítems permitidos en la factura.

    public Factura(int folio, String descripcion,Date fecha, Cliente cliente) {
        this.folio = folio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.indiceItems = 0;
    }

    // Añade los ítems de la factura
    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        } else {
            System.out.println("No se pueden añadir más ítems a la factura, se alcanzó el límite máximo.");
        }
    }

    /**
     * Calcula el importe total de la factura sumando el importe de cada ítem en la lista.
     *
     * @return el importe total de la factura, como un valor de tipo {@code float}.
     *         Si la lista de ítems está vacía o todos los ítems son {@code null}, el valor retornado será 0.0.
     */
    public float calcularTotal() {
        float total = 0.0f;
        for (ItemFactura item : this.items) {
            if (item != null) {
                total += (float) item.calcularImporte();
            }
        }
        return total;
    }

    // Prepara el detalle de la factura
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (int i = 0; i < indiceItems; i++) {
            if (this.items[i] != null) {
                sb.append(i + 1)
                        .append("\t")
                        .append(this.items[i].getCantidad())
                        .append("\t")
                        .append(this.items[i].calcularImporte())
                        .append("\n");
            }
        }
        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}