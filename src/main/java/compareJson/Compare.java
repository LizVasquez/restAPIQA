package compareJson;

import org.json.JSONObject;

public class Compare {
    //public boolean areEqualJson(String exp, String act) {
    public static boolean areEqualJson(JSONObject ob1, JSONObject ob2) {
        if ((!ob1.equals(ob2))){
            return false;
        }else {
            return true;
        }

    }



}
