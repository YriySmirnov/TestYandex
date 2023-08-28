package pages;

import static util.DriverManager.getDriver;

public class CatalogPages {
    public String heading = "[data-zone-name=\"searchTitle\"]";
    public String priceMin = "input[id*=price][id*=min]";
    public String priceMax = "input[id*=price][id*=max]";
    public String manufacturerShowAll = "[data-baobab-name=\"showMoreFilters\"]";
    public String element = "h3 a span";
    public static String catalogPage = getDriver().getWindowHandle();

}
