import java.io.IOException;
import java.util.Random;

public class Device extends Thread {
	public String name, type;
	public int con;// an integer flag to save the connection number

	public Device(String n, String t) {
		name = n;
		type = t;
	}

	public void run() {
		try {
			connect();
			onlineActivity();
			disconnect();
		} catch (IOException | InterruptedException e) {
		}
	}

	private void connect() throws IOException {
		Router.occupyConnection(this);
	}

	private void onlineActivity() throws InterruptedException {
		Random r = new Random();
		System.out.println("Connection " + con + ": " + name + " Performs online activity");
		sleep((r.nextInt(3) + 3) * 1000);
		// sleep (3-6) seconds
	}

	private void disconnect() throws IOException {
		Router.releaseConnection(this);
	}
}
