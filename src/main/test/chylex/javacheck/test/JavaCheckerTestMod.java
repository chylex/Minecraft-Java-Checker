package chylex.javacheck.test;
import org.apache.commons.lang3.JavaVersion;
import chylex.javacheck.report.JavaCheckerReporter;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "JavaCheckerTestMod")
public class JavaCheckerTestMod{
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent e){
		JavaCheckerReporter.run(null);
	}
}
