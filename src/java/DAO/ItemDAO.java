/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MenuNational.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author utilisateur
 */
public class ItemDAO extends DAO<Item>{

    public ItemDAO(Connection cnx) {
        super(cnx);
    }
    @Override
    public boolean create(Item x) {

       String req = "INSERT INTO items ('name' , 'price' , 'description' 'category' , 'availability') "+
                    "VALUES ('"+x.getName()+"','"+x.getPrice()+"','"+x.getDescription()+"','"+x.getCategory()+"','"+x.getAvailability()+"')";
       
       Statement stm = null;
       try 
       {
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0)
            {
                 stm.close();
                 return true;
            }
       }
       catch (SQLException exp)
       {
       }
       finally
       {
            if (stm!=null)
            try {
                stm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }			
       }
       return false;
    }
    public ArrayList<Item> findAll(){ //******************************************************************
        Statement stm = null;
        ResultSet r = null;      
        ArrayList<Item> listeRetour = new ArrayList();
        try 
        {
            stm = cnx.createStatement();
            r = stm.executeQuery("SELECT items.id, items.name, items.price, items.description, items.category, items.availability, options.name, options.minSelection, options.maxSelection, selections.description, selections.price, selections.availability FROM items \n" +
                                "INNER JOIN items_options ON items_options.itemsId = items.id\n" +
                                "INNER JOIN options ON options.id = items_options.optionID\n" +
                                "INNER JOIN options_selections ON options_elections.optionId\n" +
                                "INNER JOIN selections ON selections.id = options_selections.selectionsId");
            Item i;
            while (r.next())
            {
                                    
                i = new Item(
                    r.getInt("id"),
                    r.getInt("name"),
                    r.getInt("price"),
                    r.getInt("description"),
                    r.getInt("category"),    
                    r.getDouble("availability")
                );        
                
                listeRetour.add(i);
            }   
            r.close();
            stm.close();
            return listeRetour;
        }
        catch (SQLException exp)
        { }
        finally
        {
            if (stm!=null)
                try {
                    r.close();
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }			
        }
        return listeRetour;
    }
    @Override
    public boolean update(Item x) {
        String req = "UPDATE items SET "
            +", name = "+ x.getName() 
            +", price = "+ x.getPrice() 
            +", description = "+ x.getDescription() 
            +", category = "+ x.getCategory()
            +", availability = "+ x.getAvailability()
            +", WHERE id = "+ x.getId();
        //System.out.println("REQUETE "+req);
        Statement stm = null;
        try 
        {
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0)
            {
                stm.close();
                return true;
            }
        }
        catch (SQLException exp)
        {
        }
        finally
        {
            if (stm!=null)
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }			
        }
        return false;
    }
    
    @Override
    public boolean deleteById(int id) {
        String req = "DELETE 1 FROM items WHERE id = "+id;
        //System.out.println("REQUETE "+req);
        Statement stm = null;
        try{
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0) {
                stm.close();
                return true;
            }
        }
        catch (SQLException exp) {
        }
        finally
        {
            if (stm!=null)
            try {
                stm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }			
        }
        return false;
    }     
}
