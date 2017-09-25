package WECloudMusic.bean;

import java.io.Serializable;
import java.util.List;

import WECloudMusic.QueryHelper;

public class AlbumBean implements Serializable{

	private int id;
	
	private String name;
	private String description;
	private String company;
	private String ImgUrl; 
	private List<MusicBean> list;
	
	
	
	private ArtistBean artistBean;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	/**
	 * 专辑的名字
	 * @return
	 */
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 
	 * @return 专辑的描述
	 */
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * 
	 * @return 专辑的出品公司
	 */
	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}


	/**
	 * 
	 * @return 专辑的封面url
	 */
	public String getImgUrl() {
		return ImgUrl;
	}



	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}



	public List<MusicBean> getList() {
		if(this.list==null)
		{
			this.list=QueryHelper.getAlbumByID(id).getList();
		}
		return list;
	}



	public void setList(List<MusicBean> list) {
		this.list = list;
	}



	public ArtistBean getArtistBean() {
		return artistBean;
	}



	public void setArtistBean(ArtistBean artistBean) {
		this.artistBean = artistBean;
	}



	@Override
	public String toString() {
		return "AlbumBean [id=" + id + ", name=" + name + ", description=" + description + ", company=" + company
				+ ", ImgUrl=" + ImgUrl + ", list=" + list + ", artistBean=" + artistBean + "]";
	}
	
	
	
	
}
