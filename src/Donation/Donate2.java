package Donation;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class Donate2 {
	public Donate2() {
		JOptionPane.showMessageDialog(null, "You will now be redirected to Web Page","Donate",JOptionPane.INFORMATION_MESSAGE);
		try {
			URI link = new URI("http://www.geocities.ws/defaulting/");
			try {
				Desktop.getDesktop().browse(link);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Exception in opening browser");
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			System.out.println("Wrong URL format");
		}
	}

}
