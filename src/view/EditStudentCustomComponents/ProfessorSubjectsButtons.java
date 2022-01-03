package view.EditStudentCustomComponents;

import model.Database.DataModel;
import model.TableModel.PassedSubjectsTableModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarEditStudentPassedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	public JButton getBtnAddSubject() {
		return btnAddSubject;
	}
	public JButton getBtnDeleteSubject() {
		return btnDeleteSubject;
	}
    
    
}
