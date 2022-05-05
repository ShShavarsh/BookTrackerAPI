Book Tracker API

Scenario:  You are a developer for a large bookstore that wants to release a book tracker application.  You have been assigned to build a back-end service to keep track of the book list.  Other teams will be working on other aspects of the application, including the front end UI for the application.
On the next page you’ll see the first story for the MVP of the application.  
Read over the story and acceptance criteria, then move on to the next page for more details about what to do with this activity. 



As an avid reader I want to be able to keep track of the list of books I’ve recently read so that I can remember what I’ve read.
AC1:  When I enter the title, author, year of publication, and length of the book into the UI and hit submit, my book will saved to the list.
AC2:  When I click “View All Books” the application will display a list of all the books in my list.
AC3: When I click the checkbox next to a book, and then the press the “Delete Book” button, the application will remove the book from my list.
AC4: When I click the checkbox next to a book, and then press the “Update Book” button, the application will allow me to update any of the information about the book.

For this version you can keep all data in memory - we’ll add a database later.
The story and acceptance criteria assume there is a front end.  As a backend developer you’ll have to implement this without the benefit of the front end.  A you do so think about the conversations you’d need to have with a front end team to make sure they can consume your API.
All production code should be backed by tests, so use Test Driven Development.
User Spring Initializr support in VSCode (or whatever IDE you choose) to generate your project.
Do an initial push to Github immediately after generating the code.  
Commit after each failing test is written, then when it passes (at a minimum).
Push after each passing test.