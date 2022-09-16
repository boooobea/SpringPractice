package org.zerock.myapp.domain;

import lombok.Data;

// 페이징 처리
@Data
public class Criteria {

	private int currPage = 1;		//현재 페이지 번호
	private int amount = 10;		//각 페이지에서 보여줄 게시물의 개수 
	
	
	private int pagesPerPage =5; 	//pagination의 길이 

	private String keyword;			//검색
	private String type;
	private String[] typeArr;
	
	public void setType(String type) {
		this.type = type;
		this.typeArr = type.split("");
	}
}//end class
