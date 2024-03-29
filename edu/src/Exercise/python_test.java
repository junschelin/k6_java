package Exercise;

class Dog{
	
	String name;
	int age;
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sit() {
		System.out.println(name + " is now sitting.");
	}
}

public class python_test {
	public static void main(String[] args) {
		Dog d = new Dog("Willie", 6);
		d.sit();
	}
}
