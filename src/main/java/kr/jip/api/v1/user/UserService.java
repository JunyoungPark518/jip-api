package kr.jip.api.v1.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@org.springframework.stereotype.Service
public class UserService {

	// Mappers
	@Autowired
	UserMapper userMapper;

	public User selectUserById(int userId) {
		return userMapper.selectUserById(new HashMap(){{
			put("userId", userId);
		}});
	}

	public User detail(String phone) {
		return userMapper.selectUserByPhone( new HashMap(){{
			put("phone", phone);
		}});
	}

}
