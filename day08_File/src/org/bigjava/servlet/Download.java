package org.bigjava.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @ProjectName: JavaWeb
 * @ClassName: Download
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-03 16:33
 * @Version v1.0
 */
public class Download extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取需要下载的文件名
        String downloadFile = "2.jpg";
        //2.读取要下载的文件内容（通过ServletContext对象获取）
        ServletContext servletContext = getServletContext();

        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFile);
        System.out.println("下载的文件类型是"+mimeType);
        //4.在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

        //5.告诉客户端收到的数据是用于下载使用（使用响应头）
        /*
            Content-Disposition:响应头，表示收到的数据如何处理
            attachment：表示附件，表示下载使用
            filename=：表示指定下载的文件名
         */
        if (req.getHeader("User-Agent").contains("Firefox")){
            //如果是火狐浏览器使用Base64编码
            resp.setHeader("Content-Disposition", "attachment;filename==?UTF-8?B?"+new BASE64Encoder().encode("表情包.jpg".getBytes("UTF-8"))+"?=");
        }else {
            //如果是ie或谷歌使用url编码操作
            resp.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("表情包.jpg", "UTF-8"));
        }
        //斜杠 / 被服务器解析表示地址为http://ip:prot/工程名/ 映射到代码的web目录
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFile);
        //获取响应的输出流
        OutputStream outputStream = resp.getOutputStream();
        //3.把下载的文件内容回传给客户端
        //读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);






    }
}
