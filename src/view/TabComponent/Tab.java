package view.TabComponent;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.TableRowSorter;

import interfaces.IAddingController;
import interfaces.IDeleteController;
import interfaces.IEditingController;
import model.Database.DataModel;
import model.Student;
import model.TableModel.ProfessorTableModel;
import model.TableModel.StudentTableModel;
import model.TableModel.SubjectTableModel;
import view.RowFilters.StudentRowFilter;
import view.TablesComponent.Tables;
import view.ToolbarComponent.AddingScreen;
import view.ToolbarComponent.EditingScreen;

public class Tab extends JTabbedPane {

	private IAddingController addingController;
	private IDeleteController deleteController;
	private IEditingController editingController;
	private Tables studentTable;
	private Tables professorTable;
	private Tables subjectTable;

	public Tab(IAddingController addingController, IEditingController editingController,
			IDeleteController deleteController) {
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
		return model.selectedStudentIndex();
	}

	public String getSelectedProfessorId() {
		ProfessorTableModel model = (ProfessorTableModel) professorTable.getModel();
		return model.getSelectedId();
	}

	public String getSelectedSubjectId() {
		SubjectTableModel model = (SubjectTableModel) subjectTable.getModel();
		return model.getSelectedSubjectId();
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

	public void setDeleteController(IDeleteController controller) {
		this.deleteController = controller;
	}

	public IAddingController getAddingController() {
		return addingController;
	}

	public IDeleteController getDeleteController() {
		return deleteController;
	}

	public IEditingController getEditingController() {
		return editingController;
	}

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
