package view.ToolbarComponent.Department;

import controller.DepartmentController;
import utils.Constants;
import view.EditCustomComponents.AddDeleteButtons;
import view.JListModels.DepHeadList;
import view.ListenerHandler;
import view.Screen;
import view.TablesComponent.Tables;
import view.ToolbarComponent.ToolbarCustomComponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

public class EditSingleDepartmentDialog extends JDialog {
    private Vector<JComponent> fieldsReferences;
    private ToolbarEnterExitPanel tenex;
    private String[] labelNames = Constants.getDepartmentLabels();
    private DepartmentController departmentController;
    private EditSingleDepartmentDialog ref = this;
    private JButton buttonConfirm;

    public EditSingleDepartmentDialog(Tables departmentTable, DepartmentController departmentController) {
        super();
        this.departmentController = departmentController;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Izmena katedre");
        setSize(new Dimension(Constants.SCREEN_WIDTH * 2 / 5, Constants.SCREEN_HEIGHT * 1 / 2));
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        fieldsReferences = new Vector<>();


        for (String lblName : labelNames) {
            add(createRow(lblName));
        }

        JPanel bottomPanel = new JPanel();
        buttonConfirm = new JButton(Screen.getInstance().getResourceBundle().getString("btnConfirm"));
        JButton buttonCancel = new JButton(Screen.getInstance().getResourceBundle().getString("btnCancel"));

        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departmentController.setProfessorAsHead(ref, departmentTable);
                dispose();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.add(buttonConfirm);
        bottomPanel.add(Box.createHorizontalStrut(20));
        bottomPanel.add(buttonCancel);

        add(bottomPanel);
        add(Box.createVerticalStrut(20));
        departmentController.setFieldsValues(ref, departmentTable);
        setVisible(true);
    }

    public JPanel createRow(String lblText) {
        JPanel row = new JPanel();
        ToolbarWinLabel lbl = new ToolbarWinLabel(lblText);
        row.add(lbl);
        ToolbarWinTxtField field = new ToolbarWinTxtField(lblText);
        PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));

        if (lblText.equals("Šef katedre*")) {
            AddDeleteButtons addDeleteButtons = new AddDeleteButtons();
            addDeleteButtons.setListeners(ListenerHandler.deleteDepartmentListener(field,addDeleteButtons), ListenerHandler.addDepartmentListener(departmentController, field, addDeleteButtons));
            JPanel upperWrapper = new JPanel();
            upperWrapper.setLayout(new BoxLayout(upperWrapper, BoxLayout.X_AXIS));
            upperWrapper.add(field);
            upperWrapper.add(addDeleteButtons);
            errPanel.add(upperWrapper);
        }

        row.add(errPanel);
        fieldsReferences.add(field);
        return row;
    }

    public JTextField getTextField(int index) {
        return (JTextField) fieldsReferences.get(index);
    }


    public JComboBox getComboBox(int index) {
        return null;
    }


    public Vector<JComponent> getFieldsReferences() {
        return fieldsReferences;
    }

    public ToolbarEnterExitPanel getEnterExit() {
        return null;
    }

    public DepartmentController getDepartmentController() {
        return departmentController;
    }

    public JButton getButtonConfirm() {
        return buttonConfirm;
    }
}
