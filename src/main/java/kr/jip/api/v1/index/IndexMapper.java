package kr.jip.api.v1.index;

import kr.jip.api.config.db.annotation.JipDB;
import kr.jip.api.v1.user.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@JipDB
public interface IndexMapper {

	@SelectProvider(type = IndexProvider.class, method = "validateUser")
	Validation validateUser(Map param);

	@UpdateProvider(type = IndexProvider.class, method = "updateLastLogin")
	int updateLastLogin(Map param);

}
