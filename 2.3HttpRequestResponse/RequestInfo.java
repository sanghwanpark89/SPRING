package com.fastreview.ch22;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestInfo {
    @RequestMapping("/requestInfo")
    //    public static void main(String[] args) {
    public void main(HttpServletRequest request, HttpServletResponse response)throws IOException{
    	
    	response.setContentType("text/html");
    	response.setCharacterEncoding("utf-8");
    	PrintWriter out = response.getWriter();
    	
        out.println("request.getCharacterEncoding()="+request.getCharacterEncoding()); // 요청 내용의 인코딩
        out.println("<br>");
        out.println("request.getContentLength()="+request.getContentLength());  // 요청 내용의 길이. 알수 없을 때는 -1
        out.println("<br>");
        out.println("request.getContentType()="+request.getContentType()); // 요청 내용의 타입. 알 수 없을 때는 null
        out.println("<br>");
        out.println("request.getMethod()="+request.getMethod());      // 요청 방법
        out.println("<br>");
        out.println("request.getProtocol()="+request.getProtocol());  // 프로토콜의 종류와 버젼 HTTP/1.1
        out.println("<br>");
        out.println("request.getScheme()="+request.getScheme());      // 프로토콜
        out.println("<br>");
        out.println("request.getServerName()="+request.getServerName()); // 서버 이름 또는 ip주소
        out.println("<br>");
        out.println("request.getServerPort()="+request.getServerPort()); // 서버 포트
        out.println("<br>");
        out.println("request.getRequestURL()="+request.getRequestURL()); // 요청 URL
        out.println("<br>");
        out.println("request.getRequestURI()="+request.getRequestURI()); // 요청 URI
        out.println("<br>");

        out.println("request.getContextPath()="+request.getContextPath()); // context path
        out.println("<br>");
        out.println("request.getServletPath()="+request.getServletPath()); // servlet path
        out.println("<br>");
        out.println("request.getQueryString()="+request.getQueryString()); // 쿼리 스트링
        out.println("<br>");

        out.println("request.getLocalName()="+request.getLocalName()); // 로컬 이름
        out.println("<br>");
        out.println("request.getLocalPort()="+request.getLocalPort()); // 로컬 포트
        out.println("<br>");

        out.println("request.getRemoteAddr()="+request.getRemoteAddr()); // 원격 ip주소
        out.println("<br>");
        out.println("request.getRemoteHost()="+request.getRemoteHost()); // 원격 호스트 또는 ip주소
        out.println("<br>");
        out.println("request.getRemotePort()="+request.getRemotePort()); // 원격 포트
    }
}
