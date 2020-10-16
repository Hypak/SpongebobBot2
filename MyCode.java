char[] charArray = new char[bytesRead];
boolean inMessage = false;
boolean upperCase = false;
StringBuilder returnMessage = new StringBuilder(">");
for (int i = 0; i < bytesRead; ++i) {
	charArray[i] = (char)bytes[i];
	if (inMessage) {
		if (upperCase) {
			returnMessage.append(Character.toUpperCase(charArray[i]));
		} else {
			returnMessage.append(Character.toLowerCase(charArray[i]));
		}
		upperCase = !upperCase;
	}
	if (charArray[i] == MESSAGE_PRESYMBOL
			&& i + 1 < bytesRead && (char)bytes[i + 1] != '>') {
		inMessage = true;
	}
}
System.out.println(String.valueOf(charArray));
if (returnMessage.length() > 1) {
	try {
		SendMessage(outputStream, returnMessage.toString());
	} catch (IOException e) {
		e.printStackTrace();
	}
}
