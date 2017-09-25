package WECloudMusic.bean;

import java.io.Serializable;

public class QueryBean implements Serializable{
	
	private String s;
	private int offset;
	private int limit;
	private int type;
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "QueryBean [s=" + s + ", offset=" + offset + ", limit=" + limit + ", type=" + type + "]";
	}
	
	
	
}
