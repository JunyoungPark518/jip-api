package kr.jip.api.v1.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class IndexController {
	
	@Autowired
	IndexService service;

	@GetMapping("/")
	public String index(Model model){
		model.addAttribute("title", "cwk1123");
		return "index";
	}

	@PostMapping("/login")
	@ResponseBody
	public Object login(@RequestParam("phone") String phone
			, @RequestParam("password") String password) {

		return service.login(new HashMap(){{
			put("phone", phone);
			put("password", password);
		}});
	}

}