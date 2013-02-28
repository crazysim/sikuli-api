package org.sikuli.api.examples;
import java.awt.Rectangle;

import org.sikuli.api.ImageTarget;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Keyboard;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.robot.desktop.DesktopScreen;

public class MultiScreenExample {
	
	static Mouse mouse = new DesktopMouse();
	static Keyboard keyboard = new DesktopKeyboard();
//	static ScreenPainter painter = new ScreenPainter();
	
	static ScreenSimulator simulator1 = new ScreenSimulator(){
		public void run(){
			showImage(Images.GoogleSearchPage);
			wait(1);
			close();
		}
	};

	static ScreenSimulator simulator2 = new ScreenSimulator(){
		public void run(){
			showImage(Images.OSXSystemPreferences);
			wait(1);
			close();
		}
	};

	
	public static void main(String[] args) {
			
		DesktopScreen screen0 = new DesktopScreen(0);
		DesktopScreen screen1 = new DesktopScreen(1);
				
		// position the simulators on two different screens
		Rectangle b0 = screen0.getBounds();
		Rectangle b1 = screen1.getBounds();

		simulator1.setLocation(b0.x+50, b0.y+50);
		simulator2.setLocation(b1.x+50, b1.y+50);
		
		simulator1.start();
		simulator2.start();
		
		DesktopScreenRegion s0 = new DesktopScreenRegion(30,30,800,500);
		s0.setScreen(screen0);
		
		DesktopScreenRegion s1 = new DesktopScreenRegion(30,30,800,500);
		s1.setScreen(screen1);
		
//		painter.box(s0, 10000);
//		painter.box(s1, 10000);
//		
				
		ScreenRegion r0 = s0.find(new ImageTarget(Images.GoogleSearchButton));
		ScreenRegion r1 = s1.find(new ImageTarget(Images.OSXDockIcon));

//		painter.box(r0, 5000);
//		painter.box(r1, 5000);
//		
//		painter.label(r0,"Target in Screen0", 5000);
//		painter.label(r1,"Target in Screen1", 5000);
				
		
	}
}