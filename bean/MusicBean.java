package WECloudMusic.bean;

import java.io.Serializable;

import WECloudMusic.QueryHelper;

public class MusicBean implements Serializable{

	private int hot;
	private String url;
	private String name;
	private int size;
	private String suffix;
	private int duration;
	private int ID;
	
	
	private ArtistBean artistBean;
	
	private int albumId;
	private String AlbumName;
	private AlbumBean albumBean;
	
	private LyricsBean lyricsBean;
	
	
	
	
	
	public String getAlbumName() {
		return AlbumName;
	}
	public void setAlbumName(String albumName) {
		AlbumName = albumName;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public AlbumBean getAlbumBean() {
		if(this.albumBean==null)
		{
			this.albumBean=QueryHelper.getAlbumByID(albumId);
			
		}
		
		return albumBean;
	}
	public void setAlbumBean(AlbumBean albumBean) {
		this.albumBean = albumBean;
	}
	
	public LyricsBean getLyricsBean() {
		if(this.lyricsBean==null)
		{
			this.lyricsBean=QueryHelper.getLyricsByID(ID);
		}
		return lyricsBean;
	}
	public void setLyricsBean(LyricsBean lyricsBean) {
		this.lyricsBean = lyricsBean;
	}
	public ArtistBean getArtistBean() {
		return artistBean;
	}
	public void setArtistBean(ArtistBean artistBean) {
		this.artistBean = artistBean;
	}
	
	
	/**
	 * 
	 * @return 歌曲的热度(此数据为网易云上该歌曲的热度) 0-100的整数
	 */
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	/**
	 * 
	 * @return 歌曲的url
	 */
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 
	 * @return 歌曲的名字
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return 歌曲的大小 字节
	 */
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * 
	 * @return 歌曲的后缀名
	 */
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * 
	 * @return 歌曲的持续时间 毫秒
	 */
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * 
	 * @return 歌曲在网易云上的id 只在该类库内部进行查询使用
	 */
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "MusicBean [hot=" + hot + ", url=" + url + ", name=" + name + ", size=" + size + ", suffix=" + suffix
				+ ", duration=" + duration + ", ID=" + ID + "]";
	}
	
	

	
	
}
