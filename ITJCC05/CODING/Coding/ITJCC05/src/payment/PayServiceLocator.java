/**
 * PayServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package payment;

public class PayServiceLocator extends org.apache.axis.client.Service implements payment.PayService {

    public PayServiceLocator() {
    }


    public PayServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PayServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PayPort
    private java.lang.String PayPort_address = "http://localhost:8084/Bank/Pay";

    public java.lang.String getPayPortAddress() {
        return PayPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PayPortWSDDServiceName = "PayPort";

    public java.lang.String getPayPortWSDDServiceName() {
        return PayPortWSDDServiceName;
    }

    public void setPayPortWSDDServiceName(java.lang.String name) {
        PayPortWSDDServiceName = name;
    }

    public payment.Pay getPayPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PayPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPayPort(endpoint);
    }

    public payment.Pay getPayPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            payment.PayPortBindingStub _stub = new payment.PayPortBindingStub(portAddress, this);
            _stub.setPortName(getPayPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPayPortEndpointAddress(java.lang.String address) {
        PayPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (payment.Pay.class.isAssignableFrom(serviceEndpointInterface)) {
                payment.PayPortBindingStub _stub = new payment.PayPortBindingStub(new java.net.URL(PayPort_address), this);
                _stub.setPortName(getPayPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PayPort".equals(inputPortName)) {
            return getPayPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://payment/", "PayService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://payment/", "PayPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PayPort".equals(portName)) {
            setPayPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
