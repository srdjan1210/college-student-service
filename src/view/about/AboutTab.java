package view.about;

import javax.swing.JTabbedPane;

public class AboutTab extends JTabbedPane {
	private AboutSrdjan aboutSrdjanTab;
	private AboutDarko aboutDarkoTab;
	private AboutApp aboutApp;
	public AboutTab() {
		aboutSrdjanTab = new AboutSrdjan();
		aboutDarkoTab = new AboutDarko();
		aboutApp = new AboutApp();
		add("O aplikaciji", aboutApp);
		add("Srdjan", aboutSrdjanTab);
		add("Darko", aboutDarkoTab);
	}
}
