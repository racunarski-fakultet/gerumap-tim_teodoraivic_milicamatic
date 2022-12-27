package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.jTree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.message.EventType;
import raf.dsw.gerumap.gui.swing.message.Message;
import raf.dsw.gerumap.gui.swing.message.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static raf.dsw.gerumap.gui.swing.message.EventType.BlankStringForName;

public class EditDialog extends JDialog {

    private JLabel labela;
    private JTextField textField;
    private JButton saveBtn;
    EventType eventType;


    public EditDialog(Frame owner, String title, MapTreeItem mapTreeItem) {
        super(owner, title);
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
                if (textField.getText().equals("")){
                    eventType= BlankStringForName;
                    ApplicationFramework.getMessageGenerator().generateMessage(new Message("Polje za izmenu je prazno", MessageType.WARNING,eventType));
                }else {
                    MainFrame.getInstance().getMapTree().rename(mapTreeItem, textField.getText());
                    dispose();
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
