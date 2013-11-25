package org.squadra.atenea.base.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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

		Robot robik = null;
		try {
			robik = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		byte[] bytes = s.getBytes();
		for (byte b : bytes) {
			int code = b;
			
			try{
			System.out.println("Code:" + code);
			// Si la letra es mayuscula, apreto Shift
			if (code > 64 && code < 91)
				robik.keyPress(KeyEvent.VK_SHIFT);
			if (code > 96 && code < 123) 
				code -= 32;		

			robik.delay(40);

			if (code == -95)
			{					
				robik.keyPress( KeyEvent.VK_DEAD_ACUTE);

				robik.keyPress(65);
				robik.keyRelease(65);					
				robik.keyRelease( KeyEvent.VK_DEAD_ACUTE);

			}
			else if (code == -83)
			{				
				robik.keyPress( KeyEvent.VK_DEAD_ACUTE);

				robik.keyPress(73);
				robik.keyRelease(73);			
				robik.keyRelease( KeyEvent.VK_DEAD_ACUTE);

			}
			else if (code == -77)//162)
			{					
				robik.keyPress( KeyEvent.VK_DEAD_ACUTE);

				robik.keyPress(79);
				robik.keyRelease(79);				
				robik.keyRelease( KeyEvent.VK_DEAD_ACUTE);

			}
			else if (code == -70)
			{				
				robik.keyPress( KeyEvent.VK_DEAD_ACUTE);

				robik.keyPress(85);
				robik.keyRelease(85);				
				robik.keyRelease( KeyEvent.VK_DEAD_ACUTE);

			}
			else if (code == -87)
			{					
				robik.keyPress( KeyEvent.VK_DEAD_ACUTE);

				robik.keyPress(69);
				robik.keyRelease(69);					
				robik.keyRelease( KeyEvent.VK_DEAD_ACUTE);

			}
			// ñ
			else if (code == -79)
			{
				robik.keyPress(KeyEvent.VK_N);
				robik.keyRelease(KeyEvent.VK_N);					

			}
			else if (code > 0)
			{
				robik.keyPress(code);
				robik.keyRelease(code);
			}
			
			
			// Si la letra es mayuscula, suelto Shift
			if (code > 64 && code < 91)
				robik.keyRelease(KeyEvent.VK_SHIFT);
			
			}catch(Exception e)
			{
				System.out.println("error con el caracter " + code);
			}

		}

	}

}
