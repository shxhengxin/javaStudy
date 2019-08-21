package xin.shenheng.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload1方法执行了.....");
        //使用fileupload组件完成文件上传

        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断 路径是否存在

        File file = new File(path);
        if(!file.exists()) {
            //创建文件
            file.mkdirs();
        }
        //解析request对象,获取上传文件项

        DiskFileItemFactory factory = new DiskFileItemFactory();

        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item:items){
            //进行判断，当前item对象是否是上传文件项
            if(item.isFormField()) {
                //为真表示是普通表单项

            }else {
                //为假表示为上传项
                //获取上传文件名称
                String filename = item.getName();
                //把文件名称设置唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                //完成文件上传

                item.write(new File(path,filename));

                //删除临时文件
                item.delete();
            }
        }


       // request.getParameter("upload");
        return "success";
    }

    @RequestMapping("/fileUpload2")
    public String fileUploade2(HttpServletRequest request, MultipartFile upload) throws IOException {

        System.out.println("springMVC方法执行了.....");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断 路径是否存在
        File file = new File(path);
        if(!file.exists()) {
            //创建文件
            file.mkdirs();
        }


        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));


        return "success";
    }

    @RequestMapping("/fileUpload3")
    public String fileUploade3( MultipartFile upload) throws IOException {

        System.out.println("跨服务器上传.....");

        //定义路径
        String path = "http://localhost:9090/uploads/";

        File file = new File(path);

        if(!file.exists()) {
            //创建文件
            file.mkdirs();
        }


        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名称设置唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传，跨服务器

        //创建客户端对象
        Client client = Client.create();

        //和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);


        webResource.put(upload.getBytes());

        return "success";
    }



}
