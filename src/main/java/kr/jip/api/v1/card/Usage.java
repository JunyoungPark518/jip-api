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
	@JsonIgnore private Integer sequence;
	private int userId;
	private int cardId;
	private int cardBSeq;
	private int origin;
	private String usageName;
	private String memo;
	private String cancelYn;
	private String createTime;
	private String cancelTime;
}