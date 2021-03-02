import java.io.*;

/*
*	ϡ�������ת������ת��
*/
public class SparseArray{
	public static void main (String[] args){
		int chessArr[][]=new int[6][6];
		chessArr[2][2]=1;
		chessArr[2][3]=1;
		chessArr[4][5]=2;
		for(int[] row:chessArr){
			for(int col:row){
				System.out.printf(col+" ");
			}
			System.out.println(";");
		}
		//���ö�ά����תΪϡ������ķ���
		int[][] sparseArray=sparseArray(chessArr);
		for(int[] row:sparseArray){
			for(int col:row){
				System.out.printf(col+" ");
			}
			System.out.println(";");
		}
		//����ϡ������תΪ��ά����ķ���
		int chessArray[][]=chessArray(sparseArray);
		for(int[] row:chessArray){
			for(int col:row){
				System.out.printf(col+" ");
			}
			System.out.println(";");
		}

		//����ϡ�����鵽����
		try {
			save(sparseArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ϡ������תΪ��ά����
	private static int[][]  chessArray(int[][] sparseArray) {
		//��ö�ά���������������
		int a=sparseArray[0][0];
		int b=sparseArray[0][1];
		int  chessArr[][]=new int[a][b];
		int sum=sparseArray[0][2];
		for (int i=0;i<sum;i++){
			chessArr[sparseArray[i+1][0]][sparseArray[i+1][1]]=sparseArray[i+1][2];
		}
		return chessArr;
	}

	//��ά����תΪϡ������
	public static int[][] sparseArray(int[][] arr){
		//1���õ���ά����ķ�0���ݸ���
		int count=0;
		for(int[] row:arr){
			for(int i=0;i<row.length;i++){
				if(row[i]!=0){
					count++;
				}
			}
		}
		int sparseArr[][]=new int[count+1][3];
		//2����ϡ�������һ�и�ֵ
		sparseArr[0][0]= arr.length;
		sparseArr[0][1]=arr[0].length;
		sparseArr[0][2]=count;
		//3��
		int a=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]!=0){
					a++;
					sparseArr[a][0]=i;
					sparseArr[a][1]=j;
					sparseArr[a][2]=arr[i][j];
				}
			}
		}
		return sparseArr;
	}

	//����ϡ������
	private static void save(int[][] arr) throws Exception{
		File file=new File("E:\\���ݽṹ���㷨\\����\\ϡ������\\map.data");
		FileOutputStream fos=new FileOutputStream(file);
		OutputStreamWriter writer=new OutputStreamWriter(fos,"utf-8");
		for (int i=0;i< arr.length;i++){
				writer.append(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
		}
		writer.close();
		fos.close();
	}

}

