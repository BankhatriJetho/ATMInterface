ATM Simulation Project
This project is a simple, console-based ATM simulation written in Java. It allows users to:

Sign up by creating a new user account with a custom PIN.
Log in using their user ID and PIN.
View transaction history.
Withdraw, deposit, and transfer funds between accounts.
It uses a collection of classes to model account holders, accounts, transactions, and the bank’s overall functionality, following object-oriented design principles.

Key Components
AccountHolder: Represents a single user with a name, user ID, and PIN.
Account: Represents a bank account, storing a balance and transaction history.
BankTransaction: Records individual transactions (deposits, withdrawals, transfers) with timestamps.
Bank: Manages users, their accounts, authentication, and fund transfers.
ATM: Provides a user interface with a menu system for login, sign up, and banking operations.
ATMMain: The entry point that launches the ATM simulation.
How to Run
Clone or download the repository.

Navigate to the project root directory.

Compile the code:
javac src/com/atmInterface/*.java
Run the program:
java src/com/atmInterface/ATMMain
(Adjust paths if necessary, depending on your setup.)

Upon starting, you will see a menu allowing you to sign up or log in.

If you Sign Up, you’ll be prompted to enter your name and PIN. A user ID will be generated and displayed.
If you Log In, enter the provided user ID and PIN to access your account.
Features
Sign Up & Log In: Users can create a new account and then log in with the generated user ID and chosen PIN.
View Transaction History: Users can view a list of past transactions, including deposits, withdrawals, and transfers.
Perform Transactions:
Deposit funds into your account.
Withdraw money if you have sufficient balance.
Transfer funds to another user’s account using their user ID.

Possible Modifications
There are many ways to extend and improve this project:

Multiple Accounts per User:
Allow each user to have multiple accounts (e.g., checking, savings). Modify the Bank class to manage a list of Account objects per user, and enhance the ATM interface to let users select which account to operate on.

Persistent Storage:
Currently, all data is in memory and is lost when the program stops. You can:

Integrate a file-based storage (CSV, JSON) to save users and transactions.
Use a database (e.g., SQLite or MySQL) for persistent storage and more robust data handling.
Enhanced Security:

Encrypt or hash PINs before storing them to improve security.
Implement lockout mechanisms after multiple failed login attempts.
Error Handling & Validation:
Improve input validation and error handling. For instance:

Confirm that PINs meet certain complexity rules (e.g., numeric only, specific length).
Handle non-numeric input for deposits, withdrawals, and transfers gracefully.
User Interface Improvements:

Add a GUI (Swing, JavaFX, or a web interface) to make the ATM more user-friendly.
Improve the console experience with better formatting and clearer instructions.
Customizable User ID Generation:
Right now, user IDs are generated based on the user’s name plus random digits. You can:
Offer multiple schemes (e.g., only numeric user IDs, or a configurable prefix).
Validate uniqueness by checking against existing user IDs in the Bank class.
Internationalization & Localization:
Add support for multiple languages or different currency formats.

Additional Features:
Implement a “change PIN” option within the ATM menu.
Add monthly statements or interest calculations if simulating a savings account.
