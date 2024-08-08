package jbsm.user.notice.dto;

import java.util.Date;

public class NoticeDto {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeCdate;
	
	public NoticeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoticeDto(int noticeNo, String noticeTitle, String noticeContent, Date noticeCdate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeCdate = noticeCdate;
	}
	
	public NoticeDto(int noticeNo, String noticeTitle, String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeCdate() {
		return noticeCdate;
	}

	public void setNoticeCdate(Date noticeCdate) {
		this.noticeCdate = noticeCdate;
	}
	
	@Override
	public String toString() {
		return "NoticeDto [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle 
				+ ", noticeContent=" + noticeContent
				+ ", noticeCdate=" + noticeCdate + "]";
	}
	
}
