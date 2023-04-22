/*
Soheil Rajabali
The Robotics Adventure
V7.0
*/

import arc.*;
import java.awt.*;
import java.awt.image.*;

public class MidtermProject{
	//Main method to run all the code
	public static void main(String[] args){
		//Initializes the Console
		Console con = new Console("The Robotics Adventure", 1280, 720);
		
		//Defines the string variables
		String strChoice;
		String strResult;
		String strName;
		String strAnswer;
		
		//Initializes the string variables
		strChoice = "";
		strAnswer = "";
		
		//Defines the character variables
		char chrLetter;
		
		//Defines all the integer variables for the mouse
		int intMouseX;
		int intMouseY;
		int intMouseButtonClicked;
		
		//Defines integer variable to use in questions
		int intAnswer;
		
		//Defines the double variables for random number inputs
		double dblRandomNumber1;
		double dblRandomNumber2;
		double dblAnswer;
		double dblAnswerInput;
		
		//Defines the double variable for the tool selection screen
		double dblSelection;
		
		//Defines the boolean variable for the wheres waldo scene to get the result
		boolean boolResult;
		
		//Initializes the variables for random number inputs
		dblRandomNumber1 = 0.0;
		dblRandomNumber2 = 0.0;
		dblAnswer = 0.0;
		dblAnswerInput = 0.0;
		
		//Initializes all the mouse variables
		intMouseX = 0;
		intMouseY = 0;
		intMouseButtonClicked = 0;
		
		//Draws Scene 1
		scene1(con);
		
		//Repeats until they provide yes or no
		while(!strChoice.equalsIgnoreCase("yes") && !strChoice.equalsIgnoreCase("no")){
			con.println("Do you want to join robotics (Yes or No)?");
			con.print("> ");
			strChoice = con.readLine();
			if(!strChoice.equalsIgnoreCase("yes") && !strChoice.equalsIgnoreCase("no")){
				con.println("Your choice isn't valid. Please provide a valid choice.");
			}
		}
		
		//Clears the console for the next scene
		con.clear();
		
		//If the player chooses no, this code runs
		if(strChoice.equalsIgnoreCase("no")){
			//Draws Scene 2
			scene2(con);
		}
		
		//Runs choice menu with the options for scene 3
		strChoice = scene3(con,intMouseX,intMouseY,intMouseButtonClicked);
		
		//Clears the console for the next scene
		con.clear();
		
		//If the player chooses programming, this code runs
		if(strChoice.equals("Programming")){
			//Randomizes the 2 numbers
			dblRandomNumber1 = (Math.round(Math.random()*100))/10.0;
			dblRandomNumber2 = Math.round(Math.random()*100);
		
			//Gets the answer
			dblAnswer = (Math.round((dblRandomNumber1*dblRandomNumber2)*10.0))/10.0;
			
			//Draws out the scene
			scene4(con,dblRandomNumber1,dblRandomNumber2);
			
			//Gets the players answer
			dblAnswerInput = con.readDouble();
			
			//Clears the console for the next scene
			con.clear();
			
			//If the player answers wrong, this code runs
			if(dblAnswer != dblAnswerInput){
				//Re-randomizes the 2 numbers
				dblRandomNumber1 = (Math.round(Math.random()*100))/10.0;
				dblRandomNumber2 = Math.round(Math.random()*100);
			
				//Gets the answer
				dblAnswer = (Math.round((dblRandomNumber1*dblRandomNumber2)*10.0))/10.0;
				
				//Draws out the scene
				scene6(con,dblRandomNumber1,dblRandomNumber2);
				
				//Gets the players answer
				dblAnswerInput = con.readDouble();
				
				//Clears the console for the next scene
				con.clear();
			
				//If the player answers wrong again, this code runs
				if(dblAnswer != dblAnswerInput){
					dissapointedFabroa(con);
				}
			}
			
			//If the answer is right, this code runs
			impressedFabroa(con);
			
			//Gets the users choice course choice
			strChoice = scene8(con,intMouseX,intMouseY,intMouseButtonClicked);
			
			//Clears the console for the next scene
			con.clear();
			
			//If the player chooses Comp Sci as their course, this code runs
			if(strChoice.equals("Comp Sci")){
				//Runs scene 9
				strResult = scene9(con);
				
				//Clears the console for the next scene
				con.clear();
				
				//If they fail, this code runs
				if(strResult.equals("Failed")){
					dissapointedFabroa(con);	
				}
				
			//If the player selects anything else, this code runs
			}else{
				//Runs scene 11
				scene11(con);
				
				//Gets the users answer
				intAnswer = con.readInt();
				
				//Clears the console for the next scene
				con.clear();
				
				//If they do not answer 1, this code runs
				if(intAnswer != 1){
					dissapointedFabroa(con);
				}
			}
			
			//Draws scene 12
			scene12(con);
		
		//If the player chooses build, this code runs
		}else if(strChoice.equals("Build")){
			//Draws scene 13
			scene13(con);
			
			//Gets the users name and gets the first letter
			strName = con.readLine();
			chrLetter = strName.charAt(0);
			
			//Clears the console for the next scene
			con.clear();
			
			//If the first letter is A-M, this code runs
			if(((chrLetter >= 'A') && (chrLetter <= 'M')) || ((chrLetter >= 'a') && (chrLetter <= 'm'))){
				//Runs scene 14
				scene14(con);
				
				//Gets the double input from the user
				dblSelection = con.readDouble();
				
				//Clears the console for the next scene
				con.clear();
				
				//If they answer wrong, this code runs
				if(dblSelection != 3.2){
					dissapointedFabroa(con);
				}
				
			//If the first letter is anthing else, this code runs
			}else{
				//Draws Scene 16
				scene16(con);
				
				//Gets the users answer
				intAnswer = con.readInt();
				
				//Clears the console for the next scene
				con.clear();
				
				//If their answer was wrong, this code runs
				if(intAnswer != 3){
					dissapointedFabroa(con);
				}
			}
			
			//If their answer was right, this code runs
			impressedFabroa(con);
			
			//Gets the players choice
			strChoice = scene18(con,intMouseX,intMouseY,intMouseButtonClicked);
			
			//Clears the console for the next scene
			con.clear();
			
			//Delays the console for half a second
			con.sleep(500);
			
			if(strChoice.equals("Grade 12")){
				strAnswer = scene19(con,intMouseX,intMouseY,intMouseButtonClicked);
				//Clears the console for the next scene
				con.clear();
				
				//If they get it wrong, this code runs
				if(!strAnswer.equals("Decreases")){
					dissapointedFabroa(con);
				}
				
				//This runs if they get it right
				congratulationsBuild(con,19446);
			}else{
				strAnswer = scene20(con,intMouseX,intMouseY,intMouseButtonClicked);
				//Clears the console for the next scene
				con.clear();
				
				//If they get it wrong, this code runs
				if(!strAnswer.equals("Increases")){
					dissapointedFabroa(con);
				}
				
				//This runs if they get it right
				congratulationsBuild(con,19447);
			}
			
		//If the player chooses communications, this code runs
		}else{
			//Gets the result of scene 24 to see if the player clickes Mr. Fabroa
			boolResult = scene24(con,intMouseX,intMouseY,intMouseButtonClicked);
			
			//Clears the console for the next scene
			con.clear();
			
			//If they do not click Mr Fabora, this runs
			if(!boolResult){
				dissapointedFabroa(con);
			}
			
			//If they click Mr Fabora, this code runs
			scene26(con);
		}
	}
	
