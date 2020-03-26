package com.itshidu.blog.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itshidu.blog.util.HttpClientUtil;

public class QQConnectUtil {
	
	private static final String APPID = "101340964";
	private static final String APPKEY = "92c367a3cec734a0cb2c4fa49e421e04";
	private static final String CALLBACK="http://www.shiduketang.com/login/bind/qq/callback";
	
	private static final String URL_AccessToken="https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=APPID&client_secret=APPKEY&code=CODE&redirect_uri=URI";
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static String getLoginURL() {
		String url="https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=APPID&redirect_uri=URI&state=STATE";
		url=url.replaceAll("APPID", APPID);
		url=url.replaceAll("URI", CALLBACK);
		url=url.replaceAll("STATE","st_"+(int)(Math.random()*10000) );
		return url;
	}
	
	public static String getAccessToken(String authorizationCode) {
		String url = URL_AccessToken;
		url=url.replaceAll("APPID", APPID);
		url=url.replaceAll("APPKEY", APPKEY);
		url=url.replaceAll("CODE", authorizationCode);
		url=url.replaceAll("URI", CALLBACK);
		System.out.println(url);
		String text=HttpClientUtil.doGet(url);
		int start = text.indexOf("=")+1;
		int end = text.indexOf("&");
		System.out.println(text);
		return text.substring(start,end);
	}
	
	public static String getOpenid(String accessToken) throws IOException {
		String url = "https://graph.qq.com/oauth2.0/me?access_token="+accessToken;
		String text=HttpClientUtil.doGet(url);
		System.out.println(text);
		int start = text.indexOf("callback(")+9;
		int end = text.indexOf(")");
		text=text.substring(start,end);
		JsonNode node = objectMapper.readTree(text);
		return node.get("openid").asText();
	}
	
	public static JsonNode getUserInfo(String openid,String token) throws IOException {
		String url="https://graph.qq.com/user/get_user_info?access_token=TOKEN&oauth_consumer_key=APPID&openid=OPENID";
		url=url.replaceAll("TOKEN", token);
		url=url.replaceAll("APPID", APPID);
		url=url.replaceAll("OPENID", openid);
		String text = HttpClientUtil.doGet(url);
		return objectMapper.readTree(text);
	}

	public static void main(String[] args) throws IOException {
		String code = "9854B57CEF40D2FD624CF887DD6BD871";
		String token = getAccessToken(code);
		String openid=getOpenid(token);
		JsonNode user = getUserInfo(openid, token);
		System.out.println("token:"+token);
		System.out.println("OpenID:"+openid);
		System.out.println(user);
		
	}

}
