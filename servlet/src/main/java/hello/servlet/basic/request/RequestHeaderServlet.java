package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request); //Header의 모든 정보
        printHeaderUtil(request);
    }

    private void printHeaderUtil(HttpServletRequest request) {
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
