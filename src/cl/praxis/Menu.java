package cl.praxis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public  void operarMenu() {
        int op;
        List<Producto> lp = new ArrayList<>();
        ProductoServicio ps = new ProductoServicio(lp);
        ArchivoServicio as = new ArchivoServicio();

        do {
            op = menuPrincipal();

            if (op == 1) {
                ps.listarProductos(lp);
            } else if (op == 2) {
                ps.editarProducto(lp);
            } else if (op == 3) {
                as.cargarDatos(lp);
            } else if (op == 4) {
                System.out.println("Abandonando el sistema de clientes...\n" +
                        "Acaba de salir del sistema\n");
            } else {
                System.out.println("Opción no válida");
            }
        } while (op != 4);
    }

public int menuPrincipal(){
    mensaje(" === MENÚ DE OPCIONES ===");
    mensaje(" 1. Listar Producto");
    mensaje(" 2. Editar Producto");
    mensaje(" 3. Exportar Datos");
    mensaje(" 4. Salir");

    return leerValorInt("Ingrese una opción:");
}

public  int leerValorInt(String mensaje) {
    Scanner sc = new Scanner(System.in);
    System.out.println(mensaje);
    return sc.nextInt();
}
public  void mensaje (String mensaje) {
    System.out.println(mensaje );
}

}
