# Introducción a la gestión de versiones con git {#introduction_main}

[Git](https://git-scm.com/) es una herramienta de **gestión de versiones de código abierto** inicialmente diseñada por [Linus Torvalds](https://es.wikipedia.org/wiki/Linus_Torvalds) para el mantenimiento del núcleo Linux, que se ha convertido en un estándar para el trabajo en grupo. Aunque no debemos olvidar que existen otros sistemas de gestión de versiones (por ejemplo, Subversion o Mercurial), Git es hoy en día la herramienta de gestión de versiones más utilizada. Este curso no pretende abordar los fundamentos teóricos de Git ni conceptos avanzados, es esencialmente una introducción práctica en la que en 10 minutos estaremos en condiciones de crear nuestro primer repositorio Git.

El lector interesado puede consultar manuales más completos sobre Git, como el libro [Pro Git book](http://git-scm.com/book) de Scott Chacon ([CC BY-NC-SA 3.0](http://creativecommons.org/licenses/by-nc-sa/3.0)), o [este curso en línea](https://pigne.org/teaching/general/lecture/Gestion-de-version-travail-en-equipe) ([CC BY-NC-SA 4.0](http://creativecommons.org/licenses/by-nc-sa/4.0)), del cual este curso se inspiró en parte.

## Requisitos de instalación

Para este curso práctico, <mark style="background-color:gray;color:white"> <b> trabajaremos exclusivamente utilizando la línea de comandos</b></mark>. En la actualidad, existen numerosos entornos visuales para trabajar con Git, así como entornos integrados en diferentes IDE. Olvídalos. Una vez que hayas aprendido a usar Git en la línea de comandos, no tendrás ningún problema en utilizar un entorno gráfico. Sin embargo, lo contrario no es tan sencillo.

Específicamente, necesitaremos:

> 1. Un editor de texto.
2. Una instalación de Git:
   * Puedes descargar Git [aquí para diferentes plataformas](https://git-scm.com/downloads).
   * Instalación de Git en Ubuntu: `sudo apt-get update; sudo apt-get install git`
   * [Instalación de Git en Windows 10](https://www.develves.net/blogs/asd/articles/using-git-with-powershell-on-windows-10/#installing-git).
3. Una máquina virtual Java[^1].
4. Para el [TP 2](./tp2/index.md), [TP 3](./tp3/index.md), [TP 4](./tp4/index.md) y [TP 5](./tp5/index.md), una cuenta en [GitHub](https://github.com/).

[^1]: La máquina virtual Java no es necesaria para Git, sino para los ejercicios propuestos.

## Travaux pratiques 

Ce cours d'[introduction à la gestion des versions à l'aide de GIT](#introduction_main)  est divisé en quatre séances pratiques :

>* [TP 1 : Travailler sur un répertoire local ](./tp1/index.md)
>* [TP 2 : Travailler en autonomie sur un depôt github distant ](./tp2/index.md) 
>* [TP 3 : Travailler en équipe sur un depôt github distant ](./tp3/index.md)
>* [TP 4 : Résolution de conflits et pull request ](./tp4/index.md)
>* [TP 5 : Comment créer un site Web sur GitHub pages ](./tp5/index.md)

## Liens d'aide pour le cours 

### [Feuille de triche git](https://education.github.com/git-cheat-sheet-education.pdf)

### [Feuille de triche markdown](https://www.markdownguide.org/cheat-sheet)



Markdown est une syntaxe légère et facile à utiliser pour créer du texte formaté à l'aide d'un éditeur de texte. Il est couramment utilisé dans git, entre autres, pour créer des documents tels que des fichiers README ou pour déployer facilement des documents tels que [ce site web](#introduction_main) qui est écrit en utilisant markdown et [github pages](https://pages.github.com/). Vous pouvez trouver ci-dessous les principales conventions pour la syntaxe.

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List


**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```
Pour plus de détails consultez [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

## Trabajos prácticos

Este curso de [introducción a la gestión de versiones con GIT](#introduction_main) se divide en cuatro sesiones prácticas:

>* [TP 1: Trabajar en un repositorio local](./tp1/index.md)
>* [TP 2: Trabajar de manera autónoma en un repositorio GitHub remoto](./tp2/index.md)
>* [TP 3: Trabajar en equipo en un repositorio GitHub remoto](./tp3/index.md)
>* [TP 4: Resolución de conflictos y solicitud de extracción (pull request)](./tp4/index.md)
>* [TP 5: Cómo crear un sitio web en GitHub Pages](./tp5/index.md)

## Enlaces de ayuda para el curso

### [Hoja de referencia de Git](https://education.github.com/git-cheat-sheet-education.pdf)

### [Hoja de referencia de Markdown](https://www.markdownguide.org/cheat-sheet)

Markdown es una sintaxis ligera y fácil de usar para formatear texto con un editor de texto. Se utiliza comúnmente en Git, entre otros, para crear documentos como archivos README o para desplegar fácilmente documentos como [este sitio web](#introduction_main) que está escrito utilizando Markdown y [GitHub Pages](https://pages.github.com/). A continuación, puedes encontrar las convenciones principales de su sintaxis.

```markdown
Bloque de código resaltado

# Encabezado 1
## Encabezado 2
### Encabezado 3

- Lista
- con viñetas

1. Lista
2. Numerada

**Negrita** y _Cursiva_ y texto `Código`

[Enlace](url) e ![Imagen](src)
```
Para más detalles consultad [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).