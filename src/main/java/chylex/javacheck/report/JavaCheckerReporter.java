package chylex.javacheck.report;
import java.util.Map;
import javax.swing.JOptionPane;
import net.minecraftforge.fml.relauncher.FMLRelaunchLog;
import net.minecraftforge.fml.relauncher.IFMLCallHook;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;

public final class JavaCheckerReporter implements IFMLCallHook{
	public static JavaVersion minVersion = null;
	
	@Override
	public Void call() throws Exception{
		if (!SystemUtils.isJavaVersionAtLeast(minVersion)){
			FMLRelaunchLog.severe(getConsoleReport());
			JOptionPane.showMessageDialog(null, "<html>"+getWindowReport()+"</html>","Outdated Java",JOptionPane.ERROR_MESSAGE);
            		throw new OutdatedJavaException();
		}
		
		return null;
	}

	@Override
	public void injectData(Map<String,Object> data){}
	
	static String getConsoleReport(){
		return new StringBuilder(242).append("\n")
		.append("\n!! DO NOT REPORT !!\n\n")
		.append("One of the mods requires Java 1.7 or newer, you are using ").append(SystemUtils.JAVA_VERSION).append(".\n")
		.append("Visit https://java.com/download/ for the latest version.\n")
		.append("Please, uninstall the old version first to prevent further issues.")
		.append("\n\n!! DO NOT REPORT !!\n")
		.toString();
	}
	
	static String getWindowReport(){
		return new StringBuilder(230)
		.append("One of the mods requires Java 1.7 or newer, you are using ").append(SystemUtils.JAVA_VERSION).append(".<br>")
		.append("Visit <span style=\"color:red\">https://java.com/download/</span> for the latest version.<br>")
		.append("Please, uninstall the old version first to prevent further issues.")
		.toString();
	}
}
