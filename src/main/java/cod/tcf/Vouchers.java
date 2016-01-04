package cod.tcf;

import java.util.ArrayList;
import java.util.List;

public class Vouchers {

    private static List<Voucher> vouchers = new ArrayList<Voucher>();

    private Vouchers()
    {

    }

    public static List<Voucher> getInstance()
    {
        return vouchers;
    }
}
