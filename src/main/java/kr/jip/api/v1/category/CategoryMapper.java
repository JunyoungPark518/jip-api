package kr.jip.api.v1.category;

import kr.jip.api.config.db.annotation.JipDB;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@JipDB
public interface CategoryMapper {
	@SelectProvider(type = CategoryProvider.class, method = "selectCategory")
	List<Category> selectCategory();
}
