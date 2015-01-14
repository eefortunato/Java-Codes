import java.util.Iterator;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetImp<Integer> A = new SetImp<Integer>();
		SetImp<Integer> B = new SetImp<Integer>();
		SetImp<Integer> C = new SetImp<Integer>();
		SetImp<Integer> D = new SetImp<Integer>();
		SetImp<Integer> E = new SetImp<Integer>();
		SetImp<Integer> F = new SetImp<Integer>();
		for(int i= 1; i <=5; i++ ){
			if(i <=3){
				A.add(i);	
			}
			if(i > 3){
			 B.add(2*i);
			}
		}
		C= A.union(B);
		Iterator<Integer> result = C.setElements.iterator();
		while(result.hasNext()){
			System.out.print(result.next());
		}
		System.out.println("\n"+ "is A subset of C? " + C.isSuperSet(A));		
		System.out.println("\n"+ "is C superset of A? " + C.isSuperSet(A));
		D = A.intersection(C);
		Iterator<Integer> intersection = D.setElements.iterator();
		System.out.println("Intersection of A and C");
		while(intersection.hasNext()){
			System.out.print(intersection.next());	
		}
		E = A.difference(B);
		Iterator<Integer> difference = E.setElements.iterator();
		System.out.println("\n Difference of A and B");
		while(difference.hasNext()){
			System.out.print(difference.next());	
		}
	}

}
