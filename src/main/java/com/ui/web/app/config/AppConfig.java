package com.ui.web.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Value("${component.template.path}")
	private String componentTemplatePath;
	@Value("${page.template.path}")
	private String pageTemplatePath;
	
	public String getComponentTemplatePath() {
		return componentTemplatePath;
	}

	public String getPageTemplatePath() {
		return pageTemplatePath;
	}

}
