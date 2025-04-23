**Nom :** Lucas Lafosse

**Groupe :** 12

**Année :** 2025

**IUT Le Havre - Cours GIT**

### Compte-rendu TP1 Introduction GIT

Dans ce TP on apprend à travailler avec git.

### Partie 1

#### 1. Configuration de Git

- Vérification config :  
  `git config --list`  

- Définir identité :  
  `git config --global user.name "Jean Dupont"`  
  `git config --global user.email jeandupont@example.com`  

- Définir éditeur :  
  `git config --global core.editor nano`  

#### 2. Création d’un dépôt local

- Créer structure :  
  `mkdir -p courseGIT/tp1`  
  *(Windows : `mkdir courseGIT\tp1`)*

- Se déplacer :  
  `cd courseGIT/tp1`  

- Initialiser Git :  
  `git init`

- Vérifier statut :  
  `git status`

#### 3. Création et suivi d’un fichier README.md

- Créer fichier `README.md` avec les infos de base  
- Voir état du fichier :  
  `git status`

- Ajouter le fichier :  
  `git add README.md`

- Valider ajout :  
  `git commit -m "Ajoute du fichier README.md"`

- Historique des commits :  
  `git log`

#### 4. Résumé des étapes Git (workflow de base)

1. Modifier/créer un fichier
2. `git status` → voir les changements
3. `git add <fichier>` → ajouter à la zone de staging
4. `git commit -m "message"` → valider dans le dépôt

#### 5. Les 3 états d’un fichier Git

- Modifié : fichier changé localement
- Stagé : prêt à être validé
- Validé : enregistré dans le dépôt

#### 6. Les 3 zones Git

- Répertoire de travail (working directory)
- Zone de staging (staging area)
- Dépôt Git (repository)

#### 7. Les 3 actions principales

- `git add` → staging  
- `git commit` → validation  
- `git checkout` → récupération d’une version antérieure


### Exercice Partie 3 : Faire un commit et vérifier qu’il fonctionne

#### 1. Se placer dans le répertoire du projet

```bash
pwd
```
> Vérifie que l’on est bien dans le dossier `courseGIT/tp1`.  
> Sous Windows : `cd`

#### 2. Vérifier l’état du dépôt Git

```bash
git status
```
> Affiche les fichiers modifiés, non suivis ou déjà prêts à être commités.  
> Permet de savoir ce qu’il faut ajouter au prochain commit.

#### 3. Ajouter un fichier modifié à la zone de staging

```bash
git add README.md
```
> Ajoute le fichier `README.md` à la zone de staging.  
> Alternative : `git add .` pour ajouter tous les fichiers modifiés.

#### 4. Vérifier que le fichier a bien été ajouté

```bash
git status
```
> Le fichier apparaît en vert = il est prêt à être commité.

#### 5. Créer un commit avec un message

```bash
git commit -m "Ajout du compte-rendu du TP1 dans README.md"
```
> Enregistre l’état actuel du fichier dans l’historique Git, avec un message explicatif.

#### 6. Vérifier que le commit a bien été réalisé

```bash
git log
```
> Affiche l’historique des commits avec auteur, date, message, et identifiant.

```bash
git log --oneline
```
> Version abrégée : chaque commit tient sur une seule ligne.

#### 7. (Optionnel) Afficher les modifications du dernier commit

```bash
git show
```
> Permet de visualiser les changements effectués dans le dernier commit.


### Exercice Partie 4 : Gestion de version d’un programme Java

#### Objectif

Gérer les versions d’un fichier Java avec Git.

Nous allons :
- Créer un répertoire `src`
- Créer un fichier `Cryptomonnaie.java`
- Ajouter du code source
- Versionner le fichier avec Git

#### 1. Créer un dossier `src` dans le dossier `tp1`

```bash
mkdir src
```
Sous Windows : `mkdir src`

#### 2. Créer le fichier Java vide ( par ligne de commande ou avec l'éditeur de texte/code)

#### 3. Vérifier l’arborescence

```bash
tree
```
Affiche la structure du dossier.  
Sous Windows : `tree /F`

réponse dans la console :

```
.
├── README.md
└── src
    └── Cryptomonnaie.java
```

#### 4. Éditer le fichier `Cryptomonnaie.java` ( on copie colle le code donné avec un éditeur de texte )


#### 5. Vérifier les fichiers modifiés

```bash
git status
```
Le fichier `Cryptomonnaie.java` doit apparaître en rouge (non suivi).

#### 6. Ajouter le fichier au staging

```bash
git add src/Cryptomonnaie.java
```

#### 7. Créer le commit

```bash
git commit -m "Première version du fichier Cryptomonnaie.java"
```

#### 8. Vérifier que le commit est bien pris en compte

```bash
git log 
```
Et on obtien un résultat resemblant a celui montré : 

```bash
C:\Users\apsca\Documents\iut\TP\s2\courseGIT\tp1>git log
commit e88e5e1635a70e3c3d901c8d9367b2390e83f39d (HEAD -> master)
Author: Lucas Lafosse <lucas2006.lafosse@gmail.com>
Date:   Wed Apr 16 01:20:11 2025 +0200

    Première version du fichier Cryptomonnaie.java
```

### Partie 4.1 : Création du fichier `.gitignore`

#### Objectif

Ignorer les fichiers générés automatiquement (comme les `.class`) pour ne pas les versionner avec Git.

#### 1. Compiler le fichier Java

Se placer dans le dossier `src` et compiler :

```bash
cd src
javac Cryptomonnaie.java
```

#### 2. Vérifier avec `git status`

```bash
git status
```

> On voit apparaître `Cryptomonnaie.class` en **untracked** (non suivi).  
> Ce fichier ne doit pas être ajouté dans le dépôt Git (il est généré automatiquement par la compilation).

#### 3. Créer un fichier `.gitignore` à la racine du projet

Se replacer à la racine (`tp1`) :

```bash
cd ..
touch .gitignore
```
> Sous Windows : `type nul > .gitignore`

#### 4. Vérifier le status après création

```bash
git status
```

> `.gitignore` est maintenant visible comme fichier non suivi.

#### 5. Éditer `.gitignore`

Ajouter dans ce fichier :

```
*.class
```

> Cela dit à Git d’ignorer tous les fichiers compilés `.class`.

#### 6. Ajouter et valider le `.gitignore`

```bash
git add .gitignore
git commit -m ".gitignore ajouté"
```

#### 7. Vérification

```bash
git status
```

> Le fichier `.class` n’apparaît plus dans la sortie, Git l’ignore désormais.

### Exercice de fin

Compléter le fichier `.gitignore` avec d'autres extensions de fichiers générés ou archivés :

```
# Compiled class file
*.class

# Package Files
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar
```

Puis :

```bash
git add .gitignore
git commit -m "Ajout des fichiers d’archives et compilés au .gitignore"
```

Puis on vérifie une dernière fois avec : 

```bash
git status
git log
```

Et enfin, pour le ce compte rendu, on fait :

```bash
git add README.md
git commit -m "Ajout du compte rendu final du TP1"
```

Fin du TP1.