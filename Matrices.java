public class Matrices {
    public static void main(String[] args) {

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
}
