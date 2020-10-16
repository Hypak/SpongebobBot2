void RespondToMessage (char[] charArray) {
	boolean inMessage = false;
	boolean upperCase = false;
	StringBuilder returnMessage = new StringBuilder(">");
	for (int i = 0; i < charArray.length; ++i) {
		if (inMessage) {
			if (upperCase) {
				returnMessage.append(Character.toUpperCase(charArray[i]));
			} else {
				returnMessage.append(Character.toLowerCase(charArray[i]));
			}
			upperCase = !upperCase;
		}
		if (charArray[i] == ':' && i + 1 < charArray.length && charArray[i + 1] != '>') {
			inMessage = true;
		}
	}
	if (returnMessage.length() > 1) {
		try {
			SendMessage(outputStream, returnMessage.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
