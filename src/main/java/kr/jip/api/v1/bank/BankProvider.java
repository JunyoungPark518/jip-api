package kr.jip.api.v1.bank;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static kr.jip.api.util.SqlUtil.*;

@Repository
@JipDB
public class BankProvider {

    public String selectBankByUserId(Map param){
        return new SQL(){{
            SELECT("*")
            .FROM("JIP.BANK")
            .WHERE("1 = 1")
            .AND().WHERE("USER_ID " + is(param.get("userId")));
        }}.toString();
    }

    public String insertBank(Map<String, Object> param) {
        return insert("JIP.BANK", param);
    }

    public String removeBank(Map<String, Object> param) {
        String where = "USER_ID" + is(param.get("userId") + " AND NAME" + is(param.get("bankName")));
        return delete("JIP.BANK", where);
    }

}
