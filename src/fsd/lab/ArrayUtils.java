package fsd.lab;

public class ArrayUtils {
	public static int MAX_SIZE = 200;
	public static int FAIR_SIZE = 10;

	public static void initArray(int size, double[] a) {
		int i;
		if (size > 0) {
			for (i = 0; i < size; i++) {
				a[i] = i + 1;
			}
		}
	}

	public static void printArray(double[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void doubleValuesOfArray(double[] a) {
		for(int i=0;i<a.length;i++) {
			a[i]*=2;
		}
	}
	
	public static void addValueToArraysValues(double[] a, int val){
		for(int i=0;i<a.length;i++) {
			a[i]+=val;
		}
	}

}
