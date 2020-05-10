package base;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/customer")
public class CustRestController {

	@POST
	@Consumes("application/json")
	@Path("/gen")
	public String showMsg(Customer cust) {
		GeneratedBill gb=null;
			Map<String, Double> listOfItems=Map.of("PEN",16.0,"CAR",5000.0,"BIKE",2400.0);
			Set<String> items=listOfItems.keySet();
			Iterator<String> itemsItr=items.iterator();
			Collection<Double> itemCosts=listOfItems.values();
			Iterator<Double> costItr=itemCosts.iterator();

			List<Integer> discount=List.of(50,50,50);
			Iterator<Integer> discItr=discount.iterator();

			Map<String, Integer> cart=Map.of("PEN",1,"CAR",1,"BIKE",1);
			Collection<Integer> noItems=cart.values();
			Iterator<Integer>noOfItems=noItems.iterator();


			Map<String, Double> finalCartValue=new LinkedHashMap<>();
			Double toPay=0.0;
			while(discItr.hasNext()) {
				double totalCost=costItr.next()*noOfItems.next();
				Double disc=totalCost*discItr.next()/100;
				double finCost=totalCost-disc;
				finalCartValue.put(itemsItr.next(), finCost);
				toPay+=finCost;
			}
			Double billingCost=toPay+(toPay*12/100);//with 12%GST

			gb=new GeneratedBill(cust.getCustName(), listOfItems, cart, discount, finalCartValue,billingCost,"GST =12%");
		return "--GENERATED BILL--\n"+gb;
	}
}
