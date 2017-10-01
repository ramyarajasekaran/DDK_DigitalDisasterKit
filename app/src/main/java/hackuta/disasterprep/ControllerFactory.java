package hackuta.disasterprep;
import android.content.Context;
/**
 * Created by sdarnell on 9/30/2017.
 */

public class ControllerFactory {
    private static Controller controller;

    public static void SetContext(Context context){
        if(controller != null){ return; }
        controller = new Controller(context);
    }

    public static Controller getController(){
        return controller;
    }
}
