package kr.jip.api.v1.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategoryService {

	// Mappers
	@Autowired
    CategoryMapper categoryMapper;

	public List<Category> list() {
		return categoryMapper.selectCategory();
	}

}
