package assignment5;

import java.io.InputStream;
import java.io.OutputStream;

public class SerialOutput {

	public static void main(String[] args) {

		InputStream in = System.in;
		System.out.println("Enter a character:");
		try{
			SerialComm serial = new SerialComm();
			serial.connect("/dev/cu.usbserial-DN00MPMM");
			OutputStream out = serial.getOutputStream();
			ViewOutputStream vos = new ViewOutputStream(out);
			while (true) {
				if (in.available()>0) {
					int a = in.read();
					vos.write(a);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
