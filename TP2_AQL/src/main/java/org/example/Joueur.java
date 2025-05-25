package org.example;

public interface Joueur {
    int mise(); // toujours > 0
    void debiter(int somme) throws DebitImpossibleException;
    void crediter(int somme);
}
