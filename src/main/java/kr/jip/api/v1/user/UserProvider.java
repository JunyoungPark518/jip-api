package kr.jip.api.v1.user;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static kr.jip.api.util.SqlUtil.is;

@Repository
@JipDB
public class UserProvider {

    // 사용자 조회
    public String selectUserById(Integer userId){
        return new SQL(){{
            SELECT("*");
            FROM("USER");
            WHERE("1 = 1");
            AND().WHERE("USER_ID " + is(userId));
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
