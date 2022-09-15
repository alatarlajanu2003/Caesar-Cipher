class Caesar
{
    private int n;
    
    public Caesar(int n)
    {
        if(n < 1 || n > 25) throw new IllegalArgumentException("Shift value not in range!");
        this.n = n;
    }

    public String cipher(String text)
    {
        String newString = "";
        for(int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) < 65 || text.charAt(i) > 90 && text.charAt(i) < 97 || text.charAt(i) > 122) throw new IllegalArgumentException("Character is not in the eng alphabet!");
            if(text.charAt(i) >= 65 && text.charAt(i) <= 90)
            {
                String newCh = ((char)((text.charAt(i) - 65 + n) % 26 + 65)) + "";
                newString = newString + newCh; 
            } else if (text.charAt(i) >= 97 && text.charAt(i) <= 122)
            {
                String newCh = ((char)((text.charAt(i) - 97 + n) % 26 + 97)) + "";
                newString = newString + newCh; 
            }
        }
        return newString;
    }

       public String decipher(String text)
    {
        String newString = "";
        for(int i = 0; i < text.length(); i++)
        {
            
            if(text.charAt(i) >= 65 && text.charAt(i) <= 90)
            {
                int newCh = (text.charAt(i) - 65 - n) % 26 + 65;
                if(newCh < 65) {newCh = newCh + 26;} else if (newCh > 90) {newCh = newCh - 26;}
                newString = newString + (char)newCh+"";  
            } else if (text.charAt(i) >= 97 && text.charAt(i) <= 122)
            {
               int newCh = (text.charAt(i) - 97 - n) % 26 + 97;
                if(newCh < 97) {newCh = newCh + 26;} else if (newCh > 122) {newCh = newCh - 26;}
                newString = newString + (char)newCh+""; 
            }
        }
        return newString;
    }
}