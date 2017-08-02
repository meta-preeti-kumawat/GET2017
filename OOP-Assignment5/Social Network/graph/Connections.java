package graph;

import java.util.HashMap;
import java.util.Map;


public class Connections{
    Map<String, Nodes> connection = new HashMap<String, Nodes>();

    public Map<String, Nodes> getConnection() {
        return connection;
    }

    public void setConnection(Map<String, Nodes> connection) {
        this.connection = connection;
    }
    
    public void putNewConnection(String entity, Nodes nodes){
        this.connection.put(entity, nodes);
    }
}
