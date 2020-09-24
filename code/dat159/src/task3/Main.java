package task3;

public class Main {

	public static void main(String args[]) {
		Intermediate i = new Intermediate("navn");
		Medical m = new Medical("medic");
		Soldier s = new Soldier("soldier");

		System.out.println(i.getName());		
		
		System.out.println(m.getName());

		System.out.println(s.getName());

	}

}
