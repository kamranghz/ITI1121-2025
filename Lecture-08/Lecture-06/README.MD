# ITI1121-2025: Introduction to Computing II

This repository contains the source code and examples for the **ITI1121: Introduction to Computing II** course at the University of Ottawa for Winter 2025. The code illustrates key programming concepts and best practices in **Java**.



### Key Files and Folders
- **bank**: Contains examples of encapsulation, access modifiers (private, protected, public, and default), and final methods in a `BankAccount` class.
- **Constructor**: Illustrates different types of constructors:
  - Default Constructor
  - Parameterized Constructor
  - Private Constructor
- **Clock.java**: Demonstrates normalization and encapsulation in a clock-based example.
- **DigitalClock.java**: Enhances the clock example with setter validations and modularization.
- **SimpleBankAccount.java**: Explains class variables (`static`), instance variables, and shared behavior in a banking example.
- **Time.java**: Focuses on normalization, object equality, and encapsulation.

## Key Concepts Demonstrated

### Object-Oriented Programming
- **Encapsulation**: Using private variables and public methods for controlled access.
- **Access Modifiers**: Examples include private, default (package-private), protected, and public.
- **Final Keyword**: Demonstrates final variables, methods, and their impact.
- **Constructors**: Explains the differences between default, parameterized, and private constructors.

### Practical Examples
1. **BankAccount**:
   - Encapsulates account data.
   - Demonstrates protected and private methods.
   - Uses `final` methods to prevent modification.

2. **Clock and DigitalClock**:
   - Normalizes time.
   - Validates time through setters.
   - Illustrates modular programming.

3. **SimpleBankAccount**:
   - Shows the impact of `static` variables and methods on shared behavior.

4. **Time**:
   - Highlights object equality.
   - Demonstrates safe updates with normalization.

## Example Execution

### Running the Code
1. Clone the repository:
   ```bash
   git clone https://github.com/kamranghz/ITI1121-2025.git
   ```
2. Navigate to a specific lecture folder:
   ```bash
   cd ITI1121-2025/Lecture-06
   ```
3. Compile the code:
   ```bash

   javac bank/BankAccount.java
   ```
4. Run the program:
   ```bash
   java bank.BankAccount
   ```

### Example Output
**BankAccount**:
```plaintext
Bank Name: National Bank
Deposited $1000.0. New balance: $6000.0
Withdrew $2000.0. Remaining balance: $4000.0
Balance: $4000.0
Account Holder: John Doe
Account Number: 123456789
Bank Branch: Default Branch
```

## Contribution
Contributions to improve the examples or add new concepts are welcome. Please submit a pull request or create an issue for discussion.

## License
This repository is for educational purposes and follows the academic code of conduct. Please contact the course instructor for any issues regarding usage.
