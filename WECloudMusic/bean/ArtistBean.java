package WECloudMusic.bean;

import java.io.Serializable;
import java.util.List;

import WECloudMusic.QueryHelper;

public class ArtistBean implements Serializable {

	private int id;
	private String ImgUrl;
	private String name;
	private String name2;
	
	private List<AlbumBean> list;
	
	
	
	 public List<AlbumBean> getList() {
		 if(this.list==null)
		 {
			 this.list=QueryHelper.queryAlbums(id);
		 }
		 
		return list;
	}
	public void setList(List<AlbumBean> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	 /**
	  * 
	  * @return 歌手的图片url
	  */
	public String getImgUrl() {
		return ImgUrl;
	}
	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}
	/**
	 * 
	 * @return 歌手的名字
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return 歌手的第二个名字(如果有的话)
	 */
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	@Override
	public String toString() {
		return "ArtistBean [id=" + id + ", ImgUrl=" + ImgUrl + ", name=" + name + ", name2=" + name2 + ", list=" + list
				+ "]";
	}
	
	
	
	
	
}
