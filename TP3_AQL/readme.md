#  TP3 - Tests Unitaires - Partie 1

## Exercice 1 – Interaction Simple entre Modules

### Tâches réalisées
1) Création de l'interface UserRepository

       Méthode : User findUserById(long id)

Sert à abstraire la source des données (ex. base de données, mémoire, etc.)

2) Création de la classe UserService

Dépend de UserRepository (injection dans le constructeur)

    Méthode : getUserById(long id) → récupère l’utilisateur à partir du repository

3) Création de la classe User

   Représente un utilisateur avec id et name

    Implémentation de equals() et hashCode() pour permettre les assertions dans les tests

4. Écriture d’un test JUnit (avec Mockito)

    Le repository est mocké
### Le test vérifie :
Que getUserById retourne bien l’utilisateur attendu
Que la méthode findUserById(long id) du mock est appelée avec le bon argument




## Exercice 2 : Interaction avec une base de données simulée

### Implémentation
1. orderController appelle OrderService.createOrder(order).

2. OrderService utilise OrderDao.saveOrder(order) pour enregistrer la commande.

3. OrderDao est une interface représentant la couche d'accès aux données.

## Test
Testé avec JUnit 5 et Mockito.

OrderDao est mocké.

### Le test vérifie que :

1. OrderService.createOrder est bien appelé par le contrôleur.

2. OrderDao.saveOrder est bien invoqué avec l’objet Order.

### Remarques
1. Le test utilise un spy pour intercepter les appels du service.

2. La classe Order doit correctement implémenter equals() pour valider les arguments.


## Exercice 3 : Intégration d’API avec Mocking

### Implémentation
1. ProductService.getProduct(String productId) appelle ProductApiClient.getProduct(productId).

2. ProductApiClient est une interface représentant l’appel à une API tierce.

### Test
Utilisation de Mockito pour simuler ProductApiClient.
#### Trois scénarios testés :

1. Réponse valide.

2. Format de données invalide (exception personnalisée).

3. Échec de l’appel API (simulé par exception).

### Remarques:
Les exceptions sont simulées via when(...).thenThrow(...).

Le test vérifie que getProduct est appelé avec l’ID correct.