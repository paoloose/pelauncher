package pelauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DownloadClient {

    @SerializedName("sha1")
    @Expose
    public String sha1;
    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("url")
    @Expose
    public String url;

}
