package org.zerock.myapp.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReplyDTO {

	
	private Integer rno;
	private Integer bno;
	private String reply;
	private String replyer;
	
	private Timestamp regdate;
	private Timestamp updatedate;
}//end class
