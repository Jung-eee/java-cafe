package com.varxyz.javacafe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BigCategory {
	private long bid;
	private String bigCategoryName;
	
	public BigCategory(long bid) {
		this.bid = bid;
	}

	public BigCategory(String bigCategoryName) {
		this.bigCategoryName = bigCategoryName;
	}
}
