package response.kudago.UI;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("results")
    private JsonArray results;


    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("slug")
    private String slug;

    public Event() {
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
}