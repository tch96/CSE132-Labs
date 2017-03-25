package studio10;

import java.io.*;
import java.util.ArrayList;;

public class ButterworthFilter {

	public static void main(String[] args) {
		// FIXME Auto-generated method stub
		try {
			File import_data = new File("data/studio10/file_name");
			FileReader data = new FileReader(import_data);
			BufferedReader buffer = new BufferedReader(data);
			ArrayList<Double> dataArray = new ArrayList();
			System.out.println(buffer.readLine());
		
			while (buffer.ready()) {
				String dataString = buffer.readLine();
				double stringDouble = Double.parseDouble(dataString);
				dataArray.add(stringDouble);
			}

			double[] filterArray = new double[dataArray.size()];
			for (int i=0; i<dataArray.size(); ++i) {
				filterArray[i+2] = 
						b0*dataArray.get(i) +
						b1*data
			}
		}
		catch (Exception e){
			System.out.println("error");
		}
	}

}
