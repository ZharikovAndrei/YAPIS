import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Variable {
    private static final Variable INSTANCE = new Variable();
    private Variable() {}
    public static Variable getInstance() { return INSTANCE; }

    private final Set<String> graphVarSet = new HashSet<>();
    private final Set<String> nodeVarSet = new HashSet<>();
    private final Set<String> arcVarSet = new HashSet<>();
    private final List<Set<String>> stack = new ArrayList<>();
    private final Set<String> functionSet = new HashSet<>();

    public void incrementStack() {
        Set<String> set = new HashSet<>();
        stack.add(set);
    }
    public void decrementStack() {
        for (String s : stack.get(stack.size() - 1)) {
            graphVarSet.remove(s);
            nodeVarSet.remove(s);
            arcVarSet.remove(s);
        }
        stack.remove(stack.size() - 1);
    }
    public void addNode(String var) {
        stack.get(stack.size() - 1).add(var);
        nodeVarSet.add(var);
    }

    public void addArc(String var) {
        stack.get(stack.size() - 1).add(var);
        arcVarSet.add(var);
    }

    public boolean containsGraph(String var) {
        return graphVarSet.contains(var);
    }
    public boolean containsNode(String var) {
        return nodeVarSet.contains(var);
    }
    public boolean containsArc(String var) {
        return arcVarSet.contains(var);
    }
    public void addFunction(String var) {
        functionSet.add(var);
    }
    public boolean containsFunction(String var) {
        return functionSet.contains(var);
    }
}
