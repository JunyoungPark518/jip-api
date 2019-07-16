package kr.jip.api.v1.user;

import kr.jip.api.config.db.annotation.JipDB;
import kr.jip.api.v1.user.User;
import kr.jip.api.v1.user.UserProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@JipDB
public interface UserMapper {

	@SelectProvider(type = UserProvider.class, method = "selectUserById")
	User selectUserById(Map param);

	@SelectProvider(type = UserProvider.class, method = "selectUserByPhone")
	User selectUserByPhone(Map param);

//	Integer updateUserProfile(Map<String, Object> param);
//	Integer insertUser(Map<String, Object> param);
}
