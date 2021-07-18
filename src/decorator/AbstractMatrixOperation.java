package decorator;

public abstract class AbstractMatrixOperation implements Matrix {

    private Matrix matrix;

    AbstractMatrixOperation(Matrix matrixData) {

        this.matrix = matrixData;
    }

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return matrix.getElement(i, j);
    }
}
