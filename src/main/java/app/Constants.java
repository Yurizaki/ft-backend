package app;

public abstract class Constants {
	
	// Holdings
	public static final String FT_HOLDINGS_URL = "https://markets.ft.com/data/etfs/tearsheet/holdings?s=";
	public static final String FT_HOLDINGS_MODULE_SELECTOR = ".mod-module__content";

	// Errors
	public static final String ERR_HOLDINGS_DIV_NOT_FOUND = "FT Holdings div not recognised. Top holdings cannot be retrieved.";
}
