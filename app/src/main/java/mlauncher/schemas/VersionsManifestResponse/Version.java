package mlauncher.schemas.VersionsManifestResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Version {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("releaseTime")
    @Expose
    public String releaseTime;
    @SerializedName("sha1")
    @Expose
    public String sha1;
    @SerializedName("complianceLevel")
    @Expose
    public Integer complianceLevel;
}
