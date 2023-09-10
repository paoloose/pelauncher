package mlauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LibraryRule {

    @SerializedName("action")
    @Expose
    public String action;
    @SerializedName("os")
    @Expose
    public LibraryOSRule os;

}
