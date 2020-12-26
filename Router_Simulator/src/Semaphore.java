import java.util.ArrayList;

class Semaphore {
	protected int value = 0;
	private ArrayList<Boolean> connections = new ArrayList<Boolean>();
	// this array list will hold booleans corresponding to the connections
	// these booleans values will let us keep track of the connection number
	// false = available , true = occupied

	protected Semaphore() {
		value = 0;
	}

	protected Semaphore(int initial) {
		value = initial;
		for (int i = 0; i < value; i++)
			connections.add(false);// filling the array with false booleans means available connections
	}

	public synchronized void P(Device d) {
		value--;
		if (value < 0) {// if the value dropped below 0 after decrement it means all connections are
						// occupied and this device has to wait
			System.out.println("(" + d.name + ")(" + d.type + ") Arrived and waiting");
			try {
				wait();
			} catch (InterruptedException e) {
			}
		} else
			System.out.println("(" + d.name + ")(" + d.type + ") Arrived");
		d.con = connections.indexOf(false) + 1;// giving the connection number to the device
		connections.set(d.con - 1, true);// state the connection to occupied
		// connection will start from 1 not 0 as index
	}

	public synchronized void V(Device d) {
		value++;
		connections.set(d.con - 1, false);// state the connection to available
		if (value <= 0)// if it still <= 0 after increment it means there was a waiting device or more
			notify();
	}
}