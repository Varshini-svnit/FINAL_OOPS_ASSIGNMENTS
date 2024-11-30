#include <iostream>
#include <string>

using namespace std;

struct Publication {
    string title;
    double price;
    string author;

    void getData() {
        cout << "Enter title: ";
        cin.ignore();
        getline(cin, title);
        cout << "Enter price: ";
        cin >> price;
        cout << "Enter author's name: ";
        cin.ignore();
        getline(cin, author);
    }

    void display() const {
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
        cout << "Author: " << author << endl;
    }
};

struct Book : public Publication {
    int pages;

    void getData() {
        Publication::getData();
        cout << "Enter number of pages: ";
        cin >> pages;
    }

    void display() const {
        Publication::display();
        cout << "Pages: " << pages << endl;
    }
};

struct Ebook : public Publication {
    double time;

    void getData() {
        Publication::getData();
        cout << "Enter playing time (hours): ";
        cin >> time;
    }

    void display() const {
        Publication::display();
        cout << "Playing Time: " << time << " hours" << endl;
    }
};

int main() {
    Book book;
    Ebook ebook;

    cout << "'Enter details for the Book'->\n";
    book.getData();
    cout << "\nBook Details->\n";
    book.display();

    return 0;
}
