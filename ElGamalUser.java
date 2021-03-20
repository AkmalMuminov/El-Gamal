
/**
 * ElGamal.java - implementation of an ElGamal user
 */
import java.math.BigInteger;
import java.util.Scanner;

public class ElGamalUser
{
    public BigInteger p;       //prime number
    public BigInteger alpha;   //selected root
    public BigInteger beta;    //calculated beta

    private BigInteger a;      //selected SECRET number

    public ElGamalUser()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter user's prime number (p): " );
        p = new BigInteger(scan.nextLine());

        System.out.println("Enter the base root (alpha): ");
        alpha = new BigInteger(scan.nextLine());

        System.out.println("Enter user's secret number (a): ");
        a = new BigInteger(scan.nextLine());

        //beta = alpha^a (mod p)
        beta = alpha.modPow(a,p);
        System.out.println("Beta value calculated: " + beta);
    }

    public static ElGamalMessage encrypt(String m, ElGamalUser recipient)
    {
        BigInteger message = new BigInteger(m.getBytes());
        Scanner scan = new Scanner(System.in);

        //choose secret number for this message
        System.out.println("Enter secret number to encrypt this message (k): ");

        BigInteger k = new BigInteger(scan.nextLine());

        // r = alpha^k (mod p)
        BigInteger r = recipient.alpha.modPow(k,recipient.p);

        // t = beta^k (mod p) 
        BigInteger t = (recipient.beta.modPow(k,recipient.p)).multiply(message).mod(recipient.p);

        return new ElGamalMessage(r,t);
    }

    public String decrypt(ElGamalMessage mes)
    {
        //m = t * r^(-a)
        String dec = "";
        BigInteger result = (mes.r.modPow(a.negate(),p)).multiply(mes.t).mod(p);
        dec = new String(result.toByteArray());
        return dec;
    }
}
