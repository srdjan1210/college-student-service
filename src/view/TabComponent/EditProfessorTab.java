package view.TabComponent;


import controller.AddSubjectToProfessorController;
import controller.EditingProfessorController;
import model.Database.DataModel;
import model.Professor;
import view.Screen;
import view.ToolbarComponent.Professor.ToolbarEditProfessorInfoPanel;
import view.ToolbarComponent.Professor.ToolbarEditProfessorSubjectsPanel;

import javax.swing.*;

public class EditProfessorTab extends JTabbedPane {
    private ToolbarEditProfessorInfoPanel editInfo;
    private ToolbarEditProfessorSubjectsPanel editSubjects;

    public EditProfessorTab() {
        super();
        editInfo = new ToolbarEditProfessorInfoPanel();
        editSubjects = new ToolbarEditProfessorSubjectsPanel();
        editSubjects.setAddingController(new AddSubjectToProfessorController());
        String professorId = Screen.getInstance().getStudentTab().getSelectedProfessorId();
        DataModel instance = DataModel.getInstance();
        Professor professor = instance.getProfessorById(professorId);
        String[] professorData = EditingProfessorController.findProfessorDataForFields(professor);
        for (int i = 0; i < 10; i++)
            editInfo.setTextField(i, professorData[i]);
        add(Screen.getInstance().getResourceBundle().getString("info"), editInfo);
        add(Screen.getInstance().getResourceBundle().getString("subjects"), editSubjects);
    }

    public ToolbarEditProfessorInfoPanel getToolbarEditProfessorInfo() {
        return editInfo;
    }

    public ToolbarEditProfessorSubjectsPanel getEditSubjects() {
        return editSubjects;
    }


}
