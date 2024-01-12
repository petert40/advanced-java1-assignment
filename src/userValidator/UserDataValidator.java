package userValidator;
import java.io.*;


public class UserDataValidator {
	public static void main(String[] args) {
		
		BufferedReader reader = null;
		BufferedWriter validwriter = null;
		BufferedWriter errorWriter = null;
		try {
			String folderPath = "C:\\develop\\Full Stack Web Development course\\Lectures Java\\advanced-java1-assignment\\src\\data";
			reader = new BufferedReader(new FileReader(folderPath + "\\user_data.txt"));
			validwriter = new BufferedWriter(new FileWriter(folderPath + "\\valid_output.txt"));
			errorWriter = new BufferedWriter(new FileWriter(folderPath + "\\error_output.txt"));

			String line;

			// Run a while loop that iterates through each line of the file
			while((line = reader.readLine()) != null){
				// In another try / catch block (inside the while loop), do the following:

				try {
					// 1. Use the .split() method on the current line on "," so we can get an array
					// of the name, email, and age of each user
					String[] userData = line.split(",");

					// 2. If the length of the array is different than 3, we know something is wrong
					// so throw an exception with message "Missing Data"
					if(userData.length != 3){
						throw new Exception("Missing Data");
					}

					String name = userData[0].trim();
					String email = userData[1].trim();
					int age = Integer.parseInt(userData[2].trim());

					if(age <= 0){
						throw new Exception("Invalid Age");
					}

					// 5. If the line passed all of these checks, write the line with the
					// validWriter!
					validwriter.write(line + "\n");
				} catch (Exception e) {
					// 6. In the catch
					errorWriter.write(line + " -Error: " + e.getMessage() + "\n");
				}

			}

		} catch (IOException e) {
			System.out.println("Encounter IO Exception: " + e.getMessage());
		}finally{
			// After the last catch statement, use a finally statement to close out of all
			// of your readers and writers. This will require another try/catch block ;)
                try {
                    if(errorWriter!=null) errorWriter.close();
					if(reader !=null) reader.close();
					if(validwriter != null) validwriter.close();
                } catch (IOException e) {
					System.out.println("Error closing resources: " + e.getMessage());
                }
		}







		
	}
}
