# Bookstore_Manager

This project demonstrates the principles of Object-Oriented Programming (OOP) using a bank account system as an example. The project includes the following classes and interfaces:

BankAccount: A class that represents a bank account. It demonstrates the OOP principle of encapsulation by keeping the balance private and providing public methods to manipulate it.
SavingsAccount: A class that represents a savings account. It extends BankAccount and demonstrates the OOP principle of inheritance. It adds an interest rate and the ability to apply interest to the balance.
BankTransaction: A class that represents a bank transaction. It demonstrates the OOP principle of polymorphism by having methods that accept both BankAccount and SavingsAccount objects.
Transaction: An interface that represents a transaction. It demonstrates the OOP principle of abstraction.
DepositTransaction: A class that represents a deposit transaction. It implements the Transaction interface.
WithdrawalTransaction: A class that represents a withdrawal transaction. It implements the Transaction interface.
The project includes a main method that demonstrates how to use these classes and interfaces to create and manipulate bank accounts, savings accounts, and transactions.

Getting Started
To get started with this project, you will need to have a Java development environment set up on your computer. You can download the Java Development Kit (JDK) from the Oracle website.

Once you have the JDK installed, you can compile and run the project using the following commands:

Edit
Full Screen
Copy code
javac Main.java
java Main
This will compile the project and run the main method.

Class Descriptions
BankAccount
The BankAccount class represents a bank account. It has the following methods:

deposit: Deposits the specified amount into the bank account.
withdraw: Withdraws the specified amount from the bank account if sufficient funds are available.
getBalance: Returns the current balance of the bank account.
SavingsAccount
The SavingsAccount class represents a savings account. It extends BankAccount and has the following methods:

applyInterest: Applies the interest to the balance of the savings account.
BankTransaction
The BankTransaction class represents a bank transaction. It has the following methods:

executeTransaction: Executes a deposit transaction on the specified bank account.
executeTransaction: Executes a deposit transaction on the specified savings account and applies interest.
Transaction
The Transaction interface represents a transaction. It has the following method:

execute: Executes the transaction with the specified amount.
DepositTransaction
The DepositTransaction class represents a deposit transaction. It implements the Transaction interface and has the following methods:

execute: Executes the deposit transaction with the specified amount.
WithdrawalTransaction
The WithdrawalTransaction class represents a withdrawal transaction. It implements the Transaction interface and has the following methods:

execute: Executes the withdrawal transaction with the specified amount.
Main Method
The main method in the Main class demonstrates how to use these classes and interfaces to create and manipulate bank accounts, savings accounts, and transactions.

It creates a BankAccount object and performs some deposit and withdrawal transactions on it. It also creates a SavingsAccount object and applies interest to it. Finally, it creates DepositTransaction and WithdrawalTransaction objects and executes them on a BankAccount object.

License
This project is licensed under the MIT License.
