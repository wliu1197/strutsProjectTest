package webservice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import Model.DBconnection;
import Model.Todo;
import Model.sampleData;

@Path("/todo")
public class toDoResource {
  // This method is called if XMLis request
  @GET
  @Produces({ MediaType.APPLICATION_JSON })
  public Todo getXML() {
    Todo todo = new Todo();
    todo.setSummary("This is my first todo");
    todo.setDescription("This is my first todo");
    return todo;
  }
  
  @GET @Path("/getSampleData")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  public ArrayList<sampleData> getData(){
	ArrayList<sampleData> result = new ArrayList<sampleData>();
	
	DBconnection DBobject = null;
	Connection conn= DBobject.getConnection();
	PreparedStatement preparedStatement = null;
	try{
		if(conn!=null){
			String selectSQL = "SELECT * FROM sampleData";
			preparedStatement = conn.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				sampleData d = new sampleData();	
				d.setKey(rs.getInt("id"));
				d.setField1(rs.getString("testfield1"));
				d.setField2(rs.getString("testfield2"));
				result.add(d);
			}
		}
	}catch(Exception e) {
		// TODO Auto-generated catch block
	
		e.printStackTrace();
	}  
	  
	   
	  return result;
  }
  
  @POST @Path("/postRest")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  public Todo function_create(JSONObject json) throws JSONException {
  
    Todo todo = new Todo();
    todo.setSummary((String)json.get("summary"));
    todo.setDescription((String)json.get("description"));
    return todo;
  }
  
  @POST @Path("/postRestList")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  public ArrayList<Todo> function_create2(JSONObject json) throws JSONException {
	
	ArrayList<Todo> todoList = new ArrayList<Todo>();
	Todo todo = new Todo();
	todo.setSummary((String)json.get("summary"));
	todo.setDescription((String)json.get("description"));
    todoList.add(todo);
    return todoList;
  }
  
  @GET @Path("/postRestListGet")
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  public Todo function_create3(@QueryParam("summary") String summary,@QueryParam("description") String description) throws JSONException {

	Todo todo = new Todo();
	todo.setSummary(summary);
	todo.setDescription(description);
    
    return todo;
  }
  
  @POST @Path("/postRestLogin")
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces(MediaType.TEXT_PLAIN)
  public String function_login(JSONObject json) throws JSONException {
    	  
	DBconnection DBobject = null;
	Connection conn= DBobject.getConnection();
	PreparedStatement preparedStatement = null;
	try{
		if(conn!=null){
			String selectSQL = "SELECT * FROM usertable WHERE username = ? AND password = ?";
			preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setString(1, json.getString("userName"));
			preparedStatement.setString(2, json.getString("passWord"));
			ResultSet rs = preparedStatement.executeQuery();
			String userole = "";
			while (rs.next()) {
				
				userole = rs.getString("role");
				
			}
			if(userole.equals("user")){
				
				return "success";
			}else{
				
				return "unsuccess";
			}
			
		}
	}catch (Exception e) {
		// TODO Auto-generated catch block
	
		e.printStackTrace();
	}  
    
    return "unsuccessful";
  }
} 