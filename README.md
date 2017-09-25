# WECloudMusicSearch
这个库使用网易云音乐未公开的api来搜索网易云音乐的曲库，返回歌曲的url以及其他一些信息
下面的代码使用模糊搜索获得了0-10号的搜索结果(注意最好一次不要返回太多，不然数据包会非常的大，可以结合诸如tab控件之类的，每次换页的时候只获取该页所对应的歌曲)
CountData<MusicBean> countData=QueryHelper.queryMusic("千里之外", 0, 10);
		List<MusicBean> list=countData.getList();
		for (MusicBean musicBean : list) {
			System.out.println(musicBean);
		}


a libray that can search music and return url and other useful info of the music through wangyiyun private api

the usage is very simple,the following code search the music info from 0-10 index and print it to console

CountData<MusicBean> countData=QueryHelper.queryMusic("千里之外", 0, 10);
		List<MusicBean> list=countData.getList();
		for (MusicBean musicBean : list) {
			System.out.println(musicBean);
		}


you just need to call QueryHelper's function,and it will return all the info you need.then you can use this info to do sth,such as 
play music through the url of music.
this libray was done by analyze wangyiyun music http communication 


