import org.example.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    // Tests pour push()
    private Stack stack;  // Déclaration au niveau de la classe

    @BeforeEach
    void setUp() {
        stack = new Stack();  // Initialisation avant chaque test
    }

    @Test
    void testPush_OneElement() {

        stack.push(5);
        assertEquals(1, stack.size(), "La pile doit contenir 1 élément après un ajout.");
        assertEquals(5, stack.peek(), "L'élément au sommet doit être 5.");
    }

    @Test
    void testPush_ExpandArray() {

        for (int i = 0; i < 15; i++) { // Dépasse la capacité initiale (10)
            stack.push(i);
        }
        assertEquals(15, stack.size(), "La pile doit contenir 15 éléments après expansion.");
        assertEquals(14, stack.peek(), "L'élément au sommet doit être 14.");
    }

    // Tests pour pop()

    @Test
    void testPop_ValidCase() {

        stack.push(10);
        assertEquals(10, stack.pop(), "La méthode pop doit retourner l'élément retiré (10).");
        assertTrue(stack.isEmpty(), "La pile doit être vide après avoir retiré le seul élément.");
    }

    @Test
    void testPop_EmptyStack_ThrowsException() {
        assertThrows(IllegalStateException.class, stack::pop, "La méthode pop doit lever une exception si la pile est vide.");
    }

    // Tests pour peek()

    @Test
    void testPeek_ValidCase() {
        stack.push(42);
        assertEquals(42, stack.peek(), "La méthode peek doit retourner 42.");
        assertFalse(stack.isEmpty(), "La pile ne doit pas être vide après un appel à peek().");
    }

    @Test
    void testPeek_EmptyStack_ThrowsException() {
        assertThrows(IllegalStateException.class, stack::peek, "La méthode peek doit lever une exception si la pile est vide.");
    }

    // Tests pour isEmpty()

    @Test
    void testIsEmpty_EmptyStack() {
        assertTrue(stack.isEmpty(), "La pile doit être considérée comme vide.");
    }

    @Test
    void testIsEmpty_NonEmptyStack() {
        stack.push(1);
        assertFalse(stack.isEmpty(), "La pile ne doit pas être vide après avoir ajouté un élément.");
    }

    // Tests pour size()

    @Test
    void testSize_EmptyStack() {
        assertEquals(0, stack.size(), "La taille d'une pile vide doit être 0.");
    }

    @Test
    void testSize_AfterMultipleOperations() {
        stack.push(15);
        stack.push(24);
        stack.push(75);
        assertEquals(3, stack.size(), "La pile doit contenir 3 éléments.");
        stack.pop();
        assertEquals(2, stack.size(), "La pile doit contenir 2 éléments après un pop.");
    }
}
