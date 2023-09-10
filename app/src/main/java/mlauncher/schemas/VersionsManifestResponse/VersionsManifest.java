package mlauncher.schemas.VersionsManifestResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionsManifest {

    @SerializedName("latest")
    @Expose
    public Latest latest;
    @SerializedName("versions")
    @Expose
    public List<Version> versions;

}
