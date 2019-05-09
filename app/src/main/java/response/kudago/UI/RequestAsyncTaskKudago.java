package response.kudago.UI;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestAsyncTaskKudago  extends AsyncTask<Void,Void,Response> {

    private AsyncResponseKudago delegate;

    public RequestAsyncTaskKudago(AsyncResponseKudago delegate){
        this.delegate= delegate;
    }
    @Override
    protected Response doInBackground(Void... params) {

       Event response = new Event();
        return response.catchTitle();
    }

    @Override
    protected void onPostExecute(Response result) {
        delegate.processFinish(result);
    }
}