package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre_cliente;

	//bi-directional many-to-many association to Producto
	@ManyToMany
	@JoinTable(
		name="cliente_producto"
		, joinColumns={
			@JoinColumn(name="id_cliente")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_procduto")
			}
		)
	private List<Producto> productos;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_cliente() {
		return this.nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Cliente( String nombre_cliente) {
		super();
		this.nombre_cliente = nombre_cliente;
		this.productos=new ArrayList<Producto>();
		
	}
	public void AddProducto(Producto p) {
		productos.add(p);
		p.getClientes().add(this);
	}

	
	
}