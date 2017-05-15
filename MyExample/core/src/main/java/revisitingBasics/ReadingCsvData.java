package revisitingBasics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.jackrabbit.oak.plugins.memory.ArrayBasedBlob;

public class ReadingCsvData {

	public static void main(String[] args)
	{
		String csvFile = "C://Users/acha71/Desktop/ref.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] car = line.split(cvsSplitBy);
             
                List list = (List) Arrays.asList(car);
                
                
              // String[] x = mySet.toArray(new String[mySet.size()]);
                System.out.println(""+list.get(0)+"");
                

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

		
	}
}
