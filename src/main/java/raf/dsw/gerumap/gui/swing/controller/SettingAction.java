package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.gui.swing.view.SettingDialog;

import java.awt.event.ActionEvent;

public class SettingAction extends AbstractGeRuMapAction{
    public SettingAction() {
        putValue(SMALL_ICON, loadIcon("/images/settings.png"));
        putValue(SHORT_DESCRIPTION, "Settings");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SettingDialog settingDialog = new SettingDialog(MainFrame.getInstance(),(MapView) MainFrame.getInstance().getProjectView().getTp().getSelectedComponent());
        settingDialog.setVisible(true);
        settingDialog.setModal(true);
    }
}
