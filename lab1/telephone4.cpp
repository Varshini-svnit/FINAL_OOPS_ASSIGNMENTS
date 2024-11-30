#include <iostream>
#include <string>

using namespace std;

class Customer {
private:
    string name;
    int numberOfCalls;
    double billAmount;

public:
    void inputData() {
        cout << "Enter customer's name: ";
        cin.ignore();
        getline(cin, name);
        cout << "Enter number of calls made: ";
        cin >> numberOfCalls;
    }

    void computeBill() {
        if (numberOfCalls <= 100) {
            billAmount = 200.0;
        } else if (numberOfCalls <= 150) {
            billAmount = 200.0 + (numberOfCalls - 100) * 0.60;
        } else if (numberOfCalls <= 200) {
            billAmount = 200.0 + 50 * 0.60 + (numberOfCalls - 150) * 0.50;
        } else {
            billAmount = 200.0 + 50 * 0.60 + 50 * 0.50 + (numberOfCalls - 200) * 0.40;
        }
    }

    void displayData() const {
        cout << "Customer's Name: " << name << endl;
        cout << "Total Calls Made: " << numberOfCalls << endl;
        cout << "Telephone Bill Amount: Rs. " << billAmount << endl;
    }
};

int main() {
    Customer customer;

    
    customer.inputData();

   
    customer.computeBill();

    
    cout << "\nCustomer Details and Bill:\n";
    customer.displayData();

    return 0;
}
