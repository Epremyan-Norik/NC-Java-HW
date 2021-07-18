package decorator;

public class SumOfTwoMatrices extends AbstractMatrixOperation{

    private final Matrix matrix;

    public SumOfTwoMatrices (Matrix matrix1, Matrix matrix2){
        super(matrix1);
        this.matrix = matrix2;
    }

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return super.getElement(i, j) + matrix.getElement(i,j);
    }
}
