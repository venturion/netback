package netback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Pinger {
	public boolean ping(String ipAddress, NetworkInterface networkInterface) throws UnknownHostException, IOException, Exception {

		try {
			InetAddress inet = InetAddress.getByName(ipAddress);

			boolean status = inet.isReachable(networkInterface, 10, 5000); // Timeout = 5000 milli seconds

			String netName = networkInterface.getName();
			String displayName = networkInterface.getDisplayName();

			if (status) {
				System.out.println("Status : " + ipAddress + " is reachable in: " + displayName);
				return true; // conectou com sucesso ao host
			} 
			else {
				// System.out.println("Status : Host is not reachable in:" + netName);
				return false; // host não encontrado
			}
		} 
		catch (UnknownHostException e) {
			// System.err.println("Host does not exists");
			throw e;
		} 
		catch (IOException e) {
			// System.err.println("Error in reaching the Host");
			throw e;
		}
	}

	public String getExternalAddress() throws IOException {
		String url = "http://checkip.amazonaws.com";
		URL whatismyip = new URL(url);
		BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

		String ip = in.readLine(); // you get the IP as a String
		return ip;
	}

	public void getInterfaces() throws UnknownHostException, IOException, Exception {
		String ip = "localhost";

		ip = this.getExternalAddress();
		
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

		while (interfaces.hasMoreElements()) {
			NetworkInterface net = (NetworkInterface) interfaces.nextElement();
			this.ping(ip, net);
			// System.out.println(net.getDisplayName());
		}
	}

}