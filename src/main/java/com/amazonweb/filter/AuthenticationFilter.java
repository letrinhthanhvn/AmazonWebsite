package com.amazonweb.filter;

import com.amazonweb.config.UrlAPI;
import com.amazonweb.model.User;
import com.amazonweb.utils.MessageUtil;
import com.amazonweb.utils.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

public class AuthenticationFilter implements Filter {

    private ServletContext context;

    private String secret = "hello";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        UrlAPI urlAPI = new UrlAPI();
        String secret = "hello";
        MessageUtil<User> messageUtil = new MessageUtil<>();
        ObjectMapper mapper = new ObjectMapper();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String jwtToken = request.getHeader("Authorization");
//        request.getMethod();
        String servletPath = request.getServletPath();
        if (urlAPI.getListUrlAdmin().contains(servletPath)) {
            try {
                Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken)
                        .getBody();
                ObjectMapper mapperNew = new ObjectMapper();
                User userNew = mapperNew.readValue(mapperNew.writeValueAsString(claims.get("data")), User.class);
                if (userNew.getRole() == 1) {
                    chain.doFilter(servletRequest, servletResponse);
                } else {
                    messageUtil.setMessage("Not Permisson");
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    mapper.writeValue(response.getOutputStream(), messageUtil);
                }
            } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
                System.out.println("Token Error " + ex.getMessage());
                messageUtil.setMessage("Token Error");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                mapper.writeValue(response.getOutputStream(), messageUtil);
            }
        } else if (urlAPI.getListUrlUser().contains(servletPath)) {
            try {
                Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken)
                        .getBody();
                ObjectMapper mapperNew = new ObjectMapper();
                User userNew = mapperNew.readValue(mapperNew.writeValueAsString(claims.get("data")), User.class);
                if (userNew.getRole() == 0) {
                    chain.doFilter(servletRequest, servletResponse);
                } else {
                    messageUtil.setMessage("Not Permisson");
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    mapper.writeValue(response.getOutputStream(), messageUtil);
                }
            } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
                System.out.println("Token Error " + ex.getMessage());
                messageUtil.setMessage("Token Error");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                mapper.writeValue(response.getOutputStream(), messageUtil);
            }
        } else if (urlAPI.getListUrlGuest().contains(servletPath)) {

        }

//            if (checkToken) {
//                try {
//                    Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken)
//                            .getBody();
//                    ObjectMapper mapperNew = new ObjectMapper();
//                    User userNew = mapperNew.readValue(mapperNew.writeValueAsString(claims.get("data")), User.class);
//                    if (userNew.getRole() == 1) {
//                        chain.doFilter(servletRequest, servletResponse);
//                    } else {
//                        messageUtil.setMessage("Not Permisson");
//                        response.setStatus(HttpStatus.FORBIDDEN.value());
//                        mapper.writeValue(response.getOutputStream(), messageUtil);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else {
//                messageUtil.setMessage("Server Error");
//                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//                mapper.writeValue(response.getOutputStream(), messageUtil);
//            }
//            if (jwtToken == null) {
//                messageUtil.setMessage("You are not logged in yet!");
//                response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                mapper.writeValue(response.getOutputStream(), messageUtil);
//            } else {
//                System.out.println("jwtToken != null");
//                Date timeExpired = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken)
//                        .getBody().getExpiration();
//                System.out.println("timeExpired " + timeExpired);
//                Date timeNow = new Date();
//                long timeCurrent = timeNow.getTime();
//                System.out.println("Check time " + timeExpired.getTime() + " " + timeCurrent);
//                if (timeExpired.getTime() < timeCurrent) {
//                    messageUtil.setMessage("Token time Expired");
//                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                    mapper.writeValue(response.getOutputStream(), messageUtil);
//                } else {
//
//                }
//            }
//            User model = (User) SessionUtil.getInstance().getValue(request, "USERMODEL");
//            if (model != null) {
//                if (model.getRole() == 1) {
//                    chain.doFilter(servletRequest, servletResponse);
//                } else {
//                    messageUtil.setMessage("Not Permisson");
//                    response.setStatus(HttpStatus.FORBIDDEN.value());
//                    mapper.writeValue(response.getOutputStream(), messageUtil);
//                }
//            } else {
//                messageUtil.setMessage("You are not logged in yet!");
//                response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                mapper.writeValue(response.getOutputStream(), messageUtil);
//            }
    }

    @Override
    public void destroy() {

    }

    static class Fields {

        // double field
        public static Integer role;
        public static String username;
    }
}
