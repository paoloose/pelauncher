package mlauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LibraryDownloads {

    @SerializedName("artifact")
    @Expose
    public Artifact artifact;

}
