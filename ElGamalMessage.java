import java.math.BigInteger;
/**
 * ElGamalMessage.java - representation of a message encrypted using ElGamal
 */
public class ElGamalMessage
{
    public BigInteger r;
    public BigInteger t;
    
    public ElGamalMessage(BigInteger r, BigInteger t)
    {
        this.r = r;
        this.t = t;
    }
    
    public String toString()
    {
        return "r:\t " + r + "\tt:\t" + t;
    }
    
}
