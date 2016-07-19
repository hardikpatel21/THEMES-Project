/**
 * Pay.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package payment;

public interface Pay extends java.rmi.Remote {
    public java.lang.String paybill(java.lang.String acno, java.lang.String name, java.lang.String amount) throws java.rmi.RemoteException;
}
