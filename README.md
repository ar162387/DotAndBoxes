## A Git, GitLab, and JUnit exercise

This assignment is intended to give you a relatively small exercise to give you a little familiarisation working with Git, Gradle,
JUnit, and JavaFX on a very small codebase - before you and your group do something much more exciting on the much larger
class-wide project.

The example code you have been given is a simple JavaFX "dots and boxes" game. It has a couple of known bugs in it
(already commented for you - the task is not really in finding the bugs). Please note: your task **is not simply to fix the bugs**. 
Your task is a series of steps that show you can work with git, gitlab, gradle, and junit.

You will notice that this is a git repository, but it is provided to you just as a zip that you download.
If you run `git status`, you should see that you are on branch `main`.

Your tasks:

1. Create a repository on gitlab.une.edu.au and push this code to it **entirely unmodified**. 
   It will be on a branch called 'main'  
   **You will need to set the visibility on your repository so that the marker can read from it**. 
   Repositories we cannot access cannot be marked (and will receive 0 until you can fix it)
   
2. Set your name and email on the repository for your future commits, using `git config`

3. Update the "name" label in the application to show **your name**.
   Commit this change and push it to your **main** branch.

3. Create an Issue in your GitLab project for fixing the errors in the assignment.
4. Create and check out a branch for your bugfix. 
   This should follow the convention of having the issue number, followed by a hyphenated description of the issue.
   e.g. `1-fix-assignment-errors`.  
   Push this branch to the remote repository. (From here on, I'll refer to this as your "issue branch")

5. Create **unit tests** that will detect the errors in the code. Particularly:
   * That the algorithm for testing whether a box is complete is wrong.
   * That the DotsAndBoxesGrid currently permits you to "draw" a line that has already been drawn, whereas it should throw an exception.
    
6. Commit these unit tests with an appropriately descriptive commit message.  
   **Do not fix the bugs in this commit. The unit tests should *fail*.**    

7. **Tag** this commit, with the label `testsfail`

8. Fix the bugs in the code. Run your unit tests again. The tests should now pass.

9. Commit your bugfix. Push it to your issue branch.

10. Check out `main`. Merge your issue branch to main. The tests should still pass. Push this to your gitlab repository.

11. Close your issue with a reference to the commit hash in which you fixed the bugs.

12. Paste the link to your gitlab repository into the assignment and submit.

Marking. 

1. You have submitted a link to your repository on gitlab.une.edu.au and it is visible to the marker (1 point)
2. The first commit on the main branch on the repository contains the starter code, showing me as author and the same
   commit hash as in the original code I gave you. (i.e. you successfully pushed the original code I gave you to your repository). (1 point)
3. The second commit on the main branch adds your name to the label and shows you as author  
   (i.e. you have successfully configured your name & email and you have successfully created and pushed a commit) (1 point)
4. You have an issue on your repository for the bugfixing. It is closed referencing the bugfix commit. (1 point)
5. There is a `testsfail` tag in your repository (1 point)
6. Checking out the `testsfail` tag, and running the `gradlew test`, produces two failed tests (one for each bug). (2 points)
7. Checking out the main branch, both tests are present and pass (2 points)
8. The most recent commit on the `main` branch is a merge commit, merging the commit in which you set your name on the label
   and the commit in which you fixed the tests. (1 point)
