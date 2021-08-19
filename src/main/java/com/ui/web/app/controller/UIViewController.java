/**
 * 
 */
package com.ui.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.ui.web.app.config.AppConfig;

@RestController
@RequestMapping("/web")
public class UIViewController {
	@Autowired
	AppConfig appConfig;
	
	@GetMapping(value = "/{page}", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getHTMLContent(@PathVariable String page) {
		StringBuffer sb = new StringBuffer();
		
		TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addTemplateResolver(textTemplateResolver());
		sb.append("<p> Page template path:" + appConfig.getPageTemplatePath() + "</p>");
		sb.append("<p> Component template path:" + appConfig.getComponentTemplatePath() + "/" + page + "</p>");
		return sb.toString();
	}
    private ITemplateResolver textTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/text/");
        templateResolver.setSuffix(".txt");
        templateResolver.setTemplateMode(TemplateMode.TEXT /* https://github.com/thymeleaf/thymeleaf/issues/395 */);
        templateResolver.setCharacterEncoding("UTF8");
        templateResolver.setCheckExistence(true);
        templateResolver.setCacheable(false);
        return templateResolver;
    }
}
