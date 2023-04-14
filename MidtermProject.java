import arc.*;
import java.awt.*;
import java.awt.image.*;

public class MidtermProject{
	public static void main(String[] args){
		//Initializes the Console
		Console con = new Console("The Robotics Adventure", 1280, 720);
		
		//Defines all the integer variables for the mouse
		int intMouseX;
		int intMouseY;
		int intMouseButtonClicked;
		
		//Initializes all the mouse variables
		intMouseX = 0;
		intMouseY = 0;
		intMouseButtonClicked = 0;
		
		//Testing the choice menu method
		con.print(choiceMenu(con, "hey", "heyo", "hoe", "ho", intMouseX, intMouseY, intMouseButtonClicked));
	}
	
	//Choice menu method that returns the choice that has been clicked
	static String choiceMenu(Console con, String strButton1, String strButton2, String strButton3, String strButton4, int intMouseX, int intMouseY, int intMouseButtonClicked){
		//Defines and loads the choice menu outline
		BufferedImage imgChoiceMenu;
		imgChoiceMenu = con.loadImage("Choice Menu.jpg");
		
		//Defines and loads in the fonts
		Font fntButtonFont;
		Font fntRegularFont;
		fntButtonFont = con.loadFont("Button Font.ttf", 50);
		fntRegularFont = con.loadFont("Regular Font.ttf", 14);
		
		//Draws the choice menu
		con.drawImage(imgChoiceMenu, 0, 0);
		
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
			con.drawString(strButton3, 204, 526);
		}
		
		//Resets the font back to normal
		con.setDrawFont(fntRegularFont);
		
		//Repeats until a string is returned. That will be the users choice
		while(true){
			//Gets the mouse imputs from the user
			intMouseX = con.currentMouseX();
			intMouseY = con.currentMouseY();
			intMouseButtonClicked = con.currentMouseButton();
			
			//Repaints the scene
			con.repaint();
			
			//If there are 3 buttons and the mouse is hovered over the 3rd button, this code runs
			if((((intMouseX >= 425) && (intMouseX <= 825)) && ((intMouseY >= 531) && (intMouseY <= 631))) && strButton4.equalsIgnoreCase("n/a")){
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
		}
	}
	
	//Method to create a rectangle with any thickness
	static void drawRectangleOutline(Console con, int intX, int intY, int intWidth, int intHeight, int intThickness){
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
}
