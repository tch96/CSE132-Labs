package assignment4;

import studio4.SerialComm;
import java.io.*;

public class MsgReceiver {

	final private ViewInputStream vis;
	final private DataInputStream dis;
	public enum State {magicNumber, debug, error, timestamp, potential, rawTemp, convTemp, filtTemp};

	public MsgReceiver(InputStream in) {
		vis = new ViewInputStream(in);
		dis = new DataInputStream(vis);
	}

	public void run() {
		// insert code here
		// read from vis and write to console

		try {
			while (true) {
				if (vis.available()>0) {
					State nextState = State.magicNumber;
					
					switch(nextState){
					case magicNumber :
						byte b = (byte)vis.read();
						if (b == 0x30){
							nextState = State.debug;
							System.out.println("Debug: " + dis.readUTF());
						}
						else if (b == 0x31){
							nextState = State.error;
							System.out.println("High Alarm");
						}
						else if (b == 0x32){
							nextState = State.timestamp;
							System.out.println("Time: " + dis.readInt());
							break;
						}
						else if (b == 0x33){
							nextState = State.potential;
							System.out.println("Potential: " + dis.readShort());
						}
						else if (b == 0x34){
							nextState = State.rawTemp;
							System.out.println("RawTemp: " + dis.readShort());
						}
						else if (b == 0x35){
							nextState = State.convTemp;
							System.out.println("ConvTemp: " + dis.readInt()/1000);
						}
						else if (b == 0x36){
							nextState = State.filtTemp;
							System.out.println("FiltTemp: " + dis.readInt()/1000);
						}
//						else nextState = State.magicNumber;
//						break;
//
//
//					case debug:
//						nextState = State.magicNumber;
//						System.out.println("Debug: " + dis.readUTF());
//					case error:
//						nextState = State.magicNumber;
//						System.out.println(dis.readUTF());
//						break;
//					case timestamp:
//						nextState = State.magicNumber;
//						System.out.println("Time: " + dis.readInt());
//						break;
//					case potential:
//						nextState = State.magicNumber;
//						System.out.println("Potential: " + dis.readShort());
//						break;
//					case rawTemp:
//						nextState = State.magicNumber;
//						System.out.println("RawTemp: " + dis.readShort());
//						break;
//					case convTemp: 
//						nextState = State.magicNumber;
//						System.out.println("ConvTemp: " + dis.readInt()/1000);
//						break;
//					case filtTemp:
//						nextState = State.magicNumber;
//						System.out.println("FiltTemp: " + dis.readInt()/1000);
//						break;
//					default:
//						nextState = State.magicNumber;
//						System.out.println("error");
//						break;
//					}
//					state = nextState;	
				}
			}
		}
		}catch (IOException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try
		{        	
			SerialComm s = new SerialComm();
			s.connect("COM11"); // Adjust this to be the right port for your machine
			InputStream in = s.getInputStream();
			MsgReceiver msgr = new MsgReceiver(in);
			msgr.run();
		}
		catch ( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
