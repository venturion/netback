/**
 * 
 */
package netback;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @author Felipe
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	
	public static String ipAddress = "localhost";
	public static Pinger p = new Pinger();
	
	public static void main(String[] args) throws UnknownHostException, IOException, Exception {
		// TODO Auto-generated method stub
		Main.getInterfaceName();		
	}
	
	public static void getInterfaceName() throws UnknownHostException, IOException, Exception{
		Main.p.getInterfaces();
	}
	
}
