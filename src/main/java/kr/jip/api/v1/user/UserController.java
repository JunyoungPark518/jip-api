package kr.jip.api.v1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping("/detail")
	@ResponseBody
	public User detail(@RequestParam("phone") String phone) {
		return service.detail(phone);
	}

	@GetMapping("/selectUserById")
	@ResponseBody
	public User selectUserById(@RequestParam("userId") Integer userId) { return service.selectUserById(userId); }

	@GetMapping("/list")
	@ResponseBody
	public Object mock() {
		return service.mock();
	}
}