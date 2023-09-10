package mlauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionDownloads {

    @SerializedName("client")
    @Expose
    public DownloadClient client;
    @SerializedName("client_mappings")
    @Expose
    public ClientMappings clientMappings;
    @SerializedName("server")
    @Expose
    public Server server;
    @SerializedName("server_mappings")
    @Expose
    public ServerMappings serverMappings;

}
