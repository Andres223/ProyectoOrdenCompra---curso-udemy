import java.util.Scanner;

public class EjemploOrdenCompra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas ordenes va a registrar?: ");
        int cantOrdenes = sc.nextInt();
        sc.nextLine();

        OrdenCompra[] ordenes = new OrdenCompra[cantOrdenes];

        for (int i=0; i<ordenes.length; i++) {
            System.out.println("\n\tOrden #"+(i+1));

            System.out.print("Descripción orden: ");
            String descripcion = sc.next();
            sc.nextLine();

            System.out.println("\tDATOS CLIENTE");
            System.out.print("Nombre del cliente: ");
            String nombre = sc.next();
            sc.nextLine();

            System.out.print("Apellido cliente: ");
            String apellido = sc.next();
            sc.nextLine();

            System.out.print("¿Cuántos productos va agregar a la orden?: ");
            int cantProductos = sc.nextInt();

            OrdenCompra orden = new OrdenCompra(cantProductos, descripcion);
            orden.setCliente(new Cliente(nombre, apellido));

            Producto[] productos = new Producto[cantProductos];
            for (int j=0; j<productos.length; j++) {
                System.out.println("\tproducto #"+(j+1));

                System.out.print("Fabricante: ");
                String fabricante = sc.next();
                sc.nextLine();

                System.out.print("Nombre producto: ");
                String nombreProd = sc.nextLine();

                System.out.print("Precio: ");
                int precio = sc.nextInt();
                sc.nextLine();

                orden.addProductos(new Producto(fabricante, nombreProd, precio));
            }
            ordenes[i] = orden;
        }

        System.out.println("\n\033[31mOrdenes registradas\033[0m");
        for (OrdenCompra orden : ordenes) {
            System.out.println("\n\033[31mid:\033[0m "+orden.getId()+"\n\033[31mFecha:\033[0m "+orden.getFechaFormateada()+"\n\033[31mDescripción:\033[0m "+orden.getDescripcion()
            +"\n\t\033[31mCliente\033[0m\n\033[31mNombre:\033[0m "+orden.getCliente().getNombre()+"\n\033[31mApellido:\033[0m "+orden.getCliente().getApellido());
            System.out.print("\n\t\033[31mProductos\033[0m");
            for (int i=0; i<orden.getIndiceProductos(); i++) {
                Producto producto = orden.getProducto(i);

                System.out.print("\n\033[31mFabricante:\033[0m "+producto.getFabricante()+
                        " \033[31mNombre producto:\033[0m "+producto.getNombre()+" \033[31mPrecio:\033[0m "+producto.getPrecio());
            }
            System.out.print("\n\033[31mTotal productos:\033[0m "+orden.totalProductos());
        }
    }
}
