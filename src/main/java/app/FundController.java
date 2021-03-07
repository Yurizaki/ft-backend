package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class FundController {
    
    @CrossOrigin(origins = "*")
    @GetMapping("/fund")
	public String fund(
        @RequestParam(value = "ticker", defaultValue = "IITU") String ticker) {
		
        return App.execute(ticker);
	}
}
