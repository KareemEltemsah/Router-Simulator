import java.io.IOException;

public class Router {
	private int numOfConnection;
	private static Semaphore S;

	public Router(int n) {
		numOfConnection = n;
		S = new Semaphore(numOfConnection);
	}

	/*
	 * i made the semaphore and connection methods static so i can call Router class
	 * inside the Device class without making instance of it
	 */
	public static void occupyConnection(Device d) throws IOException {
		S.P(d);
		System.out.println("Connection " + d.con + ": " + d.name + " Occupied");
	}

	public static void releaseConnection(Device d) throws IOException {
		System.out.println("Connection " + d.con + ": " + d.name + " Logged out");
		S.V(d);
	}
}
