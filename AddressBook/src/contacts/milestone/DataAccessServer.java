package contacts.milestone;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataAccessServer {
public static List<BaseContact> read() {
List< BaseContact> items = new ArrayList<>();


try {
	FileInputStream fis = new FileInputStream("Addressbook.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);
	items =(ArrayList<BaseContact>) ois.readObject();
	ois.close();
	//fis.close();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return items;
}
public static void write( List<BaseContact> items) {
	
	try {
		FileOutputStream fos = new FileOutputStream("Addressbook.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(items);
		oos.close();
		fos.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}