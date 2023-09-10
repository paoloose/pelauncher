package mlauncher.schemas.MinecraftVersionResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jvm {

    @SerializedName("rules")
    @Expose
    public List<JVMRule> rules;
    @SerializedName("value")
    @Expose
    public String value;

}
