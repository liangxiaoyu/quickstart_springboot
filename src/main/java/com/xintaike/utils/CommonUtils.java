package com.xintaike.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jay on 2020/4/1.
 */
public final class CommonUtils {

    public static String printRequestInfo(HttpServletRequest request) {
        return getRequestInformation(request);
    }

    private static String getRequestInformation(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        String requestIP = getIpAddress(request);
        String serverStr = getServerStr(request);
        sb.append("Receive Request : ");
        sb.append("Requester: ");
        sb.append(requestIP);
        sb.append("  <==>  Server: ");
        sb.append(serverStr);
        return sb.toString();
    }

    private static String getServerStr(HttpServletRequest request) {
        return request.getScheme() //当前链接使用的协议
                    +"://" + request.getServerName()//服务器地址
                    + ":" + request.getServerPort() //端口号
                    + request.getContextPath() //应用名称，如果应用名称为
                    + request.getServletPath() //请求的相对url
                    + (request.getQueryString()==null?"":("?" + request.getQueryString()));
    }


    /**
     * 获取真实ip地址，避免获取代理ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