	//Choice menu method that returns the choice that has been clicked (used for scenes 3, 8, 18, 19, and 20)
	public static String choiceMenu(Console con, String strButton1, String strButton2, String strButton3, String strButton4, int intFontSize, int intMouseX, int intMouseY, int intMouseButtonClicked){
		//Defines and loads in the fonts
		Font fntButtonFont;
		Font fntRegularFont;
		fntButtonFont = con.loadFont("Button Font.ttf", intFontSize);
		fntRegularFont = con.loadFont("Regular Font.ttf", 14);
		
		//Draws the white background
		con.setDrawColor(Color.white);
		con.fillRect(0,200,1280,520);
		
		//Sets the color to grey
		con.setDrawColor(Color.gray);
		
		//If only 2 buttons are needed, only draws 2 buttons
		if(strButton3.equalsIgnoreCase("n/a") && strButton4.equalsIgnoreCase("n/a")){
			con.fillRect(194, 385, 400, 100);
			con.fillRect(647, 385, 400, 100);
			
			con.setDrawColor(Color.white);
			con.setDrawFont(fntButtonFont);
			
			con.drawString(strButton1, 204, 380);
			con.drawString(strButton2, 657, 380);
	
		//If only 3 buttons are needed, only draws 3 buttons
		}else if(strButton4.equalsIgnoreCase("n/a")){
			con.fillRect(194, 385, 400, 100);
			con.fillRect(647, 385, 400, 100);
			con.fillRect(425, 531, 400, 100);
			
			con.setDrawColor(Color.white);
			con.setDrawFont(fntButtonFont);
			
			con.drawString(strButton1, 204, 380);
			con.drawString(strButton2, 657, 380);
			con.drawString(strButton3, 435, 526);
	
		//If all buttons are needed, draws all 4 buttons
		}else{
			con.fillRect(194, 385, 400, 100);
			con.fillRect(647, 385, 400, 100);
			con.fillRect(647, 531, 400, 100);
			con.fillRect(194, 531, 400, 100);
			
			con.setDrawColor(Color.white);
			con.setDrawFont(fntButtonFont);
			
			con.drawString(strButton1, 204, 380);
			con.drawString(strButton2, 657, 380);
			con.drawString(strButton3, 657, 526);
			con.drawString(strButton4, 204, 526);
		}
		
		//Resets the font back to normal
		con.setDrawFont(fntRegularFont);
		
		//Repeats until a string is returned. That will be the users choice
		while(true){
			//Gets the mouse inputs from the user
			intMouseX = con.currentMouseX();
			intMouseY = con.currentMouseY();
			intMouseButtonClicked = con.currentMouseButton();
			
			//Repaints the scene
			con.repaint();
			
			//If there are 3 buttons and the mouse is hovered over the 3rd button, this code runs
			if((((intMouseX >= 425) && (intMouseX <= 825)) && ((intMouseY >= 531) && (intMouseY <= 631))) && (strButton4.equalsIgnoreCase("n/a") && !strButton3.equalsIgnoreCase("n/a"))){
				con.setDrawColor(Color.red);
				drawRectangleOutline(con, 422, 528, 403, 103, 3);
				
				//If the button is clicked, it is returned
				if(intMouseButtonClicked == 1){
					return strButton3;
				}
				
			//If there are 4 buttons and the mouse is hovered over the 3rd button, this code runs
			}else if((((intMouseX >= 647) && (intMouseX <= 1047)) && ((intMouseY >= 531) && (intMouseY <= 631))) && !strButton4.equalsIgnoreCase("n/a")){
				con.setDrawColor(Color.red);
				drawRectangleOutline(con, 644, 528, 403, 103, 3);
				
				//If the button is clicked, it is returned
				if(intMouseButtonClicked == 1){
					return strButton3;
				}
				
			//If there are 4 buttons and the mouse is hovered over the 4th button, this code runs
			}else if((((intMouseX >= 194) && (intMouseX <= 594)) && ((intMouseY >= 531) && (intMouseY <= 631))) && !strButton4.equalsIgnoreCase("n/a")){
				con.setDrawColor(Color.red);
				drawRectangleOutline(con, 191, 528, 403, 103, 3);
				
				//If the button is clicked, it is returned
				if(intMouseButtonClicked == 1){
					return strButton4;
				}
			}
			
			//General code for the last 2 buttons (they will always be there no matter how many buttons)
			else{
				
				//If the mouse is hovered over the 1st button, this code runs
				if(((intMouseX >= 194) && (intMouseX <= 594)) && ((intMouseY >= 385) && (intMouseY <= 485))){
					con.setDrawColor(Color.red);
					drawRectangleOutline(con, 191, 382, 403, 103, 3);
					
					//If that button is clicked, it is returned
					if(intMouseButtonClicked == 1){
						return strButton1;
					}
				
				//If the mouse is hovered over the second button, this code runs
				}else if(((intMouseX >= 647) && (intMouseX <= 1047)) && ((intMouseY >= 385) && (intMouseY <= 485))){
					con.setDrawColor(Color.red);
					drawRectangleOutline(con, 644, 382, 403, 103, 3);
					
					//If that button is clicked, it is returned
					if(intMouseButtonClicked == 1){
						return strButton2;
					}
				
				//Otherwise, the code will paint a white border around all present buttons using this else statement
				}else{
					con.setDrawColor(Color.white);
					
					if(strButton3.equalsIgnoreCase("n/a") && strButton4.equalsIgnoreCase("n/a")){
						drawRectangleOutline(con, 191, 382, 403, 103, 3);
						drawRectangleOutline(con, 644, 382, 403, 103, 3);
					}else if(strButton4.equalsIgnoreCase("n/a")){
						drawRectangleOutline(con, 191, 382, 403, 103, 3);
						drawRectangleOutline(con, 644, 382, 403, 103, 3);
						drawRectangleOutline(con, 422, 528, 403, 103, 3);
					}else{
						drawRectangleOutline(con, 191, 382, 403, 103, 3);
						drawRectangleOutline(con, 644, 382, 403, 103, 3);
						drawRectangleOutline(con, 191, 528, 403, 103, 3);
						drawRectangleOutline(con, 644, 528, 403, 103, 3);
					}
				}
			}
			
			//Sleeps the console for 33 milliseconds to animate at 30 fps
			con.sleep(33);
		}
	}
	
