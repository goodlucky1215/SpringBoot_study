package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        response.setHeader("Content-Type","text/plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("mymymymy","hahhahaha");

        //헤더 편의 메서드
        content(response);

        //쿠키
        cookie(response);

        //리다이렉트
        redirect(response);

        PrintWriter writer = response.getWriter();
        writer.println("ok"); // ln으로 하면 줄바꿈까지해서 ContentLength가 3으로 잡힌다.

    }

    private void redirect(HttpServletResponse response) throws IOException {
        //리다이렉트 번호는 302
        //response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location","/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse response) {
        //response.setHeader("Set-Cookie","myCookie=good; Max-age=600");
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }

    private void content(HttpServletResponse response) {
        //response.setHeader("Content-Type","text/plain;charset=utf-8");
        //일일히 적는것보다 이렇게 정해져있는 set으로하면 간편하다.
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        //response.setContentLength(2); //생략시 자동으로 생성됨
    }
}
