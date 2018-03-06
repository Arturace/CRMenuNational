/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuNational;

import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class Option {
    private int id;
    private String name;
    private int minSelection;
    private int maxSelection;
    private ArrayList<Selection> selections;

    public Option(int aInt, String string, double aDouble, double aDouble0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinSelection() {
        return minSelection;
    }

    public void setMinSelection(int minSelection) {
        this.minSelection = minSelection;
    }

    public int getMaxSelection() {
        return maxSelection;
    }

    public void setMaxSelection(int maxSelection) {
        this.maxSelection = maxSelection;
    }

    public ArrayList<Selection> getSelections() {
        return selections;
    }

    public void setSelections(ArrayList<Selection> selections) {
        this.selections = selections;
    }
    
    
}
