package com.api.gateway.authentication;


import java.util.Set;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter  extends ZuulFilter{

	
	
	@Override
	public Object run() throws ZuulException {
		
		 RequestContext context = RequestContext.getCurrentContext();
		Set<String> ignoredHeaders = (Set<String>) context.get("ignoredHeaders");
        ignoredHeaders.remove("authorization");
		
		/*
		RequestContext currentContext= RequestContext.getCurrentContext();
	HttpServletRequest httpRequest=currentContext.getRequest();
	Map<String, List<String>> newParameterMap = new LinkedHashMap<>();
    String uri=	httpRequest.getRequestURI();
    System.out.println(uri);
    System.out.println(httpRequest.getParameterMap());
    Map<String,String[]>  paramMap=  httpRequest.getParameterMap();
    Set<Entry<String,String[]>> entrySet=  paramMap.entrySet();
    Iterator<Entry<String, String[]>> itr=  entrySet.iterator();
    while(itr.hasNext()){
    Entry<String,String[]> maps=itr.next();
    newParameterMap.put(maps.getKey(), Arrays.asList(maps.getValue()));
    } 
    Map<String,String> passwordMaps=getMap();
    String usernameKey = "username";
    String username = " ";
    Object principal =SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if(principal instanceof UserDetails){
    	username=((UserDetails) principal).getUsername();
    }else{
    	username=principal.toString();
    }
    String usernamePassword = passwordMaps.get(username);
    newParameterMap.put(usernameKey,Arrays.asList(username));
    String passwordKey = "password";
    String encodedString = Base64.getEncoder().encodeToString(usernamePassword.getBytes());
    newParameterMap.put(passwordKey,Arrays.asList(encodedString));
    currentContext.setRequestQueryParams(newParameterMap);
    System.out.println(RequestContext.getCurrentContext().getRequest().getParameterMap());
    byte[] actualByte=Base64.getDecoder().decode(encodedString);
    String actualString= new String(actualByte);
    System.out.println(actualString);
    */
	return null;
	}


	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
