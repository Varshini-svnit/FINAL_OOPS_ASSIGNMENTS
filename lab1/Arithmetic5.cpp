#include <iostream>
using namespace std;

struct Arithmetic {
    int no1;
    int no2;
};

void add(Arithmetic numbers) {
    cout << "Addition: " << numbers.no1 + numbers.no2 << endl;
}

void sub(Arithmetic numbers) {
    cout << "Subtraction: " << numbers.no1 - numbers.no2 << endl;
}

void mul(Arithmetic numbers) {
    cout << "Multiplication: " << numbers.no1 * numbers.no2 << endl;
}

void div(Arithmetic numbers) {
    if (numbers.no2 != 0)
        cout << "Division: " << static_cast<double>(numbers.no1) / numbers.no2 << endl;
    else
        cout << "Division: Cannot divide by zero!" << endl;
}

int main() {
    Arithmetic numbers;

    // Input numbers
    cout << "Enter the first number: ";
    cin >> numbers.no1;
    cout << "Enter the second number: ";
    cin >> numbers.no2;

    // Perform operations
    add(numbers);
    sub(numbers);
    mul(numbers);
    div(numbers);

    return 0;
}
