package cl.praxis;

public class Utilidad {
    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            System.out.println(os);
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
