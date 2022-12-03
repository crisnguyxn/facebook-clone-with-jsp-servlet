package com.facebook.Facebook.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.Map;

public class FormUtil {
    @SuppressWarnings("unchecked")
    public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
        T object = null;
        String filePath = null;
        String realPath = null;
        try {
            object = clazz.newInstance();
            if(request.getServletPath().equals("/post") || request.getServletPath().equals("/update")){
                Part part = request.getPart("file");
                realPath = request.getServletContext().getRealPath("/img");
                filePath = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if(filePath.equals("")){
                    BeanUtils.populate(object, request.getParameterMap());
                    BeanUtils.setProperty(object,"fileUrl","");
                    return object;
                }
                part.write(realPath+"/"+filePath);
            }
            BeanUtils.populate(object, request.getParameterMap());
            BeanUtils.setProperty(object,"fileUrl","img/"+filePath);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |IOException|ServletException e) {
            System.out.print(e.getMessage());
        }
        return object;
    }
}
