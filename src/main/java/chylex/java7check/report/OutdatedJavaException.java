package chylex.java7check.report;
import java.io.PrintStream;
import java.io.PrintWriter;

public class OutdatedJavaException extends RuntimeException{
	public OutdatedJavaException(){
		setStackTrace(new StackTraceElement[0]);
	}
	
	@Override
	public StackTraceElement[] getStackTrace(){
		return new StackTraceElement[0];
	}
	
	@Override
	public void printStackTrace(PrintStream s){}
	
	@Override
	public void printStackTrace(PrintWriter w){}
}
