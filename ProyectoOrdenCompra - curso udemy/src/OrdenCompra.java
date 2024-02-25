import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrdenCompra {
    private int id;
    private LocalDate fecha;
    private String descripcion;
    private Cliente cliente;
    private Producto[] productos;
    private int indiceProductos;
    private static int ultimoId;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public OrdenCompra() {
        this.id = ++ultimoId;
        this.fecha = LocalDate.now();
    }

    public OrdenCompra(int tamanioArray, String descripcion) {
        this();
        this.productos = new Producto[tamanioArray];
        this.descripcion = descripcion;
    }

    public String getFechaFormateada() {
        return fecha.format(formatter);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public int getIndiceProductos() {
        return indiceProductos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void addProductos(Producto producto) {
        this.productos[indiceProductos++] = producto;
    }

    public Producto getProducto(int indice) {
        if (indice >= 0 && indice <= this.indiceProductos) {
            return productos[indice];
        } else {
            System.out.println("Indice fuera de rango.");
            return null;
        }
    }

    public int totalProductos() {
        int total = 0;
        for (Producto producto: productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
