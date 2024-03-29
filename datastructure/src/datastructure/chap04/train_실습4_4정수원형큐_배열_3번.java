package datastructure.chap04;
import java.nio.channels.OverlappingFileLockException;
/*
 * 큐에서는 예외 클래스를 만드는 연습
 */
import java.util.Random;
/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */
import java.util.Scanner;

//int형 고정 길이 큐

class IntQueue3 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	//private int num; // 현재 데이터 개수 (num 사용하지 않고 코드 구현해보기)
	boolean isFulltag = false;


//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		this.que = new int[maxlen];
		this.capacity = maxlen;
		this.front = 0;
		this.rear = 0;
	}

	//--- 실행시 예외: 큐가 가득 찼음 ---//
	// 오류 생성 클래스 선언 (Overflow)
	public class OverflowIntQueue3Exception extends RuntimeException{
		public OverflowIntQueue3Exception() {
		}
	}
	
	//--- 실행시 예외: 큐가 비어있음 ---//
	// 오류 생성 클래스 선언 (Empty)
	public class EmptyIntQueue3Exception extends RuntimeException{
		public EmptyIntQueue3Exception() {
		}
	}
	
//--- 큐에 데이터를 인큐 ---//
	public void enque(int x) throws OverflowIntQueue3Exception {
		if(isFull()) {
			System.out.println("enque: Overflow");
			throw new OverflowIntQueue3Exception();
		}
		if (rear >= capacity)
			rear %= capacity;
		que[rear++] = x; 	
		
		if (rear == front)
			isFulltag = true;
	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
		if (isEmpty()) {
			System.out.println("deque: Empty");
			throw new EmptyIntQueue3Exception();
		}
		if (front >= capacity)
			front %= capacity;
		
		return que[front++]; // primitive type은 null 값 가질 수 없음
		// null이라는 건 참조변수가 아무 객체도 지정하지 않는다는 것을 의미.
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {
		if (isEmpty()) {
			System.out.println("peek: Empty");
			throw new EmptyIntQueue3Exception();
		}
		return(que[front]);
	}

//--- 큐를 비움 ---//

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		int num;
		if (front == rear)
			if (! isFulltag)
				num = 0;
			else
				num = capacity;
		else if(front>rear)
			num = (capacity - front) + rear;
		else
			num = rear - front + 1;
		
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que[idx] == x) // 검색 성공
				return idx;
		}
		return -1; // 검색 실패
	}
	
	public void dump() throws EmptyIntQueue3Exception {
		if (isEmpty()) {
			System.out.println("dump: Empty");
			throw new EmptyIntQueue3Exception();
		}
		if(front>=rear) {
			for (int i = front; i<capacity; i++) {
				System.out.print(que[i] + " ");
			}
			
			for (int i = 0; i<rear; i++) {
				System.out.print(que[i] + " ");
			}
		}
		else if(rear > front) {
			for (int i = front; i<rear; i++) {
				System.out.print(que[i] + " ");
			}
		}

		System.out.println();
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		int num;
		if (front == rear)
			if (indexOf(que[rear])==-1)
				num = 0;
			else
				num = capacity;
		
		else if(front>rear)
			num = (capacity - front) + rear;
		else
			num = rear - front;
		return num;
	}

//--- 원형 큐가 비어있는가? --- 수정 필요//
	public boolean isEmpty() {
		return size() <= 0;
	}

//--- 원형 큐가 가득 찼는가? --- 수정 필요//
	public boolean isFull() {
		return size() >= capacity;
	}



//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//

}

public class train_실습4_4정수원형큐_배열_3번 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5)clear  (0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx +")");
				try {
					oq.enque(rndx);
				} catch(IntQueue3.OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					System.out.println("front 데이터는 " + oq.peek() +"입니다."); 
				} catch (IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 4: // 덤프
				try {
					oq.dump();
				} catch (IntQueue3.EmptyIntQueue3Exception e) {
					System.out.println("queue이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			case 5: //clear

				break;
			default:
				break;
			}
		}
	}

}