# Point of Sale (POS) System

## Overview
This is a simple **Point of Sale (POS) System** written in Java. It allows cashiers to log in, process sales, generate bills, and manage products. The system reads product and cashier data from CSV files and provides an interactive command-line interface for operations.

## Features
- Load product and cashier data from CSV files.
- Register new cashiers and authenticate them.
- Process sales by adding products to a bill.
- Apply random discounts to purchased items.
- Generate a total bill and handle payments.

## Project Structure
```
├── Main.java           # Entry point of the application
├── Cashers.java        # Handles cashier login and registration
├── Product.java        # Represents products with attributes like name, price, weight, etc.
├── billGenarator.java  # Manages bill creation and cost calculations
├── billItems.java      # Represents individual items in a bill
```

## Installation & Setup
1. **Clone the repository** (or download the source files).
   ```sh
   git clone <repo-url>
   cd pos-system
   ```

2. **Prepare CSV files** for cashiers and products:
   - `Cashiers.csv` (Format: `name,password`)
   - `Product.csv` (Format: `code,name,quantity,price,weight,unit,company`)

3. **Compile and Run the project:**
   ```sh
   javac *.java
   java Main
   ```

## Usage
1. Run the program and choose an option:
   - Register a new cashier.
   - Log in as a cashier.
   - Exit the system.
2. After logging in, the cashier can:
   - View available products.
   - Add products to a bill.
   - Process payments and generate a final bill.

## Example Output
```
***** Welcome to POS System *****
1 - Register new cashier
2 - Login to the POS system
3 - Exit
Choose number: 2
Enter cashier's name: JohnDoe
Enter your password: ******
Successful login!
These following products are in stock:
101 : Laptop : Rs. 50000.0
102 : Mouse : Rs. 800.0
What do you want to buy (Enter product Code): 101
How many 101 do you want to buy (quantity): 1
Your total bill is 47500.00 (with discount)
Payment: 50000
Exchange: 2500.00
Thank you! Have a nice day.
```

## Future Enhancements
- Add a database for better data storage.
- Implement a GUI for a better user experience.
- Improve error handling and input validation.

## Author
- R.P Thilokya Angeesa

## License
This project is open-source. Feel free to modify and distribute it.

---
This README provides a clear guide for understanding, installing, and running your POS system. Let me know if you want any modifications! 🚀