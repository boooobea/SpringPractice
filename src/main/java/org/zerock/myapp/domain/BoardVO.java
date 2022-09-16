package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Value;

@Value
public class BoardVO {

	private Integer bno;
	private String title;
	private String content;
	private String writer;
	
	private Date insertTs;
	private Date updateTs;
	
}//end class
