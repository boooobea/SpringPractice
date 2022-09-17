package org.zerock.myapp.domain;

import java.util.Date;

import lombok.Value;

@Value
public class MemberVO {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberMemo;
	private Integer adminCk;
	private Date regDate;
	private Integer money;
	private Integer point;
}//end class
