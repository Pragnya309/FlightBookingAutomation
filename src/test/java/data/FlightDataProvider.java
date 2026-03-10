package data;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class FlightDataProvider {
	@DataProvider(name = "flightData")
    public static Object[][] getFlightData() {

        String path = "src/test/resources/flightData.xlsx";

        return ExcelUtils.getExcelData(path, "Sheet1");
    }
}
