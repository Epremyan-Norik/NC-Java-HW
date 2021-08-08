package decorator;

public abstract class AbstractMatrixOperation implements Matrix {

    protected Matrix matrix;

    AbstractMatrixOperation(Matrix matrixData) {

        this.matrix = matrixData;
    }

}
