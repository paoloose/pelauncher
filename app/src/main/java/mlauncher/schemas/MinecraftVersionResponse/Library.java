package mlauncher.schemas.MinecraftVersionResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Library {

    @SerializedName("downloads")
    @Expose
    public LibraryDownloads downloads;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("rules")
    @Expose
    public List<LibraryRule> rules;

}
