package practiceProjects;

public class GrowthRate {

	public static void main(String[] args) {
		int bgNum = 500;
		int rog = 2;
		int time = 6;
		int endNum = bgNum;
		int currHr = 1;
		while(currHr<=time) {
			if(currHr%time == 0) {
				endNum*=rog;
			}
			currHr++;
		}
		System.out.println("Beginning Num: " + bgNum + ", Growth Period: " + time + ", Rate of Growth: " + 
				rog + ", Time of Observation: " + currHr + ", Ending Num: " + endNum);

	}

}
