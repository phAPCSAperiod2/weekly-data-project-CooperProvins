public class Time {
    private int minutes;
    public Time(int minutes){
        this.minutes = minutes;
    }
    public Time(String time){
        this.minutes = timeToMinutes(time);
    }


    public int getMinutes(){
        return minutes;
    }
    public String getTime(){
        return minutesToTime(minutes);
    }
    public static int[] getIntArray(Time[] array){
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i].getMinutes();
        }
        return newArray;
    }
    public static String[] getStringArray(Time[] array){
        String[] newArray = new String[array.length];
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i].getTime();
        }
        return newArray;
    }
    public static String minutesToTime(int minutes){
        return Integer.toString(minutes/60) + ":" + Integer.toString(minutes%60);
    }
    public static int timeToMinutes(String time){
        if (time.indexOf(":") == -1){
            return Integer.parseInt(time);
        }
        else {
            String hours = "";
            String minutes = "";
            int lastIndex = -3;
            for (int i = 0; time.charAt(i) != ':'; i++){
                hours += time.charAt(i);
                lastIndex = i;
            }
            for (int i = lastIndex+2; i < time.length(); i++){
                minutes += time.charAt(i);
            }
            return Integer.parseInt(hours)*60 + Integer.parseInt(minutes);
        }
        
    }
}
