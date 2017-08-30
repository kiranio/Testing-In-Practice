
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class SerenityVar {
    private static SerenityVar propsInstance = null;
    public static EnvironmentVariables variables;

    private SerenityVar() {
        variables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    public static SerenityVar getInstance() {
        if(propsInstance == null) {
            propsInstance = new SerenityVar();
        }
        return propsInstance;
    }

    public EnvironmentVariables getSerenityProps(){
        return variables;
    }