	//Method to create a border with any thickness
	public static void drawRectangleOutline(Console con, int intX, int intY, int intWidth, int intHeight, int intThickness){
		//Defines a variable for the loop
		int intCount;
		
		//loops to create a rectangle with a given thickness
		for(intCount = intThickness;intCount > 0;intCount--){
			con.drawRect(intX,intY,intWidth,intHeight);
			intX += 1;
			intY += 1;
			intWidth -= 2;
			intHeight -= 2;
		}
	}
	
	//Method to draw impressed fabroa (Used for scenes 5, 17)
	public static void impressedFabroa(Console con){
		//Defines and loads the image for this scene
		BufferedImage imgImpressedFabroa;
		imgImpressedFabroa = con.loadImage("Impressed Fabroa.png");
		
		//Draws the scene image
		con.drawImage(imgImpressedFabroa,0,200);
		
		//Prints a description of the scene
		con.println("Mr. Fabroa is impressed with your skills!");
		
		//Pauses the console for 5 seconds
		con.sleep(5000);
		
		//Clears the console for the next scene
		con.clear();
	}
	
	//Method to draw dissapointed fabroa (Used for scenes 7,10,15,21,25)
	public static void dissapointedFabroa(Console con){
		BufferedImage imgDissapointedFabroa;
		imgDissapointedFabroa = con.loadImage("Disappointed Fabroa.png");
		
		//Draws a dissapointed Fabroa face
		con.drawImage(imgDissapointedFabroa,0,200);
		
		//Prints a message saying you can do better
		con.println("Mr. Fabroa is dissapointed in you. You can do better!");
		
		//Delays for 5 seconds
		con.sleep(5000);
		
		//Closes the console
		con.closeConsole();
	}
	
