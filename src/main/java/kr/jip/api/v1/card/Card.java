package kr.jip.api.v1.card;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Serializable {
	private int cardId;
	private int userId;
	private String cardName;
	private int bankId;
	private String description;
	private String limitDetail;
	private int minPrice;
	private String creditYn;
	private String withdrawDay;
	private String cardNo;
	private String maskCardNo;
	private String cardCvc;
	private String validMy;
	private String brand;
	private int annualFee;
	private String publishDate;
	private String showYn;
	private String useYn;
}