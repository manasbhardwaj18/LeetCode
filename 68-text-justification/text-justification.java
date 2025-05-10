public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> curWords = new ArrayList<>();
        int Len = 0;

        for (String word : words) {
            if (Len + word.length() + curWords.size() > maxWidth) {
                int totalSpaces = maxWidth - Len;
                int gaps = curWords.size() - 1;
                if (gaps == 0) {
                    res.add(curWords.get(0) + " ".repeat(totalSpaces));
                } else {
                    int spacePerGap = totalSpaces / gaps;
                    int extraSpaces = totalSpaces % gaps;
                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < curWords.size(); i++) {
                        line.append(curWords.get(i));
                        if (i < gaps) {
                            line.append(" ".repeat(spacePerGap));
                            if (i < extraSpaces) {
                                line.append(' ');
                            }
                        }
                    }
                    res.add(line.toString());
                }
                curWords.clear();
                Len = 0;
            }
            curWords.add(word);
            Len += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", curWords));
        while (lastLine.length() < maxWidth) {
            lastLine.append(' ');
        }
        res.add(lastLine.toString());

        return res;
    }
}