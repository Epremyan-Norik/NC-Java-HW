package decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoMatricesTest {

    @Test
    void canGetElementFromSumMatrix() {
        int[][] myMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Matrix matrix = new MatrixImpl(myMatrix);
        Matrix sumOfTwoMatrices  = new SumOfTwoMatrices(matrix, matrix);

        assertEquals(sumOfTwoMatrices.getElement(1,2), 12);
    }

    @Test
    void returnNotNullFromSumMatrix() {
        int[][] myMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Matrix sumOfTwoMatrices  = new SumOfTwoMatrices(new MatrixImpl(myMatrix), new MatrixImpl(myMatrix));

        assertNotNull(sumOfTwoMatrices.getElement(1,2));

    }
}