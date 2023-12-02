package com.jafar.week3.bottomupmergesort;


public class MergeBottomUp{
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		aux = new Comparable[N];

		/*
		 * Outer loop determines the size of the sub-arrays and 
		 *     doubles them with each pass. This can only happen
		 *     log(N) times.
		 * Inner loop runs from beginning to end of the array
		 *     in increments of sz.
		 * (N - sz) makes sure that lo starts at the _beginning_
		 *     of the final sub-array.
		 */

		for (int sz = 1; sz < N; sz = 2*sz)
			for (int lo = 0; lo < N - sz; lo += 2*sz)
				merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
	}


	public static void merge(Comparable[] a, Comparable aux[], int lo, int mid, int hi)
	{
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++){
			if 		(i > mid)				a[k] = aux[j++];
			else if (j > hi)				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))	a[k] = aux[j++];
			else 							a[k] = aux[i++];
		}

		assert isSorted(a, lo, hi);
	}
		
	// private
	public static void main(String[] args)
	{
		Integer[] array = {0,2,3,5,1,4,6,7};

		for (Integer i : array)
			System.out.print(i + " ");
		System.out.println();

		MergeBottomUp.sort(array);

		for (Integer i : array)
			System.out.print(i + " ");
	}

	private static boolean less(Comparable a, Comparable b) { return a.compareTo(b) < 0; }

	private static boolean isSorted(Comparable[] a, int lo, int hi)
	{
		for (int i = lo + 1; i < hi; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}
}