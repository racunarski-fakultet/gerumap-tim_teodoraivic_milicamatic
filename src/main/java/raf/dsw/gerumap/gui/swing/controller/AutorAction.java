package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.AuthorDialog;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AutorAction extends AbstractGeRuMapAction{

    MainFrame mainFrame=MainFrame.getInstance();

    public AutorAction() {
        putValue(SMALL_ICON, loadIcon("/images/autor.png"));
        putValue(NAME, "Set Autor");
        putValue(SHORT_DESCRIPTION, "Autor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AuthorDialog ad = new AuthorDialog(mainFrame, MainFrame.getInstance().getMapTree().getSelectedNode());
        ad.setLocationRelativeTo(mainFrame);
        ad.setVisible(true);
        ad.setModal(true);

    }
}
