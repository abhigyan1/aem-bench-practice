package revisitingBasics;

public class Car {
private String model;
private String year;
private String number;
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

public Car(String model, String year, String number)
{
	super();
	
	        this.model = model;
	
	        this.year = year;
	
	        this.number=number;
	
}
public Car() {
	// TODO Auto-generated constructor stub
}
	
}
