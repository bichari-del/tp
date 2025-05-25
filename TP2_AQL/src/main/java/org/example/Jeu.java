package org.example;

public class Jeu {
    private Banque banque;
    private boolean ouvert;

    public Jeu(Banque labanque) {
        this.banque = labanque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        int mise = joueur.mise();

        try {
            joueur.debiter(mise); // débiter le joueur
        } catch (DebitImpossibleException e) {
            return; // joueur insolvable => on arrête sans jouer
        }

        banque.crediter(mise); // la banque encaisse la mise

        int sommeDes = de1.lancer() + de2.lancer();
        if (sommeDes == 7) {
            int gain = mise * 2;
            banque.debiter(gain);
            joueur.crediter(gain);
        }

        if (!banque.est_solvable()) {
            this.fermer();
        }
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}
