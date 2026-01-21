public class Data {
    private Time[] times;
    private int currentSize;
    private static String[] daysOfWeek = {
    "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
    };

    public Data(){
        times = new Time[daysOfWeek.length];
        for (int i = 0; i < times.length; i++){
            times[i] = new Time(0);
        }
        currentSize = 0;
    }
    
    public int getMin(){
        return findMin(Time.getIntArray(this.times));
    }
    public int getMax(){
        return findMax(Time.getIntArray(this.times));
    }
    public int getTotal(){
        int sum = 0;
        for (Time time : times){
            sum += time.getMinutes();
        }
        return sum;
    }
    public static int getTotal(int[] array){
        int sum = 0;
        for (int num : array){
            sum += num;
        }
        return sum;
    }
    public static int getMean(int[] array){
        return getTotal(array)/array.length;
    }
    public int getMean(){
        return this.getTotal()/daysOfWeek.length;
    }
    public double getSlope(){
        double numerator = 0;
        for (int i = 1; i <= daysOfWeek.length; i++){
            numerator += (i-(daysOfWeek.length+1)/2.0)*(times[i-1].getMinutes()-getMean(Time.getIntArray(times)));
        }
        double divisor = 0;
        for (int i = 1; i <= daysOfWeek.length; i++){
            divisor += Math.pow(i-(daysOfWeek.length+1)/2.0,2);
        }
        return numerator/divisor;
    }
    public void printBarChart(){
        printBarChart(Time.getIntArray(this.times),daysOfWeek);
    }
    public void addTime(int minutes){
        times[currentSize] = new Time(minutes);
        currentSize++;
    }
    public void addTime(String time){
        times[currentSize] = new Time(time);
        currentSize++;
    }
    public int getCurrentSize(){
        return this.currentSize;
    }
    public static String[] getDaysOfWeek(){
        return daysOfWeek;
    }
    public String getCurrentDayOfWeek(){
        return daysOfWeek[currentSize];
    }

    private static int findMin(int[] array){
        int minValue = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i]<minValue){
                minValue = array[i];
            }
        }
        return minValue;
    }
    private static int findMax(int[] array){
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i]>maxValue){
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    private static void printBarChart(int[] array, String[] bottomString){
        int[] newArray = new int[array.length];
        int height = 15;
        int width = 3;
        int delimeterSize = 1;
        int divisor = 1;
        for (int i = 0; i < array.length; i++){
            newArray[i] = (int)((double)height*array[i]/findMax(array));
        }
        String sideString = "";
        int lastLabel = -1;
        for (int row = height; row > 0; row--){
            int currentLabel = (int)((double) row / height * findMax(array));
            if (currentLabel != lastLabel && currentLabel%divisor == 0) {
                sideString = Integer.toString(currentLabel);
                sideString += " ".repeat(4 - sideString.length());
                lastLabel = currentLabel;
            }
            else {
                sideString = "    ";
            }

            System.out.print(sideString);
            for (int j = 0; j < array.length; j++){
                if (newArray[j]>=row){
                    System.out.print("█".repeat(width)+ " ".repeat(delimeterSize));
                }
                else{
                    System.out.print(" ".repeat(width+delimeterSize));
                }
            }
            System.out.println();
        }
        System.out.print("    ");
        for (String bottomText : bottomString){
            System.out.print(bottomText + " ".repeat(width+delimeterSize-bottomText.length()));
        }
    }
}
