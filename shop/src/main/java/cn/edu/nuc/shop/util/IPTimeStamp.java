package cn.edu.nuc.shop.util;

import java.text.SimpleDateFormat ;
import java.util.Date ;
import java.util.Random ;
public class IPTimeStamp {
	private SimpleDateFormat sdf = null ;
	private String ip = null ;
	public IPTimeStamp(){
	}
	public IPTimeStamp(String ip){
		this.ip = ip ;
	}
	public String getIPTimeRand(){
		StringBuffer buf = new StringBuffer() ;
		if(this.ip != null){
			String s[] = this.ip.split("\\.") ;
			for(int i=0;i<s.length;i++){
				buf.append(this.addZero(s[i],3)) ;
			}
		}
		buf.append(this.getTimeStamp()) ;
		Random r = new Random() ;
		for(int i=0;i<3;i++){
			buf.append(r.nextInt(10)) ;
		}
		return buf.toString() ;
	}
	public String getTimeStamp(){
		this.sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS") ;
		return this.sdf.format(new Date()) ;
	}
	private String addZero(String str,int len){
		StringBuffer s = new StringBuffer() ;
		s.append(str) ;
		while(s.length() < len){
			s.insert(0,"0") ;
		}
		return s.toString() ;
	}
	
}