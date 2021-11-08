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
		JLabel nazivAplikacijeLabel = new JLabel("[Studentska Sluzba]");
		JLabel nazivTabaLabel = new JLabel("[Naziv_taba_ovde]");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("[HH:mm dd/MM/yyyy]");
		Date date = new Date();
		JLabel trenutnoVremeLabel = new JLabel(dateTimeFormat.format(date));

		nazivAplikacijeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nazivTabaLabel.setHorizontalAlignment(JLabel.CENTER);
		trenutnoVremeLabel.setHorizontalAlignment(JLabel.RIGHT);
		add(nazivAplikacijeLabel);
		add(nazivTabaLabel);
		add(trenutnoVremeLabel);
	}
}
