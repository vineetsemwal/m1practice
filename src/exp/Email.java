package exp;


class EmailDemo {

    public static void main(String args[]) {
        EmailOperation operation = new EmailOperation();
        String from = "abc@google.com";
        String to = "e@yahoo.com";
        Header header = new Header(from, to);
        Email email = new Email();
        email.header = header;
        int result = operation.emailVerify(email);
        System.out.println("rest=" + result);
    }


}

class EmailOperation {

    /**
     * 2 -both valid
     * 1 - any one valid
     * 0- both invalid
     **/
    int emailVerify(Email email) {
        boolean fromValid = validate(email.header.from);
        boolean toValid = validate(email.header.to);
        if (fromValid && toValid) {
            return 2;
        }
        if (fromValid || toValid) {
            return 1;
        }
        return 0;
    }

    /**
     * Email address should start with alphabets(capital/small) or _(underscore).
     * <p>
     * Email address should have only one @ followed by alphabets.
     * <p>
     * Email address should end with .(dot) followed by alphabets.
     * <p>
     * e.g: amit@doselect.com, _ami@doselect.in are valid addresses, but 1ami@dos.com, amit@doselect are invalid addresses.
     * <p>
     * Return 2 if the both email addresses are valid return 1 if one is valid, and 0 if both are invalid.
     *
     * @param email
     * @return
     */
    //amit.kumar@gmail.com
    boolean validate(String email) {
        char zeroLetter = email.charAt(0);
        boolean isAlphabet = isAlphabet(zeroLetter);
        boolean isUnderScore = zeroLetter == '_';
        if (!isAlphabet && !isUnderScore) {
            return false;
        }
        int lastDotIndex = email.lastIndexOf(".");
        String endDomain = email.substring(lastDotIndex + 1);
        boolean isEndDomain = containsOnlyAlphabet(endDomain);
        if (!isEndDomain) {
            return false;
        }

        boolean containsAtTheRate = email.contains("@");
        if (!containsAtTheRate) {
            return false;
        }

        int startAtRateIndex = email.indexOf("@");
        int lastAtRateIndex = email.lastIndexOf("@");
        if (startAtRateIndex != lastAtRateIndex) {
            return false;
        }

        String afterAtTheRate = email.substring(startAtRateIndex + 1, lastDotIndex);
        boolean afterAtTheRateValid = containsOnlyAlphabet(afterAtTheRate);
        return afterAtTheRateValid;

    }

    boolean containsOnlyAlphabet(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            boolean isAlphabet = isAlphabet(ch);
            if (!isAlphabet) {
                return false;
            }
        }
        return true;
    }


    boolean isAlphabet(char ch) {
        ch = Character.toLowerCase(ch);
        return (ch >= 'a' && ch <= 'z');
    }


}


class Email {

    Header header;


}

class Header {

    String from;

    String to;

    Header(String from, String to) {
        this.from = from;
        this.to = to;
    }


}