package com.evry.rentamovie.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class Util {

	public static Pageable getPageable(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		pageNo = pageNo != null ? pageNo : 0;
		pageSize = pageSize != null ? pageSize : 10;
		sortBy = sortBy != null ? sortBy : "id";
		sortOrder = sortOrder != null ? sortOrder : "asc";
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Direction.fromString(sortOrder), sortBy));
		return pageable;
	}
}
