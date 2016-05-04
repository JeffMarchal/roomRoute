package ie.itsligo.roomroute;

public class Room {
	private String room;

	public Room() {
		
	}
	
	public String get(String data)
	{
		// TODO extract the room number eg E2004 from the data passed in
		// Here you write the code to parse the data string and extract
		// the room
		String text = data;
		String delims = "[:]";
		String[] tokens = text.split(delims);
		room = tokens[6];
		
		return(room);
	}

}

