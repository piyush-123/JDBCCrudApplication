package in.piyush.dto;

public class Student {
	
	private int sid;
	private int sage;
	
	private String sname;
	private String saddr;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSage() {
		return sage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sage=" + sage + ", sname=" + sname + ", saddr=" + saddr + "]";
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}

}
