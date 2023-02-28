
# Remote

1.
  * Create a repository *repo1*, go in it and init a git repository. Also config a user.name and email locally.

    ```sh
    mkdir 3-repo1
    cd 3-repo1
    git init
    git config --local user.name NGUYEN
    git config --local user.email minh-tri.nguyen@efrei.net
    ```

  * Create a *file.txt* with "ligne01" in it and commit it with a comment saying "first commit".

    ```sh
    touch file.txt
    echo "ligne01" >> file.txt
    git add file.txt
    git commit -m "first commit".
    ```

  * Print log

    `git log`

    Output :
    > commit 2da7fccddb28ad878cc96f1267449499d4dd5ab2 (HEAD -> master)  
      Author: NGUYEN <minh-tri.nguyen@efrei.net>  
      Date:   Tue Feb 28 15:18:38 2023 +0100    

2.
  * Go in parent repository, create a repository called *remote*, go in it and init a git repository using following command `git clone --bare 3-repo1 3-remote`.  

    ```sh
    cd ../
    mkdir 3-remote
    git clone --bare 3-repo1 3-remote
    cd 3-remote
    ```

  * What --bare is for ?

    When using `clone --bare repo1 repo2` you can create a repository that will only store file repository without working files. It is often used for shared central repository because they are lighter than common repository.

  * Print log from this repository.  

    `git log`.
    Output :
    > commit 2da7fccddb28ad878cc96f1267449499d4dd5ab2 (HEAD -> master)  
      Author: NGUYEN <minh-tri.nguyen@efrei.net>  
      Date:   Tue Feb 28 15:18:38 2023 +0100  
      first commit  


3.
  * Go in parent repository, create a repository repo2 from remote and go in it. Configure it with an other name and email and print log.

    ```sh
    cd ../
    mkdir 3-repo2
    git clone 3-remote 3-repo2
    cd 3-repo2
    git config --local user.name HADDIOUI
    git config --local user.email selim.haddioui@efrei.net
    git log
    ```

    Output :
    > commit 2da7fccddb28ad878cc96f1267449499d4dd5ab2 (HEAD -> master, origin/master, origin/HEAD)
      Author: NGUYEN <minh-tri.nguyen@efrei.net>
      Date:   Tue Feb 28 15:18:38 2023 +0100  
      first commit


4.
  * From *repo2* repository print *file.txt* content.  

    `cat file.txt`.  

    Output :  
    > ligne01

  * Add "ligne02" to *file.txt*, commit and print log.

    ```sh
    echo "ligne02" >> file.txt
    git add file.txt
    git commit -m "adding ligne02"
    git log
    ```

    Output :
    > commit 4b91077e460d5368787e60015928dcfb64fcb0ce (HEAD -> master)  
      Author: HADDIOUI <selim.haddioui@hotmail.com>  
      Date:   Tue Feb 28 15:26:57 2023 +0100  
      adding ligne02  
      commit 2da7fccddb28ad878cc96f1267449499d4dd5ab2 (origin/master, origin/HEAD)  
      Author: NGUYEN <minh-tri.nguyen@efrei.net>  
      Date:   Tue Feb 28 15:18:38 2023 +0100  
      first commit  

    We can see that the last commit has been done by HADDIOUI instead of NGUYEN for the previous one.

5.  
  * Push your commit into *3-remote*  

      `git push`.

6.  
  * Go back into *3-remote* and print log.  

    ```sh
    cd ../3-remote
    git log
    ```

    Output :
    > commit 4b91077e460d5368787e60015928dcfb64fcb0ce (HEAD -> master)  
      Author: HADDIOUI <selim.haddioui@hotmail.com>  
      Date:   Tue Feb 28 15:26:57 2023 +0100  
      adding ligne02  
      commit 2da7fccddb28ad878cc96f1267449499d4dd5ab2  
      Author: NGUYEN <minh-tri.nguyen@efrei.net>  
      Date:   Tue Feb 28 15:18:38 2023 +0100  
      first commit  

    We can see that commit are there but  *file.txt* isn't in *3-remote* repository. This is because, when we clone 3-remote we asked it to be a shared central repository that doesn't contain any working files such as *file.txt* in this case.  

7.
  * Go in *3-repo1* repository, add *3-remote* as "distant" remote and check that it did work.

    ```sh
    cd ../3-repo1
    git remote add distant ../3-remote
    git remote
    ```

    Output :
    > distant

8.
  * Fetch distant remote, print all branches available, get on new branches, and check files content.

    ```sh
    git fetch distant
    git branch -a
    ```

    Output :
    > * master  
      remotes/distant/master

    ```sh
    git checkout remotes/distant/master
    cat file.txt
    ```

    Output :
    > ligne01  
      ligne02  

9. (and 10.)
  * Get back on master branch, check file content, merge new branch with main and check again file content.

  ```sh
  git checkout master
  cat file.txt
  ```

  Output :
  > ligne01

  ```sh
  git merge remotes/distant/master
  cat file.txt
  ```

  Output :
  > ligne01  
    ligne02  

11.
  * Add a new line then push on distant.

    ```sh
    echo "ligne03" >> file.txt
    git add file.txt
    git commit -m "third line"
    git push distant master
    ```

12.
  * Go on *3-repo2*, fetch from *3-remote* using git pull and check file content.

    ```sh
    cd ../3-repo2
    git pull
    cat file.txt
    ```

    Output :
    > ligne01  
      ligne02  
      ligne03  

  * Add "ligne04", commit and push on remote.  

    ```sh
    echo "ligne04" >> file.txt
    git add file.txt
    git commit -m "adding ligne04"
    git push
    ```

13.
  * Back on *3-repo1*, pull these modifications.

  ```sh
  cd ../3-repo1
  git pull distant master
  ```

---  

[Preview](./2-branch.md)

[Next](./4-ide.md)  
