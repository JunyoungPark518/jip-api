package kr.jip.api.v1.finance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Slf4j
@org.springframework.stereotype.Service
public class FinanceService {

	// Mappers
	@Autowired
	FinanceMapper userMapper;

	public Finance selectUserById(int userId) {
		return userMapper.selectUserById(new HashMap(){{
			put("userId", userId);
		}});
	}

	public Finance detail(String phone) {
		return userMapper.selectUserByPhone( new HashMap(){{
			put("phone", phone);
		}});
	}

}
