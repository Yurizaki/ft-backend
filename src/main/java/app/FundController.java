package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundController {
    

    @GetMapping("/fund")
	public String fund(
        @RequestParam(value = "ticker", defaultValue = "IITU") String ticker) {
		
        return App.execute(ticker);
	}
}
