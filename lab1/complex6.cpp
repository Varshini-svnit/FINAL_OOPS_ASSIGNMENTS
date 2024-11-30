#include <iostream>
using namespace std;

struct Complex {
    int real;
    int imag;
};

Complex add(Complex a, Complex b) {
    Complex result;
    result.real = a.real + b.real;
    result.imag = a.imag + b.imag;
    return result;
}

Complex sub(Complex a, Complex b) {
    Complex result;
    result.real = a.real - b.real;
    result.imag = a.imag - b.imag;
    return result;
}

Complex mul(Complex a, Complex b) {
    Complex result;
    result.real = a.real * b.real - a.imag * b.imag;
    result.imag = a.real * b.imag + a.imag * b.real;
    return result;
}

Complex div(Complex a, Complex b) {
    Complex result;
    int denominator = b.real * b.real + b.imag * b.imag;
    if (denominator == 0) {
        cout << "Division by zero is not possible." << endl;
        result.real = result.imag = 0;
    } else {
        result.real = (a.real * b.real + a.imag * b.imag) / denominator;
        result.imag = (a.imag * b.real - a.real * b.imag) / denominator;
    }
    return result;
}

void menu() {
    cout << "Choose an operation to perform on two complex numbers:" << endl;
    cout << "1. Addition" << endl;
    cout << "2. Subtraction" << endl;
    cout << "3. Multiplication" << endl;
    cout << "4. Division" << endl;
    cout << "5. Exit" << endl;
}

int main() {
    Complex a, b, result;
    int choice;

    // Input complex numbers
    cout << "Enter the real and imaginary part of the first complex number: ";
    cin >> a.real >> a.imag;
    cout << "Enter the real and imaginary part of the second complex number: ";
    cin >> b.real >> b.imag;

    do {
        menu();
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            result = add(a, b);
            cout << "Result: " << result.real << " + " << result.imag << "i" << endl;
            break;
        case 2:
            result = sub(a, b);
            cout << "Result: " << result.real << " + " << result.imag << "i" << endl;
            break;
        case 3:
            result = mul(a, b);
            cout << "Result: " << result.real << " + " << result.imag << "i" << endl;
            break;
        case 4:
            result = div(a, b);
            cout << "Result: " << result.real << " + " << result.imag << "i" << endl;
            break;
        case 5:
            cout << "Exiting..." << endl;
            break;
        default:
            cout << "Invalid choice. Try again." << endl;
        }
    } while (choice != 5);

    return 0;
}
