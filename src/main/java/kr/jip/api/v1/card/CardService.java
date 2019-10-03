package kr.jip.api.v1.card;

import kr.jip.api.util.MaskUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class CardService {

	// Mappers
	@Autowired
	CardMapper cardMapper;

	public List<Card> list(int userId) {
		return cardMapper.selectCardByUserId(new HashMap(){{
			put("userId", userId);
		}})
		.stream()
		.peek(card -> card.setMaskCardNo(MaskUtil.getCardMaskingFormat(card)))
		.collect(toList());
	}

	public CardUsageMain usageList(int userId, int cardId, int pageSize, int startIndex) {
		List<CardBenefits> benefitsList = cardMapper.selectBenefits();
		List<Card> cardList = list(userId);
		List<Card> showCardList = cardList.stream().filter(c -> "Y".equals(c.getShowYn())).collect(toList());
		Card filteredCard = cardId != 0 ? list(userId).stream().filter(card -> card.getCardId() == cardId).findFirst().get() : null;
		List<Usage> list = cardMapper.selectUsageByUserId(new HashMap(){{
			put("userId", userId);
			put("pageSize", pageSize);
			put("startIndex", startIndex);
		}})
		.stream()
		.filter(u -> filteredCard == null ? true : hasCardId(u, showCardList))
		.peek(u -> u.setCardName(filteredCard == null ? cardList.stream().filter(c -> c.getCardId() == u.getCardId()).findFirst().get().getCardName() : filteredCard.getCardName()))
		.peek(u -> build(u, benefitsList))
		.collect(toList());
		return CardUsageMain.builder()
				.cardList(cardList)
				.usageList(list)
				.build();
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

	private boolean hasCardId(Usage u, List<Card> list) {
		return list.stream().filter(c -> c.getCardId() == u.getCardId()).count() > 0;
	}

	private void build(Usage u, List<CardBenefits> benefitsList) {

		// 혜택 필터
		CardBenefits cb = benefitsList.stream()
				.filter(b -> b.getCardId() == u.getCardId())
				.filter(b -> b.getSequence() == u.getCardBSeq())
				.findFirst().orElse(null);

		// 혜택 없음
		if(cb.getSequence() == 1)
			return;

		// 할인율 0이고 금액일 때
		else if(cb.getPercent() == 0.0)
			u.setMinusPrice(cb.getAmount());

		// 할인율 적용
		else {
			double percent = cb.getPercent();
			if("Y".equals(u.getPrePaidYn()))
				percent += 0.3;
			u.setPercent(percent);
			int discountPrice = (int) Math.ceil(u.getOrigin() * percent / 100);
			u.setMinusPrice(discountPrice);
			u.setFinalPrice(u.getOrigin() - discountPrice);
		}
	}



}
