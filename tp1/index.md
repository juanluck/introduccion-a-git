<a id='TP1'></a>
# TP 1 : Travailler sur un répertoire local 
[Retour à la page principale](../index.md)

Pour notre premier contact avec git, nous n'aurons besoin que d'un éditeur de texte et d'une installation fonctionnelle de git sur la console. Il ne sera pas nécessaire d'avoir un dépôt distant (comme github) parce que nous ferons tout le travail sur un répertoire locale de la machine. Dans la dernière partie de ce TP, nous commencerons à gérer un petit programme Java, il est donc également pratique d'avoir une machine virtuelle Java installée. Ce travail pratique suppose que nous travaillons sous linux bien qu'il ne devrait y avoir aucun problème à le faire sur d'autres plates-formes. 
 
## Objectifs du TP 1

Le but de ce premier TP est de commencer à se familiariser avec git. Plus précisément, nous allons apprendre: 

>1. [Configuration de GIT (`git config`)](#configuration)
2. [Création d'un dépôt git sur une machine locale (`git init` et `git status`)](#gitinit)
3. [Création d'un fichier texte README.md](#readme)
   * [Gérer les différentes modifications du fichier README.md](#readmeModifications)
   * [Différencier  3 états / 3 zones / 3 actions](#readmeEtatsZonesActions)
4. [Gestion de version d'un programme Java](#programmeJava)
   * [Creation du fichier `.gitignore`](#gitignore)

---

<a id='configuration'></a>
## 1. Configuration de GIT 

Git est livré avec un outil appelé `git config` qui vous permet d'obtenir et de définir des variables de configuration qui contrôlent tous les aspects de l'apparence et du fonctionnement de git. 

Pour vérifier les paramètres de configuration actuels de git sur votre machine, ouvrez un terminal et tapez : 

```shell
$:> git config --list
```
ce qui devrait afficher des informations similaires à ce qui suit :

```shell
user.name=...
user.email=...
color.status=auto
color.branch=auto
color.interactive=auto
color.diff=auto
push.default=matching
merge.tool=...
```

### 1.1. Votre identité

La première chose à faire lorsque vous installez git est de définir votre nom d'utilisateur et votre adresse e-mail. Ceci est important car chaque commit git utilise ces informations, et elles sont immuablement intégrées dans les commits que vous commencez à créer: 

```shell
$:> git config --global user.name "John Doe"
$:> git config --global user.email johndoe@example.com
```
Vous ne devez le faire qu'une seule fois si vous passez l'option `--global`, car alors git utilisera toujours ces informations pour tout ce que vous faites sur ce système.

### 1.2. Votre editeur

Maintenant que votre identité est configurée, vous pouvez configurer l'éditeur de texte par défaut qui sera utilisé lorsque git a besoin de vous pour taper un message :

```shell
$:> git config --global core.editor XXXX
```
où **XXXX** correspond au nom de votre éditeur de texte préféré, par exemple, vim, emacs, gedit, ... 

<!--### 1.3. Votre nom de branch par défaut

Par défaut, git créera une branche appelée `master` lorsque vous créez un nouveau dépôt avec `git init` (nous allons voir les branches et la création d'un dépôt plus tard). À partir de la version 2.28 de git, vous pouvez définir un nom différent pour la branche initiale.

Pour définir `main` comme nom de branche par défaut, procédez comme suit : 

```shell
$:> git config --global init.defaultBranch main
```
-->

### Exercices
> 1. Suivez les étapes précédentes et configurez votre nom, votre adresse e-mail et votre éditeur de texte dans git. 
2. Tapez la commande `git config --list` et assurez-vous que toutes les informations fournis sont correctes.
3. Afin de vérifier que votre nom est correct, tapez  `git config user.name`
4. Faire pareil pour votre email, tapez  `git config user.email`

[Haut de la page](#TP1)

--------

<a id='gitinit'></a>
## 2. Création d'un dépôt git sur une machine locale

Une fois git correctement configuré, nous allons procéder sans plus tarder à créer notre premier répertoire dont nous allons gérer les changements à l'aide de git. La première chose que nous allons décider est la structure de répertoires que nous allons utiliser pour ce cours. 

Accédez à votre répertoire de travail (quel qu'il soit) et créez un répertoire `courseGIT` puis le répertoire `tp1`, de sorte que la structure du répertoire soit la suivante: 

```shell
$:> tree courseGIT
courseGIT/
└── tp1
```
Allez jusqu'au répertoire tp1, de sorte que la commande `pwd` affiche le résultat suivant :

```shell
$:> pwd
/.../courseGIT/tp1 
```

Tapez la commande `ls -a` et voir que le résultat est le suivant :

```shell
$:> ls -a
. ..
```

**Prêt à créer votre premier dépôt git ?** Tapez :
```shell
$:> git init
```
Vous devriez obtenir une réponse de type :

```shell
Initialized empty Git repository in /.../courseGIT/tp1/.git/
```
Ce message indique que votre répertoire `tp1` sera désormais géré par git. En particulier, le répertoire `.git` (qui est caché) contiendra la base de données avec toutes les modifications que nous apportons au répertoire `tp1`. **Attention :** nous n'accéderons jamais directement au répertoire `.git` mais via des commandes git. Pour vérifier que le répertoire existe : 

```shell
$:> ls -a
.  ..  .git
```

<a id='gitstatus'></a>
### 2.1. La commande `git status`

La commande `git status` nous permet de vérifier les modifications apportées aux fichiers dans la copie de travail `tp1` (_working directory_). Pour l'instant, on n'a rien changé dans le repositoire `tp1` et la commande `git status` devrait afficher le message suivant :

```shell
$:> git status
On branch master

Initial commit

nothing to commit (create/copy files and use "git add" to track)
```


### Exercices
> 1. Suivez les étapes précédentes et assurez-vous que le répertoire `.git` a été bien crée.
2. Tapez la commande `git status` dans le repertoire `tp1` et vérifier qu'elle affiche bien le message montre dans la [section 2.1](#gitstatus).

**Félicitations, vous venez de créer votre premier dépôt git !!**

[Haut de la page](#TP1)

--------

<a id='readme'></a>
## 3. Création d'un fichier texte README.md 

Nous allons créer maintenant un fichier texte README.md (au format [markdown](https://www.markdownguide.org/cheat-sheet)) dans le repertoire `tp1` où nous allons enregistrer un compte-rendu de ce cours. Le fichier README.md est devenu un _standard de facto_ dans git et on vous encourage a créer un pour chaque projet git que vous démarrez.

Utilisez votre éditeur de texte préféré pour cela et commencez à éditer le fichier avec ces informations :

```markdown
**Nom :** Votre nom

**Groupe :** Votre groupe

**Année :**

**IUT Le Havre - Cours GIT**

### Compte-rendu TP1 Introduction GIT

Dans ce TP on apprend à travailler avec git.
```
**Assurez-vous d'enregistrer le fichier README.md avant de continuer.**

<a id='readmeModifications'></a>
#### 3.1. Gérer les différentes modifications du fichier README.md

Dans la [section 2.1](#gitstatus), nous avons appris que la commande `git status` est utilisée pour afficher les modifications apportées aux fichiers dans la copie de travail `tp1`. Après les modifications que nous venons d'apporter au fichier README.md, la commande devrait afficher le message suivant :

```shell
$:> git status
On branch master

Initial commit

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	README.md

nothing added to commit but untracked files present (use "git add" to track)
```

Le message "Untracked files" montre que nous venons de modifier un fichier (README.md) dans notre copie de travail et que notre dépôt git ne suit pas encore ce fichier. Pour sélectionner (_stage_) le fichier README.md, tapez :

```shell
$:> git add README.md
```

La commande `git add README.md` permettra à git de garder une trace des modifications apportées à ce fichier à partir de maintenant. Pour voir le changement d'état du fichier README.md dans git, tapez: 

```shell
$:> git status
On branch master

Initial commit

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)

	new file:   README.md
```

Vous pouvez voir que le fichier vient d'être sélectioné pour être inclus dans le dépôt git et qu'il ne reste plus qu'à valider cette inclusion. Pour cela, nous utilisons la commande `git commit`. Tapez :

```shell
$:> git commit -m "Ajoute du fichier README.md"
[master (root-commit) 23782d5] Ajoute du fichier README.md
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 README.md
```

Maintenant, le fichier README.md dans la copie de travail `tp1` (_working directory_) est synchronisé avec le dépôt. **Nous venons d'enregistrer une première version du fichier !** La commande `git status` devrait nous donner la sortie suivante :

```shell
$:> git status
On branch master
nothing to commit, working directory clean
```
<a id='sequencelocal'></a>
**Important :** ce que nous venons d'apprendre est **la séquence simple pour suivre les changements d'un fichier dans git** qui comprend les étapes suivantes :

1. Modification d'un fichier existant ou création d'un nouveau fichier.
2. `git status` pour voir les fichiers à inclure dans le dépôt git.
3. `git add <fichier>` pour sélectioner le fichier (_stage_) que nous voulons suivre dans le dépôt git.
4. `git commit -m "Ajoutez ici un petit commentaire pour décrire ce commit"` pour valider/enregistrer les changements dans le dépôt git.
5. Enfin, la commande `git log` nous permet de voir toutes les différentes versions enregistrés dans notre dépôt.  Tapez `git log` pour voir le journal des différentes versions. Chaque entrée du log correspond à une version différent du fichier validée (_commit_). 

<a id='readmeEtatsZonesActions'></a>
### 3.2. Différencier  3 états / 3 zones / 3 actions

Pour mieux comprendre le fonctionnement de git, c'est interessant de distinguer la difference entre état, zone et action. Voici un petit résumé :

**Dans un dépôt GIT un fichier peut avoir 3 états différents :**

   * Modifié (modified): il a des modification locales, il va falloir le sélectionner (stage) pour ensuite valider (commit) ses modifications.
   * Sélectionné (staged): ses modification ont été sélectionnées (staged) pour être validées (commited).
   * Validé (commited): il est synchrone avec le dépôt et ne requière pas de validation.

**Ces états correspondent à 3 zones dans un GIT :**

   * La copie de travail (directory), c’est le système de fichier local, zone où les fichiers sont modifiés.
   * La zone de sélection (staging area).
   * Le dépôt où les modifications sont enregistrées sous forme de validations (commits).

**Le passage entre ses 3 états se fait par 3 actions:**

   * Sélection (stage) qui sélectionne les fichier pour la validation(commande : `git add`).
   * Validation (commit) qui crée le commit et l’envoie dans le dépôt (commande: `git commit`).
   * Récupération (checkout) qui récupère un instantané (snapshot) depuis le dépôt vers la copie de travail (commande : `git checkout`). Nous verrons cette commande plus tard.


### Exercice
> 1. Pour nous assurer que nous avons appris la séquence de fonctionnement simple de git, nous allons mettre à jour le fichier README.md avec un compte-rendu de ce cours jusqu'à présent. Assurez-vous que les modifications sont sélectionnées et valides dans le dépôt git. 

[Haut de la page](#TP1)

--------
   
<a id='programmeJava'></a>
## 4. Gestion de version d'un programme Java 

Bien que git permette la gestion des versions de tout type de fichier (par exemple, c'est le cas du fichier texte README.md), la plupart du temps nous allons l'utiliser pour gérer les versions d'un programme. Dans cet exercice pratique, nous allons créer un petit projet Java sur le monde fascinant des crypto-monnaies.

Pour commencer à développer notre projet, dans le répertoire `tp1` nous allons créer un répertoire `src` qui contiendra les sources dudit projet dans lequel nous allons créer un premier fichier java vide à l'aide de la commande `touch Cryptomonnaie.java`. La structure du répertoire `tp1` doit être la suivante :

```shell
$:~/courseGIT/tp1> tree
.
├── README.md
└── src
    └── Cryptomonnaie.java
```

De manière simplifiée, les principaux attributs d'une crypto-monnaie sont le nom et la valeur actuelle de son jeton (_token_). Editez le fichier Cryptomonnaie.java avec le code suivant :

```java
public class Cryptomonnaie{
    private String nom;
    private double valeurDeJeton; // Imaginons en euros

    public Cryptomonnaie(String nom, double valeurDeJeton){
        this.nom = nom;
        this.valeurDeJeton = valeurDeJeton;
    }
}
```

À l'aide des commandes git que nous avons apprises, ajoutez et validez le fichier java au dépôt git avec le message `"Première version du fichier Cyptomonnaie.java"`.
 
Maintenant, la commande `git log` devrait afficher des informations similaires à ce qui suit :

```shell
$:~/courseGIT/tp1> git log
commit e6612def94728cfcb8468e5430edec6b983e5a58
Author: author <author@example.com>
Date:   Thu Apr 29 14:22:12 2021 +0200

    Première version du fichier Cyptomonnaie.java

commit 23782d55677ffc4a6ad97adc45c484e9b93671a6
Author: author <author@example.com>
Date:   Wed Apr 28 11:52:14 2021 +0200

    Ajoute du fichier README.md

```

<a id='gitignore'></a>
### 4.1. Creation du fichier `.gitignore`

Une fois qu'un fichier java a été créé, il est normal que nous procédions à sa compilation. Dans le répertoire `src`, compilons le fichier pour nous assurer qu'il n'y a pas d'erreurs :

```shell
$:~/courseGIT/tp1/src> javac Cryptomonnaie.java
```

Comme nous le savons, la compilation en java génère un nouveau fichier .class qui apparaîtra dans la zone de copie de travail (voir `git status` ci-dessous). 


```shell
$:~/courseGIT/tp1/src> git status
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)

        Cryptomonnaie.class

nothing added to commit but untracked files present (use "git add" to track)

```

La grande question que nous pouvons nous poser est la suivante : **que devons-nous faire avec ce fichier ? devrions-nous le gérer avec git aussi ?** La réponse à cette question est **non** : normalement, nous n'enregistrerons pas les modifications apportées aux fichiers générés à partir du code disponible. En d'autres termes, si nous avons un fichier java, nous n'avons pas besoin de sauvegarder le .class respectif car il s'agit d'informations redondantes et il s'agit également d'un fichier non modifiable. Cependant, il est un peu ennuyeux de voir un fichier .class apparaître à chaque fois que nous tapons la commande `git status`. 

Git offre une solution élégante à ce problème : nous pouvons générer une liste avec les types de fichiers que nous voulons que git ignore. L'emplacement de cette liste sera dans le fichier `.gitignore` que nous allons placer dans le répertoire racine de notre dépôt. 

Dans le répertoire `tp1` tapez :
 
```shell
$:~/courseGIT/tp1> touch .gitignore
```

Tapez maintenant `git status` : Que se passe-t-il ? quels fichiers ne sont pas encore sélectionnés (_stage_) ? 

Éditez le fichier `.gitignore` avec votre éditeur de texte préféré et ajoutez la ligne suivante : 

```
*.class
```

Puis sélectionnez et validez le fichier :

```shell
$:~/courseGIT/tp1> git add .gitignore
$:~/courseGIT/tp1> git commit -m ".gitignore ajouté"
```
Et maintenant : que se passe-t-il si nous tapons `git status`? **Vous pouvez tirer vos propres conclusions.**

### Exercices
> 1. Suivez toutes les étapes précédentes de la section 4.
2. Complétez le fichier .gitignore avec les lignes suivantes et validez-le dans git.


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


[Haut de la page](#TP1)

----------

**Fin du TP 1**


