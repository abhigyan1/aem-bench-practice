package revisitingBasics;

import java.util.ArrayList;
import java.util.List;

public class Simple {
	
	public static void main(String[] args)
	{
		Simple simple = new Simple();
		simple.operations();
		simple.showResults();
	}
	List<String> lyear = new  ArrayList<String>();
	List<Car> lcar =new ArrayList<Car>();
	 List<Car> operations()
	{
		
		
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		car1.setModel("mercedez");
		car1.setNumber("1229");
		car1.setYear("2015");
		car2.setModel("swift");
		car2.setNumber("7563");
		car2.setYear("2016");
		car3.setModel("city");
		car3.setNumber("4234");
		car3.setYear("2017");
		
		
		lcar.add(car1);
		lcar.add(car2);
		lcar.add(car3);
		String cc ="";
		for(Car c : lcar)
		{			
			lyear.add(c.getYear());
		}
		return lcar;
	}
	
	 void showResults() 
	{
		try{
		
		System.out.println("the 1st year is"+lyear.get(0));
		System.out.println("the 1st year is"+lyear.get(1));
		System.out.println("the 1st year is"+lyear.get(2));
		int y = 0;
		String z="";
		if( y==3)
		{
			z="ok";
		}
		else
		{
			z="not ok";
		}
		
		z =lcar.get(0) != null ? "ok" :"not ok";
		System.out.println();
	//use ternary operator here
		if(lyear.get(3) != null) 
		{
		System.out.println("there is something more to this");	
		}
		else
		{
			System.out.println("happy for no exceptions");
		}
		
	}
		catch(ArithmeticException ee	)
		{
			System.out.println("oh have run out of data");
		}
}
}
