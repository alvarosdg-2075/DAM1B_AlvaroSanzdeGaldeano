import java.util.Random;
public class Enemigo {
    private Posicion posicionActual;

    public Enemigo(Posicion posicion) {
        this.posicionActual = posicion;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public void moverse() {
        Random random = new Random();
        int direccion = random.nextInt(4) + 1; // Valores entre 1 y 4
        int nuevaFila = posicionActual.getCoordenadaFila();
        int nuevaCol = posicionActual.getCoordenadaCol();

        switch (direccion) {
            case 1: // ARRIBA
                if (nuevaFila > 0) nuevaFila--;
                break;
            case 2: // ABAJO
                if (nuevaFila < 5) nuevaFila++;
                break;
            case 3: // DERECHA
                if (nuevaCol < 19) nuevaCol++;
                break;
            case 4: // IZQUIERDA
                if (nuevaCol > 0) nuevaCol--;
                break;
        }

        posicionActual.setCoordenadaFila(nuevaFila);
        posicionActual.setCoordenadaCol(nuevaCol);
    }
}
