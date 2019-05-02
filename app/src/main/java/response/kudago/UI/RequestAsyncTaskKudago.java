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

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://kudago.com/public-api/v1.2/events/")
                .build();

        Response response = null;

        try {
            response = client.newCall(request).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response result) {
        delegate.processFinish(result);
    }
}