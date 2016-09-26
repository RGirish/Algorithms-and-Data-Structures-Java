public static String rearrange(String s) {
    int ind1 = -1, ind2 = -1;
    int i = s.length() - 2;
    for (; i >= 0; --i) {
        if (s.charAt(i) < s.charAt(i + 1)) {
            ind1 = i;
            break;
        }
    }
    if (ind1 == -1) {
        return "no answer";
    }
    for (int j = s.length() - 1; j > ind1; --j) {
        if (s.charAt(j) > s.charAt(ind1)) {
            ind2 = j;
        }
    }
    char[] chars = s.toCharArray();
    char temp = chars[ind1];
    chars[ind1] = chars[ind2];
    chars[ind2] = temp;

    String s2 = new String(chars);
    StringBuilder builder = new StringBuilder(s2.substring(ind1 + 1,
            s2.length()));
    builder.reverse();
    String sub = builder.toString();

    for (int k = ind1 + 1, l = 0; k < chars.length; ++k, ++l) {
        chars[k] = sub.charAt(l);
    }
    String newString = String.valueOf(chars);
    return newString;
}
