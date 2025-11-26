package Gestisimal;

import java.util.Scanner;

public class Gestion {
	public static Almacen A= new Almacen();
	static  Scanner sc = new Scanner(System.in);
    static final String[] ColoresANSI = {
            "\u001B[31m", // R - Rojo
            "\u001B[33m", // A - Amarillo
            "\u001B[32m", // V - Verde
            "\u001B[34m", // Z - Azul
            "\u001B[35m", // M - Marrón (usamos magenta como aproximación)
            "\u001B[37m"  // B - Blanco
        };
    static final String RESET = "\u001B[0m";
	public static void main(String[] args) {
       
        int opcion;
        
        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    listado();
                    break;
                case 2:
                    alta();
                    break;
                case 3:
                    baja();
                    break;
                case 4:
                    modificacion();
                    break;
                case 5:
                    entradaMercancia();
                    break;
                case 6:
                    salidaMercancia();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.\n");
            }
        } while (opcion != 7);

        sc.close();
    }



    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ DE INVENTARIO =====");
        System.out.println("1. Listado");
        System.out.println("2. Alta");
        System.out.println("3. Baja");
        System.out.println("4. Modificación");
        System.out.println("5. Entrada de mercancía");
        System.out.println("6. Salida de mercancía");
        System.out.println("7. Salir");
        System.out.println("===============================");
    }

    public static void listado() {
        System.out.println("→ Mostrando listado de productos...");
        
        // Aquí podrías listar productos de un arreglo o base de datos
    }

    public static void alta() {
        System.out.println("→ Alta de nuevo producto...");
        // Aquí podrías pedir datos y agregar un producto
    }

    public static void baja() {
        System.out.println("→ Baja de producto...");
        // Aquí podrías pedir un ID y eliminarlo
    }
    
    public static void PreguntarAtributos(Articulo a) {
    	System.out.println(ColoresANSI[2]+"Pulse enter si no quiere ingresar el dato"+RESET);
    	System.out.println("Codigo: ");
    	 String codigo=sc.nextLine();
    	 System.out.println("Descipcion: ");
    	 String descripcion=sc.nextLine();
    	 System.out.println("Precio: ");
    	 double precio=sc.nextDouble();
    	 System.out.println("Precio de venta: ");
    	 double precio_venta=sc.nextDouble();
    	 System.out.println("Stock: ");
    	 int stock=sc.nextInt();
    	 if (codigo!="")a.setCodigo(codigo);
    	 if (descripcion!="")a.setDescripcion(descripcion);
    	 if (precio!=0.0)a.setPrecio(precio_venta);
    	 if (precio_venta!=0.0)a.setPrecio_venta(precio_venta);
    	 if (stock!=0)a.setStock(stock);
    }

    public static void modificacion() {
        System.out.println("→ Modificación de producto...");
        int op;
        listado();
        System.out.println("Que elemento quieres modificar: ");
        op=sc.nextInt();
        
    }

    public static void entradaMercancia() {
        System.out.println("→ Entrada de mercancía...");
        // Aquí podrías aumentar la cantidad de un producto
    }

    public static void salidaMercancia() {
        System.out.println("→ Salida de mercancía...");
        // Aquí podrías disminuir la cantidad de un producto
    }
}
