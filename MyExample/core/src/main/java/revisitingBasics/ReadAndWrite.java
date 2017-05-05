package revisitingBasics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Why we need this is because we need to move folder from one destination to another
public class ReadAndWrite {

	
	public static void main(String[]args)
{
		try {
			Files.move(Paths.get("D:\\real\\cars.xls"), Paths.get("D:\\real\\carsss.xls"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
