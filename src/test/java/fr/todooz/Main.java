package fr.todooz;

public class Main {
	public static final void main(String[] args) {
		System.out.println("Hello world !");
		
		People person = new People();

		person.setFirstname("alex");
		person.setLastname("luthor");

		System.out.println(person);
    }

}
