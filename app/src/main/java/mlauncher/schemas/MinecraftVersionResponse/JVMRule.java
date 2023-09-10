package mlauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JVMRule {

    @SerializedName("action")
    @Expose
    public String action;
    @SerializedName("os")
    @Expose
    public JVMOsRule os;

}
