package kr.jip.api.v1.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardBenefits implements Serializable {
	private int cardId;
	private int sequence;
	private String benefit;
	private double percent;
	private int amount;
	private int categoryId;
}