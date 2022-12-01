import java.util.HashSet;
//Cracking the Coding Interview Book
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
public class ZeroMatrix {
    public static void zeroMatrix(int[][]arr){
        if(arr.length == 0)
            return;

        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(Integer idx : rowSet){
            for(int i = 0; i < arr[0].length; i++)
                arr[idx][i] = 0;
        }

        for(Integer idx : colSet){
            for(int i = 0; i < arr.length; i++)
                arr[i][idx] = 0;
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
