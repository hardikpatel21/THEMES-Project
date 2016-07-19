package testcodes;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class trmap {
    public static void main(String[] args) {
        Map m=new TreeMap();
        m.put("1", "a");
        m.put("2", "b");
        m.put("3", "c");
        System.out.println("map is "+m);
        Set st=new TreeSet();
        st=m.keySet();
        System.out.println("set value is "+st);
        Iterator it=st.iterator();
        while(it.hasNext())
        {
            String key=it.next().toString().trim();
            System.out.println("key is "+key);
            String value=(String) m.get(key);
            System.out.println("value is "+value);


        }
    }
}
