package cn.abellee.auth.server.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Abel Lee
 * @date 2019/11/2 2:56 下午
 */
@Service
public interface AuthenticationService {
    /**
     * 校验权限
     *
     * @param authRequest
     * @return 是否有权限
     */
    boolean decide(HttpServletRequest authRequest);

}
