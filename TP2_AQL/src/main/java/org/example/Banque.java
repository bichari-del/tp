package org.example;

public interface Banque {
    void crediter(int somme);  // reçoit les mises
    void debiter(int somme);   // paie les gains
    boolean est_solvable();
}
