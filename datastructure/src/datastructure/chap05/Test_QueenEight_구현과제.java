package datastructure.chap05;

//해가 256개 확인 필요 23.12.12
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import datastructure.chap05.Stack4.EmptyGenericStackException;

//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp
//N Queen problem / backtracking
//모든 해가 나오는 버젼 만들기 
/*
 * 체스판은 8 x 8 체스의 기물: king/가로세로대각선 1칸만 이동, queen/가로세로 대각선/같은 편의 기물을 넘을 수 없다,
 * Rook/가로,세로 이동/다른 기물을 넘을 수없다, bishop/대각선, knight/1-2칸 이동/다른 기물을 넘을 수 있다,
 * pawn/처음 이동은 2칸까지 가능, 그 후 한칸만 가능, 잡을 때는 대각선 가능 체스판 최대 배치 문제 : king/16,
 * Queen/8, rook/8, bishop/?, knight/? rook 2개/a, h, knight 2개/b, g, bishop
 * 2개/c, f, queen 1개/black queen은 black 칸에, 폰 8개
 */
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}

	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point) p).ix) && (this.iy == ((Point) p).iy))
			return true;
		else
			return false;
	}
}

class Stack4 {
	// --- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyGenericStackException extends Exception {
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException(String message) {
			super(message);
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException(String message) {
			super(message);
		}
	}

	private List<Point> data; // 스택용 배열
	// private List<T> data;
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 생성자(constructor) ---//
	public Stack4(int capacity) {
		this.capacity = capacity;
		data = new ArrayList<Point>(capacity);
		this.top = 0;
	}

	// --- 스택에 x를 푸시 ---//
	public boolean push(Point x) throws OverflowGenericStackException {
		if (isFull())
			throw new OverflowGenericStackException("push : full");

		top++;
		return this.data.add(x);
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Point pop() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("pop : empty");

		return this.data.remove(--top);
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Point peek() throws EmptyGenericStackException {
		if (isEmpty())
			throw new EmptyGenericStackException("pop : empty");

		return this.data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
		this.data.clear();
	}

	// --- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 쪽부터 선형 검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
	public void dump() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException("stack:: dump - empty");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

public class Test_QueenEight_구현과제 {
	public static void EightQueen(int[][] d) throws EmptyGenericStackException {
		int count = 0;// 퀸 배치 갯수
		int numberSolutions = 0; // 상급자
		int ix = 0, iy = 0;// 행 ix, 열 iy
		Stack4 st = new Stack4(100); // 100개를 저장할 수 있는 스택을 만들고
		Point p = new Point(ix, iy);// 현 위치를 객체로 만들고
		d[ix][iy] = 1;// 현 위치에 queen을 넣었다는 표시를 하고
		count++;
		ix++;
		st.push(p);// 스택에 현 위치 객체를 push
		while (true) {// 175 page 코드를 활용
			
			if (count==8) {
				numberSolutions++;
				System.out.println("========" + numberSolutions +"번째 경우" + "========");
				showQueens(d);		
				count--;
				p = st.pop(); //pop()한 위치를 사용해서 다음 열을 조사하고, 더 이상 없으면 이전 행으로 돌아가
				ix = p.getX();
				iy = p.getY();
				d[ix][iy++] = 0;
			}
			else if(st.isEmpty()==true) {
				if(iy>=d[0].length) {
					break;
				}
			}
			
			// ix, iy를 현재 검사해야할 행, 열 주소로 사용!
			iy = nextMove(d, ix, iy);
			if ( iy>= 0) {//체스판의 다음 행에 퀸을 배치할 수 있으면
				//checkmove, nextmove 넣어서 구성
//				iy = nextMove(d, ix, iy);
				p = new Point(ix, iy);
				st.push(p);
				d[ix][iy] = 1;
				count ++;
				ix++;
				iy=0;
				continue;
			}
			
			if (st.isEmpty() != true) {
				p = st.pop(); //pop()한 위치를 사용해서 다음 열을 조사하고, 더 이상 없으면 이전 행으로 돌아가
				count --;
				ix = p.getX();
				iy = p.getY();
				d[ix][iy++] = 0;
				continue;
			}
			

		}
		System.out.println("======== Result ========");
		System.out.println("총 경우의 수 : " + numberSolutions);	
	}
			
	
	public static boolean checkRow(int[][] d, int crow) { //배열 d에서 행 crow에 퀸을 배치할 수 있는지 조사

		for(int i = 0; i < d[0].length; i++) {
			if(d[crow][i] != 0) 
				return false;
		}
		// Queen이 없으면 true return
		return true;	
	}

	public static boolean checkCol(int[][] d, int ccol) {//배열 d에서 열 ccol에 퀸을 배치할 수 있는지 조사

		for(int i = 0; i < d.length; i++) {
			if(d[i][ccol] != 0) 
				return false;
		}
		// Queen이 없으면 true return
		return true;	
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남서, 북동 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSW(int[][] d, int cx, int cy) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		
		// 남서
		int row = cx; 
		int col = cy;
		
		while(col >=0 && row < d.length) {
			if(d[row][col] != 0) {
				return false;
			}
			row++; col--;
		}
		//북동
		row = cx; 
		col = cy;
		
		while(col < d[0].length && row >= 0) {
			if(d[row][col] != 0) {
				return false;
			}
			row--; col++;
		}
		// Queen이 없으면 true return
		return true;
		
	}

	// 배열 d에서 행 cx, 열 cy에 퀸을 남동, 북서 대각선으로 배치할 수 있는지 조사
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {// x++, y++ or x--, y--
		
		// 남동
		int row = cx; 
		int col = cy;
		
		while(col < d[0].length && row < d.length) {
			if(d[row][col] != 0) {
				return false;
			}
			row++; col++;
		}
		
		//북서
		row = cx; 
		col = cy;
		while(col >= 0 && row >= 0) {
			if(d[row][col] != 0) {
				return false;
			}
			row--; col--;
		}
		// Queen이 없으면 true return
		return true;
	}

	// 배열 d에서 (x,y)에 퀸을 배치할 수 있는지 조사
	public static boolean checkMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check
		if (checkRow(d,x) & checkCol(d,y) & checkDiagSE(d, x, y) & checkDiagSW(d, x, y))
			return true;
		else
			return false;
	}

	// 배열 d에서 현재 위치(row,col)에 대하여 다음에 이동할 위치 nextCol을 반환, 이동이 가능하지 않으면 -1를 리턴
	public static int nextMove(int[][] d, int row, int col) {// 현재 row, col에 대하여 이동할 col을 return
		for(int i = col; i<d[0].length; i++) {
			if (checkMove(d,row,i))
				return i;
		}
		
		// 없으면 -1 return
		return -1;		
		
	}

	static void showQueens(int[][] data) {// 배열 출력
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j] + " ");}
		System.out.println();}
	}

	public static void main(String[] args) throws EmptyGenericStackException {
		int row = 8, col = 8;
		int[][] data = new int[8][8];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		EightQueen(data);

	}
}
