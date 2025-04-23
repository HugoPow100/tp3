**Nom :** Hugo  VARAO GOMES DA SILVA
          Lucas LAFOSSE

**Groupe :** 12

**Année :** 2025

**IUT Le Havre - Cours GIT**

### Compte-rendu TP3 aprendre à travailler en équipe sur un depôt github distant

# TP 3 : Travailler en équipe sur un depôt github distant

Travail en équipe :

**Athos** => Hugo

**Porthos** => Lucas

# Objectifs du TP 3
Le but de ce troisième TP est de commencer à travailler en équipe sur github et développer un marché pour le projet de crypto-monnaie que nous avions déjà lancé. Dans ce TP, nous allons apprendre à :

* 1. Inviter des collaborateurs dans un dépôt personnel
* 2. Développement d’un projet java en équipe
* 3. Gérer des nouvelles fonctionnalités à l’aide des branches

# Partie 1. Inviter des collaborateurs dans un dépôt personnel


## 1 Création du dépôt `tp3-coop` par HugoPow100 (Athos)

- HugoPow100 crée un nouveau dépôt nommé `tp3-coop` sur son compte GitHub.
- Il accède aux **Settings** du dépôt → **Manage access** → **Invite a collaborator**.
- Il invite Apscawolf (Porthos) comme collaborateur.

## 2 Acceptation de l'invitation par Apscawolf (Porthos)

- Apscawolf reçoit l'invitation par mail ou dans l'interface GitHub et l'accepte.

## 3 Clonage du dépôt par les deux utilisateurs

Depuis le répertoire `~/courseGIT`, chacun clone le dépôt :

```bash
git clone git@github.com:HugoPow100/tp3-coop.git
```

Structure du dossier obtenue :

```bash
ls
tp1 tp2 tp3-coop
```

## Exercices

### Porthos (Apscawolf)

1. Se placer dans le répertoire `tp3` :

   ```bash
   cd ~/courseGIT/tp3
   ```

2. Copier les fichiers suivants depuis `tp2` :

   ```bash
   cp ../tp2/README.md .
   cp -r ../tp2/src .
   ```

   > Ne pas copier le dossier `.git`

3. Ajouter, valider et pousser les changements :

   ```bash
   git status
   git add .
   git commit -m "Ajout des fichiers depuis tp2"
   git push
   ```

4. Informer HugoPow100 (Athos) que la mise à jour est faite.

### Athos (HugoPow100)

1. Se placer dans le répertoire `tp3` local :

   ```bash
   cd ~/courseGIT/tp3
   ```

2. Récupérer les changements faits par Porthos :

   ```bash
   git pull
   ```

### Vérification finale

- Les deux utilisateurs doivent vérifier que :
  - Le contenu de leur répertoire `tp3` local est identique à celui du dépôt distant sur GitHub.
  - Le dépôt GitHub contient bien les fichiers `README.md` et `src/Cryptomonnaie.java`.


# Partie 2 : Développement d’un projet Java en équipe


## Préparation commune

- Vérification de la synchronisation complète du dépôt `tp3` entre HugoPow100 (Athos) et Apscawolf (Porthos).



## Athos (HugoPow100)

1. Copie dans `tp3/src` des fichiers suivants :
   - `CryptoMarche.java`
   - `Portefeuille.java`
   - `TestCryptoMarche.java`

2. Ajout, validation et push des fichiers :

   ```bash
   git add src/
   git commit -m "Ajout des classes de base pour le projet marché crypto"
   git push
   ```

## Porthos (Apscawolf)

1. Récupération des dernières modifications :

   ```bash
   git pull
   ```

2. Compilation du projet :

   ```bash
   javac src/*.java
   ```

3. Exécution du test :

   ```bash
   java -cp src TestCryptoMarche
   ```

   **Résultat avant implémentation :**

   ```
   Test Portefeuille transfertDevise        ... FAIL
   Test Portefeuille achatDevise            ... FAIL
   Test CryptoMarche capitalEnEuros         ... FAIL
   Test CryptoMarche capitalMonneaie        ... FAIL
   ```



