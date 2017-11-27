import java.util.Scanner;

public class CountingThreadConsole {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); //키입력 기다림
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start(); //스레드시작
	}
}

class CountingThread implements Runnable {
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++) //10이상되면 종료
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}