	//Method for Scene 22/23 (Welcome to Robotics - Build branch)
	public static void congratulationsBuild(Console con, int intTeam){
		//Defines and loads the image for this scene
		BufferedImage imgBackground;
		imgBackground = con.loadImage("Congratulations - Build.png");
		
		//Loads the font to be used on the background
		Font fntCongratulationsBuild;
		fntCongratulationsBuild = con.loadFont("Congratulations Build Font.ttf",75);
		
		//Defines the variable to read the current key pressed down
		char chrCurrentCharacter;
		
		//Defines variables to get the randomized RGB values
		int intRed;
		int intGreen;
		int intBlue;
		
		//Initializes the character variable
		chrCurrentCharacter = 'a';
		
		//Draws the background image
		con.drawImage(imgBackground,0,200);
		
		//Sets the font
		con.setDrawFont(fntCongratulationsBuild);
		
		//If statement to print the appropriate message
		if(intTeam == 19446){
			con.println("Congrats on joining team 19446! You are now a builder.");
		}else{
			con.println("Congrats on joining team 19447! You are now a builder.");
		}
		
		con.println("Press s to stop the animation");
		
		while(chrCurrentCharacter != 's'){
			//Gets the current character being pressed
			chrCurrentCharacter = con.currentChar();
			
			//Randomizes the RGB
			intRed = (int)(Math.random()*255);
			intGreen = (int)(Math.random()*255);
			intBlue = (int)(Math.random()*255);
			
			//Sets the draw color to the random color
			con.setDrawColor(new Color(intRed,intGreen,intBlue));
			
			//Repaints the scene
			con.repaint();
			
			//Draws the text
			if(intTeam == 19446){
				con.drawString("Congrats on joining 19446",200,200);
			}else{
				con.drawString("Congrats on joining 19447",200,200);
			}
			
			//Pauses for half a second
			con.sleep(500);
		}
	}
	
