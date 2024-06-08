package cl.praxis;

import java.util.List;
import java.util.Scanner;

public class ProductoServicio {
    Scanner sc = new Scanner(System.in);

    private List<Producto>listaProductos;

    public List<Producto> getListaProductos(){
        return listaProductos;
    }

    public ProductoServicio(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void listarProductos(List<Producto> listaProductos){
        for (Producto producto : listaProductos) {
            mensaje(producto.toString());
           mensaje("-------------------------------------------------------------------------------------");
        }
    }

    public void editarProducto(List<Producto> listaProductos) {
        if (!listaProductos.isEmpty()) {
            int posicion = -1;
            do {
                String codigo = selecionarProducto();
                posicion = obtenerProducto(listaProductos, codigo);

            } while (posicion < 0);
            Producto productos = listaProductos.get(posicion);
            mostarArticulosProductos(productos);
            int op = seleccionarAtributoProducto();
            String reemplazo = reemplazarAtributo();
            if (op == 1) {
                productos.setArticulo(reemplazo);
            } else if (op == 2) {
                productos.setPrecio(reemplazo);
            } else if (op == 3) {
                productos.setDescripcion(reemplazo);
            } else if (op == 4) {
                productos.setCodigo(reemplazo);
            } else if (op == 5) {
                productos.setTalla(reemplazo);
            } else if (op == 6) {
                productos.setMarca(reemplazo);
            } else if (op == 7) {
                productos.setColor(reemplazo);
            }
            listaProductos.add(posicion, productos);
        } else {
            mensaje("No existen datos en esta ubicación.");
        }
    }

    private String reemplazarAtributo() {
        String valor;

        mensaje("Ingrese el nuevo valor: ");
        valor = sc.next();

        return valor;
    }

    private int seleccionarAtributoProducto() {
        mensaje("Seleccione el campo a modificar ingresando el codigo de producto: ");
        return sc.nextInt();
    }
    public  void mensaje (String mensaje) {
        System.out.println(mensaje );
    }

    private void mostarArticulosProductos(Producto productos) {
        mensaje("DESCRIPCIÓN DEL PRODUCTO");
        mensaje("1.-"+productos.getArticulo());
        mensaje("2.-"+productos.getPrecio());
        mensaje("3.-"+productos.getDescripcion());
        mensaje("4.-"+productos.getCodigo());
        mensaje("5.-"+productos.getTalla());
        mensaje("6.-"+productos.getMarca());
        mensaje("7.-"+productos.getColor());

    }

    private int obtenerProducto(List<Producto> listaProductos, String codigo) {
        int indProduct = -1;
        Producto buscarProducto;
        for (int i=0; i<listaProductos.size();i++) {
            buscarProducto = listaProductos.get(i);
            if(buscarProducto.getCodigo().equals(codigo)){
                return i;
            }
        }
        return indProduct;
    }

    private String selecionarProducto() {
        mensaje("Ingrese el código del producto a editar: ");
        return sc.nextLine();
    }

}
