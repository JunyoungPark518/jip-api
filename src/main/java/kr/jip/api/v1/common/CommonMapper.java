package kr.jip.api.v1.common;

import kr.jip.api.config.db.annotation.JipDB;
import kr.jip.api.v1.index.Validation;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@JipDB
public interface CommonMapper {

	@SelectProvider(type = CommonProvider.class, method = "select")
	List<?> select(Map param);

//	@InsertProvider(type = CommonProvider.class, method = "insert")
//	int insert(Map param);
//
//	@UpdateProvider(type = CommonProvider.class, method = "update")
//	int update(Map param);
//
//	@DeleteProvider(type = CommonProvider.class, method = "delete")
//	int delete(Map param);
}
