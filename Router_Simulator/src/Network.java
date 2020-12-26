import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
C1 mobile
C2 tablet
C3 PC
C4 PC
C5 mobile
C6 tablet
C7 PC
C8 PC
 */
public class Network {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		int nConnections;
		int nDevices;
		ArrayList<Device> devices = new ArrayList<Device>();

		Scanner s1 = new Scanner(System.in);
		System.out.println("What is number of WI-FI Connections?");
		nConnections = s1.nextInt();
		System.out.println("What is number of devices Clients want to connect?");
		nDevices = s1.nextInt();

		Scanner s2 = new Scanner(System.in);
		for (int i = 0; i < nDevices; i++) {
			String[] info = s2.nextLine().split(" ");
			Device d = new Device(info[0], info[1]);
			devices.add(d);
		}
		System.out.println("output is being generated ...");
		System.setOut(new PrintStream("result.txt"));
		Router r = new Router(nConnections);
		for (Device d : devices) {
			d.start();
		}
	}
}
