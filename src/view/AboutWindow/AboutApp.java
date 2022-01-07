package view.AboutWindow;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

import utils.Constants;
import utils.ImageUtils;
import view.Screen;
import view.ToolbarComponent.ToolbarCustomComponents.ToolbarWinLabel;

public class AboutApp extends JPanel{
	private String[] labelNames = Constants.getAppLabels();
	private String[] appInfo = Constants.getAppInfo();
	
	public AboutApp() {
		super();
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);

		for(int i=0;i<5;i++) {
			String labelName = labelNames[i];
			add(createInfo(labelName,appInfo[i]));
		}
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("icons/FTN.png"));
		image = ImageUtils.scaleImage(image, Constants.SCREEN_WIDTH * 1 / 7, Constants.SCREEN_HEIGHT * 1 / 5);
		add(new JLabel(image),Component.CENTER_ALIGNMENT);
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
