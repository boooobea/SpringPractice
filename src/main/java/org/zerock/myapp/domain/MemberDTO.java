package org.zerock.myapp.domain;

import lombok.Data;

@Data
public class MemberDTO {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String memberMemo;

}//end class
