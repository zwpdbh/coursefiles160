public class Average{
  public static void main(String [] args){
    int[][] table = {{1,2,3},{4,5,6},{7,8}};
    
    for (int[] rows: table) {
       double sum = 0;
      int count = 0;
       for(int num: rows) {
        System.out.print(num + " ");
        sum += num;
      }
      System.out.format("\tAverage : %.1f \n", sum / rows.length);
    }    
  }
}