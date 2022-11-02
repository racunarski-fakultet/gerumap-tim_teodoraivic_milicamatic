package raf.dsw.gerumap.core;

import raf.dsw.gerumap.gui.swing.repository.composite.MapNode;
import raf.dsw.gerumap.gui.swing.repository.composite.MapNodeComposite;
import raf.dsw.gerumap.gui.swing.repository.implementation.ProjectExplorer;

public interface MapRepository {

  ProjectExplorer getProjectExplorer();

  void addChild(MapNodeComposite parent, MapNode child);

}
