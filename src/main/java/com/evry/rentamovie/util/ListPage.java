package com.evry.rentamovie.util;

import java.util.List;

import lombok.Data;

@Data
public class ListPage {

	Integer startIndex;
	Integer endIndex;
	Integer total;
	String sortBy;
	String sortOrder;
	List list;
	
}
