package chylex.java7check;
import java.util.Map;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class JavaCheckerCoremod implements IFMLLoadingPlugin{
	@Override
	public String[] getASMTransformerClass(){
		return null;
	}

	@Override
	public String getAccessTransformerClass(){
		return null;
	}

	@Override
	public String getModContainerClass(){
		return null;
	}

	@Override
	public String getSetupClass(){
		return "chylex.java7check.report.JavaCheckerReporter";
	}

	@Override
	public void injectData(Map<String,Object> data){}
}
