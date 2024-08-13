package jbsm.admin.admin.dto;

public class AdminDto {

	private int adminNo;    
	private String adminEmail;        
	private String adminPw;          
	private String adminName;
	
	public AdminDto() {}
	
	public AdminDto(int adminNo, String adminEmail, String adminPw, String adminName) {
		super();
		this.adminNo = adminNo;
		this.adminEmail = adminEmail;
		this.adminPw = adminPw;
		this.adminName = adminName;
	}
	
	public AdminDto(String adminEmail, String adminName) {
		super();
		this.adminEmail = adminEmail;
		this.adminName = adminName;
	}	


	public int getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "adminDto [adminNo=" + adminNo + ", adminEmail=" + adminEmail + ", adminPw=" + adminPw + ", adminName="
				+ adminName + "]";
	} 
	
	
}
