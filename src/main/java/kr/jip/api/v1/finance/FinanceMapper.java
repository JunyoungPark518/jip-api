package kr.jip.api.v1.finance;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@JipDB
public interface FinanceMapper {

	@SelectProvider(type = FinanceProvider.class, method = "selectUserById")
    Finance selectUserById(Map param);

	@SelectProvider(type = FinanceProvider.class, method = "selectUserByPhone")
    Finance selectUserByPhone(Map param);

//	Integer updateUserProfile(Map<String, Object> param);
//	Integer insertUser(Map<String, Object> param);
}
