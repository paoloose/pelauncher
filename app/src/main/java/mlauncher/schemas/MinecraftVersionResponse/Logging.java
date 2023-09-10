package mlauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Logging {

    @SerializedName("client")
    @Expose
    public LoggingClient client;

}
