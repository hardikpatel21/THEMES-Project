/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package payment;

import DB.Acreate;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author spiro16
 */
@WebService()
public class Pay {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "paybill")
    public String paybill(@WebParam(name = "Acno")
    String Acno, @WebParam(name = "name")
    String name, @WebParam(name = "amount")
    String amount) {
        System.out.println("name in webs "+name);
        System.out.println("Acc in webservice "+Acno);
        System.out.println("amount in websrvc "+amount);
     String result=new Acreate().payment( name,amount,Acno);

        return result ;
    }

}
