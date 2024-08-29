import edu.sena.Relacion_entre_clases.model.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNif("5555-5");
        cliente.setNombre("Andrés");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese una descripción de la factura: ");
        String descripcion = s.nextLine();

        System.out.print("Ingrese el folio: ");
        int folio = s.nextInt();

        Factura factura = new Factura(folio, descripcion, cliente);

        Producto producto;

        System.out.println();

        for(int i = 0; i<5; i++){
            producto = new Producto();
            System.out.print("Ingrese producto nº " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new ItemFactura(producto, s.nextInt()));

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura);
    }
}
