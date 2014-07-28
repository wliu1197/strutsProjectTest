package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
public class Todo {
  private String summary;
  private String description;
  private int [] a = {1,2,3};
  public String getSummary() {
    return summary;
  }
  public void setSummary(String summary) {
    this.summary = summary;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
  public int[] getA(){
	  return this.a;
  }
  public void setA(int [] a){
	  this.a = a;
  }

  
} 