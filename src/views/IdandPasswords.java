package views;
import java.util.HashMap;

public class IdandPasswords {
    
    HashMap<String, String> logininfo = new HashMap<String, String>();

    IdandPasswords() {
        logininfo.put("admin", "titok");
        logininfo.put("admin1", "titok");
        logininfo.put("admin2", "titok");
    }

    protected HashMap getLoginInfo() {
        return logininfo;
    }
} 
 