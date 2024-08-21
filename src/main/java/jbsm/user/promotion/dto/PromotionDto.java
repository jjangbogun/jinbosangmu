package jbsm.user.promotion.dto;


public class PromotionDto {
	private int promotionNo;
	private int promotionHno;
	private String promotionName;
	private String promotionCopy;
	private String promotionBdate;
	private String promotionSdate;
	private String promotionPhone;
	private String promotionForm;
	private String promotionDetail;
	private String promotionNotice;
	private String promotionImg;	
	private int promotionFee;
	private int promotionBCost;
	
	public PromotionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromotionDto(int promotionNo, int promotionHno, String promotionName, String promotionCopy,
			String promotionBdate, String promotionSdate, String promotionPhone, String promotionForm,
			String promotionDetail, String promotionNotice, String promotionImg, int promotionFee, int promotionBCost) {
		super();
		this.promotionNo = promotionNo;
		this.promotionHno = promotionHno;
		this.promotionName = promotionName;
		this.promotionCopy = promotionCopy;
		this.promotionBdate = promotionBdate;
		this.promotionSdate = promotionSdate;
		this.promotionPhone = promotionPhone;
		this.promotionForm = promotionForm;
		this.promotionDetail = promotionDetail;
		this.promotionNotice = promotionNotice;
		this.promotionImg = promotionImg;
		this.promotionFee = promotionFee;
		this.promotionBCost = promotionBCost;
	}

	public int getPromotionNo() {
		return promotionNo;
	}

	public void setPromotionNo(int promotionNo) {
		this.promotionNo = promotionNo;
	}

	public int getPromotionHno() {
		return promotionHno;
	}

	public void setPromotionHno(int promotionHno) {
		this.promotionHno = promotionHno;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionCopy() {
		return promotionCopy;
	}

	public void setPromotionCopy(String promotionCopy) {
		this.promotionCopy = promotionCopy;
	}

	public String getPromotionBdate() {
		return promotionBdate;
	}

	public void setPromotionBdate(String promotionBdate) {
		this.promotionBdate = promotionBdate;
	}

	public String getPromotionSdate() {
		return promotionSdate;
	}

	public void setPromotionSdate(String promotionSdate) {
		this.promotionSdate = promotionSdate;
	}

	public String getPromotionPhone() {
		return promotionPhone;
	}

	public void setPromotionPhone(String promotionPhone) {
		this.promotionPhone = promotionPhone;
	}

	public String getPromotionForm() {
		return promotionForm;
	}

	public void setPromotionForm(String promotionForm) {
		this.promotionForm = promotionForm;
	}

	public String getPromotionDetail() {
		return promotionDetail;
	}

	public void setPromotionDetail(String promotionDetail) {
		this.promotionDetail = promotionDetail;
	}

	public String getPromotionNotice() {
		return promotionNotice;
	}

	public void setPromotionNotice(String promotionNotice) {
		this.promotionNotice = promotionNotice;
	}

	public String getPromotionImg() {
		return promotionImg;
	}

	public void setPromotionImg(String promotionImg) {
		this.promotionImg = promotionImg;
	}

	public int getPromotionFee() {
		return promotionFee;
	}

	public void setPromotionFee(int promotionFee) {
		this.promotionFee = promotionFee;
	}

	public int getPromotionBCost() {
		return promotionBCost;
	}

	public void setPromotionBCost(int promotionBCost) {
		this.promotionBCost = promotionBCost;
	}
	
	@Override
	public String toString() {
		return "PromotionDto [promotionNo=" + promotionNo + ", promotionHno=" + promotionHno + ", promotionName="
				+ promotionName + ", promotionCopy=" + promotionCopy + ", promotionBdate=" + promotionBdate
				+ ", promotionSdate=" + promotionSdate + ", promotionPhone=" + promotionPhone + ", promotionForm="
				+ promotionForm + ", promotionDetail=" + promotionDetail + ", promotionNotice=" + promotionNotice
				+ ", promotionImg=" + promotionImg + ", promotionFee=" + promotionFee + ", promotionBCost="
				+ promotionBCost + "]";
	}

}