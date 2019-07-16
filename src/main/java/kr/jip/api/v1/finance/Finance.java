package kr.jip.api.v1.finance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Finance implements Serializable {
	private Integer sequence;
	private String username;
	private String phone;
	private String thumbnail;
	private String email;
	private String createdAt;
}