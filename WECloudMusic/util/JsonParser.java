package WECloudMusic.util;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.SystemException;

import WECloudMusic.bean.AlbumBean;
import WECloudMusic.bean.ArtistBean;
import WECloudMusic.bean.CountData;
import WECloudMusic.bean.LyricsBean;
import WECloudMusic.bean.MusicBean;
import WECloudMusic.bean.MusicDataBean;

public class JsonParser {

	public static CountData<MusicBean> parseMusicDataBean(String response) {
		
		
		CountData<MusicBean> musicDataBean=new CountData<>();
		List<MusicBean> list=new ArrayList<>();
		musicDataBean.setList(list);
		
		JSONObject jsonObject;
		try {
			jsonObject = getJson(response);
			checkReturnCode(jsonObject);
			int count=jsonObject.getJSONObject("result").getInt("songCount");
			musicDataBean.setSearchCount(count);
			
			JSONArray songs=jsonObject.getJSONObject("result").getJSONArray("songs");
			
			for(int i=0;i<songs.length();i++)
			{
				JSONObject song=songs.getJSONObject(i);
				
				MusicBean musicBean=getMusicBean(song);
				
				list.add(musicBean);
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return musicDataBean;
	}

	private static MusicBean getMusicBean(JSONObject song) throws JSONException {
		MusicBean musicBean=new MusicBean();
		
		musicBean.setUrl(song.getString("mp3Url"));
		musicBean.setDuration(song.getInt("duration"));
		musicBean.setHot(song.getInt("popularity"));
		musicBean.setName(song.getString("name"));
		musicBean.setID(song.getInt("id"));
		musicBean.setAlbumId(song.getJSONObject("album").getInt("id"));
		musicBean.setAlbumName(song.getJSONObject("album").getString("name"));
		
		JSONObject artist=song.getJSONArray("artists").getJSONObject(0);
		ArtistBean artistBean=getArtist(artist);
		musicBean.setArtistBean(artistBean);
		
		JSONObject partSong=song.getJSONObject("bMusic");
		
		musicBean.setSuffix(partSong.getString("extension"));
		musicBean.setSize(partSong.getInt("size"));
		
		
		return musicBean;
	}

	private static ArtistBean getArtist(JSONObject artist) throws JSONException {
		
		ArtistBean bean=new ArtistBean();
		bean.setImgUrl(artist.getString("picUrl"));
		bean.setName(artist.getString("name"));
		bean.setId(artist.getInt("id"));
		String name2;
		if(artist.getJSONArray("alias").length()>0)
		{
		if((name2=artist.getJSONArray("alias").getString(0))!=null)
		{
			bean.setName2(name2);
		}
		}
		
		
		return bean;
	}

	private static void checkReturnCode(JSONObject jsonObject) throws JSONException {
		
		
			int code=jsonObject.getInt("code");
			if(code!=200)
			{
				
				System.out.println("请求api失败,返回码:"+code);
			}
			
		
	}

	private static JSONObject getJson(String response) throws JSONException {
		// TODO Auto-generated method stub
		
			return new JSONObject(response);

	}

	
	public static AlbumBean parseAlbumBean(String response) {
		
		
		AlbumBean albumBean = null;
		List<MusicBean> list=new ArrayList<>();
		

		JSONObject jsonObject;
		try {
			jsonObject = getJson(response);
			checkReturnCode(jsonObject);
			jsonObject=jsonObject.getJSONObject("album");
			albumBean=getAlbum(jsonObject);
			
			
			JSONArray songs=jsonObject.getJSONArray("songs");
			
			for(int i=0;i<songs.length();i++)
			{
				JSONObject song=songs.getJSONObject(i);
				
				MusicBean musicBean=getMusicBean(song);
				
				list.add(musicBean);
			}
			
			albumBean.setList(list);
			}
			
			
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return albumBean;
	}

	private static AlbumBean getAlbum(JSONObject jsonObject) throws JSONException {
		
		AlbumBean albumBean=new AlbumBean();
		albumBean.setArtistBean(getArtist(jsonObject.getJSONObject("artist")));
		albumBean.setCompany(jsonObject.getString("company"));
		albumBean.setDescription(jsonObject.getString("description"));
		albumBean.setId(jsonObject.getInt("id"));
		albumBean.setImgUrl(jsonObject.getString("picUrl"));
		albumBean.setName(jsonObject.getString("name"));
		
		return albumBean;
	}

	public static LyricsBean parseLyricsBean(String response) {
		
		
		LyricsBean lyricsBean=new LyricsBean();
		try {
			JSONObject jsonObject=getJson(response);
			checkReturnCode(jsonObject);
			String  lyric=jsonObject.getJSONObject("lrc").getString("lyric");
			lyricsBean.setValue(lyric);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lyricsBean;
	}

	public static List<AlbumBean> parseAlbumBeanList(String response) {
		

		List<AlbumBean> list=new ArrayList<>();
		try {
			JSONObject jsonObject=getJson(response);
			checkReturnCode(jsonObject);
			JSONArray albums=jsonObject.getJSONArray("hotAlbums");
			for(int i=0;i<albums.length();i++)
			{
				AlbumBean albumBean=getAlbum(albums.getJSONObject(i));
				list.add(albumBean);
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	public static CountData<ArtistBean> parseArtistDataBean(String response) {
		
		//这里从接口传来的数据直接就有bug alias的键重复了 不知道网易自己是咋解析成功的...
		//不管了 这边预处理一下用正则删掉一个
		
		response=response.replaceFirst("\\\"alias.+?\\],", "");
	
		
		CountData<ArtistBean> data=new CountData<>();
		List<ArtistBean> list=new ArrayList<>();
		data.setList(list);
		
		JSONObject jsonObject;
		try {
			jsonObject = getJson(response);
			checkReturnCode(jsonObject);
			int count=jsonObject.getJSONObject("result").getInt("artistCount");
			data.setSearchCount(count);
			
			JSONArray artists=jsonObject.getJSONObject("result").getJSONArray("artists");
			
			for(int i=0;i<artists.length();i++)
			{
				JSONObject artist=artists.getJSONObject(i);
				
				ArtistBean artistBean=getArtist(artist);
				
				list.add(artistBean);
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return data;
	}

	
	
	
	public static CountData<AlbumBean> parseAlbumDataBean(String response) {
		
		

		
		CountData<AlbumBean> data=new CountData<>();
		List<AlbumBean> list=new ArrayList<>();
		data.setList(list);
		
		JSONObject jsonObject;
		try {
			jsonObject = getJson(response);
			checkReturnCode(jsonObject);
			int count=jsonObject.getJSONObject("result").getInt("albumCount");
			data.setSearchCount(count);
			
			JSONArray albums=jsonObject.getJSONObject("result").getJSONArray("albums");
			
			for(int i=0;i<albums.length();i++)
			{
				JSONObject album=albums.getJSONObject(i);
				
				AlbumBean albumBean=getAlbum(album);
				
				list.add(albumBean);
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return data;
	}


}
