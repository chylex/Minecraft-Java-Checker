package chylex.javacheck.report;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkEvent.EventType;
import javax.swing.event.HyperlinkListener;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;

public final class JavaCheckerReporter{
	public static void run(JavaVersion minVersion){
		if (minVersion == null || !SystemUtils.isJavaVersionAtLeast(minVersion)){
			if (minVersion == null)minVersion = JavaVersion.JAVA_1_8;
			
			try{
				Class relaunchLog = findRelaunchLog();
				if (relaunchLog != null)relaunchLog.getMethod("severe",String.class,Object[].class).invoke(null,getConsoleReport(minVersion),new Object[0]);
			}catch(Throwable t){}
			
			String style = "font-family:Dialog;font-size:12;font-weight:bold";
			JEditorPane pane = new JEditorPane("text/html","<html><body style='"+style+"'>"+getWindowReport(minVersion)+"</body></html>");
			pane.setBackground(new JLabel().getBackground());
			pane.setEditable(false);
			
			pane.addHyperlinkListener(new HyperlinkListener(){
				@Override
				public void hyperlinkUpdate(HyperlinkEvent e){
					if (e.getEventType() == EventType.ACTIVATED){
						try{
							if (Desktop.isDesktopSupported())Desktop.getDesktop().browse(e.getURL().toURI());
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}
				}
			});
			
			JOptionPane.showMessageDialog(null,pane,"Outdated Java",JOptionPane.ERROR_MESSAGE);
            throw new OutdatedJavaException();
		}
	}
	
	private static String getConsoleReport(JavaVersion minVersion){
		return new StringBuilder(242).append("\n")
		.append("\n!! DO NOT REPORT !!\n\n")
		.append("One of the mods requires Java "+minVersion.toString()+" or newer, you are using ").append(SystemUtils.JAVA_VERSION).append(".\n")
		.append("Visit https://java.com/download/ for the latest version.\n")
		.append("Please, uninstall the old version first to prevent further issues.")
		.append("\n\n!! DO NOT REPORT !!\n")
		.toString();
	}
	
	private static String getWindowReport(JavaVersion minVersion){
		return new StringBuilder(230)
		.append("One of the mods requires Java "+minVersion.toString()+" or newer, you are using ").append(SystemUtils.JAVA_VERSION).append(".<br>")
		.append("Visit <a href=\"https://java.com/download/\"><span style=\"color:blue\">https://java.com/download/</span></a> for the latest version.<br>")
		.append("Please, uninstall the old version first to prevent further issues.")
		.toString();
	}
	
	private static Class findRelaunchLog() throws Throwable{
		try{
			return Class.forName("cpw.mods.fml.relauncher.FMLRelaunchLog");
		}catch(ClassNotFoundException e){}
		
		try{
			return Class.forName("net.minecraftforge.fml.relauncher.FMLRelaunchLog");
		}catch(ClassNotFoundException e){}
		
		return null;
	}
}