## Apscawolf (Porthos)

Implémentation dans **`Portefeuille.java`** :

- **Méthode** : `transfertDevise(Portefeuille destination, double montantJetons)`
  - Vérifie la compatibilité des devises
  - Vérifie le solde suffisant
  - Transfère les jetons
- **Méthode** : `achatDevise(double montantEuros)`
  - Vérifie le montant positif
  - Convertit les euros en jetons et les ajoute

## HugoPow100 (Athos)

Implémentation dans **`CryptoMarche.java`** :

- **Méthode** : `capitalEnEuros(String proprietaire)`
  - Parcourt tous les portefeuilles du propriétaire
  - Calcule le capital en euros
- **Méthode** : `capitalMonneaie(Cryptomonnaie monnaie)`
  - Parcourt les portefeuilles contenant la monnaie cible
  - Additionne le total converti en euros

## Finalisation

- Chacun valide et pousse ses modifications :

   ```bash
   git add src/
   git commit -m "Implémentation des méthodes dans Portefeuille/CryptoMarche"
   git push
   ```

- Synchronisation croisée (`git pull`) pour chacun.

- Compilation et test final :

   ```bash
   javac src/*.java
   java /src/TestCryptoMarche
   ```

   **Résultat après implémentation :**

   ```
   Test Portefeuille transfertDevise        ... OK
   Test Portefeuille achatDevise            ... OK
   Test CryptoMarche capitalEnEuros         ... OK
   Test CryptoMarche capitalMonneaie        ... OK
   ```
# Partie 3. Gérer des nouvelles fonctionnalités à l’aide des branches

## 3.1 Tester le concept de branche avec un exemple simple

- **Objectif** : Tester l’ajout d’une nouvelle fonctionnalité dans une branche séparée pour éviter d’impacter la branche principale.
- **Étapes réalisées** :
  1. **Vérification des branches existantes** avec `git branch` (uniquement `main` présente au départ).
  2. **Création d’une nouvelle branche `test`** avec `git checkout -b test`.
  3. **Ajout d’un nouveau fichier `test.txt`** dans cette branche.
  4. **Commit du fichier** dans la branche `test`.
  5. **Retour dans la branche `main`** avec `git checkout main`.
  6. **Observation :** Le fichier `test.txt` n'existe pas dans la branche principale → Git isole bien les changements par branche.
  7. **Modification du fichier `README.md`** dans `main` pour simuler un développement parallèle.
  8. **Visualisation de l’historique git avec une fourche (`git log --graph --oneline --all`)** montrant la divergence entre `main` et `test`.

## 3.2 Fusionner la branche de test dans la branche principale

- **Objectif** : Fusionner les changements réalisés dans la branche `test` vers la branche principale.
- **Étapes réalisées** :
  1. **Passage à la branche `main`**.
  2. **Fusion de la branche `test` dans `main`** avec `git merge test`.
  3. **Vérification** : Le fichier `test.txt` est maintenant visible dans la branche `main`, confirmant la fusion.
  4. **Visualisation de l’arbre git** montrant le commit de fusion.

## Nettoyage et création des branches personnalisées

- **Suppression du fichier `test.txt`** avec :
  ```bash
  git rm test.txt
  git commit -m "test.txt supprimé"
  ```

- **Création des branches individuelles** :
  - **Athos** :
    - Branche `AthosCoin`
    - Ajout d’une classe `AthosCoin` :
      ```java
      public class AthosCoin extends Cryptomonnaie {
         public AthosCoin() {
            super("ATH", 1000);
         }
      }
      ```
    - Fusion dans la branche `main`.
  - **Porthos** :
    - Branche `PorthosCoin`
    - Ajout d’une classe `PorthosCoin` :
      ```java
      public class PorthosCoin extends Cryptomonnaie {
         public PorthosCoin() {
            super("POR", 1000);
         }
      }
      ```
    - Fusion dans la branche `main`.

- **Synchronisation finale** :
  - Push des modifications fusionnées vers le dépôt GitHub (`git push`).

**Fin du TP3**