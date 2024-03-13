**Description of Project:**
          The Simple Library Management System is a Java-based console application designed to facilitate basic library operations such as adding users, adding books, issuing books to users, and returning books. The system allows librarians to manage the library's inventory and track book borrowing activities by users.
**Instruction:**
        To run this file you will need a JDK(java development kit) with a java IDE. Run the Main java class on the IDE to use this system.
**Features:**

Add User: Librarians can add new users to the library system by providing their unique ID, name, and contact information.

Add Book: Librarians can add new books to the library catalog by specifying the book's ID, title, author, and genre. Each book is assigned a unique identifier and its availability status is set to true by default.

Issue Book: Librarians can issue books to users by specifying the user's ID and the book's ID. The system checks the availability of the book and updates its availability status accordingly. The book is then added to the user's list of borrowed books.

Return Book: Users can return borrowed books to the library by providing their ID and the book's ID. The system removes the book from the user's list of borrowed books and updates its availability status to true.

Display Book Details: The system provides the option to display detailed information about a specific book, including its title, author, genre, and availability status.

File Handling: The system utilizes file handling to store library. Book and user information is stored in binary files (books.ser and users.ser), allowing the system to load existing data when it starts and save new data when it exits.
