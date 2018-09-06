package com.synlabs.ipsaa.auth;

import com.google.common.util.concurrent.AtomicLongMap;
import com.google.common.util.concurrent.RateLimiter;
import com.synlabs.ipsaa.entity.common.CurrentUser;
import com.synlabs.ipsaa.entity.common.User;
import com.synlabs.ipsaa.ex.RateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RateLimitFilter extends GenericFilterBean
{

  private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

  @Value("${ipsaa.auth.apiprefix}")
  private String apiprefix;

  @Value("${ipsaa.auth.persec_limit}")
  private int perseclimit;

  private RateLimiter limit;

  @PostConstruct
  public void init() {
    limit = RateLimiter.create(perseclimit);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
  {

    HttpServletRequest req = (HttpServletRequest) request;
    if (!req.getRequestURI().startsWith(apiprefix) || "OPTIONS".equals(req.getMethod()))
    {
      chain.doFilter(request, response);
      return;
    }

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null)
    {
      throw new RateException("Deny: auth missing");
    }

    if (authentication.getPrincipal() instanceof CurrentUser)
    {
      User user = ((CurrentUser) authentication.getPrincipal()).getUser();

      if (!limit.tryAcquire(1, TimeUnit.SECONDS))
      {
        logger.warn("Who is trying to mug us? {} ", limit);
        throw new RateException("Deny: api rate exceeded -" + limit.getRate());
      }

    }
    else
    {
      throw new RateException("Deny: auth missing");
    }
    chain.doFilter(request, response);
  }
}



