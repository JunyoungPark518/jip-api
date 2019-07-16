package kr.jip.api.v1.index;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static kr.jip.api.util.SqlUtil.is;

@Repository
@JipDB
public class IndexProvider {

    // 사용자 검증
    public String validateUser(Map<String, String> param){
        final String phone = param.get("phone");
        final String password = param.get("password");
        return new SQL(){{
            SELECT("IFNULL((SELECT 'Y' FROM USER WHERE PHONE " + is(phone) + "), 'N') AS EXIST_PHONE");
            SELECT("IFNULL((SELECT 'N' FROM USER WHERE PHONE " + is(phone) + " AND PASSWORD " + is(password) + "), 'Y') AS WRONG_PASSWORD");
        }}.toString();
    }

    // 로그인 시간 업데이트
    public String updateLastLogin(Map<String, String> param){
        return new SQL(){{
            UPDATE("USER");
            SET("LOGIN_AT = NOW()");
            WHERE("PHONE " + is(param.get("phone")));
        }}.toString();
    }
}
