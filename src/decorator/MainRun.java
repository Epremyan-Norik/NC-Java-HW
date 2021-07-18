package decorator;

public class MainRun {

    public static void printMatrix(String label, Matrix matrix, int matrixDim){
        System.out.println(label + " : ");
        for(int i = 0; i < matrixDim; i++){
            for(int j = 0; j < matrixDim; j++){
                System.out.print(matrix.getElement(i,j) + " ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        int[][] myMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        Matrix matrix = new MatrixImpl(myMatrix);
        Matrix transposeMatrix = new TransposeMatrix(new MatrixImpl(myMatrix));
        Matrix sumOfTwoMatrices  = new SumOfTwoMatrices(transposeMatrix, matrix);

        printMatrix("Matrix", matrix, myMatrix[0].length);
        printMatrix("Transpose Matrix", transposeMatrix, myMatrix[0].length);
        printMatrix("Sum of Two Matrices", sumOfTwoMatrices, myMatrix[0].length);


    }
}
