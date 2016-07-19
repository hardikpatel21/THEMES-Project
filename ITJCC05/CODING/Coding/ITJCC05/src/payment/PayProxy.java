package payment;

public class PayProxy implements payment.Pay {
  private String _endpoint = null;
  private payment.Pay pay = null;
  
  public PayProxy() {
    _initPayProxy();
  }
  
  public PayProxy(String endpoint) {
    _endpoint = endpoint;
    _initPayProxy();
  }
  
  private void _initPayProxy() {
    try {
      pay = (new payment.PayServiceLocator()).getPayPort();
      if (pay != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pay)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pay)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pay != null)
      ((javax.xml.rpc.Stub)pay)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public payment.Pay getPay() {
    if (pay == null)
      _initPayProxy();
    return pay;
  }
  
  public java.lang.String paybill(java.lang.String acno, java.lang.String name, java.lang.String amount) throws java.rmi.RemoteException{
    if (pay == null)
      _initPayProxy();
    return pay.paybill(acno, name, amount);
  }
  
  
}