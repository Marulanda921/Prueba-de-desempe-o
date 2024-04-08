package Entity;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int idTIenda;
    private int stock;

    private Tienda objTienda;

    public Producto() {
    }

    public Producto(String nombre, float precio, int idTIenda, int stock, Tienda objTienda) {
        this.nombre = nombre;
        this.precio = precio;
        this.idTIenda = idTIenda;
        this.stock = stock;
        this.objTienda = objTienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getIdTIenda() {
        return idTIenda;
    }

    public void setIdTIenda(int idTIenda) {
        this.idTIenda = idTIenda;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Tienda getObjTienda() {
        return objTienda;
    }

    public void setObjTienda(Tienda objTienda) {
        this.objTienda = objTienda;
    }

    @Override
    public String toString() {
        return "Producto{" +
                ", nombre: '" + nombre + '\'' +
                ", precio: " + precio +
                ", Tienda: " + objTienda.getNombre() +
                ", Ubicacion: " + objTienda.getUbicacion() +
                ", stock: " + stock +
                '}';
    }
}
