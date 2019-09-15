package kr.jip.api.v1.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@org.springframework.stereotype.Service
public class UserService {

	// Mappers
	@Autowired
	UserMapper userMapper;

	public User selectUserById(int userId) {
		return userMapper.selectUserById(userId);
	}

	public User detail(String phone) {
		return userMapper.selectUserByPhone( new HashMap(){{
			put("phone", phone);
		}});
	}

	public List<User> mock() {
		List<User> list = new ArrayList<>();
		for(int i=0; i<11; i++) {
			list.add(User.builder()
					.userId(i)
					.phone("010418948906" + i)
					.build());

		}
		return list;
	}

}
