public class Main {
    public static void main(String[] args) throws MatrixException {

        //Sin genes mutados
        String[][] matriz1 = {
                {"A", "A", "C", "A", "C", "G"},
                {"C", "G", "G", "C", "G", "C"},
                {"T", "T", "T", "A", "C", "T"},
                {"A", "G", "G", "A", "G", "C"},
                {"C", "C", "G", "C", "T", "A"},
                {"T", "C", "A", "C", "T", "G"}
        };
        //Con 2 genes mutados
        String[][] matriz2 = {
                {"T", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "A", "G", "T"},
                {"A", "G", "A", "A", "G", "G"},
                {"C", "A", "C", "C", "T", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
        //Con un caracter no permitido
        String[][] matriz3 = {
                {"T", "T", "G", "C", "G", "A"},
                {"G", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "A", "G", "T"},
                {"A", "G", "4", "A", "G", "G"},
                {"C", "A", "C", "C", "T", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
        //Con una letra minusculas
        String[][] matriz4 = {
                {"T", "T", "G", "C", "G", "A"},
                {"G", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "A", "G", "T"},
                {"A", "G", "A", "a", "G", "G"},
                {"C", "A", "C", "C", "T", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };

        //Con un simbolo
        String[][] matriz5 = {
                {"T", "T", "G", "C", "/", "A"},
                {"G", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "A", "G", "T"},
                {"A", "G", "G", "A", "G", "G"},
                {"C", "A", "C", "C", "T", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
//Diagonal de izquierda abajo a derecha arriba
        String[][] matriz6 = {
                {"T", "T", "G", "C", "T", "A"},
                {"G", "A", "G", "T", "T", "C"},
                {"T", "T", "A", "A", "T", "T"},
                {"A", "G", "A", "A", "T", "G"},
                {"C", "A", "C", "C", "G", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
        //Diagonal de izquierda arriba a derecha abajo
        String[][] matriz7 = {
                {"T", "T", "G", "C", "T", "A"},
                {"G", "A", "C", "T", "T", "C"},
                {"T", "T", "G", "A", "T", "T"},
                {"A", "G", "A", "G", "T", "G"},
                {"C", "G", "C", "C", "G", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
        String[][] matriz8 = {

                {"A", "T", "G", "C", "G", "A"},
                {"C", "A", "G", "T", "G", "C"},
                {"T", "T", "A", "A", "G", "T"},
                {"A", "G", "A", "A", "T", "G"},
                {"C", "G", "C", "C", "T", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
        //Con dos genes verticales
        String[][] matriz9 = {

                {"A", "T", "G", "C", "G", "A"},
                {"C", "T", "G", "T", "G", "C"},
                {"T", "T", "A", "A", "G", "T"},
                {"A", "T", "A", "A", "G", "G"},
                {"C", "G", "C", "C", "T", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
        //Con dos genes horizontales
        String[][] matriz10 = {

                {"A", "T", "G", "C", "G", "A"},
                {"C", "G", "G", "T", "G", "C"},
                {"T", "T", "T", "T", "C", "T"},
                {"A", "T", "A", "A", "G", "G"},
                {"C", "C", "C", "C", "T", "A"},
                {"A", "C", "A", "C", "T", "G"}
        };
        System.out.println("Matriz 1");
        analisisMutante(matriz1);
        System.out.println("Matriz 2");
        analisisMutante(matriz2);
        System.out.println("Matriz 3");
        analisisMutante(matriz3);
        System.out.println("Matriz 4");
        analisisMutante(matriz4);
        System.out.println("Matriz 5");
        analisisMutante(matriz5);
        System.out.println("Matriz 6");
        analisisMutante(matriz6);
        System.out.println("Matriz 7");
        analisisMutante(matriz7);
        System.out.println("Matriz 8");
        analisisMutante(matriz8);
        System.out.println("Matriz 9");
        analisisMutante(matriz9);
        System.out.println("Matriz 10");
        analisisMutante(matriz10);

    }

    public static void analisisMutante(String[][] matrix) {
        try {
            Verificador verificador = new Verificador();
            System.out.println("La siguiente matriz:");
            showMatrix(matrix);
            if (verificador.isMutant(matrix))
                System.out.println("Es mutante\n");
            else
                System.out.println("No es mutante\n");
        } catch (MatrixException e) {
            System.out.println("Invalid matrix: " + e.getMessage());
        }
    }

    public static void showMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}