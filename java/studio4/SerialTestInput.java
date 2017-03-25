package studio4;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SerialTestInput {

	public static void main(String[] args) {
		SerialComm serial = new SerialComm();
		try {
			serial.connect("COM12");
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream stream = serial.getInputStream();
		ViewInputStream view_stream = new ViewInputStream(new BufferedInputStream(stream));
		
		System.out.println();
		while(true) {
			try {
				int available = view_stream.available();
				for (int i = 0; i < available; i++) {
					System.out.println(view_stream.read());
				}
			} catch (IOException e) {
				// FIXME Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
