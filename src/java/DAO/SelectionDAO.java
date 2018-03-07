/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MenuNational.Selection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class SelectionDAO extends DAO<Selection>{

    public SelectionDAO(Connection cnx) {
        super(cnx);
    }
    @Override
    public boolean create(Selection x) {

       String req = "INSERT INTO selections ('description' , 'price' , 'availability') "+
                    "VALUES ('"+x.getDescription()+"','"+x.getPrice()+"','"+x.getAvailability()+"')";
       
       Statement stm = null;
       try{
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0){
                stm.close();
                return true;
            }
       }
       catch (SQLException exp)
       {
       }
       finally{
            if (stm!=null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }	
            }
       }
       return false;
    }
    public ArrayList<Selection> findAll(){
        Statement stm = null;
        ResultSet r = null;      
        ArrayList<Selection> listeRetour = new ArrayList();
        try{
            stm = cnx.createStatement();
            r = stm.executeQuery("SELECT * FROM selections");
            Selection s;
            while (r.next()){
                boolean avail = r.getInt("availability") == 0?false:true;                         
                s = new Selection(
                    r.getInt("id"),
                    r.getString("description"),
                    r.getDouble("price"),
                    avail
                );        
                listeRetour.add(s);
            }   
            r.close();
            stm.close();
            return listeRetour;
        }
        catch (SQLException exp)
        { }
        finally{
            if (stm!=null){
                try {
                    r.close();
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }	
            }
        }
        return listeRetour;
    }
    @Override
    public boolean update(Selection x) {
        String req = "UPDATE selections SET "
                +", description = "+ x.getDescription() 
                +", price = "+ x.getPrice()
                +", availability = "+ x.getAvailability()
                    +", WHERE id = "+ x.getId();
        //System.out.println("REQUETE "+req);
        Statement stm = null;
        try{
            stm = cnx.createStatement(); 
            int n= stm.executeUpdate(req);
            if (n>0){
                stm.close();
                return true;
            }
        }
        catch (SQLException exp){
        }
        finally{
            if (stm!=null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    

    public boolean deleteById(int id) {
        String req = "DELETE 1 FROM selections WHERE id = "+id;
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
        finally{
            if (stm!=null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }	
            }
        }
        return false;
    } 


    @Override
    public boolean delete(Selection x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
