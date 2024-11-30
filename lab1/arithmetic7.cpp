#include <iostream>
using namespace std;

struct Arithmetic {
    int no1;
    int no2;
};

void add(Arithmetic a) {
    cout << "Addition: " << a.no1 + a.no2 << endl;
}

void sub(Arithmetic a) {
    cout << "Subtraction: " << a.no1 - a.no2 << endl;
}

void mul(Arithmetic a) {
    cout << "Multiplication: " << a.no1 * a.no2 << endl;
}

void div(Arithmetic a) {
    if (a.no2 != 0) {
        cout << "Division: " << static_cast<double>(a.no1) / a.no2 << endl;
    } else {
        cout << "Division: Cannot divide by zero!" << endl;
    }
}

void menu(Arithmetic a) {
    int choice;
    bool run = true;

    while (run) {
        cout << "\nChoose an operation:\n";
        cout << "1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                add(a);
                break;
            case 2:
                sub(a);
                break;
            case 3:
                mul(a);
                break;
            case 4:
                div(a);
                break;
            case 5:
                cout << "Exiting the program." << endl;
                run = false;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    }
}

int main() {
    Arithmetic numbers;

    cout << "Enter the first number: ";
    cin >> numbers.no1;
    cout << "Enter the second number: ";
    cin >> numbers.no2;

    menu(numbers);

    return 0;
}
