package decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransposeMatrixTest {

    @Test
    void canGetElementFromTransposeMatrix() {
        int[][] myMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Matrix matrix = new TransposeMatrix(new MatrixImpl(myMatrix));

        assertEquals(matrix.getElement(0,2), 7);

    }

    @Test
    void returnNotNullFromTransposeMatrix() {
        int[][] myMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Matrix matrix = new TransposeMatrix(new MatrixImpl(myMatrix));

        assertNotNull(matrix.getElement(0,2));

    }
}