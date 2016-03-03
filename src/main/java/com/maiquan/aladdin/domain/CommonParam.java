package com.maiquan.aladdin.domain;

import java.util.Map;

public class CommonParam implements java.io.Serializable{
	
	private static final long serialVersionUID = -8907849229416244251L;

	private App app;
	private Map<String,Object> body;

	public App getApp() {
		return app;
	}
	public void setApp(App app) {
		this.app = app;
	}
	public Map<String, Object> getBody() {
		return body;
	}
	public void setBody(Map<String, Object> body) {
		this.body = body;
	}
	
	
}
