import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Matrix;

class MatrixTest {
    private Matrix matrix3x3;
    private Matrix matrix2x2;
  //*************************************Configuration de base*************************************
    @BeforeEach
    void setUp() {
        // Matrice 3x3 pour la plupart des tests
        matrix3x3 = new Matrix(3);
        matrix3x3.set(0, 0, 1); matrix3x3.set(0, 1, 2); matrix3x3.set(0, 2, 3);
        matrix3x3.set(1, 0, 4); matrix3x3.set(1, 1, 5); matrix3x3.set(1, 2, 6);
        matrix3x3.set(2, 0, 7); matrix3x3.set(2, 1, 8); matrix3x3.set(2, 2, 9);

        // Matrice 2x2 pour les tests de taille différente
        matrix2x2 = new Matrix(2);
        matrix2x2.set(0, 0, 1); matrix2x2.set(0, 1, 1);
        matrix2x2.set(1, 0, 1); matrix2x2.set(1, 1, 1);
    }
//***********************************Tests pour  (set/get)**********************************
    @Test
    void setAndGet_workCorrectly() {
        Matrix m = new Matrix(2);
        m.set(0, 1, 42);
        assertEquals(42, m.get(0, 1));
    }

    @Test
    void get_withInvalidIndices_throwsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix3x3.get(-1, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrix3x3.get(0, 3));
    }
    //************Tests pour la méthode add()****************************
    @Test
    void add_validMatrix_updatesCorrectly() {
        Matrix other = new Matrix(3);
        other.set(0, 0, 9); other.set(0, 1, 8); other.set(0, 2, 7);
        other.set(1, 0, 6); other.set(1, 1, 5); other.set(1, 2, 4);
        other.set(2, 0, 3); other.set(2, 1, 2); other.set(2, 2, 1);

        matrix3x3.add(other);

        assertEquals(10, matrix3x3.get(0, 0));
        assertEquals(10, matrix3x3.get(1, 1));
        assertEquals(10, matrix3x3.get(2, 2));
    }

    @Test
    void add_nullMatrix_throwsException() {
        assertThrows(NullPointerException.class, () -> matrix3x3.add(null));
    }

    @Test
    void add_differentSizeMatrix_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> matrix3x3.add(matrix2x2));
    }

    @Test
    void add_identityMatrix_addsOneToDiagonal() {
        Matrix identity = new Matrix(3);
        identity.set(0, 0, 1); identity.set(1, 1, 1); identity.set(2, 2, 1);

        matrix3x3.add(identity);

        assertEquals(2, matrix3x3.get(0, 0));
        assertEquals(6, matrix3x3.get(1, 1));
        assertEquals(10, matrix3x3.get(2, 2));
    }

    @Test
    void add_zeroMatrix_noChange() {
        Matrix zero = new Matrix(3);
        matrix3x3.add(zero);
        assertEquals(1, matrix3x3.get(0, 0));
        assertEquals(5, matrix3x3.get(1, 1));
        assertEquals(9, matrix3x3.get(2, 2));
    }
    //************************************multiply**********************************
    @Test
    void multiply_validMatrix_updatesCorrectly() {
        Matrix other = new Matrix(3);
        other.set(0, 0, 1); other.set(0, 1, 0); other.set(0, 2, 0);
        other.set(1, 0, 0); other.set(1, 1, 1); other.set(1, 2, 0);
        other.set(2, 0, 0); other.set(2, 1, 0); other.set(2, 2, 1);

        matrix3x3.multiply(other);

        assertEquals(1, matrix3x3.get(0, 0));
        assertEquals(5, matrix3x3.get(1, 1));
        assertEquals(9, matrix3x3.get(2, 2));
    }

    @Test
    void multiply_nullMatrix_throwsException() {
        assertThrows(NullPointerException.class, () -> matrix3x3.multiply(null));
    }

    @Test
    void multiply_differentSizeMatrix_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> matrix3x3.multiply(matrix2x2));
    }

    @Test
    void multiply_identityMatrix_noChange() {
        Matrix identity = new Matrix(3);
        identity.set(0, 0, 1); identity.set(1, 1, 1); identity.set(2, 2, 1);

        matrix3x3.multiply(identity);

        assertEquals(1, matrix3x3.get(0, 0));
        assertEquals(5, matrix3x3.get(1, 1));
        assertEquals(9, matrix3x3.get(2, 2));
    }

    @Test
    void multiply_zeroMatrix_resultsInZeroMatrix() {
        Matrix zero = new Matrix(3);
        matrix3x3.multiply(zero);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, matrix3x3.get(i, j));
            }
        }
    }

    @Test
    void multiply_itself_correctResult() {
        matrix3x3.multiply(matrix3x3);

        assertEquals(30, matrix3x3.get(0, 0));
        assertEquals(36, matrix3x3.get(0, 1));
        assertEquals(42, matrix3x3.get(0, 2));
        assertEquals(66, matrix3x3.get(1, 0));
        assertEquals(81, matrix3x3.get(1, 1));
        assertEquals(96, matrix3x3.get(1, 2));
        assertEquals(102, matrix3x3.get(2, 0));
        assertEquals(126, matrix3x3.get(2, 1));
        assertEquals(150, matrix3x3.get(2, 2));
    }

    //******************************************transpose*******************************

    @Test
    void transpose_switchesRowsAndColumns() {
        matrix3x3.transpose();

        assertEquals(1, matrix3x3.get(0, 0));
        assertEquals(4, matrix3x3.get(0, 1));
        assertEquals(7, matrix3x3.get(0, 2));
        assertEquals(2, matrix3x3.get(1, 0));
        assertEquals(5, matrix3x3.get(1, 1));
        assertEquals(8, matrix3x3.get(1, 2));
        assertEquals(3, matrix3x3.get(2, 0));
        assertEquals(6, matrix3x3.get(2, 1));
        assertEquals(9, matrix3x3.get(2, 2));
    }

    @Test
    void transpose_symmetricMatrix_noChange() {
        Matrix symmetric = new Matrix(3);
        symmetric.set(0, 0, 1); symmetric.set(0, 1, 2); symmetric.set(0, 2, 3);
        symmetric.set(1, 0, 2); symmetric.set(1, 1, 4); symmetric.set(1, 2, 5);
        symmetric.set(2, 0, 3); symmetric.set(2, 1, 5); symmetric.set(2, 2, 6);

        symmetric.transpose();

        assertEquals(1, symmetric.get(0, 0));
        assertEquals(2, symmetric.get(0, 1));
        assertEquals(3, symmetric.get(0, 2));
        assertEquals(2, symmetric.get(1, 0));
        assertEquals(4, symmetric.get(1, 1));
        assertEquals(5, symmetric.get(1, 2));
        assertEquals(3, symmetric.get(2, 0));
        assertEquals(5, symmetric.get(2, 1));
        assertEquals(6, symmetric.get(2, 2));
    }

    @Test
    void transpose_twice_returnsOriginal() {
        int[][] original = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                original[i][j] = matrix3x3.get(i, j);
            }
        }

        matrix3x3.transpose();
        matrix3x3.transpose();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(original[i][j], matrix3x3.get(i, j));
            }
        }
    }

    @Test
    void transpose_1x1Matrix_noChange() {
        Matrix m = new Matrix(1);
        m.set(0, 0, 42);
        m.transpose();
        assertEquals(42, m.get(0, 0));
    }
    //************************************************************tostring**********************************
    @Test
    void toString_returnsCorrectFormat() {
        Matrix m = new Matrix(2);
        m.set(0, 0, 1); m.set(0, 1, 2);
        m.set(1, 0, 3); m.set(1, 1, 4);

        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, m.toString());
    }

    @Test
    void toString_emptyMatrix_returnsEmptyBrackets() {
        Matrix m = new Matrix(1);
        assertEquals("[0]\n", m.toString());
    }
}