package view.ToolbarComponent.Professor;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.AddSubjectToProfessorController;
import controller.DeleteSubjectFromProfessorController;
import model.TableModel.ProfessorSubjectsTableModel;
import view.ListenerHandler;
import view.EditStudentCustomComponents.ProfessorSubjectsButtons;
import view.TablesComponent.Tables;

public class ToolbarEditProfessorSubjectsPanel extends JPanel {
    private Tables professorSubjectsTable;
    private ProfessorSubjectsButtons professorSubjectsButtons;
    private AddSubjectToProfessorController addingController;
    private DeleteSubjectFromProfessorController deleteController;

    public ToolbarEditProfessorSubjectsPanel() {
        super();
        setPreferredSize(new Dimension(200, 800));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        professorSubjectsButtons = new ProfessorSubjectsButtons();
        professorSubjectsTable = new Tables(new ProfessorSubjectsTableModel());
        add(Box.createVerticalStrut(10));
        add(professorSubjectsButtons);
        add(Box.createVerticalStrut(10));
        add(new JScrollPane(professorSubjectsTable));
        
        professorSubjectsButtons.getBtnAddSubject().addActionListener(ListenerHandler.getAddSubjectToProfessorListener(this));
        professorSubjectsButtons.getBtnDeleteSubject().addActionListener(ListenerHandler.getDeleteSubjectFromProfessorListener(this));
        
        setVisible(true);
    }
    
	public void setAddingController(AddSubjectToProfessorController addingController) {
		this.addingController = addingController;
	}
	
	public void setDeleteController(DeleteSubjectFromProfessorController deleteController) {
		this.deleteController = deleteController;
	}
    
	public void addSubject() {
		this.addingController.addNewSubject();
	}

	public Tables getProfessorSubjectsTable() {
		return professorSubjectsTable;
	}
	
	public String getSelectedSubjectId() {
		ProfessorSubjectsTableModel model = (ProfessorSubjectsTableModel) professorSubjectsTable.getModel();
		return (String) model.getValueAt(professorSubjectsTable.getSelectedRow(), 0);
	}
	
	
}
