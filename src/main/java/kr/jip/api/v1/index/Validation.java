package kr.jip.api.v1.index;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Validation implements Serializable {
	private String existPhone;
	private String wrongPassword;
}