package raf.dsw.gerumap.gui.swing.controller;

import java.awt.event.ActionEvent;

public class SettingAction extends AbstractGeRuMapAction{
    public SettingAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        putValue(SMALL_ICON, loadIcon("/images/settings.png"));
        putValue(SHORT_DESCRIPTION, "Settings");

    }
}
