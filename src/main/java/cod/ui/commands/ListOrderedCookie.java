package cod.ui.commands;

import cod.CookieOnDemand;
import cod.tcf.Customer;
import cod.tcf.Item;
import cod.ui.framework.Command;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by corentinhardy on 04/01/2016.
 */
public class ListOrderedCookie extends Command<CookieOnDemand> {
    protected Customer customer;

    @Override
    public String identifier() { return  "recipes"; }

    @Override
    public void load(List<String> args) {
        customer = system.getCustomers().findByFirstName(args.get(0)).get();
    }

    @Override
    public void execute() {
        try{
            for(Item i : customer.getVoucher().get().getContents()) {
                System.out.println("  - " + i.toString());
            }
        }catch(NoSuchElementException e){
            System.out.println("There is no voucher for this customer.");
        }
    }

    @Override
    public String describe() {
        return "List the cookie that a given customer has ordered";
    }
}