	//Method for Scene 1 (Do you want to join robotics)
	public static void scene1(Console con){
		//Defines and loads in the image for scene 1
		BufferedImage imgScene1;
		imgScene1 = con.loadImage("Scene 1.png");
		
		//Draws the rectangle for the input
		con.setDrawColor(Color.black);
		con.drawRect(0,0,1280,200);
		
		//Draws the picture for the scene
		con.drawImage(imgScene1,0,200);
	}
	
	//Method for Scene 2 (Hope to see you next year)
	public static void scene2(Console con){
		//Defines and loads in the image for scene 2
		BufferedImage imgScene2;
		imgScene2 = con.loadImage("Scene 2.png");
		
		//Draws the image and prints the statement
		con.drawImage(imgScene2,0,200);
		con.println("We hope to see you next year!");
		
		con.sleep(5000);
		con.closeConsole();
	}
	
	//Method for Scene 3 (Choose a subcommitee)
	public static String scene3(Console con,int intMouseX,int intMouseY,int intMouseButtonClicked){
		//Defines and initializes the choice variable
		String strChoice;
		strChoice = "";
		
		//Prints instructions for the player
		con.println("To be part of robotics, you first have to pass a series of tests");
		con.println("Select the committee you would like to try to be a part of");
		
		//Gets the players choice
		strChoice = choiceMenu(con,"Programming","Build","Communications","n/a",35,intMouseX,intMouseY,intMouseButtonClicked);
		
		//Returns the players selected subcommittee
		return strChoice;
	}
	
	//Method for Scene 4 (Answer the equation)
	public static void scene4(Console con,double dblRandomNumber1,double dblRandomNumber2){
		//Defines and loads the image for this scene
		BufferedImage imgScene4;
		imgScene4 = con.loadImage("Scene 4.png");
		
		//Defines and sets the font for the equation
		Font fntEquationFont;
		fntEquationFont = con.loadFont("Equation Font.ttf",100);
		
		//Draws the scene image
		con.drawImage(imgScene4,0,200);
		con.setDrawColor(Color.black);
		con.setDrawFont(fntEquationFont);
		con.drawString(dblRandomNumber1+" * "+dblRandomNumber2+" = ?",500,400);
		
		//Print statements to give the user instructions
		con.println("To be a programmer, you have to know how to do math");
		con.println("What is the answer to this equation? (round to the nearest tenth)");
		con.print("> ");
	}
	
	//Method for Scene 6 (Last Chance)
	public static void scene6(Console con,double dblRandomNumber1,double dblRandomNumber2){
		//Defines and loads the image for this scene
		BufferedImage imgScene6;
		imgScene6 = con.loadImage("Scene 6.png");
		
		//Defines and sets the font for the equation
		Font fntEquationFont;
		fntEquationFont = con.loadFont("Equation Font.ttf",100);
		
		//Draws the scene image
		con.drawImage(imgScene6,0,200);
		con.setDrawColor(Color.black);
		con.setDrawFont(fntEquationFont);
		con.drawString(dblRandomNumber1+" * "+dblRandomNumber2+" = ?",500,400);
		
		//Print statements to give the user instructions
		con.println("Wrong! But, you have one more chance");
		con.println("What is the answer to this equation? (round to the nearest tenth)");
		con.print("> ");
	}
	
	//Method for Scene 8 (Choose a subcommitee)
	public static String scene8(Console con,int intMouseX,int intMouseY,int intMouseButtonClicked){
		//Defines and initializes the choice variable
		String strChoice;
		strChoice = "";
		
		//Prints instructions for the player
		con.println("Mr. Fabroa wants to know what course you would like to take");
		con.println("Select the course you would like to take");
		
		//Gets the players choice
		strChoice = choiceMenu(con,"Comp Sci","Comm Tech","Tech Design","None",35,intMouseX,intMouseY,intMouseButtonClicked);
		
		//Returns the players selected subcommittee
		return strChoice;
	}
	
