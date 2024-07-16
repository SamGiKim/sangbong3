package egovframework.example.category.service;

import java.util.List;

public interface ICategoryService<T> extends ICommonService<T> {
    T findByName(String name) throws Exception;
    List<T> findAllByNameContains(String name) throws Exception;

	List<T> findBySearch(SearchCategoryDto searchDto) throws Exception;
	int countBySearch(SearchCategoryDto searchDto) throws Exception;
}
