package calcs;

public class calc_percentage {

   public float per = 0f;
   public calc_percentage(int sum, int dsum)
   {
       per = (float)(dsum/sum)*100;
   }

}
