package WECloudMusic;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import WECloudMusic.bean.AlbumBean;
import WECloudMusic.bean.ArtistBean;
import WECloudMusic.bean.CountData;
import WECloudMusic.bean.LyricsBean;
import WECloudMusic.bean.MusicBean;
import WECloudMusic.bean.MusicDataBean;
import WECloudMusic.bean.QueryBean;
import WECloudMusic.net.NetHelper;
import WECloudMusic.util.JsonParser;

public class QueryHelper {

	/**
	 * 对歌曲进行模糊搜索
	 * @param name 歌曲名字
	 * @return 返回的数据
	 */
	public static CountData<MusicBean> queryMusic(String name,int offset,int limit) {
		
		QueryBean queryBean=new QueryBean();
		queryBean.setS(name);
		queryBean.setType(Constant.SEARCHTYPE_MUSIC);
		queryBean.setOffset(offset);
		queryBean.setLimit(limit);
		
		String response=NetHelper.sendPost(Constant.SearchURL,queryBean);
		CountData<MusicBean> musicDataBean=JsonParser.parseMusicDataBean(response);
		
		return musicDataBean;
	}

	/**
	 * 根据字符串模拟搜索查找歌手
	 * @param name 搜索字符串
	 * @param offset 偏移
	 * @param limit
	 * @return
	 */
	public static CountData<ArtistBean> queryArtist(String name,int offset,int limit) 
	{
		QueryBean queryBean=new QueryBean();
		queryBean.setS(name);
		queryBean.setType(Constant.SEARCHTYPE_ARTIST);
		queryBean.setOffset(offset);
		queryBean.setLimit(limit);
		
		String response=NetHelper.sendPost(Constant.SearchURL,queryBean);
		CountData<ArtistBean> data=JsonParser.parseArtistDataBean(response);
		
		return data;
	}
	
	
	/**
	 * 根据字符串模拟搜索查找专辑
	 * @param name 搜索字符串
	 * @param offset 偏移
	 * @param limit
	 * @return
	 */
	public static CountData<AlbumBean> queryAlbum(String name,int offset,int limit) 
	{
		QueryBean queryBean=new QueryBean();
		queryBean.setS(name);
		queryBean.setType(Constant.SEARCHTYPE_ALBUM);
		queryBean.setOffset(offset);
		queryBean.setLimit(limit);
		
		String response=NetHelper.sendPost(Constant.SearchURL,queryBean);
		CountData<AlbumBean> data=JsonParser.parseAlbumDataBean(response);
		
		return data;
	}
	

	
	/**
	 * 根据专辑id查找专辑
	 * @param iD 专辑id
	 * @return 专辑数据
	 */
	public static AlbumBean getAlbumByID(int iD)
	{
		String url=Constant.DETAIL_ALBUM+iD;
		String response=NetHelper.sendGet(url);
		
		AlbumBean albumBean=JsonParser.parseAlbumBean(response);
		
		return albumBean;
	}
	
	
	/**
	 * 根据歌曲数据查找专辑
	 * @param musicBean 歌曲数据
	 * @return 专辑数据
	 */
	public static AlbumBean getAlbumByID(MusicBean musicBean) {
		return getAlbumByID(musicBean.getAlbumId());
		
	}

	/**
	 * 根据歌曲id查询歌词
	 * @param iD 歌曲id
	 * @return 歌词数据
	 */
	public static LyricsBean getLyricsByID(int iD) {
		
		String url=Constant.LYRICS;
		HashMap<String, String> map=new HashMap<>();
		map.put("id", iD+"");
		map.put("lv", -1+"");
		map.put("kv", -1+"");
		map.put("tv", -1+"");
		
		
		String response=NetHelper.sendGet(url,map);
		
		LyricsBean lyricsBean=JsonParser.parseLyricsBean(response);
		
		return lyricsBean;
	}

	
	
	private static LyricsBean getLyricsByID(MusicBean musicBean) {
		
		return getLyricsByID(musicBean.getID());
	}


	
	
	/**
	 * 根据歌手id查找专辑
	 * @param id
	 * @return 专辑数据
	 */
	public static List<AlbumBean> queryAlbums(int id) {
		
		String url=Constant.ARRTIST_ALBUMS+id;
		HashMap<String, String> map=new HashMap<>();
		map.put("limit", 100+"");
		
	
		String response=NetHelper.sendGet(url, map);
		List<AlbumBean> list=JsonParser.parseAlbumBeanList(response);
		
		
		return list;
	}


	/**
	 * 根据歌手数据查找专辑
	 * @param artistBean 歌手数据
	 * @return 
	 */
	public static List<AlbumBean> queryAlbums(ArtistBean artistBean) {
		
		
		return queryAlbums(artistBean.getId());
	}

	



	
	
	
	

	
	
}
