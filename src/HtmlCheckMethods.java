
/*
 * ���ڴ����ַ����������࣬����
 */
public abstract class HtmlCheckMethods {
	
	//��ȡ�ַ�����ָ����һ���ַ�����ָ���ĵڶ����ַ���֮����ַ���
	public static String GetChars(String source,String start,String end){
		int pointStart=source.indexOf(start);
		String str=source.substring(pointStart);
		int pointEnd=str.indexOf(end);
		return str.substring(start.length(),pointEnd);
		
	}
}
