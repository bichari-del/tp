## TP1 - Tests Unitaires JUnit5

###  Bugs trouvés

**Exo1 - Classe `Palindrome`**
- Bug dans la boucle `while`: les indices `i` et `j` sont mal mis à jour (`i--` au lieu de `i++` et `j++` au lieu de `j--`).
- Problème corrigé dans `Exo1Correction.java`.

### Tests similaires
- Les tests  pour la couverture de branches et de conditions sont similaires dans cet exercice.




## Exercice 2 - Anagram

###  Bug trouvé
Une erreur a été trouvée dans la méthode `isAnagram` :

for (int i = 0; i <= s1.length(); i++) 


## Exercice 3 - BinarySearch

###  Bug trouvé



Il ignore la comparaison finale entre low et high quand ils sont égaux. Il faut utiliser while (low <= high).

De plus, la condition array[mid] <= element est fausse, car si array[mid] == element, on doit déjà avoir retourné mid

## Exercice 4 - QuadraticEquation


### Cas testés :

-  `a = 0` → lève une `IllegalArgumentException`
-  `delta < 0` → renvoie `null` (pas de solution réelle)
-  `delta == 0` → une racine réelle
- `delta > 0` → deux racines réelles

## Exercice 5 - RomanNumeral

La boucle for contient une erreur :
for (int i = 0; i <= symbols.length; i++) {
devrait être :

for (int i = 0; i < symbols.length; i++) {

### Cas testés :

-  Vérification des bornes (1, 3999)
-  Cas avec soustraction (IV, IX, XL, etc.)
- Répétition autorisée (III, XXX)
- Erreurs si n < 1 ou n > 3999


