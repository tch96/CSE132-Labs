package studio4;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;

public class ViewInputStream extends FilterInputStream {

    final private PrintStreamPanel psp;
    final private PrintStream ps;
    
    final private PrintStreamPanel frame;

    public ViewInputStream(InputStream in) {
        super(in);
 
        psp = new PrintStreamPanel();
        ps = psp.getPrintStream(); 
        
		JFrame f = new JFrame("Demo");
		f.setBounds(100,100,225,300);
		this.frame = new PrintStreamPanel(Color.YELLOW, "demo", 170);
		f.getContentPane().add(frame);
		f.setVisible(true);
    }

    public static String intToHex(int i) {
    	String chars = "0123456789abcdef";
    	int digit1 = i % 16;
    	int digit2 = i / 16;
    	String hex = " " + chars.charAt(digit2) + chars.charAt(digit1);
    	return hex;
    }
    
    public int read() {
        // TODO
        // use super.read() to access the next byte from the InputStream
        // also, you can use ps like System.out to print to the new window
    	
    	try {
			int b = super.read();
			frame.getPrintStream().println(intToHex(b));
			return b;
		} catch (IOException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }

}
