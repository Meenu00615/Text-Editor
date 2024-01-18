import java.lang.*;
class Main
{
    //'n' convert input into short url
    static String idToShortURL(int n)
    {
        //Char map to represent the set od character
        //'n' length by the set of characters
        char[] map = "https://www.linkedin.com/in/meenu-p-723741230/".toCharArray();

        StringBuilder shorturl = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (n > 0)
        {
            // use above map to store actual character
            // in short url
            shorturl.append(map[n % 62]);
            n = n / 62;
        }

        // Reverse shortURL to complete base conversion
        return shorturl.reverse().toString();
    }

    //short URL as input and converts it back to its original integer ID.
    static int shortURLtoID(String shortURL)
    {
        int id = 0; // initialize result

        //Loop will iterate though each character in short url
        for (int i = 0; i < shortURL.length(); i++)
        {
            if ('a' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'z')
                id = id * 62 + shortURL.charAt(i) - 'a';
            //Check if current character is an uppercase letter and update id
            if ('A' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= 'Z')
                id = id * 62 + shortURL.charAt(i) - 'A' + 26;
            //Check if current character is an lowercase letter id
            if ('0' <= shortURL.charAt(i) &&
                    shortURL.charAt(i) <= '9')
                id = id * 62 + shortURL.charAt(i) - '0' + 52;
        }
        //end of loop
        return id;
    }
    public static void main (String[] args) {
        int n = 12345;
        String shorturl = idToShortURL(n);
        System.out.println("Generated short url is " + shorturl);
        System.out.println("Id from url is " +
                shortURLtoID(shorturl));
    }
}

