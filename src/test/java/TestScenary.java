import Steps.CatalogStep;
import Steps.CompareStep;
import Steps.ElementStep;
import Steps.HomeStep;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestScenary {

    void Test() {
        HomeStep homeStep = new HomeStep();
        homeStep.selectCatalog();
        homeStep.selectZoo();
        homeStep.checkDelicacy();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CatalogStep catalogStep = new CatalogStep();
        catalogStep.selectDelivery("Курьером");
        catalogStep.setMinMax("50", "150");
        catalogStep.checkDelicacyFiltersAll();
        catalogStep.checkDelicacy("Whiskas");
        String expectedNameFirst = catalogStep.getNameElement(1);
        catalogStep.clickElement(1);
        ElementStep elementStep = new ElementStep();
        elementStep.compare();
        elementStep.returnBack();
        catalogStep.checkDelicacy("Whiskas");
        catalogStep.checkDelicacy("Мнямс");
        String expectedNameSecond = catalogStep.getNameElement(2);
        catalogStep.clickElement(2);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementStep.compare();
        elementStep.viewCompare();
        CompareStep compare = new CompareStep();
        String actualNameFirst = compare.getName(2);
        String actualNameSecond = compare.getName(1);
        assertEquals(expectedNameFirst, actualNameFirst, "Название элемента соответствует");
        assertEquals(expectedNameSecond, actualNameSecond, "Название элемента соответствует");
        int actualPriceFirst = compare.getPrice(1);
        assertTrue(actualPriceFirst <= 300, "Цена первого элемента больше 300");
        int actualPriceSecond = compare.getPrice(2);
        assertTrue(actualPriceSecond <= 300, "Цена второго элемента больше 300");
        compare.delElement(2);
        int actualFind = compare.findElement("Whiskas");
        assertTrue(actualFind>=0, "Элемент " + actualFind + " отсутствует");
        compare.compareClear();
        int expectedElements = 0;
        int actualElements = compare.amountElements();
        assertEquals(expectedElements, actualElements, "Элементов в сравнении" + actualElements);
    }


}
