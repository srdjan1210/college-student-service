package view.ToolbarComponent.Department;

import controller.DepartmentController;
import model.TableModel.DepartmentTableModel;
import utils.Constants;
import view.Screen;
import view.TablesComponent.Tables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentEditWindow extends JDialog {
    private Tables departmentsTable;
    private JButton editButton;
    public DepartmentEditWindow() {
        super();
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle(Screen.getInstance().getResourceBundle().getString("departmentTitle"));
        setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 3 / 4));
        setLocationRelativeTo(null);
        departmentsTable = new Tables(new DepartmentTableModel());
        departmentsTable.setPreferredSize(getSize());
        editButton = new JButton(Screen.getInstance().getResourceBundle().getString("btnDepartmentEdit"));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(departmentsTable.getSelectedRow() == -1) return;
                new EditSingleDepartmentDialog(departmentsTable, new DepartmentController());
            }
        });
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(editButton);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(new JScrollPane(departmentsTable));
        add(mainPanel);
        setVisible(true);
    }

    public Tables getDepartmentsTable() {
        return departmentsTable;
    }



}
