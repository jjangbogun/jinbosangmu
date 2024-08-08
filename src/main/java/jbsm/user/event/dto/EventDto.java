package jbsm.user.event.dto;


public class EventDto {
	
	private int eventNo;
	private String eventName;
	private String eventTimg; //썸네일 이미지
	private String eventDimg; //디테일 이미지
	private String eventSdate;
	private String eventEdate;
	
	public EventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDto(int eventNo, String eventName, String eventTimg, String eventDimg, String eventSdate,
			String eventEdate) {
		super();
		this.eventNo = eventNo;
		this.eventName = eventName;
		this.eventTimg = eventTimg;
		this.eventDimg = eventDimg;
		this.eventSdate = eventSdate;
		this.eventEdate = eventEdate;
	}

	public EventDto(String eventName, String eventTimg, String eventDimg, String eventSdate, String eventEdate) {
		// TODO Auto-generated constructor stub

		this.eventName = eventName;
		this.eventTimg = eventTimg;
		this.eventDimg = eventDimg;
		this.eventSdate = eventSdate;
		this.eventEdate = eventEdate;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventTimg() {
		return eventTimg;
	}

	public void setEventTimg(String eventTimg) {
		this.eventTimg = eventTimg;
	}

	public String getEventDimg() {
		return eventDimg;
	}

	public void setEventDimg(String eventDimg) {
		this.eventDimg = eventDimg;
	}

	public String getEventSdate() {
		return eventSdate;
	}

	public void setEventSdate(String eventSdate) {
		this.eventSdate = eventSdate;
	}

	public String getEventEdate() {
		return eventEdate;
	}

	public void setEventEdate(String eventEdate) {
		this.eventEdate = eventEdate;
	}

	@Override
	public String toString() {
		return "EventDto [eventNo=" + eventNo + ", eventName=" + eventName + ", eventTimg=" + eventTimg + ", eventDimg="
				+ eventDimg + ", eventSdate=" + eventSdate + ", eventEdate=" + eventEdate + "]";
	}

	
	
}
