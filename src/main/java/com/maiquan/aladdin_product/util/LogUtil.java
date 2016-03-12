package com.maiquan.aladdin_product.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.log4j.Logger;


public class LogUtil {

	private static Logger logger = Logger.getLogger(LogUtil.class);
	
	public static void logInput(String serviceName,String methodName,String requestID,Object... params){
		String paramStr = "";
		for(int i=0;i<params.length;i++){
			if(params[i]!=null){
				paramStr += params[i].toString()+" ";
			}
		}
		
		if(logger.isInfoEnabled()){
			try {
				logger.info("本机ip:"+InetAddress.getLocalHost().getHostAddress()+" 创建时间:"+new Date().toLocaleString()+" 服务名称:"+serviceName+" 方法名:"+methodName+" 输入参数: "+paramStr);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void logOutput(String serviceName,String methodName,String requestID,Object... params) {
		String paramStr = "";
		for(int i=0;i<params.length;i++){
			if(params[i]!=null){
				paramStr += params[i].toString()+" ";
			}
		}
		
		if(logger.isInfoEnabled()){
			try {
				logger.info("本机ip:"+InetAddress.getLocalHost().getHostAddress()+" 创建时间:"+new Date().toLocaleString()+" 服务名称:"+serviceName+" 方法名:"+methodName+" 输出参数: "+paramStr);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
	
}
