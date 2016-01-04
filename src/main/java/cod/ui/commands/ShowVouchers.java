package cod.ui.commands;

import cod.CookieOnDemand;
import cod.tcf.Vouchers;
import cod.ui.framework.Command;

public class ShowVouchers extends Command<CookieOnDemand> {

    @Override
    public String identifier()
    {
        return "vouchers";
    }

    @Override
    public void execute()
    {
        System.out.println(Vouchers.getInstance());
    }

    @Override
    public String describe()
    {
        return "show the cart contents for a given customer (cart CUSTOMER)";
    }
}
