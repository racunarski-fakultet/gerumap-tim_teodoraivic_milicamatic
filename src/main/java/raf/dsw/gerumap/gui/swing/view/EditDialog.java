package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditDialog extends JDialog {

    private JLabel labela;
    private JTextField textField;
    private JButton saveBtn;


    public EditDialog(Frame owner, String title, MapTreeItem mapTreeItem) {
        super(owner, title);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new FlowLayout());
        setBounds(0, 0, 300, 100);
        setResizable(false);

        saveBtn = new JButton("Save");
        labela=new JLabel("Insert new name: ");
        textField=new JTextField();
        textField.setColumns(15);
        add(labela);
        add(textField);
        add(saveBtn);

        saveBtn.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getInstance().getMapTree().rename(mapTreeItem, textField.getText());
                dispose();

            }
        });
    }




    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }


}
