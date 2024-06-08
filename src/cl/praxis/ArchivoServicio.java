package cl.praxis;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ArchivoServicio {
    Scanner sc = new Scanner(System.in);
    public List<Producto> cargarDatos(List<Producto> productList){
        String ruta = rutaDirectorio();
        String nombreArchivo = "/ProductosImportados.csv";
        String fullFiles = ruta+nombreArchivo;
        try {
            FileReader fr = new FileReader(fullFiles);
            BufferedReader br = new BufferedReader(fr);

            String data;
            String[] aux;
            while ((data = br.readLine()) != null) {
                aux = data.split(",");
                Producto producto=new Producto();
                producto.setArticulo(aux[0]);
                producto.setPrecio(aux[1]);
                producto.setDescripcion(aux[2]);
                producto.setCodigo(aux[3]);
                producto.setTalla(aux[4]);
                producto.setMarca(aux[5]);
                producto.setColor(aux[6]);
                productList.add(producto);
            }
            fr.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    private String rutaDirectorio() {
        System.out.print("Ingrese la ruta(SIN ESPACIOS) donde se encuentra el archivo csv: ");
        return sc.next();
    }
}
