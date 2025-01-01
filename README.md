# Contact Directory Application

This project is a simple Java-based contact directory application that allows users to perform basic CRUD (Create, Read, Update, Delete) operations on a MySQL database.

---

## Features

- Add a contact (Name, Phone Number, Email).
- View all saved contacts.
- Update contact details by ID.
- Delete a contact by ID.

---

## Prerequisites

1. **MySQL Server:** Ensure MySQL is installed and running on your system.
2. **Java JDK:** Install Java Development Kit (version 8 or later).
3. **MySQL Connector JAR:** Download the MySQL Connector JAR file from [MySQL's official website](https://dev.mysql.com/downloads/connector/j/).

---

## Setup

### 1. Create the Database

Start MySQL and create the required database and table:

```sql
CREATE DATABASE contact_directory;
USE contact_directory;

CREATE TABLE Contacts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

### 2. Configure Database Credentials

Update the `DatabaseConnector` class with your MySQL credentials:

```java
private static final String URL = "jdbc:mysql://localhost:3306/contact_directory";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

### 3. Add MySQL Connector JAR to Classpath

- Place the downloaded JAR file (e.g., `mysql-connector-java-8.x.x.jar`) in your project directory or a `lib` folder.
- Include it in the classpath when compiling and running the application.

---

## Running the Application

### 1. Compile the Java Files

```bash
javac -cp .:mysql-connector-java-8.x.x.jar *.java
```

On Windows, replace `:` with `;` in the classpath.

### 2. Run the Application

```bash
java -cp .:mysql-connector-java-8.x.x.jar ContactDirectoryApp
```

---

## Application Menu

1. **Add a Contact:** Enter name, phone number, and email.
2. **View All Contacts:** Displays all contacts saved in the database.
3. **Update a Contact:** Update a contact's phone number by ID.
4. **Delete a Contact:** Remove a contact by ID.
5. **Exit:** Close the application.

---

## Troubleshooting

### Error: `java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver`

- Ensure the MySQL Connector JAR file is included in the classpath.
- Verify the driver class name in `DatabaseConnector` is correct:
  ```java
  Class.forName("com.mysql.cj.jdbc.Driver");
  ```

### Error: `Access Denied for User`

- Double-check the username and password in the `DatabaseConnector` class.
- Ensure the MySQL user has access to the `contact_directory` database:
  ```sql
  GRANT ALL PRIVILEGES ON contact_directory.* TO 'your_username'@'localhost';
  ```

---

## Enhancements

- Add input validation for phone numbers and email addresses.
- Implement a graphical user interface (GUI) using JavaFX or Swing.
- Export contact data to a file.

---

## License

This project is open-source and available under the MIT License.
