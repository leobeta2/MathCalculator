package cordova.plugin.mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
            // String message = args.getString(0);
            // this.coolMethod(message, callbackContext);
            this.add(args, callbackContext);
            return true;
        }else if(action.equals("substract")){
          this.substract(args, callbackContext);
          return true;
        }
        return false;
    }



    private void add(JSONArray args, CallbackContext callback){

        if(args != null){

            try {
              int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
              int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));


              callback.succes(""+(p1+p2));
            } catch(Exception e) {
              callback.error("Algo no funciono!! "+e);
            }

        }else{
            callback.error("Por favor no pasar valores nulos");
        }
    }

    private void substract(JSONArray args, CallbackContext callback){

        if(args != null){

            try {
              int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
              int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));


              callback.succes(""+(p1-p2));
            } catch(Exception e) {
              callback.error("Algo no funciono!! "+e);
            }

        }else{
            callback.error("Por favor no pasar valores nulos");
        }
    }
}
