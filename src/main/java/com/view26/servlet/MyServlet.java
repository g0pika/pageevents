package com.view26.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atlassian.soy.renderer.SoyTemplateRenderer;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class MyServlet extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(MyServlet.class);
    @ComponentImport
    private SoyTemplateRenderer soyTemplateRenderer;

    @Autowired
    public MyServlet(@ComponentImport SoyTemplateRenderer soyTemplateRenderer)
    {
        this.soyTemplateRenderer = soyTemplateRenderer;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        response.getWriter().write(getHtml());
        response.getWriter().close();   
    }

    public String getHtml()
    {
        Map<String, Object> data = new HashMap<String,Object>();
        data.put("isLocal", true);
        data.put("url", "http://www.example.com");
        data.put("title", "example");
        return this.soyTemplateRenderer.render("com.view26.pageevents:soy-templates", "servlet.ui.renderPageViews", data);
    }
}