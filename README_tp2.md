**Nom :** Lucas Lafosse

**Groupe :** 12

**Année :** 2025

**IUT Le Havre - Cours GIT**

### Compte-rendu TP2 Travailler en autonomie sur un depôt github distant

### Partie 1 — Créer son compte

Ayant déjà un compte github, je me connecte juste a celui existant.

### Partie 2 — Ajouter une nouvelle clé SSH à votre compte GitHub

N'ayant pas le fichier en .pub dans mon dossier ```.ssh````
Je fais dans ma console git bash : 

```bash
ssh-keygen
```

Puis me rend dans le fichier et copie la clé ssh.

Je suis ensuite la manipulation demandé et j'ai pu ajouté ma clé ssh.

### Partie 3 — Pousser un dépôt existant depuis la ligne de commande

#### 1. Aller dans le répertoire local

```bash
cd ~/courseGIT/tp1
pwd
```

La commande `pwd` affiche bien : `/.../courseGIT/tp1`

#### 2. Créer un dépôt distant vide sur GitHub

- Aller sur GitHub
- Cliquer sur **New repository**
- Renseigner `tp1` comme nom du dépôt
- Laisser les autres champs vides
- Créer le dépôt (public ou privé selon préférence)

L’URL affichée est :  
`https://github.com/Apscawolf/tp1.git`

#### 3. Vérifier l’absence de dépôt distant localement

```bash
git remote -v
```

Aucune sortie → aucun dépôt distant n’est encore lié.

#### 4. Lier le dépôt local au dépôt distant

```bash
git remote add origin git@github.com:Apscawolf/tp1.git
```

#### 5. Vérifier le nom de la branche

```bash
git branch
```

Sortie attendue : `* master`

#### 6. Pousser vers GitHub

```bash
git push -u origin master
```

sortie :

```
Enumerating objects: 23, done.
Counting objects: 100% (23/23), done.
Delta compression using up to 16 threads
Compressing objects: 100% (19/19), done.
Writing objects: 100% (23/23), 4.80 KiB | 1.20 MiB/s, done.
Total 23 (delta 4), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (4/4), done.
To github.com:Apscawolf/tp1.git
 * [new branch]      master -> master
branch 'master' set up to track 'origin/master'.
```

#### 7. Vérifier sur GitHub

Aller à l’adresse :  
`https://github.com/Apscawolf/tp1`  
Les fichiers doivent maintenant apparaître dans le dépôt distant.

### Partie 4 — Séquence de travail avec un dépôt distant

#### Exercice — Mise à jour de `Cryptomonnaie.java` et synchronisation avec GitHub

##### 1. Récupérer les dernières modifications du dépôt distant

```bash
git pull
git log
```

> Vérifier que le dépôt local est à jour et consulter l’historique des commits.

##### 2. Modifier le fichier `Cryptomonnaie.java`

Je copie colle dans le fichier existant le code donné

##### 3. Préparer et pousser les modifications

```bash
git status
git add Cryptomonnaie.java
git commit -m "Ajout de getters et setters"
git push
```

Vérifier que le fichier a bien été modifié, ajouté, commité, puis poussé.

##### 4. Vérifier sur GitHub

Se rendre sur :  
`https://github.com/Apscawolf/tp1`  
S’assurer que les modifications sont bien visibles dans le fichier `Cryptomonnaie.java`.

Et j'ai pu bien voir que les modification sont bien présente

### Partie 5 — Cloner un dépôt distant sur notre machine locale

#### 1. Créer un nouveau dépôt `tp2` sur GitHub

- Nom du dépôt : `tp2`
- COcher privée, add README, et add .gitignore
- Une fois créé, cliquer sur **Code** pour obtenir le lien SSH du dépôt :
  ```bash
  git@github.com:<votre_utilisateur>/tp2.git
  ```

#### 2. Cloner le dépôt distant

Se placer dans le répertoire `courseGIT` :

```bash
cd ~/courseGIT
ls
# Affiche : tp1
```

Cloner le dépôt :

```bash
git clone git@github.com:<votre_utilisateur>/tp2.git
```

Vérifier que le dossier `tp2` a bien été créé :

```bash
ls
# Affiche : tp1 tp2
```

> Le dépôt local `tp2` est déjà lié et synchronisé avec GitHub. Pas besoin de configurer `git remote` ni de faire un `git push -u`.

#### Exercices

##### Copier les fichiers de `tp1` vers `tp2`

Se placer dans `courseGIT` puis :

```bash
cp -r tp1/README.md tp2/
cp -r tp1/src tp2/
```

> ⚠️ Ne surtout pas copier le dossier `.git` de `tp1` vers `tp2`.

##### Synchroniser le dépôt

```bash
cd tp2
git status
git add .
git commit -m "Ajout des fichiers depuis tp1"
git push
```

On vérifie sur le repo github et on voit que tout es bien importé.

Fin du TP2