package chylex.javacheck;
import java.util.Map;
import org.apache.commons.lang3.JavaVersion;
import chylex.javacheck.report.JavaCheckerReporter;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class Java8CheckerCoremod implements IFMLLoadingPlugin{
	@Override
	public String getSetupClass(){
		JavaCheckerReporter.minVersion = JavaVersion.JAVA_1_8;
		return JavaCheckerReporter.class.getName();
	}

	@Override public String[] getASMTransformerClass(){ return null; }
	@Override public String getAccessTransformerClass(){ return null; }
	@Override public String getModContainerClass(){ return null; }
	@Override public void injectData(Map<String,Object> data){}
}
