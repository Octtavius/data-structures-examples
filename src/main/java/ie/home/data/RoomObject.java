package ie.home.data;

public class RoomObject {
	private int id;
	private int price;
	public RoomObject(int id, int price) {
		super();
		this.id = id;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
            return true;
        }
		
		if (object == null || getClass() != object.getClass()) {
		    return false;
		}
		
		RoomObject room = (RoomObject) object;
		return getId() == room.getId();
	}
}
