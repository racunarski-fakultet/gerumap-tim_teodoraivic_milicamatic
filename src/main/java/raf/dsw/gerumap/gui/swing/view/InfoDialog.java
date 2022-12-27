package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class InfoDialog extends JDialog {

    private JLabel ime;

    private JLabel prezime;

    private JLabel index;

    public InfoDialog(JFrame parent){
        super(parent, "Info", false);

        setSize(400,300);
        ime = new JLabel("Teodora");
        prezime = new JLabel("Ivic");
        index = new JLabel("RN 58/2021");

        URL url = InfoDialog.class.getClassLoader().getResource("images/slicica.jpg");
        ImageIcon slika1 = new ImageIcon(url);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


        gc.weightx = 0.1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.PAGE_START;
        add(ime, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(prezime, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(index, gc);

        gc.gridx = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel(slika1),gc);

    }



}
