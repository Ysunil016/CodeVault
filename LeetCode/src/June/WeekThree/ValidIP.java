package June.WeekThree;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

public class ValidIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValidIP("127.0.0.1"));
	}

	private static String isValidIP(String IP) {
		try {
			return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
		} catch (UnknownHostException e) {
			return "Neither";
		}

	}
	
	class Solution {
		  String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
			Pattern pattenIPv4 =
		          Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

		  String chunkIPv6 = "([0-9a-fA-F]{1,4})";
		  Pattern pattenIPv6 =
		          Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

		  public String validIPAddress(String IP) {
		    if (pattenIPv4.matcher(IP).matches()) return "IPv4";
		    return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
		  }
		}

}
