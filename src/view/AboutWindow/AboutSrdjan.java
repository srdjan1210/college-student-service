package view.AboutWindow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Constants;
import utils.ImageUtils;
import view.Screen;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;

public class AboutSrdjan extends JPanel {
	private String[] labelNames = Constants.getCreatorsLabels();
	private String[] srdjanInfo = Constants.getSrdjanInfo();
	
	public AboutSrdjan() {
		super();
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		for(int i=0;i<8;i++) {
			String labelName = labelNames[i];
			add(createInfo(labelName,srdjanInfo[i]));
		}
		setVisible(true);
	}
	
	private JPanel createInfo(String labelName,String info) {
		JPanel panel = new JPanel();
		ToolbarWinLabel lbl1 = new ToolbarWinLabel(labelName);
		panel.add(lbl1);
		ToolbarWinLabel lbl2 = new ToolbarWinLabel(info);
		lbl2.setForeground(Color.GRAY);
		panel.add(lbl2);
		return panel;
	}
}
