package ${pkg}.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("RequestLogger")
public class RequestLogger implements HandlerInterceptor {

  private static final Logger LOGGER = LoggerFactory.getLogger(
    RequestLogger.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
    Object handler) throws Exception {

    /* Logs the "wrong" ip - the ip of the reverse proxy, in our example 127.0.0.1 */
    LOGGER.info("Page {} was requested by IP {}", request.getRequestURI(),
      request.getRemoteAddr());
    /* Logs the "real" remote ip address, as set by Nginx */
    LOGGER.info("Page {} was requested by IP {}", request.getRequestURI(),
      request.getHeader("X-Forwarded-For"));

    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response,
    Object handler, ModelAndView modelAndView) throws Exception {
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
    Object handler, Exception ex) throws Exception {
  }
}
