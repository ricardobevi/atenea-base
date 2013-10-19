package org.squadra.atenea.base.actions;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.*;

public class Dictate extends PreloadAction {

	@Override
	public void execute() {
		//Hago click en la mitad de la pantalla para darle foco a lo que esté atras -.-'
		try {
			
			Robot r = new Robot();
			r.mouseMove(Toolkit.getDefaultToolkit().getScreenSize().width / 2,
					Toolkit.getDefaultToolkit().getScreenSize().height / 2);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (Exception e) {		}
		
		//Escribo
		typeString(param);
	}

	public void typeString(String s) {
		try {
			Robot robik = new Robot();
			byte[] bytes = s.getBytes();
			System.out.println(bytes);
			for (byte b : bytes) {
				int code = b;
				pressUnicode(robik, code);
//				// Si la letra es mayuscula, apreto Shift
//				if (code > 64 && code < 91)
//					robik.keyPress(KeyEvent.VK_SHIFT);
//				if (code > 96 && code < 123) 
//					code -= 32;		
//				
//				robik.delay(40);
//				robik.keyPress(code);
//				robik.keyRelease(code);
//				// Si la letra es mayuscula, suelto Shift
//				if (code > 64 && code < 91)
//					robik.keyRelease(KeyEvent.VK_SHIFT);
			}
		} catch (Exception e) {}
	}
	
	public static void pressUnicode(Robot r, int key_code)
	{
	    r.keyPress(KeyEvent.VK_ALT);

	    for(int i = 3; i >= 0; --i)
	    {
	        // extracts a single decade of the key-code and adds
	        // an offset to get the required VK_NUMPAD key-code
	        int numpad_kc = key_code / (int) (Math.pow(10, i)) % 10 + KeyEvent.VK_NUMPAD0;

	        r.keyPress(numpad_kc);
	        r.keyRelease(numpad_kc);
	    }

	    r.keyRelease(KeyEvent.VK_ALT);
	}
}
