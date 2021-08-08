package decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixImplTest {

    @Test
    void canGetElement() {
        int[][] myMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Matrix matrix = new MatrixImpl(myMatrix);

        assertEquals(matrix.getElement(0,2), 3);
    }

    @Test
    void returnNotNull() {
        int[][] myMatrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        Matrix matrix = new MatrixImpl(myMatrix);

        assertNotNull(matrix.getElement(0,2));
    }

}