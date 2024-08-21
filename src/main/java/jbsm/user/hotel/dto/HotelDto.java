package jbsm.user.hotel.dto;


public class HotelDto {

	private int hotelNo;
	private String hotelName;
	private int hotelClass;
	private String hotelPhone;
	private String hotelAddr;
	
	public HotelDto() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public HotelDto(int hotelNo, String hotelName, int hotelClass, String hotelPhone, String hotelAddr) {
		super();
		this.hotelNo = hotelNo;
		this.hotelName = hotelName;
		this.hotelClass = hotelClass;
		this.hotelPhone = hotelPhone;
		this.hotelAddr = hotelAddr;
	}

	public int getHotelNo() {
		return hotelNo;
	}

	public void setHotelNo(int hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getHotelClass() {
		return hotelClass;
	}

	public void setHotelClass(int hotelClass) {
		this.hotelClass = hotelClass;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public String getHotelAddr() {
		return hotelAddr;
	}

	public void setHotelAddr(String hotelAddr) {
		this.hotelAddr = hotelAddr;
	}
	
	@Override
	public String toString() {
		return "HotelDto [hotelNo=" + hotelNo + ", hotelName=" + hotelName + ", hotelClass=" + hotelClass
				+ ", hotelPhone=" + hotelPhone + ", hotelAddr=" + hotelAddr + "]";
	}
	
}
