public class MyClock {
    public static void main(String[] args) {

        int hours, minutes, seconds;
        for(hours = 0; hours < 24; hours++) {
            for(minutes = 0; minutes < 60; minutes++) {
                for(seconds = 0; seconds < 60; seconds++) {
                    System.out.println(hours + ":" +minutes + ":" + seconds);
                }
            }
        }

    }
}
