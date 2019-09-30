package kr.jip.api.v1.card;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@JipDB
public interface CardMapper {

	@SelectProvider(type = CardProvider.class, method = "selectUsageByUserId")
	List<Usage> selectUsageByUserId(Map param);

	@InsertProvider(type = CardProvider.class, method = "insertUsage")
	Integer insertUsage(Map param);
}
