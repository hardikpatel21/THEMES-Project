/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.util.Random;

/**
 *
 * @author spiro16
 */
public class Randomnumber {
    public static void main(String[] args)
    {
        while(true)
        {
        Random ran=new Random();
        int acno=ran.nextInt(100);
        int k=acno+1000;
        System.out.println("k is "+k);
        }

    }
}
