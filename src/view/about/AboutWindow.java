package view.about;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

import utils.Constants;
import view.Screen;

public class AboutWindow extends JDialog {
	public AboutWindow() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		setTitle(Screen.getInstance().getResourceBundle().getString("aboutUs"));
		setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
		setLocationRelativeTo(null);
		add(new AboutTab());
		setVisible(true);
	}
}
