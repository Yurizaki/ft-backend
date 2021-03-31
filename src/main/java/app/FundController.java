package app;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class FundController {

	@CrossOrigin(origins = "*")
	@GetMapping("/fund")
	public String fund(@RequestParam(value = "ticker", defaultValue = "IITU") String ticker) {

		return execute(ticker);
	}

	public String execute(String fundTicker) {
		try {
			String search = Constants.FT_HOLDINGS_URL + fundTicker;
			Document doc = Jsoup.connect(search).get();
			String fundName = doc.title();

			if (fundName != null) {
				String arr[] = fundName.split(":");
				fundName = arr[0];
			}


			Elements moduleDivs = doc.select(Constants.FT_HOLDINGS_MODULE_SELECTOR);
			if (!moduleDivs.is("div")) {
				handleError(Constants.ERR_HOLDINGS_DIV_NOT_FOUND);
			}
			if (moduleDivs.size() <= 0) {
			}

			Element holdingsDiv = moduleDivs.get(2);
			if (!holdingsDiv.is("div")) {
			}

			Element holdingsTable = holdingsDiv.child(1);
			if (!holdingsDiv.is("table")) {
			}

			Element holdingsTableBody = holdingsTable.child(1);

			ArrayList<Holding> holdingsList = new ArrayList<Holding>();
			for (int i = 0; i < holdingsTableBody.childrenSize(); i++) {
				Element row = holdingsTableBody.child(i);

				String holdingName = row.child(0).text().split(":")[0];
				String yearChange = row.child(1).text();
				String holdingWeight = row.child(2).text();

				Holding holding = new Holding(holdingName, yearChange, holdingWeight);
				holdingsList.add(holding);
			}

			Fund fund = new Fund(fundName, fundTicker, holdingsList);
			FundControllerResponse response = new FundControllerResponse(fund, search);

			ObjectMapper mapper = new ObjectMapper();
			String jsonStr;
			try {
				jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
				System.out.println(jsonStr);
				return jsonStr;
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void handleError(String error) {
		System.out.println("###################");
		System.out.println(error);
		System.out.println("###################");
	}
}
