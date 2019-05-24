package response.kudago.UI;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Event {

    @SerializedName("results")
    private JsonArray results;
    @SerializedName("images")
    private JsonArray images;

    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("slug")
    private String slug;
    @SerializedName("image")
    private String image;

    public Event() {
    }

    public Response catchTitle(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://kudago.com/public-api/v1.4/events/?lang=&fields=title,images&actual_since=1558685995")
                .build();

        okhttp3.Response response = null;

        try {
            response = client.newCall(request).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public JsonArray getResults() {
        return results;
    }

    public void setResults(JsonArray results) {
        this.results = results;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public JsonArray getImages() {
        return images;
    }

    public void setImages(JsonArray images) {
        this.images = images;
    }
}