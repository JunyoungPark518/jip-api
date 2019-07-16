package kr.jip.api.v1.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/f")
public class FinanceController {
	
	@Autowired
	FinanceService service;

	@GetMapping("/detail")
	@ResponseBody
	public Finance detail(@RequestParam("phone") String phone) {
		return service.detail(phone);
	}
}