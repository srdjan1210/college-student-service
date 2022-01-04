package view.ToolbarComponent.Department;

import controller.DepartmentController;
import utils.Constants;
import view.Screen;
import view.JListModels.DepHeadList;
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
        if(lblText.equals("Sef katedre*"))
            addActionListenerForHead(field);
        PanelFieldError errPanel = new PanelFieldError(field, new ErrorMessageLabel("", field.getPreferredSize().width, 20));
        row.add(errPanel);
        fieldsReferences.add(field);

        return row;
    }

    private void addActionListenerForHead(JTextField field) {
        System.out.println(field.getName());
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!field.getText().equals("")) return;
                JList lista = new JList(new DepHeadList());
                int result = JOptionPane.showConfirmDialog(null, new JScrollPane(lista),"Izaberite profesora!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if(result == 0) {
                    DepHeadList model =(DepHeadList) lista.getModel();
                    if(lista.getSelectedIndex() == -1) return;
                    field.setText(model.getObjectAt(lista.getSelectedIndex()).getIdNumber());
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
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
