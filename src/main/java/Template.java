public class Template {
    public static final String PROGRAM = """
            import java.util.HashMap;
            import java.util.Map;
            import java.util.Set;
            import java.util.Collections;
            import java.util.ArrayList;
                        
            public class Program {
                    public class GraphElement {
                        public final String label;
                        public final Map<String, Object> properties = new HashMap<>();
                        
                        public GraphElement(String label) {
                            this.label = label;
                        }
                        
                        public class Node extends GraphElement {
                            public final String id;
                            public final List<Edge> outgoingEdges = new ArrayList<>();
                            public final List<Edge> incomingEdges = new ArrayList<>();
                        
                            public Node(String label, String id) {
                                super(label);
                                this.id = id;
                            }
                        
                            public Node getNode(String id) {
                                return getNode().getNode(id);
                            }
                        }
                        
                        public Stream<Edge> incomingEdges(String edgeLabel) {
                            return incomingEdges.stream().filter(e -> e.label.equals(edgeLabel));
                        }
                        
                        public Stream<Edge> outgoingEdges(String edgeLabel) {
                            return outgoingEdges.stream().filter(e -> e.label.equals(edgeLabel));
                        }
                    }
                        
                        
                public class Edge extends GraphElement {
                    public final Node source;
                    public final Node target;
                        
                    public Edge(String label, Node source, Node target) {
                        super(label);
                        this.source = source;
                        this.target = target;
                    }
                }
                        
                public class Graph {
                    public final Map<String, Node> nodeIdToNode = new HashMap<>();
                    public final Map<String, Set<Node>> nodeLabelToNodes = new HashMap<>();
                        
                    public Node createNode(String label, String id) {
                        if (nodeIdToNode.containsKey(id)) {
                            throw new DuplicateNodeException(id);
                        }
                        
                        final Node n = new Node(label, id);
                        
                        nodeIdToNode.put(id, n);
                        nodeLabelToNodes.get(label).add(n);
                        
                        return n;
                    }
                        
                    public Edge createEdge(String label, String fromNodeId, String toNodeId) {
                        final Node fromNode = getNode(fromNodeId);
                        final Node toNode = getNode(toNodeId);
                        
                        final Edge e = new Edge(label, fromNode, toNode);
                        
                        fromNode.outgoingEdges.add(e);
                        toNode.incomingEdges.add(e);
                        
                        return e;
                    }
                }
                        
                public static void main (String[]args){
                    try {
                        new Program().start();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                        
                public void start() throws Exception {
                    Node firstNode = new Node("A", 0);
                    Node firstNode = new Node("B", 1);
                    Arc arcAB = new Edge("1", 0, 1);
                }
            }
            """;
}
