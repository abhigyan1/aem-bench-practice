package revisitingBasics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterDataIntoCsv {
public static void main (String[] argsv)
{
	FileWriter fw = null;
	try
	{
		fw = new FileWriter("D://real/car.xls");
		fw.append("model");
		fw.append(",");
		fw.append("year");
		fw.append("\n");
		Simple simple = new Simple();
		List<Car> lcar = simple.operations();
		for(Car car : lcar)
		{
			fw.append(car.getModel());
			fw.append(",");
			fw.append(car.getYear());
			fw.append(",");
			fw.append(car.getNumber());
			fw.append("\n");
		}
	
	
	}
	catch(Exception e)
	{
		System.out.println("error is"+e);
	}
	finally{
		try {
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
}
