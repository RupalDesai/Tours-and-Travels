package com.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Account;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String UPLOAD_DIRECTORY = "C:/my j2ee proj/Tour/WebContent/upload";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		if(action == null){
			request.getRequestDispatcher("jsps/admin/index.jsp").forward(request, response);
		}
		else{
			doPost(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		if(action.equals("add_tour")){
			request.setAttribute("flag", "100");
			request.getRequestDispatcher("jsps/admin/index.jsp").forward(request, response);
			
		}
		if(action.equals("add_package_form")){
			String pname=request.getParameter("pname");
			String price = request.getParameter("price");
			String details = request.getParameter("details");
			String continent_id = request.getParameter("continent_id");
			request.setAttribute("flag", "100");
			request.setAttribute("msg", "Tour Package Added..");
			//Add this info to DB
			Account account = new Account();
			try {
				account.insertPackage(pname,price,details,continent_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account=null;
			request.getRequestDispatcher("jsps/admin/index.jsp").forward(request, response);
		}
		
		if(action.equals("edit_tour")){
			
		}
		
		if(action.equals("custom_package")){
			
		}
		
		if(action.equals("add_image")){
			request.getRequestDispatcher("jsps/admin/image_upload.jsp").forward(request, response);
			
		}
		if(action.equals("show_upload")){
			String pac=request.getParameter("pac");
			request.setAttribute("pac", pac);
			request.getRequestDispatcher("jsps/admin/image_form.jsp").forward(request, response);
		}
		
		if(action.equals("image_upload")){
		//file upload goes here
			//process only if its multipart content
			String name="";
			
			 String pac  = request.getParameter("pac");
	        if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                List<FileItem> multiparts = new ServletFileUpload(
	                                         new DiskFileItemFactory()).parseRequest(request);
	              
	                for(FileItem item : multiparts){
	                    if(!item.isFormField()){
	                         name = new File(item.getName()).getName();
	                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
	                    }
	                }
	                System.out.println(pac);
	                //add image to db
	                Account account = new Account();
	                String path="upload" + "/" + name;
	               account.addImage(path,pac);
	               
	               
	            }
	            catch(Exception e){
	            	e.printStackTrace();
	            	
	            }
	                
	                request.setAttribute("msg", "Image Uploaded...");
	            request.getRequestDispatcher("jsps/admin/image_upload.jsp").forward(request, response);
	    		
		
	}

		}
		
	}
}
		
	

















