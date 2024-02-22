# Partie IV (Gestion Etudiant)

On souhaite développer une application de gestion des étudiants, pour ce faire on va suivre les étapes suivantes :

## Étape 1 : Développement de la couche métier Dans cette étape on demande de créer

* La classe Etudiant caractérisée par : id, nom, prénom, sexe et filière. Dans cette classe :
  * Respecter le principe d'encapsulation,
  * Mettre deux constructeurs l'un en précisant l'id et l'autre sans le préciser. Dans ce 2ème cas l’id doit être auto-incrément.
* L’interface IGestionEtudiants avec les méthodes suivantes :

  ```java

        Etudiant ajouterEtudiant(Etudiant e);
        List<Etudiant> rechercherParMC(String mc);
        void trierListeEtudiantsParNom();
        List<Etudiant> listeDesEtudiants();

  ```

* La classe GestionEtudiants qui implémente l'interface IGestionEtudiants et redéfinir toutes les méthodes de l'interface.

## Étape 2 : Développement de la couche DAO

1. Créer la base de données MYSQL

    ```sh
        cd src/main/java/com/java_gui/dao && ./db.sh
    ```

2. Créer les classes persistantes Produit et Categorie
3. Créer l’interface IDaoCatalogue déclarant les méthodes à implémenter
4. Créer une classe SingletonConnection contenant une méthode statique geConnection() qui permet de retourner une connexion unique vers la base de données.

## Étape 3 : Développement de la couche présentation

* Dans cette étape on demande de créer une interface utilisateur avec la bibliothèque Swing. Cette interface permet de gérer les étudiants(voir figure ci-dessous) :

    ![java_gui1](../../images/partie4.png)
