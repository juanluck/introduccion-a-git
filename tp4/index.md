<style>
.note {
  min-height: 17px;
  margin: 4px 0 2px;
    margin-bottom: 2px;
  font-size: 12px;
  color: #000000;
  font-size: 14px !important;
  padding: 16px !important;
  margin-bottom: 24px !important;
  border-color: #000000; !important;
  background-color: rgba(84,174,255,0.4); !important;
  border-radius: 4px !important;
  border: 1px solid #000000; !important;
}
</style>

<a id='TP4'></a>
# TP 4 : Résolution de conflits  et pull request 
[Retour à la page principale](../index.md)


---

## Objectifs du TP 4

L'objectif de ce TP est double. D'une part, lorsque plusieurs personnes interagissent avec un référentiel Git, des conflits peuvent survenir, c'est-à-dire problèmes d'intégration des changements produits par plusieurs utilisateurs. Le premier objectif de ce TP est **i) d'apprendre comment nous pouvons résoudre des conflits**. D'autre part, **ii) nous allons apprendre à utiliser l'option `pull request`**. Cette option n'est pas standard dans git, mais une fonctionnalité ajoutée par différentes plates-formes telles que github. Les `pull request` sont couramment utilisées par les équipes qui collaborent dans un référentiel partagé, où tout le monde partage un référentiel unique et les branches thématiques sont utilisées pour développer des fonctionnalités et isoler les modifications.

