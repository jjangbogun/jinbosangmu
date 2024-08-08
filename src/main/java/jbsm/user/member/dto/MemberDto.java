package jbsm.user.member.dto;

import java.util.Date;

public class MemberDto {
	
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberZip;
	private String memberAddr1;
	private String memberAddr2;
	private Date memberCdate;
	
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDto(int memberNo, String memberEmail, String memberPw, 
			String memberName, String memberPhone,
			String memberZip, String memberAddr1, 
			String memberAddr2, Date memberCdate) {
		super();
		this.memberNo = memberNo;
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberZip = memberZip;
		this.memberAddr1 = memberAddr1;
		this.memberAddr2 = memberAddr2;
		this.memberCdate = memberCdate;
	}	

	public MemberDto(String memberEmail, String memberPw, String memberName, String memberPhone, String memberZip,
			String memberAddr1, String memberAddr2, Date memberCdate) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberZip = memberZip;
		this.memberAddr1 = memberAddr1;
		this.memberAddr2 = memberAddr2;
		this.memberCdate = memberCdate;
	}

	public MemberDto(String memberEmail, String memberPw) {
		super();
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
	}
	
	public MemberDto(int memberNo, String memberEmail, String memberName) {
		super();
		this.memberNo = memberNo;
		this.memberEmail = memberEmail;
		this.memberName = memberName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberZip() {
		return memberZip;
	}

	public void setMemberZip(String memberZip) {
		this.memberZip = memberZip;
	}

	public String getMemberAddr1() {
		return memberAddr1;
	}

	public void setMemberAddr1(String memberAddr1) {
		this.memberAddr1 = memberAddr1;
	}

	public String getMemberAddr2() {
		return memberAddr2;
	}

	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}

	public Date getMemberCdate() {
		return memberCdate;
	}

	public void setMemberCdate(Date memberCdate) {
		this.memberCdate = memberCdate;
	}

	@Override
	public String toString() {
		return "memberDto [memberNo=" + memberNo + ", memberEmail=" + memberEmail 
				+ ", memberPw=" + memberPw + ", memberName=" + memberName 
				+ ", memberPhone=" + memberPhone + ", memberZip=" + memberZip
				+ ", memberAddr1=" + memberAddr1 + ", memberAddr2=" + memberAddr2 
				+ ", memberCdate=" + memberCdate + "]";
	}
	
}
