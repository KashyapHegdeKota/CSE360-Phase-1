package passwordEvaluationTestbed;

public class PasswordEvaluationTestingAutomation {
	
	static int numPassed = 0;//Number of test cases passed.
	static int numFailed = 0;//Number of test cases failed.
	//Printing the body of the program and then testing 5 test cases and printing their outputs.
	public static void main(String[] args) {
		System.out.println("____________________________________________________________________________");
		System.out.println("\nTesting Automation");
		
		performTestCase(1, "Aa!15678", true);

		performTestCase(2, "A!", false);
		
		performTestCase(3, "Aa!15678", false);
		
		performTestCase(4, "A!", true);
		performTestCase(5, "", true);
		performTestCase(6,"kkota3",true);
		performTestCase(7,"Kashyap@280",true);
		performTestCase(8,"kkh",false);
		System.out.println("____________________________________________________________________________");
		System.out.println();
		System.out.println("Number of tests passed: "+ numPassed);
		System.out.println("Number of tests failed: "+ numFailed);
	}
	
	//Function to perform test case.
	private static void performTestCase(int testCase, String inputText, boolean expectedPass) {
		//Body of the test case.
		System.out.println("____________________________________________________________________________\n\nTest case: " + testCase);
		System.out.println("Input: \"" + inputText + "\"");
		System.out.println("______________");
		System.out.println("\nFinite state machine execution trace:");
		
		/*Using evaluatePassword function from PasswordEvaluator.java to check if the password is valid 
		 * or not.
		 */
		String resultText= PasswordEvaluator.evaluatePassword(inputText);
		
		System.out.println();
		/*If password has an error message, print out a failure message if it is supposed to be valid or
		 *  a success if it is supposed to be invalid.
		 */
		if (resultText != "") {
			if (expectedPass) {
				System.out.println("***Failure*** The password <" + inputText + "> is invalid." + 
						"\nBut it was supposed to be valid, so this is a failure!\n");
				System.out.println("Error message: " + resultText);
				numFailed++;
			}
			else {			
				System.out.println("***Success*** The password <" + inputText + "> is invalid." + 
						"\nBut it was supposed to be invalid, so this is a pass!\n");
				System.out.println("Error message: " + resultText);
				numPassed++;
			}
		}
		/* Else, if the password has no error message, print out a success message if it is supposed to be
		 *  valid or a failure message if it is supposed to be invalid.
		 */
		else {	
			if (expectedPass) {	
				System.out.println("***Success*** The password <" + inputText + 
						"> is valid, so this is a pass!");
				numPassed++;
			}
			else {
				System.out.println("***Failure*** The password <" + inputText + 
						"> was judged as valid" + 
						"\nBut it was supposed to be invalid, so this is a failure!");
				numFailed++;
			}
		}
		displayEvaluation();
	}
	
	//Function to display the evaluation of the test case.
	private static void displayEvaluation() {
		//If the password has at least one upper case
		if (PasswordEvaluator.foundUpperCase)
			System.out.println("At least one upper case letter - Satisfied");
		else
			System.out.println("At least one upper case letter - Not Satisfied");
		//If the password has at least one lower case
		if (PasswordEvaluator.foundLowerCase)
			System.out.println("At least one lower case letter - Satisfied");
		else
			System.out.println("At least one lower case letter - Not Satisfied");
	
		//If the password has at least one number.
		if (PasswordEvaluator.foundNumericDigit)
			System.out.println("At least one digit - Satisfied");
		else
			System.out.println("At least one digit - Not Satisfied");
		//If the password has at least one special character.
		if (PasswordEvaluator.foundSpecialChar)
			System.out.println("At least one special character - Satisfied");
		else
			System.out.println("At least one special character - Not Satisfied");
		//If the password has at least one special character.
		if (PasswordEvaluator.foundLongEnough)
			System.out.println("At least 8 characters - Satisfied");
		else
			System.out.println("At least 8 characters - Not Satisfied");
	}
}
