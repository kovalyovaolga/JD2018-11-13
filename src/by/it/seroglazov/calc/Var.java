package by.it.seroglazov.calc;

import java.util.HashMap;
import java.util.TreeSet;

public abstract class Var implements Operations, ScalarOperations, VectorOperations, MatrixOperations, OperationsDispatch {

    private static HashMap<String, Var> vars = new HashMap<String, Var>();

    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;
    }

    static String getVars(){
        StringBuilder sb = new StringBuilder();
        for (String varName : vars.keySet()) {
            sb.append(varName);
            sb.append('=');
            sb.append(vars.get(varName));
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /*static String getSortedVars(){
        TreeSet<String> sortedNames = new TreeSet<>(vars.keySet());
        StringBuilder sb = new StringBuilder();
        for (String name : sortedNames) {
            sb.append(name);
            sb.append('=');
            sb.append(vars.get(name));
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }*/

    abstract String getType();

    @Override
    public String toString() {
        return "this abstract class";
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption("Сложение " + this + " + " + other + " невозможно.");
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption("Вычитание " + this + " - " + other + " невозможно.");
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption("Умножение " + this + " * " + other + " невозможно.");
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption("Деление " + this + " / " + other + " невозможно.");
    }

    static Var createVar(String strVar) throws CalcExeption {
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw new CalcExeption("Невозможно создать " + strVar);
    }

}
