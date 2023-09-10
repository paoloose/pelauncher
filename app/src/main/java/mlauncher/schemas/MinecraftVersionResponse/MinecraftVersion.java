package mlauncher.schemas.MinecraftVersionResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MinecraftVersion {

    @SerializedName("arguments")
    @Expose
    public Arguments arguments;
    @SerializedName("assetIndex")
    @Expose
    public AssetIndex assetIndex;
    @SerializedName("assets")
    @Expose
    public String assets;
    @SerializedName("complianceLevel")
    @Expose
    public Integer complianceLevel;
    @SerializedName("downloads")
    @Expose
    public VersionDownloads downloads;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("javaVersion")
    @Expose
    public JavaVersion javaVersion;
    @SerializedName("libraries")
    @Expose
    public List<Library> libraries;
    @SerializedName("logging")
    @Expose
    public Logging logging;
    @SerializedName("mainClass")
    @Expose
    public String mainClass;
    @SerializedName("minimumLauncherVersion")
    @Expose
    public Integer minimumLauncherVersion;
    @SerializedName("releaseTime")
    @Expose
    public String releaseTime;
    @SerializedName("time")
    @Expose
    public String time;
    @SerializedName("type")
    @Expose
    public String type;
}
