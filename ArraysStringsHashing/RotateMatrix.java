//Cracking the Coding Interview Book
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)
class RotateMatrix{
    public static void rotateMatrix(int[][]arr){
        if((arr.length != arr[0].length)
            || (arr.length == 0 || arr.length == 1))
            return;
        
        int[][]newArr = new int[arr.length][arr[0].length];
        int z = arr.length-1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                newArr[j][z] = arr[i][j];
            }
            z--;
        }
        

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.println(newArr[i][j]);
            }
        }

        return;
    }
}