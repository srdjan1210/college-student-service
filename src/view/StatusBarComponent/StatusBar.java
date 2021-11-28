package view.StatusBarComponent;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StatusBar extends JPanel {
	private JLabel tabName;
	public StatusBar(JFrame frame) {
		super();
		setPreferredSize(new Dimension(frame.getWidth(), 18));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JLabel appNameLabel = new JLabel("Studentska Sluzba");
		tabName = new JLabel("Student");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		Date date = new Date();
		JLabel currentDateLabel = new JLabel(dateTimeFormat.format(date));

		add(Box.createHorizontalStrut(10));
		add(appNameLabel);
		add(Box.createHorizontalStrut(20));
		add(tabName);
		add(Box.createHorizontalGlue());
		add(currentDateLabel);
		add(Box.createHorizontalStrut(10));
	}
	
	public void setTabName(String name)
	{
		tabName.setText(name);
	}
}
