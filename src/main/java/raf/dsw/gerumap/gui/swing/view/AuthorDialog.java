package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.repository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AuthorDialog extends JDialog {

    private JLabel lbl;
    private JTextField textField;
    private JButton saveBtn;


    public AuthorDialog(JFrame parent, MapTreeItem project) {
        super(parent, "Info", false);
        this.setLocationRelativeTo(parent);
        getContentPane().setLayout(new FlowLayout());
        setBounds(0, 0, 300, 100);
        setResizable(false);

        saveBtn = new JButton("Save");
        lbl = new JLabel("Insert author name: ");
        textField = new JTextField();
        textField.setColumns(15);
        add(lbl);
        add(textField);
        add(saveBtn);

        saveBtn.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(project.getMapNode() instanceof Project){
                ((Project) project.getMapNode()).setAutor(textField.getText());
                revalidate();
                }
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


