package Src;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		try {
			String fileName = args[0];
			// String fileName = "./" + x;

			File file = new File(fileName);
			if (!fileName.endsWith(".arxml")) {
				throw new NotVaildAutosarFileException("Not Valid Extention");
			}
			if (!file.exists()) {
				throw new FileNotFoundException();
			}
			if (file.length() == 0) {
				throw new EmptyAutosarFileException("File is Empty");
			}
			FileInputStream inputStream = new FileInputStream(file);
			int d;
			StringBuilder stringBuilder = new StringBuilder();
			while ((d = inputStream.read()) != -1) {
				stringBuilder.append((char) d);
			}
			String data = stringBuilder.toString();
			Scanner scanner = new Scanner(data);
			ArrayList<Cont> containers = new ArrayList<>();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.contains("<CONTAINER")) {
					String contid = line.substring(line.indexOf("UUID="), line.indexOf(">"));
					String nametag = scanner.nextLine();

					String name = nametag.substring(nametag.indexOf(">") + 1, nametag.indexOf("</"));
					String lnametag = scanner.nextLine();

					String lname = lnametag.substring(lnametag.indexOf(">") + 1, lnametag.indexOf("</"));
					Cont cont = new Cont();
					cont.setID(contid);
					cont.setSname(name);
					cont.setLname(lname);

					containers.add(cont);
				}

			}
			Collections.sort(containers);
			String outFileName = fileName.substring(0, fileName.indexOf(".a")) + "_mod.arxml";
			FileOutputStream outputStream = new FileOutputStream(outFileName);
			outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
			outputStream.write("<AUTOSAR>\n".getBytes());
			for (int j = 0; j < containers.size(); j++) {
				outputStream.write(containers.get(j).toString().getBytes());
			}
			outputStream.write("</AUTOSAR>\n".getBytes());

		} catch (NotVaildAutosarFileException e) {

		} catch (FileNotFoundException e) {
			System.out.println("File Not found");
		} catch (EmptyAutosarFileException e) {

		} catch (Exception e) {
			System.out.println("error");
		}
	}

}