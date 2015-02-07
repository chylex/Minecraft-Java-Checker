package chylex.javacheck;
import java.util.Map;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.commons.lang3.JavaVersion;
import chylex.javacheck.report.JavaCheckerReporter;

public class Java7CheckerCoremod implements IFMLLoadingPlugin{
	@Override
	public String getSetupClass(){
		JavaCheckerReporter.minVersion = JavaVersion.JAVA_1_7;
		return "chylex.javacheck.report.JavaCheckerReporter";
	}
	
	@Override public String[] getASMTransformerClass(){ return null; }
	@Override public String getAccessTransformerClass(){ return null; }
	@Override public String getModContainerClass(){ return null; }
	@Override public void injectData(Map<String,Object> data){}
}
