package cn.web.security.utils;

//用于对一条处理结果的管理（项目）
public class Result {
	private Integer resultid;
	private Integer line;
	private Integer risklevel;
	private String catagory;
	private String rkey;
	private String warning;
	private String suggestion;
	
	
	public Integer getResultid() {
		return resultid;
	}
	public void setResultid(Integer resultid) {
		this.resultid = resultid;
	}
	public Integer getLine() {
		return line;
	}
	public void setLine(Integer line) {
		this.line = line;
	}
	public Integer getRisklevel() {
		return risklevel;
	}
	public void setRisklevel(Integer risklevel) {
		this.risklevel = risklevel;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getRkey() {
		return rkey;
	}
	public void setRkey(String rkey) {
		this.rkey = rkey;
	}
	public String getWarning() {
		return warning;
	}
	public void setWarning(String warning) {
		this.warning = warning;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	

}
