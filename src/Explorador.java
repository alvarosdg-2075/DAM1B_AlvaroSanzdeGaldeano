import java.util.Random;
public class Explorador {
    private String nombre;
    private Posicion posicionActual;
    private static final int ARRIBA = 1;
    private static final int ABAJO = 2;
    private static final int DERECHA = 3;
    private static final int IZQUIERDA = 4;

    public Explorador(String nombre) {
        this.nombre = nombre;
        Random random = new Random();
        int fila = random.nextInt(6);
        this.posicionActual = new Posicion(fila, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }
}
