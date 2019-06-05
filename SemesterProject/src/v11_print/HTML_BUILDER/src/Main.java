import HTML_BUILDER.HTMLBuilder;

public class Main 
{
	public static void main(String[] args)
	{
		String[] date = new String[5];
		String[] opponent = new String[5];
		
		date[0] = "2019-05-12";
		date[1] = "2019-05-13";
		date[2] = "2019-05-14";
		date[3] = "2019-05-15";
		date[4] = "2019-05-16";
		
		opponent[0] = "Opponent1";
		opponent[1] = "Opponent2";
		opponent[2] = "Opponent3";
		opponent[3] = "Opponent4";
		opponent[4] = "Opponent5";
		
		HTMLBuilder.build("match_report.html", date, opponent);
	}
}
