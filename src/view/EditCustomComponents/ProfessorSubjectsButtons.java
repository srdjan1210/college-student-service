package view.EditCustomComponents;

import view.Screen;

import javax.swing.*;
import java.awt.*;

public class ProfessorSubjectsButtons extends JPanel{
    private JButton btnAddSubject;
    private JButton btnDeleteSubject;
    public ProfessorSubjectsButtons() {
        super();
        btnAddSubject = new JButton("Dodaj predmet");
        btnDeleteSubject = new JButton("Ukloni predmet");

        setMaximumSize(new Dimension(Screen.getInstance().getWidth(), 40));
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);


        add(Box.createHorizontalStrut(20));
        add(btnAddSubject);
        add(Box.createHorizontalStrut(20));
        add(btnDeleteSubject);
    }
}
