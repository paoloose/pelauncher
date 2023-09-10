package pelauncher.schemas.VersionsManifestResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Latest {
    @SerializedName("release")
    @Expose
    public String release;
    @SerializedName("snapshot")
    @Expose
    public String snapshot;
}
