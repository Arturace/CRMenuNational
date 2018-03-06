/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MenuNational.Option;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class OptionDAO extends DAO<Option>{

    public OptionDAO(Connection cnx) {
        super(cnx);
    }
    @Override
    public boolean create(Option x) {

       String req = "INSERT INTO options ('name' , 'minSelection' , 'maxSelection') "+
                    "VALUES ('"+x.getName()+"','"+x.getMinSelection()+"','"+x.getMaxSelection()+"')";
       
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
    public ArrayList<Option> findAll(){ // *********************************************************
        Statement stm = null;
        ResultSet r = null;      
        ArrayList<Option> listeRetour = new ArrayList();
        try 
        {
            stm = cnx.createStatement();
            r = stm.executeQuery("SELECT * FROM options");
            Option o;
            while (r.next())
            {                     
                o = new Option(
                    r.getInt("id"),
                    r.getString("name"),
                    r.getDouble("minSelection"),
                    r.getDouble("maxSelection")
                );        
                listeRetour.add(o);
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
    public boolean update(Option x) {
        String req = "UPDATE options SET "
                +", name = "+ x.getName() 
                +", minSelection = "+ x.getMinSelection()
                +", maxSelectiuon = "+ x.getMaxSelection()
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
    

    public boolean deleteById(int id) {
        String req = "DELETE 1 FROM options WHERE id = "+id;
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


    @Override
    public boolean delete(Option x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
