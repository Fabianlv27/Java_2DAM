package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre_producto")
	private String nombreProducto;

	//bi-directional many-to-many association to Cliente
	@ManyToMany(mappedBy="productos")
	private List<Cliente> clientes;

	public Producto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	public Producto(String nombreProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.clientes=new ArrayList<Cliente>();
	}

	public void AddCliente(Cliente c) {
		clientes.add(c);
		c.getProductos().add(this);
	}

}