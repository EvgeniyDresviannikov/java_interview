package first;

public class AscMax {
    public static void main(String[] args) {
        AscMax ascMax = new AscMax();
        int[] arr = {1,2,3,1,2,3,4,5,6,1,2};
        ascMax.checkSortArrayLength(arr);

    }

    void checkSortArrayLength(int[] array){
        int n =1;
        int nmax =1;
        for (int i = 1; i<array.length;i++){
            if(array[i]>=array[i-1]) {
                n++ ;
                if (n>nmax) nmax =n;
            }
            else n=1;
        }
        System.out.println(nmax);
    }

}
