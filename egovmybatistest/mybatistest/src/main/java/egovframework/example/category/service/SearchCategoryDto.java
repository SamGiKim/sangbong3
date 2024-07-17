package egovframework.example.category.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCategoryDto extends CategoryDto {
	/** 검색조건 */
	private int searchCondition = 0;
	
	/** 현재페이지 */
	private int pageIndex = 1;

	/** 페이지갯수 */
	private int pageUnit = 10;

	/** 페이지사이즈 */
	private int pageSize = 10;

	/** firstIndex */
	private int firstIndex = 1;

	/** lastIndex */
	private int lastIndex = 1;

	/** recordCountPerPage */
	private int recordCountPerPage = 10;
}