package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class MyChooser extends JFileChooser {

     JFrame f;
    protected JDialog createDialog(Component parent)
            throws HeadlessException {
        JDialog dlg = super.createDialog(f);
        dlg.setLocation(1, 1);
        return dlg;
    }

}
