package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request); //Header의 모든 정보
        printHeaderUtil(request); //http header에 있는 내용을 조회
        printEtc(request); //기타 정보
    }

    private void printEtc(HttpServletRequest request) {

        System.out.println("request.getRemoteHost() => "+request.getRemoteHost());
        System.out.println("request.getRemoteAddr() => "+request.getRemoteAddr());
        System.out.println("request.getRemotePort() => "+request.getRemotePort());
        System.out.println("request.getLocalName() => "+request.getLocalName());
        System.out.println("request.getLocalAddr() => "+request.getLocalAddr());
        System.out.println("request.getLocalPort() => "+request.getLocalPort());

    }

    private void printHeaderUtil(HttpServletRequest request) {

        System.out.println("request.getServerName() => " + request.getServerName());
        System.out.println("request.getServerPort() => " +request.getServerPort());

        //이건 언어의 순서대로 나온다. 가장 먼저 제공(편의로하는?)하는 언어부터 찍히게 됨!!
        Enumeration<Locale> locales = request.getLocales();
        while(locales.hasMoreElements()){
            Locale locale = locales.nextElement();
            System.out.println("locale = "+locale);
        }
        System.out.println("request.getLocales() => "+request.getLocales());

        /* 요즘 방식 - java버전9부터 가능
         request.getLocales().asIterator()
            .forEachRemaining(locale -> System.out.println("locale = "+locale));
         */

        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + ": "+ cookie.getValue());
            }
        }

        System.out.println("request.getContentType() => " +request.getContentType());
        System.out.println("request.getContentLength() => "+request.getContentLength());
        System.out.println("request.getCharacterEncoding() => "+request.getCharacterEncoding());

        System.out.println("============================================================");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {
        //옛날 방식
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName+ " : "+request.getHeader(headerName));
        }

        /*
        //최근 방식 => 자바버전9부터 되서 내꺼는 안됨!!
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName+ " : "+request.getHeader(headerName)));
        */
        System.out.println("============================================================");
        System.out.println();
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("request.getMethod() => "+ request.getMethod());
        System.out.println("request.getProtocol() => "+request.getProtocol());
        System.out.println("request.getScheme() => "+request.getScheme());

        System.out.println("request.getRequestURL() => "+ request.getRequestURL());
        System.out.println("request.getRequestURI() => "+ request.getRequestURI());
        System.out.println("request.getQueryString() => "+request.getQueryString());
        System.out.println("request.isSecure() => "+request.isSecure());

        System.out.println("============================================================");
        System.out.println();
    }
}
