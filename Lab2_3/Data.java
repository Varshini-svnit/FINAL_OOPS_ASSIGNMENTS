package Lab2;

public class Data {

    private int day;
    private int month;
    private int year;

    public Data() {
        this.day = 12;
        this.month = 3;
        this.year = 1993;
    }

    public Data(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Data(Data other) {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    public void display() {
        System.out.printf("Date: %02d-%02d-%04d%n", day, month, year);
    }

    public static void main(String[] args) {
        Data defaultDate = new Data();
        defaultDate.display();

        Data customDate = new Data(15, 8, 1947);
        customDate.display();

        Data copiedDate = new Data(customDate);
        copiedDate.display();
    }
}
