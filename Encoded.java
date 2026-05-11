public class Encoded {
    
    // Data Fields
    // Contributed by Annie 

    private String inputText;  // Stores the original text entered by user
    private int charCount;  // Stores total number of non-space characters
    private String resultText;  // Stores the encoded result text
    private final String groupID = "G02/CS-G03";  // Hardcoded and hidden group ID used for generating shift value

    // Default constructor
    public Encoded() {
        inputText = "";
        charCount = 0;
        resultText = "";
    }

    // Constructor with parameter
    public Encoded(String inputText) {
        this.inputText = inputText;
        this.charCount = 0;
        this.resultText = "";
    }
    
    // Getters and Setters

    // Getter for inputText
    public String getInputText() {
        return inputText;
    }

    // Setter for inputText
    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    // Getter for charCount
    public int getCharCount() {
        return charCount;
    }

    // Setter for charCount
    public void setCharCount(int charCount) {
        this.charCount = charCount;
    }

    // Getter for resultText
    public String getResultText() {
        return resultText;
    }

    // Setter for resultText
    public void setResultText(String resultText) {
            this.resultText = resultText;
    }

    // Validation Method
    public boolean checkStringValidity(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
        return false;
        }
        return inputText.matches("[a-z0-9 ]+");
    }

    // Character Counting Method
    public int countCharacters(String inputText) {
        int count = 0;
        for (int i = 0; i < inputText.length(); i++) {
            // Ignore spaces
            if (inputText.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    // METHOD: generateShift()
    // Generates the group-specific shift value from the secret groupID.
    public int generateShift() {

        // Step 1: Get hash of the secret group ID
        // Math.abs() ensures we always get a positive number
        int hash = Math.abs(groupID.hashCode());

        // Step 2: Shrink to range 0-9, then add 1 to make it 1-10
        int groupShift = (hash % 10) + 1;
        return groupShift;
    }
    
}

