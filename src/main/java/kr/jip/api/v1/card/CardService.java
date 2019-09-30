package kr.jip.api.v1.card;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class CardService {

	// Mappers
	@Autowired
	CardMapper cardMapper;

	public List<Usage> list(int userId, int pageSize, int startIndex) {
		List<Usage> list = cardMapper.selectUsageByUserId(new HashMap(){{
			put("userId", userId);
			put("pageSize", pageSize);
			put("startIndex", startIndex);
		}});
		return list;
	}

	public void insertUsage(int userId, int cardId, int cardBSeq, int origin, String usageName, String memo) {
		cardMapper.insertUsage(new HashMap(){{
			put("userId", userId);
			put("cardId", cardId);
			put("cardBSeq", cardBSeq);
			put("origin", origin);
			put("usageName", usageName);
			put("memo", memo);
		}});

	}


}
