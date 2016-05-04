package ie.itsligo.roomroute;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Directions {
	
	private final int SOUND_A = 1;
	private final int SOUND_B = 2; 
	private final int SOUND_C = 3;
	private final int SOUND_D = 4;
	private final int SOUND_E = 5; 
	private final int SOUND_F = 6; 
	private final int SOUND_default = 7;
	private final int SOUND_0 = 8;
	private final int SOUND_1 = 9;
	private final int SOUND_2 = 10;
	private final int SOUND_003 = 11;
	private final int SOUND_004 = 12;
	private final int SOUND_006 = 13; 
	private final int SOUND_007 = 14;
	private final int SOUND_defaultDirection = 15;
	private final int SOUND_defaultFloor = 16;  
    
	private final int ROOM_LENGTH = 5; // size of the room string
	private char building ;
	private char floor;
	private String locationOnFloor = null;

	public Directions() {

	}

	
	public char getBuilding() {
		return building;
	}


	public void setBuilding(char building) {
		this.building = building;
	}


	public char getFloor() {
		return floor;
	}


	public void setFloor(char floor) {
		this.floor = floor;
	}


	public String getLocationOnFloor() {
		return locationOnFloor;
	}

	public void setLocationOnFloor(String locationOnFloor) {
		this.locationOnFloor = locationOnFloor;
	}

	/*
	 * This method takes in a room eg E2004 and splits up into the correct block
	 * (Engineering, Science, Business, etc) The correct floor The correct room
	 * number
	 */
	public boolean validate(String room) {
		if (room.length() != ROOM_LENGTH) {
			return false;
		}
		if (Character.isLetter(room.charAt(0)) == false) {
			return false; // room must start with a letter
		}
		for (int i = 1; i < ROOM_LENGTH; i++) {
			if (Character.isDigit(room.charAt(i)) == false) {
				return false; // room must start with a letter
			}
		}
		
		// all ok - store the info
		building = room.charAt(0);
		floor = room.charAt(1);
		locationOnFloor = room.substring(2);
		
		return true;
	}
	
	/*
	 * Get directions to building
	 */
	public String toBuilding() {
		String directions = null;
		switch (this.building) {
		case 'A':
			directions = "From reception, walk straight ahead and then turn to your right";
			this.playit(SOUND_A);
            delayfor(5);
			break;
		case 'B':
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest";
			this.playit(SOUND_B);
            delayfor(11);
			break;
		case 'C':
            directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and continute through long corridor";
            this.playit(SOUND_C);
            delayfor(12);
            break;
		case 'D':
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and continute through long corridor";
			this.playit(SOUND_D);
            delayfor(12);
			break;
		case 'E':
			directions = "From reception, move to the centre of reception and turn left into the engineering building";
			this.playit(SOUND_E);
			delayfor(6);
			break;
		case 'F':
            directions = "From reception, walk outside and turn to your right.  Walk past the engineering building and the F block is straigt in front";
            this.playit(SOUND_F);
            delayfor(9);
            break;
		default:
			directions = "Sorry, that building is not recognised";
			this.playit(SOUND_default);
			delayfor(4);
			break;
			
		}
		return(directions);
	}
	
	/*
	 * Get directions to floor
	 */
	public String toFloor() {
		String directions = null;
		switch (this.floor) {
		case '0':	
			directions = "Stay on this floor";
			this.playit(SOUND_0);
			delayfor(2);
			break;
		case '1':
            directions = "Ascend the stairs or take the lift to the first floor";			
            this.playit(SOUND_1);
            delayfor(4);
            break;
		case '2':
			directions = "Ascend two flight of stairs or take the lift to the second floor";			
			this.playit(SOUND_2);
            delayfor(5);
			break;
		default:
			directions = "Sorry, floor " + this.floor + " is not recognised";
			this.playit(SOUND_defaultFloor);
            delayfor(3);
			break;
		}
		return(directions);
	}

	/*
	 * Get directions to floor
	 */
	public String toLocation() {
		String directions = null;
		switch (this.locationOnFloor) {
		case "006":
			directions = "This is a room to the right on this level";
			this.playit(SOUND_006);
            delayfor(3);
			break;
		case "007":
            directions = "This is a room to the right on this level";			
            this.playit(SOUND_007);
            delayfor(3);
            break;
		case "003":
            directions = "This is the last room to the right on this level";			
            this.playit(SOUND_003);
            delayfor(3);
            break;
		case "004":
            directions = "This is the second last room to the right on this level";			
            this.playit(SOUND_004);
            delayfor(4);
            break;
		default:
			directions = "Sorry, that room is not recognised";
			this.playit(SOUND_defaultDirection);
            delayfor(3);
			break;
		}
		return(directions);
	}
	public void playit(int soundRequired) {
		URL url;
		String soundFile = null;
		String fn = null;
		File sound;

		switch (soundRequired) {
		case SOUND_A:
			fn = "./src/resources/sounds/A.wav";
			break;
		case SOUND_B:
			fn = "./src/resources/sounds/B.wav";
			break;
		case SOUND_C:
			fn = "./src/resources/sounds/C.wav";
			break;
		case SOUND_D:
			fn = "./src/ressources/sounds/D.wav";
			break;
		case SOUND_E:
			fn = "./src/resources/sounds/E.wav";
			break;
		case SOUND_F:
			fn = "./src/ressources/sounds/F.wav";
			break;
		case SOUND_0:
			fn = "./src/resources/sounds/0.wav";
			break;
		case SOUND_1:
			fn = "./src/resources/sounds/1.wav";
			break;
		case SOUND_2:
			fn = "./src/resources/sounds/2.wav";
			break;
		case SOUND_003:
			fn = "./src/resources/sounds/003.wav";
			break;
		case SOUND_004:
			fn = "./src/resources/sounds/004.wav";
			break;
		case SOUND_006:
			fn = "./src/resources/sounds/006.wav";
			break;
		case SOUND_007:
			fn = "./src/resources/sounds/007.wav";
			break;
		case SOUND_defaultDirection:
			fn = "./src/resources/sounds/defaultDirection.wav";
			break;
		case SOUND_default:
			fn = "./src/resources/sounds/default.wav";
			break;
		case SOUND_defaultFloor:
			fn = "./src/resources/sounds/defaultfloor.wav";
			break;
		default:
			break;
		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delayfor(int n){
		try{
			Thread.sleep(n * 1000);
		} catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
}
