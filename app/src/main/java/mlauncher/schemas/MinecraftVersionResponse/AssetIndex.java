package mlauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssetIndex {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("sha1")
    @Expose
    public String sha1;
    @SerializedName("size")
    @Expose
    public Integer size;
    @SerializedName("totalSize")
    @Expose
    public Integer totalSize;
    @SerializedName("url")
    @Expose
    public String url;

}
