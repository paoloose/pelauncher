package pelauncher.schemas.MinecraftVersionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JVMOsRule {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("arch")
    @Expose
    public String arch;

}
