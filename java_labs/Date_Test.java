package java_labs;

class date{
	int month;
	int day;
	int year;
	
	public date(int month,int day,int year) {
		this.month=month;
		this.day=day;
		this.year=year;
	}
	
	    public int getMonth() {
	        return month;
	    }

	    public void setMonth(int month) {
	        this.month = month;
	    }

	    public int getDay() {
	        return day;
	    }

	    public void setDay(int day) {
	        this.day = day;
	    }

	
	    public int getYear() {
	        return year;
	    }

	    public void setYear(int year) {
	        this.year = year;
	    }

	    public String displayDate() {
	        return month + "/" + day + "/" + year;
	    }
}



public class Date_Test {
	   public static void main(String[] args) {
	       
	        date date1 = new date(10, 8, 2024);

	        System.out.println("Initial date: " + date1.displayDate());

	        date1.setMonth(10);
	        date1.setDay(7);
	        date1.setYear(2024);

	        System.out.println("Modified date: " + date1.displayDate());

	        System.out.println("Month: " + date1.getMonth());
	        System.out.println("Day: " + date1.getDay());
	        System.out.println("Year: " + date1.getYear());
	    }
	}


