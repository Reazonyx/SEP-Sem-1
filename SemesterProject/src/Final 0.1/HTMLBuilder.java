import java.io.FileNotFoundException;

public class HTMLBuilder 
{
	/**
	 * method for building match report as HTML page
	 * @param fileName name of HTML file report
	 * @param date day of match
	 * @param opponent 
	 * @param relevance
	 */
	public static void build(String fileName, String[] date, String[] opponent, String[] relevance)
	{
		//HTML file IO class object
		MyHtmlFileIO mhfio = new MyHtmlFileIO();
		
		//initial content of table
		String tableContents = "";
		
		//generating table content
		for(int index = 0; index < date.length; index++)
		{
			//table row
			tableContents += "<tr>";
			
			/*-------Date-------*/
			//table data
			tableContents += "<td>";
			tableContents += date[index];
			//end of table data
			tableContents += "</td>";
			
			/*-------Opponent-------*/
			//table data
			tableContents += "<td>";
			tableContents += opponent[index];
			//end of table data
			tableContents += "</td>";
			
			/*-------Relevance-------*/
			//table data
			tableContents += "<td>";
			tableContents += relevance[index];
			//end of table data
			tableContents += "</td>";
			
			//end of table row
			tableContents += "<tr>";
		}
		
		//output of table content
		try 
		{
			mhfio.writeToFile(fileName, "$tableContents", tableContents);
		}
		catch(Exception e)
		{
			System.out.println("HTML template file was not found. Exception message: " + e.getMessage());
		}
	}
}
