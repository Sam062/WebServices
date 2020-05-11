package base;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bill")
public class BillingProcess {

	@POST
	@Path("/gen")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Invoice calculateInvoiceData(Cart cobj) {
		var cid=cobj.getCid();
		var code=cobj.getCode();
		var inv=new Invoice();
		var gstPercent=12;

		var totalPrice=0.0;
		var prts=cobj.getPrts();
		List<SaleInfo> listSaleInfo=new ArrayList<>();
		for (Part part : prts) {

			var totalAmout=part.getPcost()*part.getQuantity();
			var discountAmt=totalAmout*part.getDiscPercent()/100;
			var amtAfterDisc=totalAmout-discountAmt;

			totalPrice+=amtAfterDisc;

			var saleInfo=new SaleInfo(
					part.getPid(),part.getPcode(),part.getPcost(),totalAmout,discountAmt,amtAfterDisc
					);

			//Added To List- List<SaleInfo>
			listSaleInfo.add(saleInfo);
		}
		var gstAmount=totalPrice*gstPercent/100;
		var bilingAmount=totalPrice+gstAmount;

		inv.setId(cid);
		inv.setCode(code);
		inv.setTotalPrice(totalPrice);
		inv.setGstAmount(gstAmount);
		inv.setBillAmount(bilingAmount);
		inv.setSaleInfo(listSaleInfo);

		return inv;
	}
}
