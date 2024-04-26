import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        System.out.println("Con las 3 matrices que ingresaras a continuacion se efectuara la ecuacion siguiente:\n D=(A*B)+[(B^T)*C]-A^-1\n IMPORTANTE: Los valores decimales se redondearan hacia abajo. ");
        int[][] A = inputMatrix("A");
        int[][] B = inputMatrix("B");
        int[][] C = inputMatrix("C");

        int[][] result = new int[2][2];

        result = multiplyMatrices(A, B);
        
        int[][] BT = transposeMatrix(B);

        int[][] temp = multiplyMatrices(BT, C);

        int[][] AInverse = inverseMatrix(A);
        result = addMatrices(result, temp);
        result = subtractMatrices(result, AInverse);

        System.out.println("El resultado es:");
        printMatrix(result);
    
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[][] transposeMatrix(int[][] A) {
        int[][] AT = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                AT[i][j] = A[j][i];
            }
        }
        return AT;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] C = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static int[][] inverseMatrix(int[][] A) {
        int det = A[0][0] * A[1][1] - A[0][1] * A[1][0];
        int[][] inverseA = {{A[1][1], -A[0][1]}, {-A[1][0], A[0][0]}};

        if(det!=0){
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    inverseA[i][j] /= det;
                }
            }
            
        }else{
            System.out.println("El determinante de la matriz A es 0, por lo que no es posible realizar la operación.");
            System.exit(0);   
        }


        
        return inverseA;
        
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] inputMatrix(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los valores de la matriz " + name + ":");
        int[][] matrix = new int[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(name + "[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        return matrix;
    }
}
