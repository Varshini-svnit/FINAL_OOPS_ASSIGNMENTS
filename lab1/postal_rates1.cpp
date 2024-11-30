#include <iostream>
#include <cmath>

using namespace std;


struct Letter {
    double weight;
    union {
        double postage;
    };
};

// Function to calculate postage
double calculatePostage(double weight) {
    if (weight <= 0) {
        return -1; 
    }

    double postage = 0.0;

    if (weight <= 50) {
        postage = ceil(weight / 10) * 0.50;
    } else if (weight <= 150) {
        postage = 5.0; 
        
        weight -= 50;
        postage += ceil(weight / 10) * 0.40;
    } else if (weight <= 400) {
       
        postage = 5.0 + 4.0; 
        weight -= 150;
        postage += ceil(weight / 10) * 0.25;
    } else {
        postage = (weight / 1000) * 25; // Rs. 25 per kilogram
    }

    return postage;
}

int main() {
    Letter letter;

    cout << "Enter the weight of the letter in grams: ";
    cin >> letter.weight;

    if (letter.weight <= 0) {
        cout << "Invalid weight entered." << endl;
        return 1;
    }

    
    letter.postage = calculatePostage(letter.weight);

    
    cout << "The postage to be paid is Rs. " << letter.postage << endl;

    return 0;
}
