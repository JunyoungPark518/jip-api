package kr.jip.api.v1.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private Integer userId;
	private String username;
	private String phone;
	private String thumbnail;
	private String email;
	private String createdAt;
}