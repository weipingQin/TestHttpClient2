
/*
 * 用于处理字符串方法的类，包括
 */
public abstract class HtmlCheckMethods {
	
	//获取字符串中指定第一个字符串与指定的第二个字符串之间的字符串
	public static String GetChars(String source,String start,String end){
		int pointStart=source.indexOf(start);
		String str=source.substring(pointStart);
		int pointEnd=str.indexOf(end);
		return str.substring(start.length(),pointEnd);
		
	}
}
