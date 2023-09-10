package mlauncher.schemas.MinecraftVersionResponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arguments {

    @SerializedName("game")
    @Expose
    public List<Object> game;
    @SerializedName("jvm")
    @Expose
    public List<Object> jvm;
}
