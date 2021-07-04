
package contacts.milestone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	List<BaseContact> baseContact = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void open() {
		baseContact = DataAccessServer.read();

		menu();
		DataAccessServer.write(baseContact);
	}

	public void menu() {
		do {
			System.out.println("===========");
			System.out.println(" MAIN MENU ");
			System.out.println("===========");
			System.out.println(" 1. Create a Person Contact ");
			System.out.println(" 2. Create a Business Contact ");
			System.out.println(" 3. Show All Contacts ");
			System.out.println(" 4. Show Details Of One Contact");
			System.out.println(" 5. Update a Contact ");
			System.out.println(" 6. Delete a Contact ");
			System.out.println(" 7. Sort All Contacts by Name");
			System.out.println(" 8. Search for a Contact by Name");
			System.out.println(" 9. Exit");
			System.out.println("===========");
			System.out.println("What options to perform? ");
			int option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				addPerson();
				break;
			case 2:
				addBusiness();
				break;
			case 3:
				viewAllContacts();
				break;
			case 4:
				viewContactDetails();
				break;
			case 5:
				updateContact();
				break;
			case 6:
				deleteContact();
				break;
			case 7:
				sortContactByName();
				break;
			case 8:
				searchByName();
				break;

			case 9:
				System.out.println("Thank you for visting our addressbook");
				DataAccessServer.write(baseContact);
				System.exit(0);
				break;
			default:
				System.out.println("Please enter different option");
			}
		} while (true);

	}

	private void searchByName() {
		System.out.println("===========");
		System.out.println(" SEARCH LIST ");
		System.out.println("===========");
		System.out.println("What do you want to search for? ");
		String search = sc.nextLine();

		int counter = 1;

		for (BaseContact bg : baseContact) {
			if (bg.getName().toUpperCase().contains(search.toUpperCase()))
				System.out.println(counter++ + ". " + bg.toString());
		}

	}

	private void sortContactByName() {

		System.out.println("===========");
		System.out.println(" SORT CONTACTS BY NAME ");
		System.out.println("===========");
		viewAllContacts();
		System.out.println("===========");
		System.out.println("Sorted by name? ");
		Collections.sort(baseContact, (e1, e2) -> {
			return e1.getName().compareTo(e2.getName());

		});
		// System.out.print(baseContact);

		int counter = 1;

		for (BaseContact bc : baseContact) {
			System.out.println(counter++ + ". " + bc.toString());
		}
	}

	private void deleteContact() {
		System.out.println("============");
		System.out.println(" DELETE MENU ");
		System.out.println("============");
		viewAllContacts();
		System.out.println("=====================");
		System.out.println("What item to delete? ");
		System.out.println("=====================");
		int item = sc.nextInt();
		sc.nextLine();
		baseContact.remove(item - 1);

	}

	private void updateContact() {
		System.out.println("=============");
		System.out.println(" UPDATE MENU ");
		System.out.println("=============");
		viewAllContacts();

		System.out.println("What Contact would you like to update? ");
		int item = sc.nextInt();
		item = item - 1;
		if (baseContact.get(item) instanceof PersonContact) {
			System.out.println("Updating a PersonContact");
			updatePersonContact(item);
		} else if ((baseContact.get(item) instanceof BusinessContact)) {
			System.out.println("Updating a BusinessContact");
			updateBusinessContact(item + 1);
		} else {
			System.out.println("I do not recognize that Contact");
		}

	}

	private void updateBusinessContact(int item) {
		System.out.println("=====================");
		System.out.println(" UPDATE CONTACT MENU ");
		System.out.println("=====================");
		// int number,String name, String phone, String bday , String description,
		// String relatives

		System.out.println("Enter a new number. [ " + baseContact.get(item).getNumber() + "]");
		int number = sc.nextInt();
		sc.nextLine();
		baseContact.get(item).setNumber(number);

		System.out.println("what is the new name?.[ " + baseContact.get(item).getName() + "]");
		String name = sc.nextLine();
		sc.nextLine();
		baseContact.get(item).setName(name);

		System.out.println("Enter a new number. [ " + baseContact.get(item).getPhone() + "]");
		String phone = sc.nextLine();
		baseContact.get(item).setPhone(phone);

		System.out.println("Enter new email. [ " + ((BusinessContact) baseContact.get(item)).getEmail() + "]");
		String email = sc.nextLine();
		((BusinessContact) baseContact.get(item)).setEmail(email);

		System.out.println("Add new business hours. [ " + ((BusinessContact) baseContact.get(item)).getHours() + "]");
		String hours = sc.nextLine();
		((BusinessContact) baseContact.get(item)).setHours(hours);

		System.out.println(
				"Enetr new street. [ " + ((BusinessContact) baseContact.get(item)).getLocation().getStreet() + "]");
		String street = sc.nextLine();
		((BusinessContact) baseContact.get(item)).getLocation().setStreet(street);

		System.out.println(
				"Add a new city. [ " + ((BusinessContact) baseContact.get(item)).getLocation().getCity() + "]");
		String city = sc.nextLine();
		((BusinessContact) baseContact.get(item)).getLocation().setCity(city);

		System.out.println(
				"Add a new state. [ " + ((BusinessContact) baseContact.get(item)).getLocation().getState() + "]");
		String state = sc.nextLine();
		sc.nextLine();
		((BusinessContact) baseContact.get(item)).getLocation().setState(state);

		System.out.println("Do you want to update photo? [Yes, No]"); // yes
		String needPhoto = sc.nextLine().toUpperCase();
		if (needPhoto.equals("YES") || needPhoto.equals("Y")) {
			System.out.println(
					"Eneter new photo id. [ " + ((BusinessContact) baseContact.get(item)).getPhoto().getId() + "]");
			int id = sc.nextInt();

			((BusinessContact) baseContact.get(item)).getPhoto().setId(id);

			System.out.println("Add a new filename. [ "
					+ ((BusinessContact) baseContact.get(item)).getPhoto().getFilename() + "]");
			String filename = sc.nextLine();
			sc.nextLine();
			((BusinessContact) baseContact.get(item)).getPhoto().setFilename(filename);

			System.out.println("Add a new photodate. [ "
					+ ((BusinessContact) baseContact.get(item)).getPhoto().getPhotodate() + "]");
			String photodate = sc.nextLine();
			((BusinessContact) baseContact.get(item)).getPhoto().setPhotodate(photodate);
			System.out.println("Add a new pic description. [ "
					+ ((BusinessContact) baseContact.get(item)).getPhoto().getDescription2() + "]");
			String description2 = sc.nextLine();
			((BusinessContact) baseContact.get(item)).getPhoto().setDescription2(description2);
		}
	}

	private void viewContactDetails() {
		System.out.println("===========");
		System.out.println(" VIEW CONTACT DETAILS ");
		System.out.println("===========");
		System.out.println(" Veiwing.....");
		viewAllContacts();
		System.out.println("What contcact to see details? ");
		int item = sc.nextInt();
		item = item - 1;
		sc.nextLine();
		System.out.println("NUMBER: \t" + baseContact.get(item).getNumber());
		System.out.println("PHONE: \t" + baseContact.get(item).getPhone());
		System.out.println("NAME: \t" + baseContact.get(item).getName());
		if (baseContact.get(item) instanceof PersonContact) {
			System.out.println("BIRTHDAY: \t" + ((PersonContact) baseContact.get(item)).getBday());
			System.out.println("DESCRIPTION: \t" + ((PersonContact) baseContact.get(item)).getDescription());
			System.out.println("RELATIVES: \t" + ((PersonContact) baseContact.get(item)).getRelatives());
			System.out.println("ADDRESS");
			System.out.println("STREET: \t" + ((PersonContact) baseContact.get(item)).getLocation().getStreet());
			System.out.println("CITY: \t" + ((PersonContact) baseContact.get(item)).getLocation().getCity());
			System.out.println("STATE: \t" + ((PersonContact) baseContact.get(item)).getLocation().getState());
			System.out.println("PHOTO");
			System.out.println("PHOTO ID: \t" + (((PersonContact) baseContact.get(item)).getPhoto().getId()));
			System.out.println("FILENAME: \t" + (((PersonContact) baseContact.get(item)).getPhoto().getFilename()));
			System.out
					.println("DATE OF PHOTO: \t" + (((PersonContact) baseContact.get(item)).getPhoto().getPhotodate()));
			System.out.println(
					"DESCRIPTION: \t" + (((PersonContact) baseContact.get(item)).getPhoto().getDescription2()));
		} else if (baseContact.get(item) instanceof BusinessContact) {
			System.out.println("EMAIL: \t" + ((BusinessContact) baseContact.get(item)).getEmail());
			System.out.println("HOURS: \t" + ((BusinessContact) baseContact.get(item)).getHours());
			System.out.println("ADDRESS");
			System.out.println("STREET: \t" + ((BusinessContact) baseContact.get(item)).getLocation().getStreet());
			System.out.println("CITY: \t" + ((BusinessContact) baseContact.get(item)).getLocation().getCity());
			System.out.println("STATE: \t" + ((BusinessContact) baseContact.get(item)).getLocation().getState());
			System.out.println("PHOTO");
			System.out.println("PHOTO ID: \t" + (((BusinessContact) baseContact.get(item)).getPhoto().getId()));
			System.out.println("FILENAME: \t" + (((BusinessContact) baseContact.get(item)).getPhoto().getFilename()));
			System.out.println(
					"DATE OF PHOTO: \t" + (((BusinessContact) baseContact.get(item)).getPhoto().getPhotodate()));
			System.out.println(
					"DESCRIPTION: \t" + (((BusinessContact) baseContact.get(item)).getPhoto().getDescription2()));

		}
		// else if (baseContact.get(item) instanceof Cookie) {
		// System.out.println("TOPPING: \t" + ((Cookie)baseContact.get(item -
		// 1)).getTopping());
		// }

	}

	private void updatePersonContact(int item) {
		System.out.println("=====================");
		System.out.println(" UPDATE CONTACT MENU ");
		System.out.println("=====================");
		// int number,String name, String phone, String bday , String description,
		// String relatives

		System.out.println("Enter a contact number. [ " + baseContact.get(item).getNumber() + "]");
		int number = sc.nextInt();
		sc.nextLine();
		baseContact.get(item).setNumber(number);

		System.out.println("what is the new name?.[ " + baseContact.get(item).getName() + "]");
		String name = sc.nextLine();
		sc.nextLine();
		baseContact.get(item).setName(name);

		System.out.println("Enter a new number. [ " + baseContact.get(item).getPhone() + "]");
		String phone = sc.nextLine();
		baseContact.get(item).setPhone(phone);

		System.out.println("Enter new birthday. [ " + ((PersonContact) baseContact.get(item)).getBday() + "]");
		String bday = sc.nextLine();
		((PersonContact) baseContact.get(item)).setBday(bday);

		System.out
				.println("Add a new description. [ " + ((PersonContact) baseContact.get(item)).getDescription() + "]");
		String description = sc.nextLine();
		((PersonContact) baseContact.get(item)).setDescription(description);

		System.out.println(
				"List new relatives or contacts. [ " + ((PersonContact) baseContact.get(item)).getRelatives() + "]");
		String relatives = sc.nextLine();
		((PersonContact) baseContact.get(item)).setRelatives(relatives);

		System.out.println("Do you want to update photo? [Yes, No]"); // yes
		String needPhoto = sc.nextLine().toUpperCase();
		if (needPhoto.equals("YES") || needPhoto.equals("Y")) {
			System.out.println(
					"Eneter new photo id. [ " + ((PersonContact) baseContact.get(item)).getPhoto().getId() + "]");
			int id = sc.nextInt();

			((PersonContact) baseContact.get(item)).getPhoto().setId(id);

			System.out.println(
					"Add a new filename. [ " + ((PersonContact) baseContact.get(item)).getPhoto().getFilename() + "]");
			String filename = sc.nextLine();
			sc.nextLine();
			((PersonContact) baseContact.get(item)).getPhoto().setFilename(filename);

			System.out.println("Add a new photodate. [ "
					+ ((PersonContact) baseContact.get(item)).getPhoto().getPhotodate() + "]");
			String photodate = sc.nextLine();
			((PersonContact) baseContact.get(item)).getPhoto().setPhotodate(photodate);
			System.out.println("Add a new pic description. [ "
					+ ((PersonContact) baseContact.get(item)).getPhoto().getDescription2() + "]");
			String description2 = sc.nextLine();
			((PersonContact) baseContact.get(item)).getPhoto().setDescription2(description2);
			// Photo photo = new Photo(id, filename, photodate,description2);
		}
	}

	private void addBusiness() {
		System.out.println("========================");
		System.out.println(" Create BusinessContact ");
		System.out.println("========================");
		System.out.println("Enter a business name. ");
		String name = sc.nextLine();
		sc.nextLine();

		System.out.println("What number is this store? ");
		int number = sc.nextInt();
		sc.nextLine();

		System.out.println("Input a phone number. ");
		String phone = sc.nextLine();
		sc.nextLine();

		System.out.println("Enter an mail. ");
		String email = sc.nextLine();
		sc.nextLine();

		System.out.println("Enter business hours. ");
		String hours = sc.nextLine();
		sc.nextLine();

		System.out.println("Enter street name. ");
		String street = sc.nextLine();
		sc.nextLine();

		System.out.println("Enter city name ");
		String city = sc.nextLine();
		sc.nextLine();

		System.out.println("Enter state name ");
		String state = sc.nextLine();
		sc.nextLine();
		Location location = new Location(street, city, state);

		System.out.println("Do you want to add a Photo? [Yes, No]"); // yes
		String needPhoto = sc.nextLine().toUpperCase();
		if (needPhoto.equals("YES") || needPhoto.equals("Y")) {

			System.out.println("Enter photo id number? ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter filename");
			String filename = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter date of photo. ");
			String photodate = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter a photo description? ");
			String description2 = sc.nextLine();

			Photo photo = new Photo(id, filename, photodate, description2);

			baseContact.add(new BusinessContact(number, name, phone, email, hours, location, photo));

		} else {
			baseContact.add(new BusinessContact(number, name, phone, email, hours, location));

		}

	}

	private void addPerson() {
		System.out.println("===========");
		System.out.println(" CREATE MENU ");
		System.out.println("===========");

		System.out.println("Enter a contact number ");
		int number = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter a contact name ");
		String name = sc.nextLine();
		sc.nextLine();

		System.out.println("Input a phone number ");
		String phone = sc.nextLine();

		System.out.println("Enter a Birthday ");
		String bday = sc.nextLine();

		System.out.println("Enter description ");
		String description = sc.nextLine();
		sc.nextLine();

		System.out.println("Add relatives/contacts ");
		String relatives = sc.nextLine();

		System.out.println("Enter street name. ");
		String street = sc.nextLine();
		sc.nextLine();

		System.out.println("Enter city name ");
		String city = sc.nextLine();
		sc.nextLine();

		System.out.println("Enter state name ");
		String state = sc.nextLine();
		sc.nextLine();
		Location location = new Location(street, city, state);

		System.out.println("Do you want to add a Photo? [Yes, No]"); // yes
		String needPhoto = sc.nextLine().toUpperCase();
		if (needPhoto.equals("YES") || needPhoto.equals("Y")) {
			System.out.println("Enter photo id? ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter filename");
			String filename = sc.nextLine();

			System.out.println("Enter photo date ");
			String photodate = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter a description? ");
			String description2 = sc.nextLine();

			Photo photo = new Photo(id, filename, photodate, description2);

			baseContact.add(new PersonContact(number, name, phone, bday, description, relatives, location, photo));
		} else {

			{
				baseContact.add(new PersonContact(number, name, phone, bday, description, relatives, location));
			}
		}
	}

	public void viewAllContacts() {
		System.out.println("===========");
		System.out.println(" View all Contacts ");
		System.out.println("===========");

		int counter = 1;

		for (BaseContact bc : baseContact) {
			System.out.println(counter++ + ". " + bc.toString());
		}
	}

}
