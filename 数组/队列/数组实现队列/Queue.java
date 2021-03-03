class ArrayQueueDemo{
	public static void main(){
		Scanner s=new Scanner(System.in);
		int a=s.next();
		System.out.println(a);
	}
}
class ArrayQueue{
	private int arr[];
	private int front;
	private int rear;
	private int maxSize;
	public ArrayQueue(int Size){
		maxSize=Size;
		arr=new int[maxSize];
		front=-1;
		rear=-1;
	}
	//向队列中加数据
	public void add(int data){
		//先判断队列是否已满
		if(isFull()){
			throw new RuntimeException("队列已满，无法添加！");
		}
		rear++;
		arr[rear]=data;
		System.out.println("添加数据成功！");
	}
	//从队列中取出元素
	public void get(){
		//先判断队列是否为空
		if(isEmpty()){
			throw new RuntimeException("队列为空，无数可取！");
		}
		System.out.println("取出的数据为："+arr[front]);
		arr[front]=0;
		front++;
	}
	//判断队列是否为空
	public boolean isEmpty(){
		return front==rear;
	}
	//判断队列是否为满
	public boolean isFull(){
		return rear==maxSize-1;
	}
	//显示队列的所有数据
	public void showQueue(){
		if(isEmpty()){
			System.out.println("队列为空，无法返回！");
			return;
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	//显示队列的头部元素
	public void headQueue(){
		if(isEmpty()){
			System.out.println("队列为空，无法返回！");
			return;
		}
		System.out.println("队列的头部元素是:"+arr[front]);
	}
}