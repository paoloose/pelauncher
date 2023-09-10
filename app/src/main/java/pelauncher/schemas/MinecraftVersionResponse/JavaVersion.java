package pelauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JavaVersion {

    @SerializedName("component")
    @Expose
    public String component;
    @SerializedName("majorVersion")
    @Expose
    public Integer majorVersion;

}
