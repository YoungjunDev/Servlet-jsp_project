package com.dto.board;

public class BoardDTO {
	int num;
	String userid;
	String title;
	String scategory;
	String content;
	String writeday;
	int readcnt;    //조회수
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int num, String userid, String title, String scategory, String content, String writeday,
			int readcnt) {
		super();
		this.num = num;
		this.userid = userid;
		this.title = title;
		this.scategory = scategory;
		this.content = content;
		this.writeday = writeday;
		this.readcnt = readcnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getScategory() {
		return scategory;
	}

	public void setScategory(String scategory) {
		this.scategory = scategory;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", userid=" + userid + ", title=" + title + ", scategory=" + scategory
				+ ", content=" + content + ", writeday=" + writeday + ", readcnt=" + readcnt + "]";
	}
	
	
}
