package kr.jip.api.v1.category;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static kr.jip.api.util.SqlUtil.insert;
import static kr.jip.api.util.SqlUtil.is;

@Repository
@JipDB
public class CategoryProvider {

    public String selectCategory(){
        return new SQL(){{
            SELECT("*")
            .FROM("JIP.CATEGORY");
        }}.toString();
    }

}
