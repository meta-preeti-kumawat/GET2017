package graph;

import java.util.HashSet;
import java.util.Set;


public class Nodes{
    Set<String> setOfEntities = new HashSet<String>();
    
    public void setNodes(String entity){
        this.setOfEntities.add(entity);
    }
    
    public Set<String> getNodes() {
        return this.setOfEntities;
    }
    
    public void splitNodes(String nodes){
        String[] nodeList = nodes.split(",");
        for (String string : nodeList) {
            this.setNodes(string);
        }
    }

    public void removeNodes(String choice) {
        this.setOfEntities.remove(choice);
    }
}
