package raf.dsw.gerumap.core;

import raf.dsw.gerumap.repository.composite.MapNode;

public interface NodeFactory {


    public MapNode getNode();

    //pravi mapNode objekte- apstrakcija, ova fabrika mora da zavisis samo od MAPNODE-a,
    //ne zanima nas sta je konkretno cvor
    //factory se oslanja samo na mapnode, ne moze da se osloni na njene potklase

}
