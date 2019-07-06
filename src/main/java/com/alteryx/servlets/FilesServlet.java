package com.alteryx.servlets;

import com.alteryx.beans.FileInfo;
import com.alteryx.beans.utils.IFileReader;
import com.alteryx.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/files")
public class FilesServlet extends HttpServlet {

    private IFileReader fileReader;

    public static final String FILES_DIRECTORY = "C:\\Work\\csvFiles";
    public static final String[] FILES_EXTENSIONS = new String[]{"csv"};

    @Override
    public void init() throws ServletException {
        super.init();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.fileReader = context.getBean(IFileReader.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FileInfo> filesInfo = fileReader.getFilesInfo(FILES_DIRECTORY, FILES_EXTENSIONS);
        request.setAttribute("filesInfo", filesInfo);

        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}
