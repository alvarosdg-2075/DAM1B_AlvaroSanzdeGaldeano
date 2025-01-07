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

    public void moverse(int direccion) {
        int nuevaFila = posicionActual.getCoordenadaFila();
        int nuevaCol = posicionActual.getCoordenadaCol();

        switch (direccion) {
            case ARRIBA:
                if (nuevaFila > 0) nuevaFila--;
                break;
            case ABAJO:
                if (nuevaFila < 5) nuevaFila++;
                break;
            case DERECHA:
                if (nuevaCol < 19) nuevaCol++;
                break;
            case IZQUIERDA:
                if (nuevaCol > 0) nuevaCol--;
                break;
        }

        posicionActual.setCoordenadaFila(nuevaFila);
        posicionActual.setCoordenadaCol(nuevaCol);
    }
}
