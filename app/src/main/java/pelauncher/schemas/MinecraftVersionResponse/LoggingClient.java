package pelauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoggingClient {

    @SerializedName("argument")
    @Expose
    public String argument;
    @SerializedName("file")
    @Expose
    public File file;
    @SerializedName("type")
    @Expose
    public String type;

}
