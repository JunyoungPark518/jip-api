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
public class Usage implements Serializable {
	@JsonIgnore private int sequence;
	@JsonIgnore private int userId;
	@JsonIgnore private int cardId;
	private String cardName;
	@JsonIgnore private int cardBSeq;
	private int origin;
	private double percent;
	private int minusPrice;
	private int finalPrice;
	private String usageName;
	private String memo;
	private String cancelYn;
	private String prePaidYn;
	private String createTime;
	private String cancelTime;
}