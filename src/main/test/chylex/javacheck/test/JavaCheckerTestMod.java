package chylex.javacheck.test;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import chylex.javacheck.report.JavaCheckerReporter;

@Mod(modid = "JavaCheckerTestMod")
public class JavaCheckerTestMod{
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent e){
		JavaCheckerReporter.run(null);
	}
}
