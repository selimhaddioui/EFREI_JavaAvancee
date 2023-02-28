
# Branch

* Create a repository, configure it with your name and mail.

  ```sh
  mkdir 2-exercise
  cd 2-exercise
  git init
  git config --global user.name "Haddioui"
  git config --global user.email "selim.haddioui@hotmail.com"
  ```

* Create *lignes.txt* which below content.

  ```sh
  touch lignes.txt
  echo "igne01" >> lignes.txt
  echo "igne02" >> lignes.txt
  echo "ligne03" >> lignes.txt
  ```

* Create a branch *correction* and print all available branch.

  ```sh
  git add lignes.txt
  git commit -m "First commit"
  git branch correction
  git branch
  ```

* On which branch are we ?

  We are currently on default branch (master or main).

* Go on correction branch and, again, print all available branches.

  ```sh
  git checkout correction
  git branch
  ```

* What is the difference ?

  Branch correction is now bold and colored, it mean we are on it.

* In which state are our files ?

  They are all unmodified cause we commited them before.

* Edit *file.txt* to add 'l' on beginning of first line. Commit it with this comment "ligne01 corrigée".

  ```sh
  // do the edit on lignes.txt
  git add lignes.txt
  git commit -m "ligne01 corrigée"
  ```

* Go back on master and check *lignes.txt* content.

  ```sh
  git checkout master
  ```

  Because we did our fix on correction branch, lignes.txt from master branch still have the same content has before our last commit on correction.

* Add "ligne04" to *lignes.txt* and commit.

    ```sh
    echo "ligne04" >> lignes.txt
    git add lignes.txt
      git commit -m "ajout ligne04".
    ```

* Go back on correction branch, fix "ligne02" on *lignes.txt* and commit.

  ```sh
  git checkout correction
  // do the correction on lignes.txt
  git add lignes.txt
  git commit -m "ligne02 corrigée"
  ```

* What is inside *lignes.txt* ?

  We can see that our last fix has been done but "ligne04" isn't in it.

* Go back on master.

  `git checkout master`.  

* Print lignes.txt content.

  `cat lignes.txt`.  

  Output :

  > igne01  
    igne02  
    ligne03  

* Merge correction into main.

  `git merge correction -m "fusion"`.  

* Print *lignes.txt* after edit.

  `cat lignes.txt`.   

  Output :

  > igne01
    igne02
    ligne03
    ligne04

* Print using graphics evolutions in an graphic interface

  `git gui` `Repository > Visualize Git's History`

---  

[Preview](./1-base.md)

[Next](./3-remote.md)  
