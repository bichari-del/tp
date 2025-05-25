package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JeuTest {

    /**
     * Test 1 : Vérifie que si le jeu est fermé, une exception est levée quand on tente de jouer.
     *
     */
    @Test
    public void testJeuFermeDeclencheException() {
        Banque banque = mock(Banque.class);
        Jeu jeu = new Jeu(banque);
        jeu.fermer(); // fermeture du jeu

        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        // Attente d'une exception JeuFermeException
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));
    }

    /**
     * Test 2 : Vérifie que si le joueur est insolvable (débit impossible), il ne lance pas les dés.
     *
     */
    @Test
    public void testJoueurInsolvableNeLancePasLesDes() throws JeuFermeException, DebitImpossibleException {
        Banque banque = mock(Banque.class);
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        Jeu jeu = new Jeu(banque);

        when(joueur.mise()).thenReturn(100);
        // Simuler une exception lors du débit
        doThrow(new DebitImpossibleException("pas d'argent")).when(joueur).debiter(100);

        jeu.jouer(joueur, de1, de2);

        // Vérifie que les dés n'ont pas été lancés
        verify(de1, never()).lancer();
        verify(de2, never()).lancer();
    }

    /**
     * Test 3 : Vérifie le cas où le joueur perd (somme ≠ 7). La banque crédite la mise.
     *
     */
    @Test
    public void testJoueurPerd() throws Exception {
        Banque banque = mock(Banque.class);
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        Jeu jeu = new Jeu(banque);

        when(joueur.mise()).thenReturn(100);
        doNothing().when(joueur).debiter(100);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(3); // 2 + 3 = 5 ≠ 7

        jeu.jouer(joueur, de1, de2);

        // La banque reçoit la mise
        verify(banque).crediter(100);
        // La banque ne paie pas
        verify(banque, never()).debiter(anyInt());
        // Le joueur ne reçoit rien
        verify(joueur, never()).crediter(anyInt());
    }

    /**
     * Test 4 : Le joueur gagne (somme = 7) et la banque est solvable. Le joueur est crédité.
     *
     */
    @Test
    public void testJoueurGagneEtBanqueResteSolvable() throws Exception {
        Banque banque = mock(Banque.class);
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        Jeu jeu = new Jeu(banque);

        when(joueur.mise()).thenReturn(100);
        doNothing().when(joueur).debiter(100);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // 3 + 4 = 7
        when(banque.est_solvable()).thenReturn(true);

        jeu.jouer(joueur, de1, de2);

        // Le joueur reçoit le double de sa mise
        verify(joueur).crediter(200);
        // La banque paie le joueur
        verify(banque).debiter(200);
        // Le jeu reste ouvert
        assertTrue(jeu.estOuvert());
    }

    /**
     * Test 5 : Le joueur gagne mais la banque devient insolvable après le paiement.
     *
     */
    @Test
    public void testJoueurGagneEtBanqueDevientInsolvable() throws Exception {
        Banque banque = mock(Banque.class);
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        Jeu jeu = new Jeu(banque);

        when(joueur.mise()).thenReturn(100);
        doNothing().when(joueur).debiter(100);
        when(de1.lancer()).thenReturn(5);
        when(de2.lancer()).thenReturn(2); // 5 + 2 = 7
        when(banque.est_solvable()).thenReturn(false);

        jeu.jouer(joueur, de1, de2);

        // Le jeu est fermé car la banque n'est plus solvable
        assertFalse(jeu.estOuvert());
    }

    /**
     * Test 6 & 7 : Test avec une vraie implémentation de BanqueImpl.
     * Vérifie si les fonds de la banque sont bien mis à jour (bonus).
     *
     */
    @Test
    public void testAvecBanqueImplReelle() throws Exception {
        BanqueImpl banque = new BanqueImpl(200, 50); // fond initial : 200
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        Jeu jeu = new Jeu(banque);

        when(joueur.mise()).thenReturn(100);
        doNothing().when(joueur).debiter(100);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // 3 + 4 = 7 → gain

        jeu.jouer(joueur, de1, de2);

        // La banque débite 200 après avoir reçu 100 → solde final : 100
        assertEquals(100, banque.getFond());
    }
}
