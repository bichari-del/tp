# TP2 - Tests Unitaires avec Mockito
## Exercice 1 : Initiation
Remarque sur le  to  do TODO : Vérification de l'état de l'objet
**Vérification de l’état de l’objet non applicable ici car l’objet est mocké**
et donc ne contient pas d’état réel (le champ `result` n’existe pas dans un mock)

## Exercice 2 : Mocker un service externe (API)

### Remarques:
- Utilisation de MockitoJUnitRunner pour activer l'injection automatique des mocks.
- Le mock utilisateurApiMock est injecté dans l'objet  UserService pour le test.
- On utilise verify(utilisateurApiMock).creerUtilisateur(utilisateur) pour valider que l’appel s’est bien produit.
## Exercice 3 — Mock de service externe avec scénarios variés

### Scénarios testés :
- Exception simulée lors de la création d’un utilisateur (ServiceException).

- Aucun appel API si les données de l'utilisateur sont invalides (verify(..., never())).

- Attribution d'un ID à l’utilisateur par l’API (simulation avec doAnswer()).

- Capture et vérification des arguments envoyés à l’API (ArgumentCaptor).

### Remarque :
- Utilisation de doThrow() pour simuler une exception.
- Utilisation de verify(..., never()) pour s'assurer qu'une méthode n'a pas été appelée.
- Usage avancé de doAnswer() pour modifier un objet passé en paramètre (ajout d’un ID).
- Vérification précise des valeurs transmises via ArgumentCaptor.

## Exercice 4 — Tests du jeu de dés (Jeu du 7)

### 1. Objets à mocker
Les objets à mocker pour isoler les tests de la méthode **jouer** sont :
- Banque : pour simuler la solvabilité et les transferts d'argent.
- Joueur : pour simuler les mises, débits et crédits.
- De: pour contrôler le résultat des lancers de dés.

### 2. Scénarios de test
Les cas testés sont :
- Jeu fermé  lance l'exception JeuFermeException.
- Joueur insolvable (débit échoue) donc  on ne lance pas les dés.
- Joueur perd (somme des dés ≠ 7) donc la banque garde la mise.
- Joueur gagne (somme = 7) et la banque reste solvable donc joueur gagne 2×mise.
- Joueur gagne et la banque devient insolvable donc jeu fermé automatiquement.
- Test d’intégration avec une vraie classe BanqueImpl.

### 3. Code Java
Voir la classe Jeu.java.

### 4. Jeu fermé : test d’état ou d’interaction ?
C’est un **test d’état**, car on vérifie que l’appel lève une exception en fonction de l'état interne (`ouvert = false`).

### 5. Joueur insolvable : test d’interaction
C’est un **test d’interaction**, car on vérifie que **aucun appel** n’est fait aux dés (verify(..., never())).

### 6. Autres scénarios
On teste les cas de gain, de perte, et l’évolution de l’état de la banque (solvable ou pas).

### 7. Implémentation réelle de Banque
BanqueImpl est une classe concrète avec un fond et un fond minimal. Le test **testAvecBanqueImplReelle** valide une situation réelle, contrairement aux tests mockés. Cela permet de valider la logique de solvabilité avec des **valeurs concrètes**.

---

