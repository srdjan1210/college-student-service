package view.EditCustomComponents;

import model.Database.DataModel;
import model.TableModel.PassedSubjectsTableModel;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.Student.ToolbarEditStudentPassedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassedSubjectsButtons extends JPanel {
    private JButton removeFromPassed;
    private PassedSubjectsButtons reference = this;
    public PassedSubjectsButtons() {
        super();
        setMaximumSize(new Dimension(Screen.getInstance().getWidth(), 600));
        BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
        setLayout(layout);

        removeFromPassed = new JButton("Ponisti ocenu");
        removeFromPassed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ToolbarEditStudentPassedPanel studPassedPanel = (ToolbarEditStudentPassedPanel) reference.getParent();
                Tables marksTable = studPassedPanel.getPassedSubjectsTable();
                if(marksTable.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Predmet nije selektovan!");
                    return;
                }
                int result = JOptionPane.showConfirmDialog(null, "Da li zelite ponistiti ocjenu iz obiljezenog predmeta", "Ponistavanje", JOptionPane.YES_NO_OPTION);
                if(result != 0) return;
                PassedSubjectsTableModel pstm = (PassedSubjectsTableModel) marksTable.getModel();
                String subId = pstm.getSelectedSubjectId(marksTable.getSelectedRow());
                String studId = Screen.getInstance().getStudentTab().getSelectedStudentIndex();
                DataModel.getInstance().undoMarkFromStudent(subId, studId);
            }
        });
        add(Box.createHorizontalStrut(20));
        add(removeFromPassed);
    }
}
