package entity;

import java.sql.Date;

public class BookManage {
	private int bid;
	private String bname;
	private String bauthor;
	private Date btime;
	private String btimes;
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public Date getBtime() {
		return btime;
	}

	public void setBtime(Date btime) {
		this.btime = btime;
	}

	public String getBtimes() {
		return btimes;
	}

	public void setBtimes(String btimes) {
		this.btimes = btimes;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public BookManage(String bname, String bauthor, 
			String btimes, int btype) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.btimes = btimes;
		this.btype = btype;
	}

	private int btype;
	public BookManage() {
		super();
	}
	
	public String getTypeStr(){
		if(this.btype==1){
			return "计算机/软件";
		}else if(this.btype==2){
			return "小说、文摘";
		}else if(this.btype==3){
			return "杂项";
		}
		return "";
	}
}
