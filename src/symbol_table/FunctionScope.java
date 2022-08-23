package symbol_table;

import java.util.HashMap;
import java.util.Map;

public class FunctionScope extends Scope{
    String functionName;
    Map<String,String> params = new HashMap<>();

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Map<String, String> getParameters() {
        return params;
    }

    public void setParameters(String name , String type) {
        this.params.put(name, type);
    }
}
