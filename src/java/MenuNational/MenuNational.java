/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuNational;

import DAO.Connexion;
import DAO.ItemDAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
/**
 *
 * @author utilisateur
 */
@WebService(serviceName = "MenuNational")
public class MenuNational {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "menu")
    public String getMenu() {
        ItemDAO dao;
        String json = "[]";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connexion.setUrl("jdbc:mysql://localhost/orangecrushjava?user=root&password=root");
            Connection cnx = Connexion.getInstance();

            dao = new ItemDAO(cnx);
            
            ArrayList<Item> menu = dao.getMenu();
            
            //Convertissement en JSON
            ObjectMapper mapper = new ObjectMapper();

            try {
                json = mapper.writeValueAsString(menu);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(MenuNational.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuNational.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
}

