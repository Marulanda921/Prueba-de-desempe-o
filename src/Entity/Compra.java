package Entity;


import java.util.Date;

public class Compra {
    private int id;
    private int idCliente;
    private  int idProducto;
    private Date fechaCompra;
    private int cantidad;


    private Cliente objCliente;
    private  Producto objProducto;

    private Tienda objTienda;

    public Compra() {
    }

    public Compra(int idCliente, int idProducto, Date fechaCompra, int cantidad, Cliente objCliente, Producto objProducto ,Tienda objTienda) {
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.objCliente = objCliente;
        this.objProducto = objProducto;
        this.objTienda = objTienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public java.sql.Date getFechaCompra() {
        return (java.sql.Date) fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }

    public Tienda getObjTienda() {
        return objTienda;
    }

    public void setObjTienda(Tienda objTienda) {
        this.objTienda = objTienda;
    }


    @Override
    public String toString() {
        return "Compra{" +
                ", fechaCompra=" + fechaCompra +
                ", cantidad=" + cantidad +
                ", Cliente=" + objCliente.getNombre() +
                ", Producto =" + objProducto.getNombre() +
                ", Tienda=" + objTienda.getNombre() +
                '}';
    }
}
