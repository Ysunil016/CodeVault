import java.util.LinkedList;
import java.util.Queue;

public class Start {
	static Queue<Animal> queueStore = new LinkedList<Animal>();

	public static void main(String[] args) {

	}

	public static void enqueue(Animal animalInput) {
		queueStore.add(animalInput);
	}

	public static void dequeueAny() {
		if (!queueStore.isEmpty()) {
			queueStore.poll();
		}
	}

	static class Animal {
		int id;
		int type;
		Animal next = null;

		Animal(int id, int type) {
			this.id = id;
			this.type = type;
			this.next = null;
		}

	}
}
