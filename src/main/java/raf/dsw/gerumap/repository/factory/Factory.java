package raf.dsw.gerumap.repository.factory;

import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.implementation.Element;
import raf.dsw.gerumap.repository.implementation.MindMap;
import raf.dsw.gerumap.repository.implementation.Project;
import raf.dsw.gerumap.repository.implementation.ProjectExplorer;

public abstract class Factory {

    MindMap mindMap;
    Project project;
    ProjectExplorer projectExplorer;
    Element element;



    public abstract MapNode createNode(String naziv,MapNode parent);

    public MindMap getMindMap() {
        return mindMap;
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    public void setProjectExplorer(ProjectExplorer projectExplorer) {
        this.projectExplorer = projectExplorer;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
