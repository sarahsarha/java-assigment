public class Encoded {

    // --- Fields (Member 1 / Annie) ---
    private String inputText;
    private int charCount;
    private String resultText;
    private final String groupID = "G02/CS-G03";

    // --- Constructors (Member 1 / Annie) ---
    public Encoded() { inputText = ""; charCount = 0; resultText = ""; }
    public Encoded(String inputText) { this.inputText = inputText; charCount = 0; resultText = ""; }

    // --- Getters & Setters (Member 1 / Annie) ---
    public String getInputText()            { return inputText; }
    public void   setInputText(String t)    { this.inputText = t; }
    public int    getCharCount()            { return charCount; }
    public void   setCharCount(int c)       { this.charCount = c; }
    public String getResultText()           { return resultText; }
    public void   setResultText(String r)   { this.resultText = r; }

    // --- Validation (Member 1 / Annie) ---
    public boolean checkStringValidity(String inputText) {
        if (inputText == null || inputText.isEmpty()) return false;
        return inputText.matches("[a-z0-9 ]+");
    }

    // --- Hashing / Shift generation (Member 1 / Annie) ---
    public int generateShift() {
        int hash = Math.abs(groupID.hashCode());
        return (hash % 10) + 1;
    }

    // ============================================================
    // MEMBER 2 — Security Specialist  |  Contributed by: Izz
    // ============================================================

    // Counts all non-space characters. Contributed by: Izz
    public int countCharacters(String inputText) {
        int count = 0;
        for (int i = 0; i < inputText.length(); i++)
            if (inputText.charAt(i) != ' ') count++;
        this.charCount = count;
        return count;
    }

    // Caesar-style cipher for letters and digits. Contributed by: Izz
    public void applyCipher() {
        int finalShift = generateShift();               // e.g., 15 for this group
        this.charCount = countCharacters(this.inputText);

        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < this.inputText.length(); i++) {
            char c = this.inputText.charAt(i);
            if      (c >= 'a' && c <= 'z') encoded.append((char)((c - 'a' + finalShift) % 26 + 'a'));
            else if (c >= '0' && c <= '9') encoded.append((char)((c - '0' + finalShift) % 10 + '0'));
            else                           encoded.append(c);   // preserve spaces
        }
        this.resultText = encoded.toString();
    }
}
