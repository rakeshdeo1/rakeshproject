/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.filter;

import com.mycompany.sptest.model.User;
import com.mycompany.sptest.repo.UserRepository;
import com.mycompany.sptest.service.IuserService;
import com.sun.glass.events.ViewEvent;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TokenRequestFilter implements Filter {
    
    @Autowired
    UserRepository userRepository;

	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
           ApplicationContext ctx = WebApplicationContextUtils
      .getRequiredWebApplicationContext(filterConfig.getServletContext());
        this.userRepository = ctx.getBean(UserRepository.class);
	}

	@Override
	public void doFilter(ServletRequest request,
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		try {
		//apply filter only to post,put and delete request
                
                
                    HttpServletRequest req=(HttpServletRequest)request;
                    HttpServletResponse res=(HttpServletResponse)response;
                    
                    System.out.println(req.getRequestURL().toString());
                    
                    if(req.getMethod().equals("GET")){
                        chain.doFilter(request, response); 
                        
                    }else if(!req.getMethod().equals("GET")){ 
                        if(req.getRequestURL().toString().equals("http://localhost:8080/login")){
                            System.out.println("ok");
                            chain.doFilter(request, response);  
                            return;
                        }
                       System.out.println("Heelo");
                       String token=req.getHeader("token");
                        if(userRepository.countByToken(token)>0 && token!=null 
                                && !token.isEmpty() && token.length()>0){   
                            chain.doFilter(request, response);   
                            return;
                        }else{
                            res.sendRedirect("/error");                            
                        }  
                    }
                        
		} catch (Exception ex) {
                    //throw some messages
                    ex.printStackTrace();
		}

	}

}
