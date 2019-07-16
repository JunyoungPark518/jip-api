package kr.jip.api.v1.index;

import kr.jip.api.v1.common.JipResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@Service
public class IndexService {

	// Mappers
	@Autowired
	IndexMapper indexMapper;

	public JipResponse login(Map param) {
		log.info(param.toString());
		Validation validation = indexMapper.validateUser(param);
		if(validation.getExistPhone().equalsIgnoreCase("N")) {
			return new JipResponse(false, "회원 정보가 없어요.");
		}

		if(validation.getWrongPassword().equalsIgnoreCase("Y")) {
			return new JipResponse(false, "비밀번호가 달라요.");
		}

		return new JipResponse(indexMapper.updateLastLogin(param) == 1, "로그인 완료");
	}

}
