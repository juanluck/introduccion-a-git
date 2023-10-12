<a id='TP1'></a>
# TP 1: Trabajar en un repositorio local
[Volver a la página principal](../index.md)

Para nuestro primer contacto con Git, solo necesitaremos un editor de texto y una instalación funcional de Git en la consola. No será necesario tener un repositorio remoto (como GitHub) porque realizaremos todo el trabajo en un directorio local de la máquina. En la última parte de este TP, comenzaremos a gestionar un pequeño programa Java, por lo que también es práctico tener una máquina virtual Java instalada. Este trabajo práctico asume que estamos trabajando en Linux, aunque no debería haber ningún problema en hacerlo en otras plataformas.

## Objetivos del TP 1

El objetivo de este primer TP es familiarizarse con Git. Más específicamente, aprenderemos:

> 1. [Configuración de GIT (`git config`)](#configuration)
2. [Creación de un repositorio Git en una máquina local (`git init` y `git status`)](#gitinit)
3. [Creación de un archivo de texto README.md](#readme)
   * [Gestión de diferentes modificaciones en el archivo README.md](#readmeModifications)
   * [Diferenciar 3 estados / 3 áreas / 3 acciones](#readmeEtatsZonesActions)
4. [Gestión de versiones de un programa Java](#programmeJava)
   * [Creación del archivo `.gitignore`](#gitignore)

---

<a id='configuration'></a>
## 1. Configuración de GIT

Git viene con una herramienta llamada `git config` que le permite obtener y definir variables de configuración que controlan todos los aspectos de la apariencia y el funcionamiento de git.

Para verificar la configuración actual de git en su máquina, abra una terminal y escriba:

```shell
$:> git config --list
```

lo que debería mostrar información similar a la siguiente:

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

### 1.1. Tu Identidad

Lo primero que debes hacer al instalar git es definir tu nombre de usuario y tu dirección de correo electrónico. Esto es importante porque cada confirmación de git utiliza esta información y se incorpora de forma inmutable en las confirmaciones que comiences a crear:

```shell
$:> git config --global user.name "John Doe"
$:> git config --global user.email johndoe@example.com
```

Solo necesitas hacerlo una vez si usas la opción --global, ya que git utilizará siempre esta información para todo lo que hagas en este sistema.

### 1.2. Tu Editor

Ahora que tu identidad está configurada, puedes configurar el editor de texto por defecto que se utilizará cuando git necesite que escribas un mensaje:

```shell
$:> git config --global core.editor XXXX
```

donde **XXXX** corresponde al nombre de tu editor de texto preferido, por ejemplo, vim, emacs, gedit, ... 

<!--### 1.3. Tu Nombre de Rama por Defecto

Por defecto, git creará una rama llamada `master` cuando creas un nuevo repositorio con `git init` (veremos las ramas y la creación de un repositorio más adelante). A partir de la versión 2.28 de git, puedes establecer un nombre diferente para la rama inicial.

Para establecer `main` como nombre de rama por defecto, sigue estos pasos:

```shell
$:> git config --global init.defaultBranch main
```
-->

### Ejercicios
> 1. Siga los pasos anteriores y configure su nombre, dirección de correo electrónico y editor de texto en git.
2. Ejecute el comando `git config --list` y asegúrese de que toda la información proporcionada sea correcta.
3. Para verificar que su nombre es correcto, ejecute `git config user.name`.
4. Haga lo mismo para su dirección de correo electrónico, ejecute `git config user.email`.

[Arriba de la página](#TP1)
--------

<a id='gitinit'></a>
## 2. Creación de un Repositorio Git en una Máquina Local

Una vez que git esté configurado correctamente, procederemos a crear nuestro primer repositorio que gestionaremos con git. Lo primero que decidiremos es la estructura de directorios que utilizaremos para este curso.

Accede a tu directorio de trabajo (cualquiera que sea) y crea un directorio llamado `cursoGIT` y luego el directorio `tp1`, de modo que la estructura del directorio sea la siguiente:

```shell
$:> tree cursoGIT
cursoGIT/
└── tp1
```

Ve al directorio `tp1` de manera que el comando `pwd` muestre el siguiente resultado:

```shell
$:> pwd
/.../cursoGIT/tp1 
```

Ejecuta el comando `ls -a` y verifica que el resultado sea el siguiente:

```shell
$:> ls -a
. ..
```

**¿Listo para crear tu primer repositorio git?** Escribe:

```shell
$:> git init
```

Deberías obtener una respuesta de tipo:

```shell
Initialized empty Git repository in /.../cursoGIT/tp1/.git/
```

Este mensaje indica que tu directorio `tp1` será gestionado por git a partir de ahora. En particular, el directorio `.git` (que está oculto) contendrá la base de datos con todas las modificaciones que realizamos en el directorio `tp1`. **Atención:** nunca accederemos directamente al directorio `.git`, sino a través de comandos git. Para verificar que el directorio existe:

```shell
$:> ls -a
.  ..  .git
```

<a id='gitstatus'></a>
### 2.1. El Comando `git status`

El comando `git status` nos permite verificar las modificaciones realizadas en los archivos en la copia de trabajo `tp1` (_working directory_). Hasta el momento, no hemos cambiado nada en el repositorio `tp1` y el comando `git status` debería mostrar el siguiente mensaje:

```shell
$:> git status
On branch master

Initial commit

nothing to commit (create/copy files and use "git add" to track)
```


### Ejercicios
> 1. Sigue los pasos anteriores y asegúrate de que el directorio `.git` haya sido creado correctamente.
2. Ejecuta el comando `git status` en el directorio `tp1` y verifica que muestre el mensaje mostrado en la [sección 2.1](#gitstatus).

**¡Felicidades, acabas de crear tu primer repositorio git!**

[Arriba de la página](#TP1)
--------


<a id='readme'></a>
## 3. Creación de un Archivo de Texto README.md

Ahora vamos a crear un archivo de texto README.md (en formato [markdown](https://www.markdownguide.org/cheat-sheet)) en el directorio `tp1`, donde registraremos un informe de este curso. El archivo README.md se ha convertido en un _estándar de facto_ en git, y se recomienda crear uno para cada proyecto git que inicies.

Usa tu editor de texto preferido para hacerlo y comienza a editar el archivo con esta información:

```markdown
**Nombre:** Tu nombre

**Grupo:** Tu grupo

**Año:** Curso escolar

### Informe TP1 Introducción a GIT

En este TP aprendemos a trabajar con git.
```

Asegúrate de guardar el archivo README.md antes de continuar.


<a id='readmeModifications'></a>
#### 3.1. Gestionar las Diferentes Modificaciones del Archivo README.md

En la [sección 2.1](#gitstatus), aprendimos que el comando `git status` se utiliza para mostrar las modificaciones realizadas en los archivos en la copia de trabajo `tp1`. Después de las modificaciones que acabamos de hacer en el archivo README.md, el comando debería mostrar el siguiente mensaje:

```shell
$:> git status
On branch master

Initial commit

Untracked files:
  (use "git add <file>..." to include in what will be committed)

	README.md

nothing added to commit but untracked files present (use "git add" to track)
```

El mensaje "Untracked files" muestra que acabamos de modificar un archivo (README.md) en nuestra copia de trabajo y nuestro repositorio git aún no está siguiendo este archivo. Para seleccionar (_stage_) el archivo README.md, escribe:

```shell
$:> git add README.md
```

El comando `git add README.md` permitirá a git hacer un seguimiento de las modificaciones realizadas en este archivo a partir de ahora. Para ver el cambio de estado del archivo README.md en git, escribe:

```shell
$:> git status
On branch master

Initial commit

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)

	new file:   README.md
```

Puedes ver que el archivo acaba de ser seleccionado para ser incluido en el repositorio git y solo queda confirmar esa inclusión. Para hacerlo, utilizamos el comando `git commit`. Escribe:

```shell
$:> git commit -m "Agrega el archivo README.md"
[master (root-commit) 23782d5] Agrega el archivo README.md
 1 archivo cambiado, 0 inserciones(+), 0 eliminaciones(-)
 create mode 100644 README.md
```

Ahora, el archivo README.md en la copia de trabajo `tp1` (_working directory_) está sincronizado con el repositorio. **¡Hemos registrado la primera versión del archivo!** La salida del comando `git status` debería ser la siguiente:


```shell
$:> git status
On branch master
nothing to commit, working directory clean
```

<a id='sequencelocal'></a>
**Importante:** lo que acabamos de aprender es **una secuencia simple para seguir los cambios de un archivo en git**, que incluye los siguientes pasos:

1. Modificación de un archivo existente o creación de un nuevo archivo.
2. `git status` para ver los archivos que se incluirán en el repositorio git.
3. `git add <archivo>` para seleccionar el archivo (_stage_) que queremos seguir en el repositorio git.
4. `git commit -m "Agrega aquí un breve comentario para describir este commit"` para validar/registrar los cambios en el repositorio git.
5. Finalmente, el comando `git log` nos permite ver todas las diferentes versiones registradas en nuestro repositorio. Escribe `git log` para ver el registro de las diferentes versiones. Cada entrada del registro corresponde a una versión diferente del archivo validada (_commit_).


<a id='readmeEtatsZonesActions'></a>
### 3.2. Diferenciar 3 Estados / 3 Zonas / 3 Acciones

Para comprender mejor el funcionamiento de git, es interesante distinguir la diferencia entre estado, zona y acción. Aquí tienes un breve resumen:

**En un repositorio GIT, un archivo puede tener 3 estados diferentes:**

   * Modificado (modified): tiene modificaciones locales, que deben ser seleccionadas (staged) y luego validadas (commit).
   * Seleccionado (staged): sus modificaciones han sido seleccionadas (staged) para ser validadas (commited).
   * Validado (commited): está sincronizado con el repositorio y no requiere validación.

**Estos estados corresponden a 3 zonas en GIT:**

   * La copia de trabajo (working directory), que es el sistema de archivos local, donde se modifican los archivos.
   * La zona de selección (staging area).
   * El repositorio, donde las modificaciones se registran como confirmaciones (commits).

**La transición entre estos 3 estados se realiza mediante 3 acciones:**

   * Selección (stage), que selecciona los archivos para la validación (comando: `git add`).
   * Validación (commit), que crea el commit y lo envía al repositorio (comando: `git commit`).
   * Recuperación (checkout), que recupera un snapshot desde el repositorio hacia la copia de trabajo (comando: `git checkout`). Veremos este comando más adelante.


### Ejercicio
> 1. Para asegurarnos de que hemos aprendido la secuencia de funcionamiento simple de git, vamos a actualizar el archivo README.md con un informe de este curso hasta ahora. Asegúrate de que las modificaciones estén seleccionadas y validadas en el repositorio git.

[Arriba de la página](#TP1)
--------
   
<a id='programmeJava'></a>
## 4. Gestión de Versiones de un Programa Java

Aunque git permite la gestión de versiones de cualquier tipo de archivo (por ejemplo, como el archivo de texto README.md), la mayoría de las veces lo utilizaremos para gestionar las versiones de un programa. En este ejercicio práctico, vamos a crear un pequeño proyecto Java sobre el fascinante mundo de las criptomonedas.

Para empezar a desarrollar nuestro proyecto, en el directorio `tp1` crearemos un directorio `src` que contendrá las fuentes del proyecto, y dentro de este directorio crearemos un primer archivo Java vacío utilizando el comando `touch Criptomoneda.java`. La estructura del directorio `tp1` debería verse de la siguiente manera:

```shell
$:~/cursoGIT/tp1> tree
.
├── README.md
└── src
    └── Criptomoneda.java
```

De forma simplificada, los principales atributos de una criptomoneda son el nombre y el valor actual de su ficha (_token_). Edita el archivo Criptomoneda.java con el siguiente código:

```java
public class Criptomoneda{
    private String nombre;
    private double valorDeToken; // Imaginemos en euros

    public Criptomoneda(String nombre, double valorDeToken){
        this.nombre = nombre;
        this.valorDeToken = valorDeToken;
    }
}
```

Con las órdenes de git que hemos aprendido, añade y valida el archivo Java en el repositorio git con el mensaje "Primera versión del archivo Cyptomonnaie.java".

Ahora, el comando `git log` debería mostrar información similar a la siguiente:

```shell
$:~/courseGIT/tp1> git log
commit e6612def94728cfcb8468e5430edec6b983e5a58
Author: author <author@example.com>
Date:   Thu Apr 29 14:22:12 2021 +0200

    Primera versión del archivo Criptomoneda.java

commit 23782d55677ffc4a6ad97adc45c484e9b93671a6
Author: author <author@example.com>
Date:   Wed Apr 28 11:52:14 2021 +0200

    Agrega el archivo README.md

```

<a id='gitignore'></a>
### 4.1. Creación del archivo `.gitignore`

Una vez que se ha creado un archivo Java, es normal proceder a su compilación. En el directorio `src`, compilamos el archivo para asegurarnos de que no haya errores:

```shell
$:~/cursoGIT/tp1/src> javac Criptomoneda.java
```

Como sabemos, la compilación en Java genera un nuevo archivo .class que aparecerá en la zona de copia de trabajo (ver git status a continuación).

```shell
$:~/cursoGIT/tp1/src> git status
On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)

        Criptomoneda.class

nothing added to commit but untracked files present (use "git add" to track)

```

La gran pregunta que podemos hacernos es la siguiente: **¿qué debemos hacer con este archivo? ¿deberíamos gestionarlo también con git?** La respuesta a esta pregunta es **no**: normalmente, no registraremos las modificaciones realizadas en los archivos generados a partir del código disponible. En otras palabras, si tenemos un archivo Java, no necesitamos guardar el archivo .class respectivo, ya que se trata de información redundante y también es un archivo no editable. Sin embargo, es un poco molesto ver un archivo .class aparecer cada vez que ejecutamos el comando `git status`.

Git ofrece una solución elegante a este problema: podemos generar una lista con los tipos de archivos que queremos que git ignore. El lugar para esta lista será el archivo `.gitignore`, que colocaremos en el directorio raíz de nuestro repositorio.

En el directorio `tp1`, escribe:
 
```shell
$:~/cursoGIT/tp1> touch .gitignore
```

Ahora, escribe `git status`: ¿Qué sucede? ¿Qué archivos aún no están seleccionados (_stage_)?

Edita el archivo `.gitignore` con tu editor de texto preferido y agrega la siguiente línea:


```
*.class
```

Luego, selecciona y valida el archivo:

```shell
$:~/cursoGIT/tp1> git add .gitignore
$:~/cursoGIT/tp1> git commit -m ".gitignore añadido"
```
Y ahora, ¿qué sucede si escribimos `git status`? **Puedes sacar tus propias conclusiones.**

### Ejercicios
> 1. Sigue todos los pasos anteriores de la sección 4.
2. Completa el archivo .gitignore con las siguientes líneas y válidalo en git.


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


[Arriba de la página](#TP1)
----------

**Fin del TP 1**
