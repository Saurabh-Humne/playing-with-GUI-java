import java.util.HashMap;

public class IDandPassword {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPassword(){
		
		logininfo.put("Godzila", "pizza");
		logininfo.put("Kong", "BANANA");
		logininfo.put("Shimu", "ice123");
	}
	
	protected HashMap getLoginInfo() {
		return logininfo;
	}
}
