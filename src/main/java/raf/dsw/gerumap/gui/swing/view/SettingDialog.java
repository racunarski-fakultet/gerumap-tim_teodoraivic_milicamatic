package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.commands.SettingCommand;
import raf.dsw.gerumap.repository.implementation.Concept;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SettingDialog extends JDialog{

    private JButton saveBtn;
    private JTextField strokeTextField;
    private JLabel strokeSize;
    private JLabel colorPick;

    private JColorChooser colorChooser;

    public SettingDialog(JFrame parent, MapView mapView) {
        super(parent, "Setting", false);
        this.setLocationRelativeTo(mapView);
        getContentPane().setLayout(new FlowLayout());
        setBounds(0, 0, 400, 400);
        setResizable(false);

        saveBtn = new JButton("Save");
        strokeTextField = new JTextField(5);
        strokeSize = new JLabel("Enter stroke size: ");
        colorPick = new JLabel("Pick a color: ");

        colorChooser = new JColorChooser(Color.black);
        colorChooser.setBorder(null);
        colorChooser.setSize(200,200);
        saveBtn.setToolTipText("Save");

        this.add(strokeSize);
        this.add(strokeTextField);
        this.add(colorPick);
        this.add(saveBtn);
        this.add(colorChooser);

        colorChooser.getSelectionModel().addChangeListener(e -> {
            if(!mapView.getMindMap().getSelectedElements().isEmpty()){ // menjanje boje selektovanih
                mapView.getMindMap().recolorSelection(colorChooser.getColor().getRGB());
            }
            else if(mapView.getMindMap().getElements().isEmpty()){
                mapView.getMindMap().setDrawColor(colorChooser.getColor().getRGB()); //pre crtanja biranje kojom bojom ce se crtati
            }else{
                mapView.getMindMap().recolorElement(colorChooser.getColor().getRGB()); //ako imamo elemente i nista nije selektovano menjanj sve
            }

        });



        saveBtn.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!strokeTextField.getText().equals("")) {

                    AbstractCommand command = new SettingCommand(mapView, Integer.valueOf(strokeTextField.getText()), colorChooser.getColor());
                    AppCore.getInstance().getGui().getCommandManager().addCommand(command);
                }

                if(strokeTextField.getText().equals("")){
                    mapView.getMindMap().getSelectedElements().clear();
                    dispose();
                }
//                else if(!mapView.getMindMap().getSelectedElements().isEmpty()){
//                    mapView.getMindMap().setSelectedStroke(Integer.valueOf(strokeTextField.getText()));
//
//                }
//                else if(mapView.getMindMap().getElements().isEmpty()){
//                    mapView.getMindMap().initialStroke(Integer.valueOf(strokeTextField.getText()));
//                }
//                else{
//                    mapView.getMindMap().setNewStroke(Integer.valueOf(strokeTextField.getText()));
//                }

                dispose();
            }
        });

    }
}
