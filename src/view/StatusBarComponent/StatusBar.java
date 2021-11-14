package view.StatusBarComponent;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StatusBar extends JPanel {
	public StatusBar(JFrame frame) {
		super();
		setPreferredSize(new Dimension(frame.getWidth(), 18));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JLabel appNameLabel = new JLabel("[Studentska Sluzba]");
		JLabel tabNaemLabel = new JLabel("[Naziv_taba_ovde]");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("[HH:mm dd/MM/yyyy]");
		Date date = new Date();
		JLabel currentDateLabel = new JLabel(dateTimeFormat.format(date));

		appNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		tabNaemLabel.setHorizontalAlignment(JLabel.CENTER);
		currentDateLabel.setHorizontalAlignment(JLabel.RIGHT);
		add(appNameLabel);
		add(tabNaemLabel);
		add(currentDateLabel);
	}
}
