package kr.jip.api.v1.bank;

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
public class Bank implements Serializable {
	@JsonIgnore private Integer bankId;
	@JsonIgnore private int userId;
	private String name;
	private String account;
	private String maskAccount;
}