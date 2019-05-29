package AllForFragment;

import android.util.Log;

public class Dialog {
    private String alert;
    private boolean flag = false;
    private int value = 0;
    private int count = 1;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = this.value + value ;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = this.count + count;
    }
}
