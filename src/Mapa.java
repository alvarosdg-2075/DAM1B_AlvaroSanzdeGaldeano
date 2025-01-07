import java.util.Random;
class Mapa {
    private char[][] tablero;
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo[] listadoEnemigos;
    private Posicion[] posicionTrampas;

    public Mapa() {
        tablero = new char[6][20];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }
        }

        generarJugador();
        generarEnemigos();
        generarTrampas();
        generarTesoro();
    }

    private void generarJugador() {
        Explorador explorador = new Explorador("Jugador");
        posJugador = explorador.getPosicionActual();
        tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';
    }

    private void generarEnemigos() {
        listadoEnemigos = new Enemigo[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int fila, col;
            do {
                fila = random.nextInt(6);
                col = random.nextInt(20);
            } while (tablero[fila][col] != ' ');

            Posicion posicion = new Posicion(fila, col);
            listadoEnemigos[i] = new Enemigo(posicion);
            tablero[fila][col] = 'E';
        }
    }

    private void generarTrampas() {
        posicionTrampas = new Posicion[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int fila, col;
            do {
                fila = random.nextInt(6);
                col = random.nextInt(20);
            } while (tablero[fila][col] != ' ' || !cumpleDistanciaTrampas(fila, col, i));

            posicionTrampas[i] = new Posicion(fila, col);
            tablero[fila][col] = 'T';
        }
    }

    private boolean cumpleDistanciaTrampas(int fila, int col, int index) {
        for (int i = 0; i < index; i++) {
            Posicion trampa = posicionTrampas[i];
            if (Math.abs(trampa.getCoordenadaFila() - fila) < 3 || Math.abs(trampa.getCoordenadaCol() - col) < 3) {
                return false;
            }
        }
        return true;
    }

    private void generarTesoro() {
        Random random = new Random();
        int fila, col;
        do {
            fila = random.nextInt(6);
            col = random.nextInt(20);
        } while (tablero[fila][col] != ' ');

        posTesoro = new Posicion(fila, col);
    }

    public char[][] getTablero() {
        return tablero;
    }

    public Posicion getPosTesoro() {
        return posTesoro;
    }

    public void mostrar() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}