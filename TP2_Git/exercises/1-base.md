
# Elementary Git command

* Create a *project* repository.  

    `mkdir project`.  

* Initialiaze, in the current repository, a git repository.  

    `git init`.  

* Configure your repository with your name and email.  

    ```sh
    git config --global user.name "NGUYEN"
    git config --global user.mail "minh-tri.nguyen@efrei.net"
    ```

* Create *file.txt* with "ligne01" in it then stage it.  

  ```sh
  git touch file.txt
  git echo "ligne01" >> file.txt
  git add file.txt
  ```

* In which state are repository's file ?  

  *file.txt* is staged.  

* Take a snapshot with a comment "version1".  

  `git commit -m "version1"`.

* Add "ligne02" to *file.txt*, stage and commit it.  

  ```sh
  echo "ligne02" >> file.txt
  git add file.txt
  git commit "version2"
  ```

* Which command print the log ?  

  `git log`.  

* Name this commit v0.1.  

  `git tag v0.1`.  

* Add "ligne03" to *file.txt*.  

  `echo "ligne03" >> file.txt`.  

* Which command allow you to print differences between last commit and working repository ?

  `git status` list all files untracked, modified or staged then `git diff "file.txt"` give you the lines that changed in *file.txt*.  

* What does that mean ?  

  Output :   
  >  warning: in the working copy of 'file.txt', LF will be replaced by CRLF the next time Git touches it  
    diff --git a/file.txt b/file.txt  
    index 2b7ab18..38bda22 100644  
    --- a/file.txt  
    +++ b/file.txt  
    @@ -1,2 +1,3 @@  
     ligne01  
     ligne02  
    +ligne03  

* Snapshot it in a new commit.  

    `git commit -m "version 3"`.  

* Rollback to v0.1

  `git checkout v0.1` to rollback.  

* What is inside *file.txt* ?  

  `cat file.txt`.      
  Output:  

  > Here is the output.

* How to rollback 3 commit before ?  

    `git checkout HEAD~3`.

* Add "ligne04" to *file.txt* and commit it. Then tag this commit v0.2.  

  ```sh
  echo "ligne04" >> file.txt
  git add file.txt
  git commit -m "version4"
  git tag v0.2
  ```

* What command allow you to print tagged commit.

  `git tag`.  

* Using a user interface, show the repo.

  `git gui`.  

---   

[Next](./2-branch.md)  
