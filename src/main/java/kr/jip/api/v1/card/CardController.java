package kr.jip.api.v1.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

	@Autowired
	CardService service;


	@GetMapping("/list")
	@ResponseBody
	public List list(@RequestParam("userId") int userId) {
		return service.list(userId);
	}

	@GetMapping("/usageList")
	@ResponseBody
	public CardUsageMain usageList(@RequestParam("userId") int userId
		, @RequestParam(value="cardId", defaultValue = "0", required = false) int cardId
		, @RequestParam(value="pageSize", defaultValue = "10", required = false) int pageSize
		, @RequestParam(value="startIndex", defaultValue = "0", required = false) int startIndex) {
		return service.usageList(userId, cardId, pageSize, startIndex);
	}

	@PostMapping("/insert")
	@ResponseBody
	public void insert(@RequestParam("userId") int userId
		, @RequestParam("cardId") int cardId
		, @RequestParam("cardBSeq") int cardBSeq
		, @RequestParam("origin") int origin
		, @RequestParam("usageName") String usageName
		, @RequestParam("memo") String memo) {
		service.insertUsage(userId, cardId, cardBSeq, origin, usageName, memo);
	}
}