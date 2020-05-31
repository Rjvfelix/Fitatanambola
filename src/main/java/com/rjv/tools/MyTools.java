package com.rjv.tools;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MyTools {
	public static String formatVola(double vola) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("Ar");
        dfs.setGroupingSeparator(' ');
        dfs.setMonetaryDecimalSeparator(',');
      
        ((DecimalFormat) nf).setDecimalFormatSymbols(dfs);
        return nf.format(vola).replaceAll(",00", "");
    }
}
