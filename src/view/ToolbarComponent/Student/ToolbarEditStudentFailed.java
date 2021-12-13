package view.ToolbarComponent.Student;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.DeleteFailedSubjectController;
import controller.ListenerHandler;
import model.Student;
import model.Subject;
import model.Database.DataModel;
import model.TableModel.FailedSubjectsTableModel;
import utils.Constants;
import view.Screen;
import view.EditStudentCustomComponents.FailedSubjectsButtons;
import view.TablesComponent.Tables;

public class ToolbarEditStudentFailed extends JPanel {
	private Tables failedSubjectsTable;
	private DeleteFailedSubjectController deleteController;

	public ToolbarEditStudentFailed() {
		super();
		// DeleteFailedSubjectController deleteController = new
		// DeleteFailedSubjectController(this);
		setPreferredSize(new Dimension(200, 800));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		FailedSubjectsButtons buttons = new FailedSubjectsButtons();
		add(buttons);

		String[] columnNames = Constants.subjectColumnNames;
		Student student = DataModel.getInstance()
				.getStudentById(Screen.getInstance().getStudentTab().getSelectedStudentIndex());
		ArrayList<Subject> failedSubjects = student.getFailedSubjects();
		String[][] data = getSubjectsData(failedSubjects);

		failedSubjectsTable = new Tables(new FailedSubjectsTableModel(data));
		DataModel.getInstance().setTableObserver(failedSubjectsTable);
		add(new JScrollPane(failedSubjectsTable));

		buttons.getButtonDelete().addActionListener(ListenerHandler.getButtonDeleteFailedSubjectListener(this));
		setVisible(true);
	}

	public String getSelectedSubjectId() {
		FailedSubjectsTableModel model = (FailedSubjectsTableModel) failedSubjectsTable.getModel();
		return (String) model.getValueAt(failedSubjectsTable.getSelectedRow(), 0);
	}

	public void setDeleteController(DeleteFailedSubjectController deleteController) {
		this.deleteController = deleteController;
	}

	public Tables getFailedSubjectsTable() {
		return failedSubjectsTable;
	}

	public String[][] getSubjectsData(ArrayList<Subject> subjects) {
		String[][] data = new String[subjects.size()][5];
		int i = 0;
		for (Subject subject : subjects) {
			data[i][0] = subject.getSubjectId();
			data[i][1] = subject.getSubjectName();
			data[i][2] = Integer.toString(subject.getEspb());
			data[i][3] = Integer.toString(subject.getYearOfStudy());
			data[i][4] = subject.getSemester().getValue();
			i++;
		}
		return data;
	}
}
