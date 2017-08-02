package graph;


public class Graph {
    private Nodes nodes = new Nodes();
    private Connections connections = new Connections();
    
    public Graph splitData(String data){
        Graph graph = new Graph();
        String[] separate = data.split("-");
        if(separate.length == 2){
            graph.nodes.splitNodes(separate[1].trim());
            graph.connections.putNewConnection(separate[0], graph.nodes);
        }
        else{
            graph.connections.putNewConnection(separate[0], null);
        }
        return graph;
    }

    public Nodes getNodes() {
        return nodes;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }
}
