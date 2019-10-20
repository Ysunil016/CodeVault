package com.Coding;

import java.util.LinkedList;

public class AnimalShelter {

	static LinkedList<Dog> dogQueue = new LinkedList<Dog>();
	static LinkedList<Cat> catQueue = new LinkedList<Cat>();
	static int order = 0;

	public static void main(String[] args) {
		Animal dogOne = new Dog("Sunil");
		Animal dogTwo = new Dog("Sanjay");
		Animal dogThree = new Dog("Anuj");
		Animal dogFour = new Dog("Avinash");
		Animal dogFive = new Dog("Ajay");

		Animal catOne = new Cat("Shreya");
		Animal catTwo = new Cat("Sarita");
		Animal catThree = new Cat("Shine");
		Animal catFour = new Cat("Shami");
		Animal catFive = new Cat("Pankhuri");

		enqueue(dogOne);
		enqueue(catOne);
		enqueue(catTwo);
		enqueue(dogTwo);
		enqueue(catThree);
		enqueue(catFour);
		enqueue(dogThree);
		enqueue(catFive);
		enqueue(dogFour);
		enqueue(dogFive);

		dequeueAny();
		dequeueAny();
		dequeueDog();
		dequeueAny();
		dequeueAny();
		dequeueAny();
		dequeueAny();

		dogQueue.iterator().forEachRemaining(dog -> {
			System.out.println(dog.name);
		});
		System.out.println();
		catQueue.iterator().forEachRemaining(cat -> {
			System.out.println(cat.name);
		});

	}

	public static void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) {
			dogQueue.add((Dog) a);
		} else {
			catQueue.add((Cat) a);
		}

	}

	public static Animal dequeueAny() {
		if (dogQueue.size() == 0) {
			return dequeueCat();
		} else if (catQueue.size() == 0) {
			return dequeueDog();
		}

		Dog dog = dogQueue.peek();
		Cat cat = catQueue.peek();

		if (dog.isOlderThan(cat))
			return dequeueDog();
		else
			return dequeueCat();

	}

	public static Dog dequeueDog() {
		return dogQueue.poll();
	}

	public static Cat dequeueCat() {
		return catQueue.poll();
	}

	abstract static class Animal {
		protected String name;
		private int order;

		public Animal(String name) {
			this.name = name;
		};

		public void setOrder(int order) {
			this.order = order;
		}

		public int getOrder() {
			return order;
		}

		public boolean isOlderThan(Animal a) {
			return (a.getOrder() > this.order);
		}

	}

	static class Dog extends Animal {
		public Dog(String name) {
			super(name);
		}
	}

	static class Cat extends Animal {
		public Cat(String name) {
			super(name);
		}

	}
}
