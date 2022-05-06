import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListVisitor extends GrammarBaseVisitor<String> {
    private final List<String> errors = new ArrayList<>();
    private final List<String> globalGraphVars = new ArrayList<>();
    private final List<String> globalNodeVars = new ArrayList<>();
    private final List<String> globalArcVars = new ArrayList<>();

    @Override
    public String visitProgram(GrammarParser.ProgramContext ctx) {
        Variable.getInstance().incrementStack();
        String buffer = Template.PROGRAM;

        String buffer1 = "";
        for (GrammarParser.FunctionDeclareContext context : ctx.functionDeclare()) {
            buffer1 = visitFunctionDeclare(context);
        }

        buffer += "{";

        for (GrammarParser.StatementContext context : ctx.statement()) {
            buffer = visitStatement(context);
        }
        buffer += "}";
        buffer += buffer1;
        buffer += "}";

        String error = "";
        if (!errors.isEmpty()) {
            for (String string : errors) {
                error = string + "\n";
            }
            JOptionPane.showMessageDialog(null, error);
            throw new RuntimeException(error);
        }
        return buffer;
    }

    @Override
    public String visitFunctionDeclare(GrammarParser.FunctionDeclareContext ctx) {
        String functionName = ctx.NAME().get(0).getText();
        if (Variable.getInstance().containsFunction(functionName)) {
            errors.add("Function " + functionName + " already exists - (Declare_func)");
        }

        Variable.getInstance().addFunction(functionName);

        String buffer = "functionType " + functionName + "(";

        for (int index = 1; index < ctx.NAME().size(); index++) {
            String type = visitType(ctx.type(index - 1));
            String name = ctx.NAME().get(index).getText();

            if (type.equals("Graph")) {
                globalGraphVars.add(name);
            }
            if(type.equals("Node")){
                globalNodeVars.add(name);
            }
            else {
                globalArcVars.add(name);
            }

            buffer = type + " " + name;
        }

        buffer += ") throws Exception";
        buffer += "{";
        buffer += visitStatement((GrammarParser.StatementContext) ctx.statement());
        buffer += "}";
        return buffer;
    }

    @Override
    public String visitType(GrammarParser.TypeContext ctx) {
        if (ctx.ARC() != null) {
            return "Arc";
        }

        if (ctx.NODE() != null) {
            return "Node";
        }

        if (ctx.GRAPH() != null) {
            return "Graph";
        }

        if (ctx.VOID() != null) {
            return "Void";
        }
        return "";
    }

    @Override
    public String visitStatement(GrammarParser.StatementContext ctx) {
        if (ctx.print() != null) {
            return visitPrint(ctx.print());
        }

        if (ctx.functionCall() != null) {
            return visitFunctionCall(ctx.functionCall());
        }

        if (ctx.forCycle() != null) {
            return visitForCycle(ctx.forCycle());
        }

        if (ctx.variableDeclare() != null) {
            return visitVariableDeclare(ctx.variableDeclare());
        }

        if (ctx.assign() != null) {
            return visitAssign(ctx.assign());
        }

        if (ctx.ifBlock() != null) {
            return visitIfBlock(ctx.ifBlock());
        }

        if (ctx.addNode() != null) {
            return visitAddNode(ctx.addNode());
        }

        if (ctx.addArc() != null) {
            return visitAddArc(ctx.addArc());
        }

        if (ctx.remoteNode() != null) {
            return visitRemoteNode(ctx.remoteNode());
        }

        if (ctx.remoteArc() != null) {
            return visitRemoteArc(ctx.remoteArc());
        }

        if (ctx.getArc() != null) {
            return visitGetArc(ctx.getArc());
        }

        if (ctx.getNode() != null) {
            return visitGetNode(ctx.getNode());
        }

        if (ctx.statement() != null) {
            String buffer = "{";
            buffer += visitStatement((GrammarParser.StatementContext) ctx.statement()) + "}";
            return buffer;
        }
        return "";
    }

    @Override
    public String visitFunctionCall(GrammarParser.FunctionCallContext ctx) {
        String functionName = ctx.NAME().getText();
        if (!Variable.getInstance().containsFunction(functionName)) {
            errors.add("Function " + functionName + " doesn't exists - (FunctionCall)");
        }
        String buffer = functionName + "(";

        buffer += visitArgumentList(ctx.argumentList());
        buffer += ")";
        return buffer;
    }

    @Override
    public String visitForCycle(GrammarParser.ForCycleContext ctx) {
        String name1 = ctx.NAME().get(0).getText();
        String name2 = ctx.NAME().get(1).getText();

        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exist - (ForCycle)");
        }

        if (Variable.getInstance().containsArc(name2)) {
            errors.add("Variable arc" + name2 + " already exists - (ForCycle)");
        }

        if (Variable.getInstance().containsNode(name2)) {
            errors.add("Variable node" + name2 + " already exists - (ForCycle)");
        }

        globalNodeVars.add(name2);

        String buffer = "for (Node " + name2 + ":" + name1 + ".getGraph()" + ")";
        buffer += visitStatement(ctx.statement());

        return buffer;
    }

    @Override
    public String visitPrint(GrammarParser.PrintContext ctx) {
        if (ctx.STRING() != null) {
            return "System.out.println(" + ctx.STRING().getText() + ");";
        }

        if (ctx.NAME() != null) {
            String s = ctx.NAME().getText();
            if (!(Variable.getInstance().containsNode(s) | Variable.getInstance().containsGraph(s) | Variable.getInstance().containsArc(s))) {
                errors.add("Variable " + s + " doesn't exists - (Print)");
            }
            return "System.out.println(" + s + ");";
        }

        if (ctx.size() != null) {
            return "System.out.println(" + visitSize(ctx.size()) + ");";
        }

        return "";
    }

    @Override
    public String visitIfBlock(GrammarParser.IfBlockContext ctx) {
        String buffer = "";
        buffer += "if(" + visitExpr(ctx.expr()) + ")" + visitStatement((GrammarParser.StatementContext) ctx.statement());
        if (ctx.statement() != null) {
            buffer += "else";
            buffer += visitStatement((GrammarParser.StatementContext) ctx.statement());
        }
        return buffer;
    }

    @Override
    public String visitExpr(GrammarParser.ExprContext ctx) {
        if (ctx.getArc() != null) {
            return visitGetArc(ctx.getArc());
        }

        if (ctx.getNode() != null) {
            return visitGetNode(ctx.getNode());
        }

        if (ctx.functionCall() != null) {
            return visitFunctionCall(ctx.functionCall());
        }
        String name = ctx.NAME().getText();
        String buffer = "";

        if (ctx.NAME() != null) {
            if (Variable.getInstance().containsNode(name)) {
                errors.add("Variable node " + name + " already exists - (expr)");

                Variable.getInstance().addNode(name);
                buffer += "Node " + name + "=";
            }
            if (Variable.getInstance().containsArc(name)) {
                errors.add("Variable arc " + name + " already exists - (expr)");

                Variable.getInstance().addArc(name);
                buffer += "Arc " + name + "=";
            }
        } else {
            if (!Variable.getInstance().containsGraph(name)) {
                errors.add("Variable graph " + name + " doesn't exists - (expr)");
            }
            buffer += name + "=";
        }

        if (ctx.STRING() != null) {
            if (ctx.getNode() != null) {
                buffer += "new Node(" + ctx.STRING().getText() + ");";
            } else if (ctx.getArc() != null) {
                buffer += "new Arc(" + ctx.STRING().getText() + ");";
            } else {
                String name2 = ctx.NAME().getText();
                if (!Variable.getInstance().containsGraph(name2)) {
                    errors.add("Variable node     " + name2 + " doesn't exists - (expr)");
                    buffer += "new Node(" + name2 + ".toString());";

                }
            }
        }
        return buffer;
    }

    @Override
    public String visitAddNode(GrammarParser.AddNodeContext ctx) {
        String name1 = ctx.NAME().get(0).getText();
        String name2 = ctx.NAME().get(1).getText();

        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exists - (addNode)");
        }

        if (!Variable.getInstance().containsNode(name2)) {
            errors.add("Variable node " + name2 + " doesn't exists - (addNode)");
        }

        return name1 + ".add(" + name2 + ");";
    }

    @Override
    public String visitAddArc(GrammarParser.AddArcContext ctx) {
        String name1 = ctx.NAME().get(0).getText();
        String name2 = ctx.NAME().get(1).getText();
        String name3 = ctx.NAME().get(2).getText();
        String name4 = ctx.NAME().get(3).getText();
        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exists - (addArc)");
        }

        if (!Variable.getInstance().containsNode(name2)) {
            errors.add("Variable node " + name2 + " doesn't exists - (addArc)");
        }

        if (!Variable.getInstance().containsNode(name3)) {
            errors.add("Variable node " + name2 + " doesn't exists - (addArc)");
        }

        if (!Variable.getInstance().containsArc(name4)) {
            errors.add("Variable arc " + name2 + " doesn't exists - (addArc)");
        }

        return name1 + ".add(" + name4 + ")" + ";";
    }


    @Override
    public String visitGetNode(GrammarParser.GetNodeContext ctx) {
        String name1 = ctx.NAME().getText();

        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exists - (getNode)");
        }

        return name1 + ".get(" + ctx.NUMBER().getText() + ")";
    }

    @Override
    public String visitGetArc(GrammarParser.GetArcContext ctx) {
        String name1 = ctx.NAME().getText();

        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exists - (getArc)");
        }

        return name1 + ".get(" + ctx.NUMBER().get(0).getText() + "," + ctx.NUMBER().get(1).getText() + ")";
    }

    @Override
    public String visitRemoteNode(GrammarParser.RemoteNodeContext ctx) {
        String name1 = ctx.NAME().get(0).getText();
        String name2 = ctx.NAME().get(1).getText();

        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exists - (deleteNode)");
        }
        String buffer = "";

        if (!Variable.getInstance().containsNode(name2)) {
            errors.add("Variable node " + name2 + " doesn't exists - (deleteNode)");
        }
        else {
            buffer += name1 + ".remove(" + name2 + ");";
        }

        return buffer;
    }

    @Override
    public String visitRemoteArc(GrammarParser.RemoteArcContext ctx) {
        String name1 = ctx.NAME().get(0).getText();
        String name2 = ctx.NAME().get(1).getText();
        String name3 = ctx.NAME().get(2).getText();
        String buffer = "";
        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exists - (deleteNode)");
        }
        else {

            if (!Variable.getInstance().containsNode(name2)) {
                errors.add("Variable node " + name2 + " doesn't exists - (deleteNode)");
            } else {
                buffer += name1 + ".remove(" + name2 + ");";
            }
            if (Variable.getInstance().containsNode(name3)) {
                buffer += name1 + ".remove(" + name2 + ");";
            }
        }
        return buffer;
    }

    @Override
    public String visitSize(GrammarParser.SizeContext ctx) {
        String name1 = ctx.NAME().getText();

        if (!Variable.getInstance().containsGraph(name1)) {
            errors.add("Variable graph " + name1 + " doesn't exists - (size)");
        }

        return name1 + ".getGraph().size()";
    }

    @Override
    public String visitArgumentList(GrammarParser.ArgumentListContext ctx){
        String buffer = "";
        if (ctx.expr() != null){
            return visitExpr((GrammarParser.ExprContext) ctx.expr());
        }
        buffer += ',';
        if (ctx.expr() != null){
            return visitExpr((GrammarParser.ExprContext) ctx.expr());
        }

        return buffer;
    }

    @Override public String visitAssign(GrammarParser.AssignContext ctx){
        String name = ctx.NAME().getText();
        String buffer = "";

        if (ctx.NAME().getText().equals("Graph")) {
            if (Variable.getInstance().containsGraph(name)) {
                errors.add("Variable graph " + name + " already exists - (Assign_op)");
            } else {
                buffer += "Graph " + name + "=";
                buffer += visitExpr(ctx.expr());
            }
        }

        if (ctx.NAME().getText().equals("Arc")) {
            if (Variable.getInstance().containsArc(name)) {
                errors.add("Variable arc " + name + " already exists - (Assign_op)");
            } else {
                buffer += "Arc " + name + "=";
                buffer += visitExpr(ctx.expr());
            }
        }

        if (ctx.NAME().getText().equals("Node")) {
            if (Variable.getInstance().containsNode(name)) {
                errors.add("Variable node " + name + " already exists - (Assign_op)");
            } else {
                buffer += "Node " + name + "=";
                buffer += visitExpr(ctx.expr());
            }
        }

        return buffer;
    }
    @Override
    public String visitVariableDeclare(GrammarParser.VariableDeclareContext ctx) {
        String name = ctx.NAME().getText();
        String buffer = "";
        String ass = ctx.ASSIGN().getText();

        if (ctx.NAME().getText().equals("Graph")) {
            if (Variable.getInstance().containsGraph(name)) {
                errors.add("Variable graph " + name + " already exists - (VariableDeclare)");
            } else {
                buffer += "Graph " + name;
                if(ass != null) {
                    buffer += "=";
                    buffer += visitExpr(ctx.expr());
                }
            }
        }

        if (ctx.NAME().getText().equals("Arc")) {
            if (Variable.getInstance().containsArc(name)) {
                errors.add("Variable arc " + name + " already exists - (VariableDeclare)");
            } else {
                buffer += "Arc " + name;
                if(ass != null) {
                    buffer += "=";
                    buffer += visitExpr(ctx.expr());
                }            }
        }

        if (ctx.NAME().getText().equals("Node")) {
            if (Variable.getInstance().containsNode(name)) {
                errors.add("Variable node " + name + " already exists - (VariableDeclare)");
            } else {
                buffer += "Node " + name;
                if(ass != null) {
                    buffer += "=";
                    buffer += visitExpr(ctx.expr());
                }
            }
        }

        return buffer;
    }

}
