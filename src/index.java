import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class index {

	public static String indexUrl="https://grs.zju.edu.cn/cas/login?service=http%3A%2F%2Fyjsds.zju.edu.cn%2Flogincheck.htm";
	public static String loginUrl="https://grs.zju.edu.cn/cas/login?service=http://yjsds.zju.edu.cn/logincheck.htm";
	public static String refer="https://grs.zju.edu.cn/cas/login?service=http%3A%2F%2Fyjsds.zju.edu.cn%2Flogincheck.htm";
	public static String ltStartChar="name=\"lt\" value=\"";
	public static String ltEndCahr="\" />";
	public static String exStartChar="name=\"execution\" value=\"";
	public static String exEndChar="\" />";
	public static String url="http://yjsds.zju.edu.cn/page/grxx/jbxxmenu.htm";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try{
			HttpResponse response=HttpClientMethods.GetResponseFromUrl(indexUrl, httpclient);
			HttpEntity entity=response.getEntity();
			String htmlStr=EntityUtils.toString(entity);
			System.out.println(htmlStr);
			System.out.println("=========================================================");
			String lt=HtmlCheckMethods.GetChars(htmlStr, ltStartChar, ltEndCahr);
			System.out.println(lt);
			System.out.println("=========================================================");
			String execution=HtmlCheckMethods.GetChars(htmlStr, exStartChar, exEndChar);
			System.out.println(execution);
			//create post list
			ArrayList<NameValuePair> nvps=new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username","21531133"));
			nvps.add(new BasicNameValuePair("password","love1993,."));
			nvps.add(new BasicNameValuePair("submit",""));
			nvps.add(new BasicNameValuePair("lt",lt));
			nvps.add(new BasicNameValuePair("execution",execution));
			nvps.add(new BasicNameValuePair("_eventId","submit"));
			response=HttpClientMethods.PostFormToUrl(loginUrl, refer, nvps, httpclient);
			String getUrl=response.getFirstHeader("location").getValue();
			System.out.println("=========================================================");
			System.out.println("Location:"+getUrl);
			System.out.println("=========================================================");
			System.out.println(response.getStatusLine());
			System.out.println("=========================================================");
			HttpGet httpget=new HttpGet(getUrl);
			HttpResponse response2=null;
			try{
				response2=httpclient.execute(httpget);
			}catch(IOException e){
				e.printStackTrace();
			}
			System.out.println(EntityUtils.toString(response2.getEntity()));
			HttpGet httpget2=new HttpGet("http://yjsds.zju.edu.cn/page/grxx/jbxx1.htm");
			httpget2.setHeader("Referer","http://yjsds.zju.edu.cn/page/grxx/grxx.htm");
			HttpResponse response3=null;
			try{
				response3=httpclient.execute(httpget2);
			}catch(IOException e){
				e.printStackTrace();
			}
			System.out.println(EntityUtils.toString(response3.getEntity()));
			int i=0;System.out.println(i);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