	//Method for Scene 9 (Robot Minigame)
	public static String scene9(Console con){
		//Defines and loads the images for this scene
		BufferedImage imgScene9;
		BufferedImage imgRobot;
		imgScene9 = con.loadImage("Scene 9.png");
		imgRobot = con.loadImage("Robot.png");
		
		//Defines the variables for the robot movement
		int intRobotX;
		int intRobotY;
		
		//Defines the variable to read the current key pressed down
		char chrCurrentCharacter;
		
		//Initializes the variables for the robot movement
		intRobotX = 1039;
		intRobotY = 500;
		
		//Draws the background for this scene
		con.drawImage(imgScene9,0,200);
		
		//Prints the statements for this scene
		con.println("Since you have coding experience, you can program this robot");
		con.println("Using the W A S D keys on the keyboard, navigate the robot to the top right of the maze while\navoiding the borders!");
		con.println("W - Up");
		con.println("A - Left");
		con.println("S - Down");
		con.println("D - Right");
		
		//Infinite loop until a statement is returned to see if the user passes or fails this challenge
		while(true){
			//Draws a rectangle to get the old robot out of the scene
			con.setDrawColor(Color.white);
			con.fillRect(intRobotX,intRobotY,153,149);
			chrCurrentCharacter = con.currentChar();
			
			//Logic to change the robot position
			if(chrCurrentCharacter == 'w'){
				intRobotY -= 5;
			}else if(chrCurrentCharacter == 'a'){
				intRobotX -= 5;
			}else if(chrCurrentCharacter == 's'){
				intRobotY += 5;
			}else if(chrCurrentCharacter == 'd'){
				intRobotX += 5;
			}
			
			//If robot is touching the outermost border
			if((intRobotY > 515) || (intRobotY < 245) || (intRobotX < 50) || (intRobotX > 1080)){
				return("Failed");
			}
			
			//If the robot is touching the middle line, this code runs
			if((intRobotY >= 305) && (intRobotY <= 465)){
				if(intRobotX > 99){
					return("Failed");
				}
			}
			
			//If the robot gets to the top right, this code runs
			if((intRobotY < 300) && (intRobotX > 985)){
				return("Passed");
			}
			
			//Redraws the image
			con.drawImage(imgRobot,intRobotX,intRobotY);
			con.repaint();
			
			//Makes the animation 30 fps
			con.sleep(33);
		}
	}
	
	//Method for Scene 11 (Binary Question)
	public static void scene11(Console con){
		//Defines and loads the images for this scene
		BufferedImage imgScene11;
		imgScene11 = con.loadImage("Scene 11.png");
		
		//Draws the image for this scene
		con.drawImage(imgScene11,0,200);
		
		//Prints the instructions for this scene
		con.println("Since you are not taking Computer Science, answer this basic coding question to test your coding knowledge");
		con.print("> ");
	}
	
	//Method for Scene 12 (Welcome to robotics - Programming branch)
	public static void scene12(Console con){
		//Defines and loads the images for this scene
		BufferedImage imgScene12;
		imgScene12 = con.loadImage("Scene 12.png");
		
		//Prints a statement at the top of the screen
		con.println("Congratulations! Welcome to robotics. You are now a programmer.");
		
		//Draws the scene image
		con.drawImage(imgScene12,0,200);
	}
	
	//Method for Scene 13 (Input for name)
	public static void scene13(Console con){
		//Defines and loads the images for this scene
		BufferedImage imgScene13;
		imgScene13 = con.loadImage("Scene 13.png");
		
		//Prints the instructions for this scene
		con.print("Mr. Fabroa is asking you what your name is\n> ");
		
		//Draws the image for this scene
		con.drawImage(imgScene13,0,200);
	}
	
	//Method for Scene 14 (Select the wrench)
	public static void scene14(Console con){
		//Defines and loads the images for this scene
		BufferedImage imgScene14;
		imgScene14 = con.loadImage("Scene 14.png");
		
		//Prints the instructions for this scene
		con.println("Mr. Fabroa wants you to find the wrench in this picture");
		con.println("Enter the double that corresponds to the wrench in the form column.row");
		con.println("Ex. Column 2, Row 1: 2.1");
		con.print("> ");
		
		//Draws the image for this scene
		con.drawImage(imgScene14,0,200);
	}
	
