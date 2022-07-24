import java.util.Scanner;

public class Shell {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("basic > ");
			String text = sc.nextLine();
			
			if (text.equals("exit")) {
				break;
			}
			
			Basic b = new Basic();
			b = b.run("<stdin>", text);
			
			if (b.getError() != null) {
				System.out.println(b.getError());
			} else {
				System.out.println(b.getResult());
			}
		}
		
		sc.close();
	}

}
