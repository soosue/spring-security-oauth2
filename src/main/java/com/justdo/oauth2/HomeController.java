package com.justdo.oauth2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final HttpSession httpSession;

    public HomeController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        responseHeader(response);

        String html = html("""
                <body>
                    <h2>OAUTH TEST HOME</h2>
                    <a href="/board"> board page</a>
                    <a href="/mypage"> my page</a>
                    <a href="/loginpage"> login page</a>
                </body>""");

        PrintWriter writer = response.getWriter();
        writer.write(html);
        writer.flush();
    }

    @GetMapping("/board")
    public void board(HttpServletRequest request, HttpServletResponse response) throws IOException {
        responseHeader(response);

        String html = html("""
                <body>
                    <h2>Board you are logined</h2>
                "</body>""");

        PrintWriter writer = response.getWriter();
        writer.write(html);
        writer.flush();
    }

    @GetMapping("/loginpage")
    public void loginpage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        responseHeader(response);

        String html = html("""
                <body>
                    <h2>Login Page</h2>
                    <a href="/oauth2/authorization/kakao">kakao login</a>
                    <a href="/oauth2/authorization/naver">naver login</a>
                    <div>""" + httpSession.getAttribute("user") + "</div>" +
                "</body>");

        PrintWriter writer = response.getWriter();
        writer.write(html);
        writer.flush();
    }

    @GetMapping("/mypage")
    public void mypage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        responseHeader(response);

        String html = html("""
                <body>
                    <h2>My Page</h2>
                    <div>""" + httpSession.getAttribute("user") + "</div>" +
                "</body>");

        PrintWriter writer = response.getWriter();
        writer.write(html);
        writer.flush();
    }

    private void responseHeader(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html;utf-8");
    }

    private String html(String body) {
        return """
                <!DOCTYPE html>
                <html>
                ${body}
                </html>
                """.replace("${body}", body);
    }

    @RequestMapping(value = "/error/403", method = RequestMethod.GET)
    public String error() {
        return "error/403";
    }
}
