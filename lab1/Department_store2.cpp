#include <iostream>
#include <iomanip>

using namespace std;

double calculateTotal(int miners, int toasters, int fans) {

    const double minerCost = 1500.0;
    const double toasterCost = 200.0;
    const double fanCost = 450.0;

    const double minerDiscount = 0.05;   
    const double toasterDiscount = 0.10; 
    const double fanDiscount = 0.15;     

    const double salesTaxRate = 0.10;

    double minerNetCost = miners * minerCost * (1 - minerDiscount);
    double toasterNetCost = toasters * toasterCost * (1 - toasterDiscount);
    double fanNetCost = fans * fanCost * (1 - fanDiscount);

    double totalNetCost = minerNetCost + toasterNetCost + fanNetCost;

    double totalCost = totalNetCost * (1 + salesTaxRate);

    return totalCost;
}

int main() {
    int miners, toasters, fans;

    cout << "Enter the number of miners: ";
    cin >> miners;
    cout << "Enter the number of toasters: ";
    cin >> toasters;
    cout << "Enter the number of fans: ";
    cin >> fans;

    double totalAmount = calculateTotal(miners, toasters, fans);

    cout << fixed << setprecision(2);
    cout << "The total amount to be paid by the store is Rs. " << totalAmount << endl;

    return 0;
}
