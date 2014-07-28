package Controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import Model.*;
import java.sql.Connection;
import com.opensymphony.xwork2.ActionSupport;

public class login extends ActionSupport implements SessionAware,RequestAware{
	
	private user userBean;
	private DBconnection DBobject;
	private Map session;
	private Map request;
	/*************************************************************
	 * get session
	 *************************************************************/
	public void setSession(Map value){
		session=value;
	}
	
	public void setRequest(Map value){
		request=value;
	}
    public void setUserBean(user userBean){
    	this.userBean = userBean;
    }
    public user getUserBean(){
    	return this.userBean;
    }
	
	
	public String login(){
		
		Connection conn= DBobject.getConnection();
		PreparedStatement preparedStatement = null;
		try{
			if(conn!=null){
				String selectSQL = "SELECT * FROM usertable WHERE username = ? AND password = ?";
				preparedStatement = conn.prepareStatement(selectSQL);
				preparedStatement.setString(1, userBean.getUserName());
				preparedStatement.setString(2, userBean.getPassWord());
				ResultSet rs = preparedStatement.executeQuery();
				String userole = "";
				while (rs.next()) {
					
					userole = rs.getString("role");
					
				}
				if(userole.equals("user")){
					return "success";
				}else{
					request.put("loginErrorMessage", "Login fail !!!");
					return "unsuccess";
				}
				
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}
		request.put("loginErrorMessage", "DB connect fail !!!");
		return "unsuccess";
		
	}

}
