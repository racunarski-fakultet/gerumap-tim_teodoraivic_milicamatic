package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.repository.implementation.Concept;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ConceptDialog extends JDialog {

    private JLabel labela;
    private JTextField textField;
    private JButton saveBtn;

    private String name;

    public ConceptDialog(JFrame parent,Concept concept) {
        super(parent, "Info", false);
        this.setLocationRelativeTo(parent);
        getContentPane().setLayout(new FlowLayout());
        setBounds(0, 0, 300, 100);
        setResizable(false);
        setModalityType(ModalityType.APPLICATION_MODAL);

        saveBtn = new JButton("Save");
        labela= new JLabel("Insert concept text: ");
        textField = new JTextField();
        textField.setColumns(15);
        add(labela);
        add(textField);
        add(saveBtn);

        saveBtn.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    setName(textField.getText());
                   revalidate();
                   concept.setName(textField.getText());

                dispose();
            }
        });




    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
