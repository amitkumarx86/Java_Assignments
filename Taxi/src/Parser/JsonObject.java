package Parser;

public class JsonObject {
	private String key;
	private String value;
	private JsonObject[] obj;
	public JsonObject(String key, String value){
		this.key=key;
		this.value = value;
	}
	public JsonObject(String key, JsonObject[] obj){
		this.key=key;
		this.obj = obj;
	}
	
	public void setKey(String key){
		this.key=key;
	}
	public void setValue(String value){
		this.value = value;
	}
	public void setKey(JsonObject[] obj){
		this.obj = obj;
	}
	
	public String getKey(){
		return this.key;
	}
	public String getValue(){
		return this.value;
	}
	public JsonObject[] getObj(){
		return this.obj;
	}
	
}
