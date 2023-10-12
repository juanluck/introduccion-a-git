<a id='TP3'></a>
# TP 3 : Travailler en équipe sur un depôt github distant 
[Retour à la page principale](../index.md)

Il est temps de commencer à utiliser git pour le travail d'équipe. En fait, git a été initialement conçu dans ce but et c'est là qu'il peut nous montrer sa puissance. 

Avant de continuer, nous allons nous organiser en binômes. Si vous êtes un nombre impair, un équipe peut être composé de trois personnes malgré le TP est conçu pour deux roles. 

**Êtes-vous déjà constitué en équipe ?** Lancez une pièce et décidez qui assumera le rôle de <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> et qui assumera le rôle de <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> pour ce travail pratique. Si vous êtes trois, deux personnes seront regroupées dans le rôle d'<mark style="background-color:red;font-weight:bold; color:white">Athos</mark>.

 
---

## Objectifs du TP 3

Le but de ce troisième TP  est de commencer à travailler en équipe sur github et développer un marché pour le projet de crypto-monnaie que nous avions déjà lancé. Dans ce TP, nous allons apprendre à : 

>1. [Inviter des collaborateurs dans un dépôt personnel](#collaborateurs)
2. [Développement d'un projet java en équipe](#projet)
3. [Gérer des nouvelles fonctionnalités à l'aide des branches](#branch)

   

[Haut de la page](#TP3)

---

<a id='collaborateurs'></a>
## 1. Inviter des collaborateurs dans un dépôt personnel

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark> :

: * Pour commencer, <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> va créer un nouveau dépôt dans son compte github appelé `tp3` (<mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> fera bien de regarder et de commenter avec <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> comment cela est fait). Nous allons remplir le formulaire de la même manière que nous l'avons fait avec le dépôt `tp2`.

: * Une fois le dépôt créé, cliquez sur **Settings** :

![Settings](./images/settings.png)

: * ensuite sur **Manage access** et puis sur **Invite a collaborator** :

![Manage access](./images/inviteCollaborator.png)

: * demandez à <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> son nom d'utilisateur sur github et invitez-le dans votre dépôt :

![Manage access](./images/invitePorthos.png)

<mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :

: * <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark>  doit aller dans sa boîte email pour recevoir l'invitation d'<mark style="background-color:red;font-weight:bold; color:white">Athos</mark> à collaborer dans le dépôt `tp3` et l'accepter.

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark>  et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :

: * Chacun de vous peut faire un clone du projet en se plaçant dans le répertoire `courseGIT` :

```shell
$:~/courseGIT> git clone git@github.com:<utilisateur_de_athos>/tp3.git
```

* Si vous l'avez bien fait, votre répertoire `courseGIT` devrait contenir trois répertoires comme indiqué ci-dessous :

```shell
$:~/courseGIT> ls
tp1 tp2 tp3
```

### Exercices
>1. <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> : allez dans le répertoire `tp3` et mettez à jour tous les fichiers avec ceux du répertoire `tp2` (README.md et src/Cryptomonnaie.java) (surtout ne copiez pas le répertoire caché .git). Synchronisez les dépôts local et distant.
2.  <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> : après que <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> vous en informe, faissez un `git pull` depuis votre répertoire local `tp3` pour synchroniser les changements.
3. Les deux : vérifiez que tous les dépôts sont bien synchronisés (ce qui est sur github correspond bien à ce que vous avez dans votre répertoire local).

[Haut de la page](#TP3)

-----

<a id='projet'></a>
## 2. Développement d'un projet java en équipe

Git a été principalement conçu pour gérer le travail en équipe. Revenons au projet Crypto-monnaie pour lequel nous allons créer un marché avec différents portefeuilles. Avant de commencer, décrivons certains concepts :

**Portefeuille :**
: Un portefeuille cryptographique est un portefeuille virtuel dans lequel un utilisateur peut stocker un certain nombre de jetons d'une crypto-monnaie. Cet utilisateur peut posséder plusieurs portefeuilles, mais chaque portefeuille ne peut contenir qu'un seul type de crypto-monnaie. Un portefeuille permet des achats de jetons ainsi qu'un transfert de jetons entre portefeuilles si le type de crypto-monnaie est le même. 

**Marché :**
: Le marché est un registre avec une série de portefeuilles cryptographiques. En principe, le marché nous permet de poser certaines questions telles que quel est le capital total d'un utilisateur avec plusieurs portefeuilles ou quel est le capital total en circulation d'une crypto-monnaie spécifique.

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark>  et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :

: * Avant de continuer, assurez-vous que votre dépôt `tp3` est parfaitement synchronisé.

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark> :

: * Copiez les fichiers suivants dans le répertoire `tp3/src`, validez-les dans le dépôt local et distant :
   * [CryptoMarche.java](./src/CryptoMarche.java)
   * [Portefeuille.java](./src/Portefeuille.java)
   * [TestCryptoMarche.java](./src/TestCryptoMarche.java) 
   
<mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :
: * Assurez-vous d'obtenir la dernière version du dépôt distant. 

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark>  et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :

: * Votre mission sera de compléter la fonctionnalité qui manque pour compléter notre application de marché de crypto-monnaie. <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> se concentrera sur l'implementation de la classe **Portefeuille.java** et <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> sur l'implementation de la classe **CryptoMarche.java**. **L'objectif est de faire passer les tests décrits dans le fichier TestCryptoMarche.java (il n'est pas permis de modifier ce fichier).**
* Avant de continuer, compilez tout le code et assurez-vous qu'il n'y a pas d'erreurs de compilation. 
* Exécutez en ligne de commande `java TestCryptoMarche`. La réponse devrait être la suivante :

```shell
Test Portefeuille transfertDevise        ... FAIL
Test Portefeuille achatDevise            ... FAIL
Test CryptoMarche capitalEnEuros         ... FAIL
Test CryptoMarche capitalMonneaie        ... FAIL
```

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark> :

: * Votre tâche consiste à terminer l'implémentation des deux fonctions suivantes de la classe **CryptoMarche.java**. Suivez la spécification dans les commentaires pour les compléter. Une fois terminé, synchronisez vos modifications avec le dépôt local et distant. 

```java
    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * du propriétaire et calcule son capital en euros. 
     * @param proprietare
     * @return capital en euros du propriétare.
     */
    public double capitalEnEuros(String proprietaire){
        /**
			FONCTION À IMPLEMENTER
        **/
        return 0;
    }

    /**
     * Cette fonction recherche sur le marché tous les portefeuilles 
     * d'un type de devise et calcule le volume total de capital de 
     * cette devise sur le marché 
     * @param monnaie
     * @return capital total en circulation de la cryptomonnaie (en euros).
     */
    public double capitalMonneaie(Cryptomonnaie monnaie){
        /**
			FONCTION À IMPLEMENTER
        **/
        return 0;
    }
```


 <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :

 : * Votre tâche consiste à terminer l'implémentation des deux fonctions suivantes de la classe **Portefeuille.java**. Suivez la spécification dans les commentaires pour les compléter. Une fois terminé, synchronisez vos modifications avec le dépôt local et distant. 
 
```java
  /**
   * Cette fonction vous permet de transférer des devises du portefeuille actuel 
   * vers le portefeuille de destination pour le montant indiqué. Le type de devise 
   * (nom du Jeton) doit être le même entre les deux portefeuilles et le montant 
   * du portefeuille actuel doit être supérieur ou égal à celui indiqué.
   * @param destination 
   * @param montantJetons
   * @return true si la transaction a été effectuée, false sinon.  
   */
  public boolean transfertDevise (Portefeuille destination, double montantJetons){
      /**
           FONCTION À IMPLEMENTER
	  **/
      return false;
  }

  /**
   * Cette fonction vous permet d'acheter des jetons de la 
   * crypto-devise en fonction de leur valeur en euros. 
   * Le résultat est l'augmentation des jetons de la crypto-monnaie.
   * @param montantEuros Valeur d'achat en euros 
   * @return true si le montant en euros est supérieur ou égal à 0 
   */
  public boolean achatDevise (double montantEuros){
	/**
           FONCTION À IMPLEMENTER
	**/
    return false;
  }
```

### Exercice
>1. Réalisez les étapes précédentes. Une fois les dépôts synchronisés, <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> doivent compiler et lancer le test `java TestCryptoMarche`. Le résultat doit être le suivant :

```shell
Test Portefeuille transfertDevise        ... OK
Test Portefeuille achatDevise            ... OK
Test CryptoMarche capitalEnEuros         ... OK
Test CryptoMarche capitalMonneaie        ... OK
``` 

[Haut de la page](#TP3)

-----


<a id='branch'></a>
## 3. Gérer des nouvelles fonctionnalités à l'aide des branches

Après avoir lancé le projet commun de marché de la crypto-monnaie, <mark style="background-color:red;font-weight:bold; color:white">Athos</mark>  et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> décident de s'attaquer à de nouveaux projets séparément. En particulier, chacun d'eux décide de lancer sa propre crypto-monnaie, respectivement : la **AthosCoin** et la **PorthosCoin**.  Afin d'intégrer ces devises dans le marché existant, nous allons utiliser **le concept de branches git.** 

Jusqu'à présent, sans avoir besoin de le savoir, toutes les modifications que nous avons apportées au dépôt, nous l'avons fait sur une branche principale appelée **main** ou **master** (le nom dépend des paramètres de configuration ). Si vous tapez `git branch`, vous obtiendrez ce nom. Cependant, si vous souhaitez créer une nouvelle fonctionnalité dans votre code (pas forcément une fonctionnalité principale, mais une fonctionnalité supplémentaire), git vous permet de créer une nouvelle branche : une fourchette dans la séquence des changements. 

### 3.1. Tester le concept de branche avec un exemple simple 

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark>  et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :

: * Imaginons que nous voulions tester une nouvelle fonctionnalité dans notre projet que nous appellerons **"test"**. Cette fonctionnalité peut être intégrée directement dans la branche principale **main** (comme nous l'avons fait jusqu'à présent) ou nous pouvons la tester dans une branche séparée, vérifier si cela fonctionne puis l'intégrer dans la branche principale. Essayons ce deuxième cas.

: * Commençons par lister toutes les branches actuelles de notre dépôt avec `git branch` puis voyons le contenu de cette branche :

```shell
$:~/courseGIT/tp3> git branch
* main
$:~/courseGIT/tp3> tree
.
├── README.md
└── src
    ├── CryptoMarche.java
    ├── Cryptomonnaie.java
    ├── Portefeuille.java
    └── TestCryptoMarche.java
```

* À l'aide de `git log`, nous pouvons également voir toutes les modifications que nous avons apportées jusqu'à présent. Passons certains paramètres à la commande pour la rendre plus lisible. 

```shell
$:~/courseGIT/tp3> git log --graph --oneline --all --decorate --topo-order
* 922b42b (HEAD -> main) Adding CryptoMarche
* 177514f (origin/main, origin/HEAD) Starting tp3++
* e7820d8 Starting tp3
* 455453c Initial commit
```

* Il est temps de créer une nouvelle branche que nous appellerons **test**. Utilisez la commande suivante : 

```shell
$:~/courseGIT/tp3> git checkout -b test
Switched to a new branch 'test'
```
* L'option `-b` nous permet de dire à `checkout` que nous allons créer cette nouvelle branche. `checkout` nous fait changer de branche et aller dans la branche **test** (toutes les modifications apportées à partir de maintenant ne modifieront pas la branche **main** mais la branche **test**).  Pour nous assurer que nous sommes dans la branche **test**, tapez : 

```shell
$:~/courseGIT/tp3> git branch
  main
* test
```
* L'étoile * indique qu'il s'agit de la branche de travail actuelle. Si nous voulons basculer entre les branches, nous pouvons utiliser la commande `git checkout <nom_branche>`. 

* Commençons par créer un nouveau fichier "test.txt" dans la branche **test**. Pour cela tapez :

```shell
$:~/courseGIT/tp3> touch test.txt
$:~/courseGIT/tp3> ls
README.md  src  test.txt
```
* Et puis validons ces changements dans le dépôt local : 

```shell
$:~/courseGIT/tp3> git add test.txt
$:~/courseGIT/tp3> git commit -m "fonction de test ajoutée "
```
* Oublions un instant la branche **test** et revenons à la branche principale **main**, puis tapez la commande `ls`: 

```shell
$:~/courseGIT/tp3> git checkout main
$:~/courseGIT/tp3> ls
README.md  src
```
**Que se passe-t-il? Où est passé le fichier _test.txt_ ?**

: * Imaginez que nous suivions le développement au sein de la branche principale. Pour simuler cela, modifiez le fichier README.md en ajoutant la ligne: "Nous avons maintenant créé une nouvelle branche de test". Effectuer un `git add README.md` puis un `git commit -m "nouveau commit sur la branche principale"`. Tapez la commande :

```shell
$:~/courseGIT/tp3> git log --graph --oneline --all --decorate --topo-order
* f721aae (HEAD -> main) nouveau commit sur la branche principale
| * bee45b2 (test) fonction de test ajoutée
|/  
* 922b42b Adding CryptoMarche
```

* Vous pouvez voir dans la sortie du log qu'une fourchette dans le code vient d'être produite.  Visuellement, il y a maintenant une branche principale et une branche de test :

```shell
* (main)
| * (test) 
|/ 
* (main)
```

### 3.2. Fusionner la branche de test dans la branche principale 

<mark style="background-color:red;font-weight:bold; color:white">Athos</mark>  et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> :

: * Travailler avec des branches serait inutile si à un certain moment on ne pouvait pas les fusionner. Imaginons que nous voulions ajouter la fonctionnalité **test** à notre branche principale. Pour ce faire, allons dans la branche principale :

```shell
$:~/courseGIT/tp3> git checkout main
```

* puis nous utiliserons la commande `git merge` qui nous permet de fusionner des branches :

```shell
$:~/courseGIT/tp3> git merge test
```

* pour visualiser la fusion, vous pouvez écrire la commande :


```shell
$:~/courseGIT/tp3> git log --graph --oneline --all --decorate --topo-order
*   454d00d (HEAD -> main) Merge branch 'test' into main
|\  
| * bee45b2 (test) fonction de test ajoutée
* | f721aae nouveau commit sur la branche principale
|/  
* 922b42b Adding CryptoMarche
```
* **Que se passe-t-il si nous tapons la commande `ls` ?** : 

```shell
$:~/courseGIT/tp3> ls
???
```

### Exercices
>1. <mark style="background-color:red;font-weight:bold; color:white">Athos</mark>  et <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> faire les sections 3.1 et 3.2 séparément sans synchronisation avec le dépot github.
2. Ensuite, supprimez le fichier test.txt du dépôt, pour cela, écrivez la commande `git rm test.txt` puis` git commit -m "test.txt supprimé"`.
3. Chacun de vous va créer une branche appelée **AthosCoin** et **PorthosCoin** respectivement. Dans cette branche, vous allez créer votre crypto-monnaie (suivez l'exemple d'AramisCoin ci-dessous). Une fois la devise créée, fusionnez la branche avec la branche principale. Assurez-vous ensuite que les modifications sont synchronisées dans le dépôt github. 

```java
public class AramisCoin extends Cryptomonnaie{
    public AramisCoin(){
        super("ARA", 1000);
    }
}
```
[Haut de la page](#TP3)

-----

**Fin du TP 3**