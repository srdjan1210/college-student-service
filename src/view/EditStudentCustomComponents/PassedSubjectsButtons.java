package view.EditStudentCustomComponents;

import view.Screen;

import javax.swing.*;
import java.awt.*;

public class PassedSubjectsButtons extends JPanel {
    private JButton removeFromPassed;
    public PassedSubjectsButtons() {
        super();
        setMaximumSize(new Dimension(Screen.getInstance().getWidth(), 600));
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);

        removeFromPassed = new JButton("Ponisti ocenu");
        add(Box.createHorizontalStrut(20));
        add(removeFromPassed);
    }
}
