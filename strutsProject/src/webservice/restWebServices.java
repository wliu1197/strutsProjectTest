package webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class restWebServices {
	

	  // This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }

	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  public String sayHTMLTextHello() {
	    return "<h1>Hello Jersey</h1>";
	  }

	
}
