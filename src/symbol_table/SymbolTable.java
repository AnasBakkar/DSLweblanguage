package symbol_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable {
    List<Scope> scopes = new ArrayList<>() ;
    Map<String , String > page_controller  =  new HashMap<>();
    Map<String , String > pageAndItsController  =  new HashMap<>();
    Map<String , Integer > paramsNumber = new HashMap<>();

    public Map<String, String> getPageAndItsController() {
        return pageAndItsController;
    }

    public void setPageAndItsController(String page,String controller) {
        this.pageAndItsController.put(page,controller);
    }

    public List<Scope> getScopes() {
        return scopes;
    }

    public void setScopes(Scope scope) {
        this.scopes.add(scope);
    }

    public Map<String, String> getPage_controller() {
        return page_controller;
    }

    public void setPage_controller(String page, String controller) {
        this.page_controller.put(page , controller);
    }

    public void setPage_controller_index(int index, String controller) {
        page_controller.replace( this.page_controller.keySet().toArray()[index].toString() , controller);
    }

    public Map<String, Integer> getParamsNumber() {
        return paramsNumber;
    }

    public void setParamsNumber(String funcName, int paramsNumber) {
        this.paramsNumber.put(funcName,paramsNumber);
    }
}
