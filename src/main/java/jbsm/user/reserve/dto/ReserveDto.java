package jbsm.user.reserve.dto;

import java.util.Date;

public class ReserveDto {

	int reserveNo = 0;
	int reservePno = 0;
	int reserveMno = 0;
	int reserveStat = 0;
	String reserveCode = "";
	String reserveName = "";
	String reservePhone = "";
	int reserveFea = 0;
	int reserveFee = 0;
	int reserveBea = 0;
	int reserveBcost = 0;
	int reserveSum = 0;
	String reserveSdate = "";
	String reserveEdate = "";
	String reserveAdd = "";
	Date reserveRdate = null;
	
	public ReserveDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReserveDto(int reserveNo, int reservePno, int reserveMno, int reserveStat, String reserveCode,
			String reserveName, String reservePhone, int reserveFea, int reserveFee, int reserveBea, int reserveBcost,
			int reserveSum, String reserveSdate, String reserveEdate, String reserveAdd, Date reserveRdate) {
		super();
		this.reserveNo = reserveNo;
		this.reservePno = reservePno;
		this.reserveMno = reserveMno;
		this.reserveStat = reserveStat;
		this.reserveCode = reserveCode;
		this.reserveName = reserveName;
		this.reservePhone = reservePhone;
		this.reserveFea = reserveFea;
		this.reserveFee = reserveFee;
		this.reserveBea = reserveBea;
		this.reserveBcost = reserveBcost;
		this.reserveSum = reserveSum;
		this.reserveSdate = reserveSdate;
		this.reserveEdate = reserveEdate;
		this.reserveAdd = reserveAdd;
		this.reserveRdate = reserveRdate;
	}

	public int getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}

	public int getReservePno() {
		return reservePno;
	}

	public void setReservePno(int reservePno) {
		this.reservePno = reservePno;
	}

	public int getReserveMno() {
		return reserveMno;
	}

	public void setReserveMno(int reserveMno) {
		this.reserveMno = reserveMno;
	}

	public int getReserveStat() {
		return reserveStat;
	}

	public void setReserveStat(int reserveStat) {
		this.reserveStat = reserveStat;
	}

	public String getReserveCode() {
		return reserveCode;
	}

	public void setReserveCode(String reserveCode) {
		this.reserveCode = reserveCode;
	}

	public String getReserveName() {
		return reserveName;
	}

	public void setReserveName(String reserveName) {
		this.reserveName = reserveName;
	}

	public String getReservePhone() {
		return reservePhone;
	}

	public void setReservePhone(String reservePhone) {
		this.reservePhone = reservePhone;
	}

	public int getReserveFea() {
		return reserveFea;
	}

	public void setReserveFea(int reserveFea) {
		this.reserveFea = reserveFea;
	}

	public int getReserveFee() {
		return reserveFee;
	}

	public void setReserveFee(int reserveFee) {
		this.reserveFee = reserveFee;
	}

	public int getReserveBea() {
		return reserveBea;
	}

	public void setReserveBea(int reserveBea) {
		this.reserveBea = reserveBea;
	}

	public int getReserveBcost() {
		return reserveBcost;
	}

	public void setReserveBcost(int reserveBcost) {
		this.reserveBcost = reserveBcost;
	}

	public int getReserveSum() {
		return reserveSum;
	}

	public void setReserveSum(int reserveSum) {
		this.reserveSum = reserveSum;
	}

	public String getReserveSdate() {
		return reserveSdate;
	}

	public void setReserveSdate(String reserveSdate) {
		this.reserveSdate = reserveSdate;
	}

	public String getReserveEdate() {
		return reserveEdate;
	}

	public void setReserveEdate(String reserveEdate) {
		this.reserveEdate = reserveEdate;
	}

	public String getReserveAdd() {
		return reserveAdd;
	}

	public void setReserveAdd(String reserveAdd) {
		this.reserveAdd = reserveAdd;
	}

	public Date getReserveRdate() {
		return reserveRdate;
	}

	public void setReserveRdate(Date reserveRdate) {
		this.reserveRdate = reserveRdate;
	}
	
	@Override
	public String toString() {
		return "ReserveDto [reserveNo=" + reserveNo + ", reservePno=" + reservePno + ", reserveMno=" + reserveMno
				+ ", reserveStat=" + reserveStat + ", reserveCode=" + reserveCode + ", reserveName=" + reserveName
				+ ", reservePhone=" + reservePhone + ", reserveFea=" + reserveFea + ", reserveFee=" + reserveFee
				+ ", reserveBea=" + reserveBea + ", reserveBcost=" + reserveBcost + ", reserveSum=" + reserveSum
				+ ", reserveSdate=" + reserveSdate + ", reserveEdate=" + reserveEdate + ", reserveAdd=" + reserveAdd
				+ ", reserveRdate=" + reserveRdate + "]";
	}
	
}
