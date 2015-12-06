import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
public class HttpClientMethods {
	public static HttpResponse GetResponseFromUrl(String url,HttpClient httpclient){
		/*
		 * �򵥷�װ��httpclient���get����
		 */
		
		HttpGet httpget=new HttpGet(url);
		HttpResponse response=null;
		try{
			response=httpclient.execute(httpget);
		}catch(IOException e){
			e.printStackTrace();
		}
		return response;
	}
	public static HttpResponse GetResponseFromUrl(String url,String referer,HttpClient httpclient){
		/*
		 * ͬ�Ϸ���
		 * ����һ������������������ĳЩ��ַ���з�������Ϣ
		 */
		HttpGet httpget=new HttpGet(url);
		//��ӷ�������header
		httpget.setHeader("Referer", referer);
		HttpResponse response=null;
		try{
			response=httpclient.execute(httpget);
		}catch(IOException e){
			e.printStackTrace();
		}
		return response;
	}
	
	public static HttpResponse PostFormToUrl(String url,ArrayList<NameValuePair> nvps,HttpClient httpclient){
		HttpPost httppost=new HttpPost(url);
		HttpResponse response=null;
		try{
			httppost.setEntity(new UrlEncodedFormEntity(nvps));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		try {
			response=httpclient.execute(httppost);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public static HttpResponse PostFormToUrl(String url,String referer,ArrayList<NameValuePair> nvps,HttpClient httpclient){
		HttpPost httppost=new HttpPost(url);
		HttpResponse response=null;
		try{
			httppost.setEntity(new UrlEncodedFormEntity(nvps));
			httppost.setHeader("Referer", referer);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		try {
			response=httpclient.execute(httppost);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}