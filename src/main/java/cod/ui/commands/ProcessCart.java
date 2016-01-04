package cod.ui.commands;

import java.util.List;

import cod.CookieOnDemand;
import cod.tcf.Customer;
import cod.tcf.Voucher;
import cod.tcf.Vouchers;
import cod.ui.framework.Command;

public class ProcessCart extends Command<CookieOnDemand> {

    private Customer customer;

    @Override
    public String identifier()
    {
        return "send";
    }

    @Override
    public void load(List<String> args)
    {
        customer = system.getCustomers().findByFirstName(args.get(0)).get();
    }

    @Override
    public void execute()
    {
        system.process(customer);
        Voucher v = customer.getVoucher().get();
        Vouchers.getInstance().add(v);
        System.out.println("  " + v);
    }

    @Override
    public String describe()
    {
        return "Send the contents of the cart to the bakery (send CUSTOMER)";
    }
}
