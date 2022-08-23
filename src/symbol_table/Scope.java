package symbol_table;
import java.util.HashMap;
import java.util.Map;

public class Scope {

    Map<String , String> ScopeVariables = new HashMap<>();
    Map<String , Integer> listValues = new HashMap<>();
    int ID = 1;
    Scope parent ;

    public  void increaseID(int id){  ID = id + 1;}

    public Scope getParent() {
        return parent;
    }

    public void setParent(Scope parent) {
        this.parent = parent;
    }

    public Map<String, String> getScopeVariables() {
        return ScopeVariables;
    }

    public void setScopeVariables(String name , String type) {
        this.ScopeVariables.put(name, type);
    }

    public Map<String, Integer> getListValues() {
        return listValues;
    }

    public void setListValues(String listName , int numberOfValues) {
        this.listValues.put(listName,numberOfValues);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
