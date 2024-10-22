package es.diplock.examples.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().startsWith("/auth/")) {
            return true;
        }
        
        // Verificar si el usuario está autenticado
        HttpSession session = request.getSession();
        if (session.getAttribute("authenticatedUser") == null) {
            // Guardar la URL original para redireccionar después del login
            session.setAttribute("redirectUrl", request.getRequestURI());
            response.sendRedirect("/auth/login");
            return false;
        }
        
        return true;
    }
}
