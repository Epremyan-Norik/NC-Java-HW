package decorator;

public class TransposeMatrix extends AbstractMatrixOperation{

    public TransposeMatrix(Matrix matrix){
        super(matrix);
    }

    @Override
    public int getElement(int i, int j) throws ArrayIndexOutOfBoundsException {
        return super.getElement(j, i);
    }

}
