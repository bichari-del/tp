package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getFullNameShouldReturnCorrectFormat() {
        Person person = new Person("John", "Doe", 25);
        assertEquals("John Doe", person.getFullName());
    }

    @Test
    void isAdultShouldReturnTrueForAdults() {
        Person adult = new Person("Alice", "Smith", 20);
        assertTrue(adult.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseForMinors() {
        Person minor = new Person("Bob", "Brown", 17);
        assertFalse(minor.isAdult());
    }

    @Test
    void isAdultShouldReturnTrueForExactly18() {
        Person person = new Person("Charlie", "Johnson", 18);
        assertTrue(person.isAdult());
    }
}