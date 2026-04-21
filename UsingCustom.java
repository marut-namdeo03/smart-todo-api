package ArrayInsertion;

public class UsingCustom {
	
	public static void main(String[] args)
	{
		int[] arr = {10, 20, 30, 40, 0};
		int n = 4;
		int ele = 50;
		int pos = 2;
		
		System.out.println("Array before insertion: ");
		for (int i=0; i<n; i++)
			System.out.print(arr[i] + " ");
		
		//shift all elements right side from the given position (where new element to be inserted)
		for (int i=n; i>=pos; i--)
			arr[i] = arr[i-1];
		
		arr[pos-1] = ele;
		
		System.out.println("\n\nArray after insertion: ");
		for (int i=0; i<=n; i++)
			System.out.print(arr[i] + " ");
	}
}
