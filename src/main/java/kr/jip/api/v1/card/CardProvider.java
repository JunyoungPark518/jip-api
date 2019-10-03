package kr.jip.api.v1.card;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static kr.jip.api.util.SqlUtil.insert;
import static kr.jip.api.util.SqlUtil.is;

@Repository
@JipDB
public class CardProvider {

    public String selectUsageByUserId(Map<String, Integer> param){
        return new SQL(){{
            SELECT("*")
            .FROM("JIP.USAGE")
            .WHERE("1 = 1")
            .AND().WHERE("USER_ID " + is(param.get("userId")))
            .ORDER_BY("CREATE_TIME DESC");
        }}.toString() + " LIMIT " + param.get("startIndex") + ", " + param.get("pageSize");
    }

    public String selectCardByUserId(Map<String, Integer> param){
        return new SQL(){{
            SELECT("*, NAME AS CARD_NAME")
            .FROM("JIP.CARD")
            .WHERE("1 = 1")
            .AND().WHERE("USER_ID " + is(param.get("userId")))
            .ORDER_BY("CARD_ID DESC");
        }}.toString();
    }

    public String selectBenefits(){
        return new SQL(){{
            SELECT("*")
            .FROM("JIP.CARD_BENEFITS");
        }}.toString();
    }

    public String insertUsage(Map<String, Object> param) {
        return insert("JIP.USAGE", param);
    }

}
