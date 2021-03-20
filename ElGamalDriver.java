// 1.  Use the BigInteger class (instead of int primitives), to support larger numbers.

// 2.  The message to encrypt/decrypted should be entered as a String.  The String will be converted to a numerical 
// BigInteger based on the ASCII codes of the composite chars, and will be encrypted.  For decryption, 
// once the numerical value is calculated, you should convert back to the String representation. [see hint below]

// 3.  Make sure that your program is generalized.  You can test it out for the provided example below, 
// BUT it should be work for ANY input prime number, secret number, message (shorter than your prime), and random message key.  

// 4.  Make any necessary changes to clean up the code and make it more user friendly (helpful prompt messages, output, etc).

// Write a driver class to input the parameters for a particular ElGamal user (prime, alpha, a) and calculates the beta. 
//  You should have the ability to encrypt a message to be sent to the user (based on input message and k).  
// And the user should be able to decrypt the received message based on the user's parameters.  

// ---------------

// Test input:

// p = 290249282772097489001037512744818724479 [128 bits]
// alpha = 2
// a = 1912062319540607
// message = Cryptography!
// k = 21205200308120525
// Test output:

// beta = 204425843808726574008313391612189709033
// r = 95362866958141345467790058284834141315
// t = 202678883533677262297736902001266815564

import java.util.Scanner;
import java.math.BigInteger;

public class ElGamalDriver
{
    public static void main(String[] args)
    {
        ElGamalUser bob = new ElGamalUser();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String (message) to send to Bob, and");
        System.out.println("Make sure it it shorter than your prime: ");
        String m = scan.nextLine();
        
        ElGamalMessage mes = ElGamalUser.encrypt(m, bob);
        System.out.println("Encrypted message: " + mes);
        
        String decrypted = bob.decrypt(mes);
        System.out.println("Decrypted message: " + decrypted);
    }
}
