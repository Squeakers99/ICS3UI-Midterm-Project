import arc.*;
import java.awt.*;
import java.awt.image.*;

public class MidtermProject{
	public static void main(String[] args){
		//Initializes the Console
		Console con = new Console("The Robotics Adventure", 1280, 720);
		
		//Defines and initializes the string variables
		String strChoice;
		strChoice = "";
		
		//Defines all the integer variables for the mouse
		int intMouseX;
		int intMouseY;
		int intMouseButtonClicked;
		
		//Initializes all the mouse variables
		intMouseX = 0;
		intMouseY = 0;
		intMouseButtonClicked = 0;
		
		//Runs scene 1 to get the users choice and then clears the console
		strChoice = scene1(con);
		con.clear();
		
		//If the player chooses no, this code runs
		if(strChoice.equalsIgnoreCase("no")){
			scene2(con);
		}
		
		//Runs choice menu with the options for scene 3
		strChoice = scene3(con,intMouseX,intMouseY,intMouseButtonClicked);
		
		//Testing if the user can select a choice
		con.println(strChoice);
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
	
	//Method for Scene 1 (Do you want to join robotics)
	public static String scene1(Console con){
		//Defines and loads in the image for scene 1
		BufferedImage sceneImage;
		sceneImage = con.loadImage("Scene 1.png");
		
		//Defines and initializes the string variable to be used for the users choice
		String strChoice;
		strChoice = "";
		
		//Draws the rectangle for the input
		con.setDrawColor(Color.black);
		con.drawRect(0,0,1280,200);
		
		//Draws the picture for the scene
		con.drawImage(sceneImage,0,200);
		
		//Repeats until they provide yes or no
		while(!strChoice.equalsIgnoreCase("yes") && !strChoice.equalsIgnoreCase("no")){
			con.print("Do you want to join robotics?: ");
			strChoice = con.readLine();
			if(!strChoice.equalsIgnoreCase("yes") && !strChoice.equalsIgnoreCase("no")){
				con.println("Your choice isn't valid. Please provide a valid choice.");
			}
		}
		
		//Returns their choice
		return strChoice;
	}
	
	//Method for Scene 2 (Hope to see you next year)
	public static void scene2(Console con){
		//Defines and loads in the image for scene 2
		BufferedImage sceneImage;
		sceneImage = con.loadImage("Scene 2.png");
		
		//Draws the image and prints the statement
		con.drawImage(sceneImage,0,200);
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
}
