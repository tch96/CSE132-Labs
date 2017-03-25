package assignment10;

import java.io.*;
import studio4.SerialComm;

public class Health {
	final private ViewInputStream vis;
	final private DataInputStream dis;
	
	public Health (InputStream in) {
		vis = new ViewInputStream(in);
		dis = new DataInputStream(vis);
	}

	public void run() {
		try {
			while (true) {
				if (vis.available()>0) {
					byte b = (byte)vis.read();
					if (b==0x21) {
						System.out.println("Steps: " + dis.readShort());
					}
					else if (b==0x31) {
						System.out.println("Temperature: " + dis.readFloat());
					}
					else if (b==0x22) {
						System.out.println("Pulse: " + dis.readInt()/100.0);
					}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try
		{        	
			SerialComm s = new SerialComm();
			s.connect("/dev/cu.usbserial-DN00N75Z"); // Adjust this to be the right port for your machine
			InputStream in = s.getInputStream();
			Health msgReceiver = new Health(in);
			msgReceiver.run();
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
