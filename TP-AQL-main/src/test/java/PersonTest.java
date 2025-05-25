import org.example.Calculator;
import org.example.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



public class PersonTest {

    // Tests pour getFullName()

    @Test
    void testGetFullName_ValidName() {
        Person person = new Person("guelila", "amine", 25);
        assertEquals("guelila amine", person.getFullName(), "Le nom complet doit être 'guelila amine'");
    }

    @Test
    void testGetFullName_EmptyName() {
        Person person = new Person("", "", 30);
        assertEquals(" ", person.getFullName(), "Le nom complet doit être ' ' si les deux champs sont vides");
    }

    @Test
    void testGetFullName_OneEmptyName() {
        Person person = new Person("farouk", "", 40);
        assertEquals("farouk ", person.getFullName(), "Le nom complet doit être 'Alice '");
    }

    // Tests pour isAdult()

    @Test
    void testIsAdult_Exactly18() {
        Person person = new Person("hamouda", "idir", 18);
        assertTrue(person.isAdult(), "Une personne de 18 ans doit être considérée comme adulte");
    }

    @Test
    void testIsAdult_Above18() {
        Person person = new Person("akram", "walid", 20);
        assertTrue(person.isAdult(), "Une personne de 20 ans doit être considérée comme adulte");
    }

    @Test
    void testIsAdult_Below18() {
        Person person = new Person("moukhtar", "anwer", 17);
        assertFalse(person.isAdult(), "Une personne de 17 ans ne doit pas être considérée comme adulte");
    }

    @Test
    void testIsAdult_ZeroAge() {
        Person person = new Person("moukhtar", "anwer", 0);
        assertFalse(person.isAdult(), "Une personne de 0 an ne doit pas être considérée comme adulte");
    }

    @Test
    void testIsAdult_NegativeAge() {
        Person person = new Person("amine", "mohamed", -5);
        assertFalse(person.isAdult(), "Une personne avec un âge négatif ne doit pas être considérée comme adulte");
    }
}


