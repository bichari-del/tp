package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // Appel de la méthode
        int result = calculatrice.additionner(2, 3);

        // Vérification du résultat
        assert(result == 5);

        // Vérification que la méthode a été appelée avec LES ENTIER  2 et 3
        verify(calculatrice).additionner(2, 3);

        // Vérifie qu’aucune autre méthode n’a été appelée
        verifyNoMoreInteractions(calculatrice);

        // TO DO 5  Vérification de l’état de l’objet non applicable ici car l’objet est mocké
        // et donc ne contient pas d’état réel (le champ `result` n’existe pas dans un mock)
    }

}
