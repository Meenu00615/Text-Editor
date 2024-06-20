import java.lang.*;
class Main
{
    //'n' convert input into short url
    static String idToShortURL(int n)
    {
        //Char map to represent the set od character
        //'n' length by the set of characters
        char[] map = "https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000002-0000-0ff1-ce00-000000000000&redirect_uri=https%3a%2f%2foutlook.office365.com%2fowa%2f&resource=00000002-0000-0ff1-ce00-000000000000&response_mode=form_post&response_type=code+id_token&scope=openid&msafed=1&msaredir=1&client-request-id=844a0051-1202-3305-c194-06ef2cc3a08d&protectedtoken=true&claims=%7b%22id_token%22%3a%7b%22xms_cc%22%3a%7b%22values%22%3a%5b%22CP1%22%5d%7d%7d%7d&nonce=638544712832118147.98ffc7ca-4174-4f9b-a1a1-af82e3257a9d&state=DcuxDoIwFEDRov_iVuE9Cm0H4mBiGMABSTRsr6VNIBIMEIx_b4dztxsxxo7BIYiSECbzVGVCSECVIoACIc9aeW-lJS5ACi68NpyAgJNX6FLMJOk-Cm8Zz1-KL-tGmyvgtLh-WJzd2rmgsklsWefVT-_9q1kN6qWa9NRN77Fra7w_stFgspvn7WOu6g8&sso_reload=true".toCharArray();

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

