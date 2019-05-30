package AllForFragment;

import android.util.Log;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;

public class Dialog {
    private String alert;
    private boolean flag = false;
    private String[] ImagesIfYES = {"SOMETHING"};
    private int[] array;
    public String getAlert() {
        return this.alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag() {
        this.flag = true;
    }

    public String getImagesIfYES() {
        return ImagesIfYES[0];
    }

    public void setImagesIfYES(String element) {
        ImagesIfYES[0] = element;
    }
}
