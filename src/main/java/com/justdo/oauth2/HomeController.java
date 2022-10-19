package com.justdo.oauth2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justdo.oauth2.config.auth.SessionUser;
import com.justdo.oauth2.user.domain.User;

@RestController
public class HomeController {
    private final HttpSession httpSession;

    public HomeController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        response.addHeader("Content-Type", "text/html;utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("""
                <!DOCTYPE html>
                <html>
                <head></head>
                <body>
                    <h2>OAUTH TEST</h2>
                    <a href="/oauth2/authorization/kakao">kakao login</a>
                    <a href="/oauth2/authorization/naver">naver login</a>""" +
                "<div>" + httpSession.getAttribute("user") + "</div>"
                + """
                </body>
                </html>
                """);
        writer.flush();

    }
}
