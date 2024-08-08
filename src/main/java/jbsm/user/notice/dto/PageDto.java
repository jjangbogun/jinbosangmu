package jbsm.user.notice.dto;

public class PageDto {

	private int startPage; // 게시글 화면에 보여질 첫번째 번호
	private int endPage; // 게시글 화면에 보여질 마지막 번호
	private boolean prev, next; // 이전버튼, 다음버튼 활성화여부
	
	private int pageNum; // 현재 조회하는 페이지번호
	private int pageSize = 10; // 화면에 그려질 데이터
	private int total; // 전체게시글 수
	
	public PageDto(int pageNum, int pageSize, int total) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.total = total;
		
		this.endPage = (int)Math.ceil(this.pageNum * 0.1) * 10;
		this.startPage = this.endPage - 10 + 1;
		
		int realEnd = (int)Math.ceil(this.total / (double)this.pageSize);
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		System.out.println("시작페이지:" + this.startPage + ", 끝페이지:" + this.endPage);
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
