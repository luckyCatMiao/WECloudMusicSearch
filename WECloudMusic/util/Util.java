package WECloudMusic.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Util {

	
	static public String beanToQueryString(Object bean)
	{
		
		try {
			return beanToQueryString(bean,new String[]{});
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String beanToQueryString(Object bean, String[] strings) throws IllegalArgumentException, IllegalAccessException {
		
		Field[] fields=bean.getClass().getDeclaredFields();
		List<String> ignores=Arrays.asList(strings);
		
		List<String> list=new ArrayList<>();
		for(Field field:fields)
		{
			field.setAccessible(true);
			if(!ignores.contains(field.getName()))
			{
				list.add(field.getName()+"="+field.get(bean));
			}
		}
		
		
		String line="";
		for(int i=0;i<list.size();i++)
		{
			if(i!=list.size()-1)
			{
			line+=list.get(i)+"&";
			}
			else
			{
				line+=list.get(i);
			}
		}
		
		
		
		return line;
	}

	public static String mapToqueryString(HashMap<String, String> map) {
		List<String> list=new ArrayList<>();
		
		for(String key:map.keySet())
		{
			list.add(key+"="+map.get(key));
		}
		
		String line="";
		for(int i=0;i<list.size();i++)
		{
			if(i!=list.size()-1)
			{
			line+=list.get(i)+"&";
			}
			else
			{
				line+=list.get(i);
			}
		}
		
		line="?"+line;
		
		
		return line;
	}

	//从字符串中解析出歌词
	public static void parsrLyric(Map<String, String> map, String value) {
		Pattern pattern=Pattern.compile("(\\[.+?\\])(.+)");
		Matcher matcher=pattern.matcher(value);
		
		while(matcher.find())
		{
			map.put(matcher.group(1), matcher.group(2));
		}
		
		
		
		
	}
}
