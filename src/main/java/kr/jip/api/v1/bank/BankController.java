package kr.jip.api.v1.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bank")
public class BankController {

	@Autowired
	BankService service;

	@GetMapping("/list")
	@ResponseBody
	public List list(@RequestParam("userId") int userId) {
		return service.list(userId);
	}

	@PostMapping("/insert")
	@ResponseBody
	public void insert(@RequestParam("userId") int userId
		, @RequestParam("name") String name
		, @RequestParam("account") String account) {
		service.insertBank(userId, name, account);
	}

	@PostMapping("/remove")
	@ResponseBody
	public void insert(@RequestParam("userId") int userId
			, @RequestParam("name") String name) {
		service.removeBank(userId, name);
	}
}