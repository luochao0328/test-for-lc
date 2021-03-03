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
	//������м�����
	public void add(int data){
		//���ж϶����Ƿ�����
		if(isFull()){
			throw new RuntimeException("�����������޷���ӣ�");
		}
		rear++;
		arr[rear]=data;
		System.out.println("������ݳɹ���");
	}
	//�Ӷ�����ȡ��Ԫ��
	public void get(){
		//���ж϶����Ƿ�Ϊ��
		if(isEmpty()){
			throw new RuntimeException("����Ϊ�գ�������ȡ��");
		}
		System.out.println("ȡ��������Ϊ��"+arr[front]);
		arr[front]=0;
		front++;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		return front==rear;
	}
	//�ж϶����Ƿ�Ϊ��
	public boolean isFull(){
		return rear==maxSize-1;
	}
	//��ʾ���е���������
	public void showQueue(){
		if(isEmpty()){
			System.out.println("����Ϊ�գ��޷����أ�");
			return;
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	//��ʾ���е�ͷ��Ԫ��
	public void headQueue(){
		if(isEmpty()){
			System.out.println("����Ϊ�գ��޷����أ�");
			return;
		}
		System.out.println("���е�ͷ��Ԫ����:"+arr[front]);
	}
}