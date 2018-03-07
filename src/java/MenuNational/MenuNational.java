/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuNational;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author utilisateur
 */
@WebService(serviceName = "MenuNational")
public class MenuNational {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getMenu")
    public String getMenu() {
        return "{type:kek}";
    }
}

