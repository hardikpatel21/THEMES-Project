/**
 * PayService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package payment;

public interface PayService extends javax.xml.rpc.Service {
    public java.lang.String getPayPortAddress();

    public payment.Pay getPayPort() throws javax.xml.rpc.ServiceException;

    public payment.Pay getPayPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
