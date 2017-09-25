package WECloudMusic.bean;

import java.io.Serializable;
import java.util.List;

public class MusicDataBean implements Serializable{
	
	private int searchCount;
	private List<MusicBean> list;
	
	public int getSearchCount() {
		return searchCount;
	}
	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}
	public List<MusicBean> getList() {
		return list;
	}
	public void setList(List<MusicBean> list) {
		this.list = list;
	}
	
	
	
	
}
