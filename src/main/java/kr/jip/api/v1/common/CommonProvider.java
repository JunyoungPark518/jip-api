package kr.jip.api.v1.common;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static kr.jip.api.util.SqlUtil.is;

@Repository
@JipDB
public class CommonProvider {

    public String select(Map<String, String> param){
        final String column = param.get("column"),
                table = param.get("table"),
                where = param.get("where"),
                orderBy = param.get("orderBy"),
                groupBy = param.get("groupBy"),
                limit = param.get("limit");

        return new SQL(){{
            SELECT(StringUtils.isNotBlank(column) ? column : "*")
            .FROM(table)
            .WHERE(StringUtils.isNotBlank(where) ? where : "1 = 1");
            if(StringUtils.isNotBlank(groupBy))
                GROUP_BY(groupBy);

            if(StringUtils.isNotBlank(orderBy))
                ORDER_BY(orderBy);

        }}.toString() + (StringUtils.isNotBlank(limit) ? limit : "");
    }

    public String insert(Map<String, String> param){
        return new SQL(){{
            UPDATE("USER");
            SET("LOGIN_AT = NOW()");
            WHERE("PHONE " + is(param.get("phone")));
        }}.toString();
    }
}