>1. [Créer un conflit](#pull-request)
2. [Résoudre un conflit](#conflit)
3. [Un exemple simple de pull request](#pullrequest)
   

[Haut de la page](#TP4)

---

<a id='creation-conflits'></a>
## 1. Créer un conflit  

Normalement, dans le développement réel d'une application, des conflits se produiront spontanément. Cependant, pour notre formation, nous allons intentionnellement forcer un conflit dans git.

Dans la plupart des cas, git est capable de mélanger les modifications que différents utilisateurs apportent à différents fichiers, mais si deux utilisateurs apportent des modifications au même fichier localement (surtout si la modification se trouve sur la même ligne), git ne pourra pas savoir quelle modification est la bonne.

- Soit <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> ou  <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark>, Allez sur github et créer un repositoire `test-conflict` avec le fichier **README.md** ci-dessous.

```shell
# test-conflict

Normalement, dans le développement réel d'une application, des conflits se produiront spontanément. Cependant, pour notre formation, nous allons intentionnellement forcer un conflit dans git.

Dans la plupart des cas, git est capable de mélanger les modifications que différents utilisateurs apportent à différents fichiers, mais si deux utilisateurs apportent des modifications au même fichier localement (surtout si la modification se trouve sur la même ligne), git ne pourra pas savoir quelle modification est la bonne. Produisons un tel conflit :

- Voici une ligne du README.md avec dex (deux) fotes de frape (fautes de frappe) à corriger

- **Athos** corrigera la première faute de frappe (deux) et **Porthos** la seconde (fautes de frappe) 

- Chacun va faire un clone du repositoire et corriger sa faute de frappe localement, puis essayer de faire un `push` du changement. 

```
- Invitez votre collègue au projet en github. Chacun va faire un clone du repositoire et corriger sa faute de frappe localement (n'oubliez de faire un `commit` des changements), puis essayer de faire un `push` pour synchroniser les modifications avec le dêpòt distant . 

- Pour forcer le conflit, ne corrigez pas les erreurs dans le fichier tant que vous n'avez pas tous les deux cloné le référentiel. 

- Imaginons que c'est <mark style="background-color:green;font-weight:bold; color:white">Porthos</mark> le premier à corriger le fichier **README.md** et faire un `push` des modifications (éventuellement, cela fonctionnerait aussi dans l'autre sens, si Athos est le premier à faire le `push`).

- Empêchez surtout <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> de faire un `pull`. Cela synchroniserait les répertoires et nous ne produirions pas de conflit. 

- Ensuite, <mark style="background-color:red;font-weight:bold; color:white">Athos</mark> corrigera sa ligne du fichier, validera les modifications (`commit`) et tentera de synchroniser les répertoires local et distant (`push`). Le message suivant signale un conflit :

```shell
From github.com:<utilisateur>/test-conflict
   1094a44..dcb1032  main       -> origin/main
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.
```

- Si nous essayons de faire un `git pull`, nous aurons également le message suivant :

```shell
error: Pulling is not possible because you have unmerged files.
hint: Fix them up in the work tree, and then use 'git add/rm <file>'
hint: as appropriate to mark resolution and make a commit.
fatal: Exiting because of an unresolved conflict.
```
- **Nous venons de générer un conflit !!** Dans la section suivante, nous essaierons de le corriger. 

---
<a id='conflit'></a>
## 2. Résoudre un conflit  

Nous continuerons cette section sur la machine <mark style="background-color:red;font-weight:bold; color:white">Athos</mark>, qui est initialement la personne avec le conflit. 

- Pour déterminer le conflit, nous pouvons écrire la commande `git diff`, qui produira la sortie suivante :

```shell
diff --cc README.md                                                                                                                                        
index 12d78ec,9c2e1f1..0000000
--- a/README.md
+++ b/README.md
  
++<<<<<<< HEAD
 +- Voici une ligne du README.md avec deux fotes de frape (fautes de frappe) à corriger
++=======
+ - Voici une ligne du README.md avec dex (deux) fautes de frappe à corriger
++>>>>>>> dcb10325482119cf4001d04049e285ea7fe2274a
  
```
Voici, la ligne `<<<<<<< HEAD` nous indique la ligne de notre référentiel local qui diffère du référentiel distant. Ensuite, après `=======` et jusqu'à `>>>>>>` la ligne telle qu'elle se trouve dans le référentiel distant. 

Si nous éditons le fichier README.md avec n'importe quel éditeur de texte, nous verrons que ces lignes apparaissent également marquées avec la même syntaxe. 

- Modifiez le fichier README.md avec votre éditeur de texte préféré et résolvez le conflit afin que le contenu : 

```shell
<<<<<<< HEAD
- Voici une ligne du README.md avec deux fotes de frape (fautes de frappe) à corriger
=======
- Voici une ligne du README.md avec dex (deux) fautes de frappe à corriger
>>>>>>> dcb10325482119cf4001d04049e285ea7fe2274a
```

- soit modifié à la ligne suivante  : 

```shell
- Voici une ligne du README.md avec deux fautes de frappe à corriger
```
- Enregistrez ensuite le fichier et exécutez les commandes appropriées pour mettre à jour le référentiel local et distant :

```shell
$ git status
$ git add README.md
$ git commit -m "Conflit README résolu"
$ git push
```

* **Félicitations !!** Vous venez de résoudre un conflit dans git. Bien que git dispose encore de nombreux outils plus avancés pour gérer le flux de travail, vous disposez déjà de tous les outils pour utiliser git pour le travail d'équipe. 

<div class="note">
	<p><strong>NOTE : </strong> Git dispose d'outils graphiques, tels que meld, qui nous aident à résoudre ces conflits de manière plus visuelle. Cela nécessite de configurer git avec ces outils spécifiques et nous n'entrerons pas dans ces détails. Si vous souhaitez plus d'informations à ce sujet, vous pouvez visiter, par exemple, <a href="https://stackoverflow.com/questions/34119866/setting-up-and-using-meld-as-your-git-difftool-and-mergetool">ce fil de discussion.</a> </p>
	
<p>	De même, les IDE disposent d'aides visuelles pour gérer à la fois les conflits et le workflow git. Dans cette introduction à GIT, nous étudions simplement les outils de base. L'adaptation aux outils visuels est facile lorsque les concepts de base sont bien compris. </p>
</div>


[Haut de la page](#TP4)

-----

<a id='pullrequest'></a>
## 3. Un exemple simple de pull request   

Comme nous l'avons mentionné au début de ce TP, _un pull request_ n'est pas standard dans git, mais une fonctionnalité ajoutée par différentes plateformes comme github. Cependant, cette façon de travailler est devenue un standard de facto dans le développement d'applications open source. L'idée principale est de proposer un mécanisme par lequel nous pouvons proposer des modifications à un référentiel même sans en être les développeurs ou les propriétaires. 

En quelques mots, une pull request consiste à faire une copie d'un réferentiel sur notre compte, à créer une branche pour apporter des modifications et à notifier le propriétaire du réferentiel d'origin afin qu'il accepte les changements que nous proposons. 

Nous vous proposons ici un exercice pour faire une pull request. 
 
### Exercice
>1. Allez sur [ce site](https://github.com/juanluck/test-pull-request-2022) et faites une `pull request` en suivant les instructions décrites dans le fichier **README.md**  

[Haut de la page](#TP4)

-----

**Fin du TP 4**
