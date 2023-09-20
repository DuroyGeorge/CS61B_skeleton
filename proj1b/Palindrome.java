public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        for(int i=0,j=word.length()-1;i<j;i++,j--){
            if(word.charAt(i)!=word.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        for(int i=0,j=word.length()-1;i<j;i++,j--){
            if(!cc.equalChars(word.charAt(i),word.charAt(j))){
                return false;
            }
        }
        return true;
    }

}
