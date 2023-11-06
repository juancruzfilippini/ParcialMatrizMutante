public class Verificador {
    public boolean isMutant(String[][] dna) throws MatrixException {
        int n = dna.length;
        if (n == 0) {
            throw new MatrixException("La matriz ingresada esta vacia.");
        }
        for (int i = 0; i < n; i++) {
            if (dna[i].length != n) {
                throw new MatrixException("La matriz ingresada no es una matriz cuadrada");
            }
            for (int j = 0; j < n; j++) {
                if (!dna[i][j].matches("[ATCG]")) {
                    throw new MatrixException("La matriz ingresada contiene caracteres no validos. (Solo A, T, C, G)");
                }
            }
        }
        //Contador de genes mutados
        int contador = 0;
        //Incrementar el contador si se encuentran genes en la matriz
        contador += contadorHorizontal(dna);
        contador += contadorVertical(dna);
        contador += contadorDiagonal(dna);
        return contador >= 2;
    }

    //Funcion para buscar genes de forma horizontal
    private int contadorHorizontal(String[][] dna) {
        int contador = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length - 3; j++) {
                if (dna[i][j].equals(dna[i][j+1]) && dna[i][j].equals(dna[i][j+2]) && dna[i][j].equals(dna[i][j+3])) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //Funcion para buscar genes de forma vertical
    private int contadorVertical(String[][] dna) {
        int contador = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length; j++) {
                if (dna[i][j].equals(dna[i+1][j]) && dna[i][j].equals(dna[i+2][j]) && dna[i][j].equals(dna[i+3][j])) {
                    contador++;
                }
            }
        }
        return contador;
    }

    //Funcion para buscar genes de forma diagonal (incluye llamados a funciones contadorDiagonalTopLeftToBottomRight y contadorDiagonalBottomLeftToTopRight )
    private int contadorDiagonal(String[][] dna) {
        int contador = 0;
        contador += contadorDiagonalTopLeftToBottomRight(dna);
        contador += contadorDiagonalBottomLeftToTopRight(dna);
        return contador;
    }

    private int contadorDiagonalTopLeftToBottomRight(String[][] dna) {
        int contador = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length - 3; j++) {
                if (dna[i][j].equals(dna[i+1][j+1]) && dna[i][j].equals(dna[i+2][j+2]) && dna[i][j].equals(dna[i+3][j+3])) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private int contadorDiagonalBottomLeftToTopRight(String[][] dna) {
        int contador = 0;
        for (int i = 3; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length - 3; j++) {
                if (dna[i][j].equals(dna[i-1][j+1]) && dna[i][j].equals(dna[i-2][j+2]) && dna[i][j].equals(dna[i-3][j+3])) {
                    contador++;
                }
            }
        }
        return contador;
    }
}
