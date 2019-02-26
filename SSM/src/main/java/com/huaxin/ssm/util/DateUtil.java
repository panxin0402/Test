package com.huaxin.ssm.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtil {

	public DateUtil() {
		
	}
	
	public static java.sql.Date  str2SqlDate(String str){
		java.sql.Date sqldate=null;
		try {
			if(str!=null && !"".equals(str)){
		
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date udate=df.parse(str);
				sqldate=new java.sql.Date(udate.getTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqldate;
	}
	
	public static String  date2String(Date date){
		String strdate="";
		try {
			if(date!=null){
				//����ת��
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				strdate=df.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strdate;
	}

}
