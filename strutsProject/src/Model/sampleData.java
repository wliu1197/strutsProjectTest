package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
public class sampleData {
	private int key;
	private String field1;
	private String field2;
	
	public void setKey(int key){
		this.key = key;
	}
	public int getKey(){
		return this.key;
	}
	
	public void setField1(String field1){
		this.field1 = field1;
	}
	public String getField1(){
		return this.field1;
	}
	
	public void setField2(String field2){
		this.field2 = field2;
	}
	public String getField2(){
		return this.field2;
	}
	
	
	
}
