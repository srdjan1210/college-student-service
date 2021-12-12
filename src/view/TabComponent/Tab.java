package view.TabComponent;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import interfaces.IAddingController;
import interfaces.IDeleteController;
import interfaces.IEditingController;
import model.Database.DataModel;
import model.TableModel.ProfessorTableModel;
import model.TableModel.StudentTableModel;
import model.TableModel.SubjectTableModel;
import view.TablesComponent.Tables;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.EditingScreen;

public class Tab extends JTabbedPane {

    private IAddingController addingController;
    private IDeleteController deleteController;
	private IEditingController editingController;
    private int selectedTab = 0;
    private Tables studentTable;
    private Tables professorTable;
    private Tables subjectTable;


    public Tab(IAddingController addingController,IEditingController editingController, IDeleteController deleteController) {
        super();
        this.addingController = addingController;
		this.editingController = editingController;
        this.deleteController = deleteController;

        studentTable = new Tables(new StudentTableModel());
        professorTable = new Tables(new ProfessorTableModel());
        subjectTable = new Tables(new SubjectTableModel());
        DataModel.getInstance().setTableObserver(studentTable);

        add("Student", new JScrollPane(studentTable));
        add("Profesor", new JScrollPane(professorTable));
        add("Predmeti", new JScrollPane(subjectTable));
    }



    public String getSelectedStudentIndex() {
        StudentTableModel model = (StudentTableModel) studentTable.getModel();
        return (String)model.getValueAt(studentTable.getSelectedRow(), 0);
    }

    public String getSelectedProfessorId() {
        ProfessorTableModel model = (ProfessorTableModel) professorTable.getModel();
        return Integer.toString(professorTable.getSelectedRow());
        //return (String)model.getValueAt(professorTable.getSelectedRow(), 0);
    }

    public String getSelectedSubjectId() {
        SubjectTableModel model = (SubjectTableModel) subjectTable.getModel();
        return (String)model.getValueAt(subjectTable.getSelectedRow(), 0);
    }

    public void addNewEntity(AddingScreen dialog) {
        this.addingController.addNewEntity(dialog);
    }

    public void editNewEntity(EditingScreen dialog) {
    	this.editingController.editEntity(dialog);
    }

    public void deleteEntity() {
        deleteController.deleteEntity();
    }

    public void setAddingController(IAddingController controller) {
        this.addingController = controller;
    }

    public void setEditingController(IEditingController controller) {
        this.editingController = controller;
    }

    public void setDeleteController(IDeleteController controller) { this.deleteController = controller; }

    public Tables getStudentTable() {
        return studentTable;
    }

    public Tables getProfessorTable() {
        return professorTable;
    }

    public Tables getSubjectTable() {
        return subjectTable;
    }

}
