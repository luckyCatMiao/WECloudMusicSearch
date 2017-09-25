package WECloudMusic.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import WECloudMusic.util.Util;

public class LyricsBean implements Serializable{

	private String value;
	private Map<String, String> map;
	
	
	/**
	 * 
	 * @return 返回原始的歌词数据(混合了时间和实际的歌词)
	 */
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if(this.map==null)
		{
			this.map=new HashMap<>();
			Util.parsrLyric(map,value);
			
		}
		
		this.value = value;
	}

	@Override
	public String toString() {
		return "LyricsBean [value=" + value + ", map=" + map + "]";
	}
	
	
	
}
