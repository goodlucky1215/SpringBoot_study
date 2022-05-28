package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
* 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello1&age=20&username=hello2
* */
@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("=============================한꺼번에 조회===============================");
        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement();
            System.out.println(paramName+" : "+request.getParameter(paramName));
        }
        /* 자바9부터 asIterator
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName+" : "+request.getParameter(paramName)));
        */

        System.out.println("=============================단일 조회===============================");
        System.out.println("username : "+ request.getParameter("username")); //복수값은 가장 앞에있는 쿼리스트링 값을 가져온다.
        System.out.println("age : "+ request.getParameter("age"));

        System.out.println("=============================복수의 쿼리 스트링일 경우===============================");
        String[] usernames = request.getParameterValues("username");
        for(String name : usernames){
            System.out.println("username : "+name);
        }

        response.getWriter().write("ok!");
    }
}
