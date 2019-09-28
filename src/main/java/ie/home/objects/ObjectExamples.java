package ie.home.objects;

import java.util.ArrayList;
import java.util.List;

import ie.home.data.RoomObject;

public class ObjectExamples {

	public void checkEquals() {
		RoomObject RoomObject1 = new RoomObject(11, 100);
		RoomObject RoomObject2 = new RoomObject(12, 200);
		RoomObject RoomObject3 = new RoomObject(13, 110);
		
		List<RoomObject> RoomObjects = new ArrayList<RoomObject>();
		RoomObjects.add(RoomObject1);
		RoomObjects.add(RoomObject2);
		RoomObjects.add(RoomObject3);
		
		RoomObject newRoomObject = new RoomObject(11, 500);
		
		System.out.println(RoomObjects.contains(newRoomObject));
	}
	
	public void undefinedObjectsParams() {
		
	}
}