	//Method for Scene 16 (Get the gear ratio)
	public static void scene16(Console con){
		BufferedImage imgScene16;
		imgScene16 = con.loadImage("Scene 16.png");
		con.println("You must enter the correct gear ratio to pass this test");
		con.print("> ");
		con.drawImage(imgScene16,0,200);
	}
	
	//Method for Scene 18 (Pick a grade)
	public static String scene18(Console con,int intMouseX,int intMouseY,int intMouseButtonClicked){
		//Defines and initializes the choice variable
		String strChoice;
		strChoice = "";
		
		//Prints instructions for the player
		con.println("Mr. Fabroa wants to know what grade you are in");
		con.println("Select the grade you are in");
		
		//Gets the players choice
		strChoice = choiceMenu(con,"Grade 9","Grade 10","Grade 12","Grade 11",35,intMouseX,intMouseY,intMouseButtonClicked);
		
		//Returns the players selected subcommittee
		return strChoice;
	}

	//Method for Scene 19 (Torque increases, what happens to speed)
	public static String scene19(Console con,int intMouseX,int intMouseY,int intMouseButtonClicked){
		//Defines and initializes the answer variable
		String strAnswer;
		strAnswer = "";
		
		//Prints instructions for the player
		con.println("For your final test, you must answer this question");
		con.println("If torque increases, what happens to the speed");
		
		//Gets the players choice
		strAnswer = choiceMenu(con,"Increases","Decreases","Same","n/a",35,intMouseX,intMouseY,intMouseButtonClicked);
		
		//Returns the players selected subcommittee
		return strAnswer;
	}
	
	//Method for Scene 20 (Torque decreases, what happens to speed)
	public static String scene20(Console con,int intMouseX,int intMouseY,int intMouseButtonClicked){
		//Defines and initializes the choice variable
		String strAnswer;
		strAnswer = "";
		
		//Prints instructions for the player
		con.println("For your final test, you must answer this question");
		con.println("If torque decreases, what happens to the speed");
		
		//Gets the players choice
		strAnswer = choiceMenu(con,"Increases","Decreases","Same","n/a",35,intMouseX,intMouseY,intMouseButtonClicked);
		
		//Returns the players selected subcommittee
		return strAnswer;
	}
	
	//Method for Scene 24 (Wheres waldo but Mr Fabroa)
	public static boolean scene24(Console con,int intMouseX,int intMouseY,int intMouseButtonClicked){
		//Initializes the image for this scene
		BufferedImage imgScene24;
		imgScene24 = con.loadImage("Scene 24.png");
		
		//Defines the chances variable for this scene
		int intChances;
		
		//Draws the background image
		con.drawImage(imgScene24,0,200);
		
		//Prints the instructions for this scene
		con.println("To be in communications, you must have an eye for detail");
		con.println("To test this, you must find Mr Fabroa in this crowd. Once you find him, click him. You have 3 chances");
		
		//Gives the player 3 chances to find Mr. Fabroa
		for(intChances = 2;intChances >= 0; intChances--){
			//Gets the mouse status at the beginning
			intMouseButtonClicked = con.currentMouseButton();
			
			//Repeats until they click the mouse
			while(intMouseButtonClicked != 1){
				intMouseButtonClicked = con.currentMouseButton();
			}
			
			//Gets the X and Y of the cursor
			intMouseX = con.currentMouseX();
			intMouseY = con.currentMouseY();
			
			//If it is on Mr. Fabroa, returns a true statement because they passed the challenge
			if(((intMouseX >= 1146) && (intMouseX <= 1227)) && ((intMouseY >= 319) && (intMouseY <= 423))){
				return true;
			}
			
			//Only prints a message if their chaces aren't 0
			if(intChances != 0){
				//Prints a failed message if they missed with the chances left
				con.println("You missed! You have "+intChances+" chances left.");
			}
			
			//Delays the console for half a second
			con.sleep(500);
		}
		
		//Only runs when all 3 chances are finished
		return false;
	}
	
	//Method for Scene 26 (Welcome to robotics - Communications branch)
	public static void scene26(Console con){
		//Defines and loads the images for this scene
		BufferedImage imgScene26;
		imgScene26 = con.loadImage("Scene 26.png");
		
		//Prints a statement at the top of the screen
		con.println("Congratulations! Welcome to robotics. You are now communications.");
		
		//Draws the scene image
		con.drawImage(imgScene26,0,200);
	}
}
