package kr.jip.api.v1.user;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static kr.jip.api.util.SqlUtil.is;

@Repository
@JipDB
public class UserProvider {

    // 사용자 조회
    public String selectUserById(Map<String, String> param){
        final String useYn = param.get("searchUseYn");
        final String rewardType = param.get("searchType");
        return new SQL(){{
            SELECT("*");
            FROM("USER");
            WHERE("1 = 1");

            if(StringUtils.isNotBlank(useYn))
                AND().WHERE("USE_YN " + is(useYn));

            if(StringUtils.isNotBlank(rewardType))
                AND().WHERE("REWARD_TYPE " + is(rewardType));

        }}.toString();

    }

    public String selectUserByPhone(Map<String, String> param){
        final String phone = param.get("phone");
        return new SQL(){{
            SELECT("*");
            FROM("USER");
            WHERE("PHONE " + is(phone));
        }}.toString();

    }

}
