package CNA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Findingdate
{
	

	 public List call(List l,int period,int cost)
		{
		 List re= new ArrayList();
		 int syear = Integer.parseInt(l.get(0).toString());
		 int eyear = Integer.parseInt(l.get(1).toString());
		 int smonth=0;
		 if(l.get(2).toString().equals("Jan"))
		 {
			smonth=1;
		 }
		 if(l.get(2).toString().equals("Feb"))
		 {
			smonth=2;
		 }
		 if(l.get(2).toString().equals("Mar"))
		 {
			smonth=3;
		 }
		 if(l.get(2).toString().equals("Apr"))
		 {
			smonth=4;
		 }
		 if(l.get(2).toString().equals("May"))
		 {
			smonth=5;
		 }
		 if(l.get(2).toString().equals("Jun"))
		 {
			smonth=6;
		 }
		 if(l.get(2).toString().equals("Jul"))
		 {
			smonth=7;
		 }
		 if(l.get(2).toString().equals("Aug"))
		 {
			smonth=8;
		 }
		 if(l.get(2).toString().equals("Sep"))
		 {
			smonth=9;
		 }
		 if(l.get(2).toString().equals("Oct"))
		 {
			smonth=10;
		 }
		 if(l.get(2).toString().equals("Nov"))
		 {
			smonth=11;
		 }
		 if(l.get(2).toString().equals("Dec"))
		 {
			smonth=12;
		 }
		 
		 int emonth=0;//Mar
		 if(l.get(3).toString().equals("Jan"))
		 {
			emonth=1;
		 }
		 if(l.get(3).toString().equals("Feb"))
		 {
			emonth=2;
		 }
		 if(l.get(3).toString().equals("Mar"))
		 {
			emonth=3;
		 }
		 if(l.get(3).toString().equals("Apr"))
		 {
			emonth=4;
		 }
		 if(l.get(3).toString().equals("May"))
		 {
			emonth=5;
		 }
		 if(l.get(3).toString().equals("Jun"))
		 {
			emonth=6;
		 }
		 if(l.get(3).toString().equals("Jul"))
		 {
			emonth=7;
		 }
		 if(l.get(3).toString().equals("Aug"))
		 {
			emonth=8;
		 }
		 if(l.get(3).toString().equals("Sep"))
		 {
			emonth=9;
		 }
		 if(l.get(3).toString().equals("Oct"))
		 {
			emonth=10;
		 }
		 if(l.get(3).toString().equals("Nov"))
		 {
			emonth=11;
		 }
		 if(l.get(3).toString().equals("Dec"))
		 {
			emonth=12;
		 }
		 
		 int sday = Integer.parseInt(l.get(4).toString());;
		 int eday = Integer.parseInt(l.get(5).toString());;

	 Date startDate = new Date(syear-1900,smonth-1,sday);
	 Date endDate = new Date(eyear-1900,emonth-1,eday);
	 int difInDays = (int) ((endDate.getTime() - startDate.getTime())/(1000*60*60*24));
	 System.out.println(""+difInDays);
	 int amt= 0;
	 int dif=0;
	 if(difInDays<=period)
	 {
		amt=cost; 
	 }
	 else
	 {
		 dif= cost/period;
		 amt=cost+((difInDays-period)*dif);
	 }
	 System.out.println(amt);
	 re.add(difInDays);
	 re.add(amt);
	 return re;
		}
	 
}
