# Java SMS Messaging System

**Author:** Jack Male 

**Note:** This project was completed under test conditions within **3 hours**.  

## Overview
A Java-based SMS messaging system demonstrating object-oriented programming, file I/O, and simple message encryption/decryption. The system reads SMS data from a CSV file, processes messages, displays them in the console, and writes them to an output file. Confidential messages are handled securely with a simple decryption method.

## Features
- Abstract `Message` class for message hierarchy  
- `SmsMessage` class with:
  - Message metadata (ID, sender, receiver, timestamp)
  - Validity period handling
  - Confidential message flag
- `MessageServer` class:
  - Reads SMS data from `sms_message.csv`
  - Displays all message content in the console
  - Writes processed messages to `message_sent.csv`
- `WriteMessagesToFile` implements `Runnable` for asynchronous file writing
- Unit testing with JUnit 5 (`SmsMessageTest`)

## Dependencies
- Java 11 or higher  
- JUnit 5 for testing  

## How to Run
1. Compile the Java source files:
```bash
javac -d bin src/p3/*.java
```
2. Ensure sms_message.csv is in the project root or update the path in MessageServer.java.

3. Run the server:
   java -cp bin p3.MessageServer

4.  Processed messages will be written to message_sent.csv.

## Testing

The Unit tests cover constructors, getters/setters, and confidential message handling. They are located in testing/SmsMessageTest.java. Run using JUnit 5 from the project root:
```bash
javac -cp .:path_to_junit_jar testing/SmsMessageTest.java

java -cp .:path_to_junit_jar org.junit.runner.JUnitCore messageSystem.SmsMessageTest
```

## Notes

- Confidential messages are decrypted by shifting letters back by 1.

- Message display truncates messages longer than 20 characters.

- This project demonstrates OOP principles and basic file handling in Java.
