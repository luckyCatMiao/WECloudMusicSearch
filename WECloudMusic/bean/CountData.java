package WECloudMusic.bean;

import java.io.Serializable;
import java.util.List;

public class CountData<T> implements Serializable{

	private int searchCount;
	private List<T> list;
	
	
	/**
	 * 返回实际查找到的数量(不是返回的数量,因为流量的关系 最好不要一次返回全部数据 界面上也没必要显示出那么多数据,可以采用分页获取)
	 * @return
	 */
	public int getSearchCount() {
		return searchCount;
	}
	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CountData [searchCount=" + searchCount + ", list=" + list + "]";
	}
	
	
	
	
	
}
