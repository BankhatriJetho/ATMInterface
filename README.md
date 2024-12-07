ATM Simulation Project
A simple console-based ATM application written in Java.

Features
Sign Up & Log In: Create a new user account with a chosen PIN and automatically generated user ID, then log in to access your account.
Transactions: View transaction history, deposit funds, withdraw cash (if your balance allows), and transfer money to other users.
User-Friendly: Menu-driven interface for easy navigation.
Getting Started

Compile:
javac src/com/atmInterface/*.java

Run:
java src/com/atmInterface/ATMMain
Use:

Choose to Sign Up: Enter name and PIN to get a user ID.
Log In with your user ID and PIN to perform ATM operations.


Potential Improvements
Multiple Accounts per User: Add multiple accounts (e.g., checking and savings).
Persistent Storage: Save user data and transactions to files or a database.
Enhanced Security: Hash/encrypt PINs, lock accounts after failed attempts.
GUI: Replace the console interface with a graphical interface.
Data Validation: Improve input handling and error message
