import edu.rit.util.Hex;
import edu.rit.util.Packing;

/**
 * This is the Encrypt.java class that implements the encryption algorithm for Speck32/64 block cipher
 * @author Eric Fortunato
 *
 */

public class Encrypt implements BlockCipher{

	private short[] subkey = new short [22];
	private short[] lKeys = new short [24];

	/*
	 * (non-Javadoc)
	 * @see BlockCipher#blockSize()
	 */
	public int blockSize() {
		// TODO Auto-generated method stub
		return 4;
	}

	/*
	 * (non-Javadoc)
	 * @see BlockCipher#keySize()
	 */

	public int keySize() {
		// TODO Auto-generated method stub
		return 8;
	}
/*
 * (non-Javadoc)
 * @see BlockCipher#setKey(byte[])
 */
	
	
	public void setKey(byte[] key) {
		// TODO Auto-generated method stub
		
		subkey[0]=Packing.packShortBigEndian(key, 6);
		lKeys[0]=Packing.packShortBigEndian(key, 4);
		lKeys[1]=Packing.packShortBigEndian(key, 2);
		lKeys[2]=Packing.packShortBigEndian(key, 0);
		
		for(int i= 0; i <= 20; i++){		
			lKeys[i+3]=0;	
			lKeys[i+3]|= ((subkey[i] + ((((lKeys[i]&0xFFFF) >>> 7)|((lKeys[i]&0xFFFF) << (Short.SIZE-7))))) ^ i);
			subkey[i+1] |= (((((subkey[i]&0xFFFF) << 2) | ((subkey[i]&0xFFFF) >>> (Short.SIZE-2))) ^ lKeys[i+3]));
				
		}
	}
/*
 * (non-Javadoc)
 * @see BlockCipher#encrypt(byte[])
 */
	
	public void encrypt(byte[] text) {
		// TODO Auto-generated method stub
		//int [] words = new int[4];
		short wordX = Packing.packShortBigEndian(text, 0);
		short wordY = Packing.packShortBigEndian(text, 2);
		for(int i=0; i <= 21; i++){
			wordX = (short)((((((wordX&0xFFFF) >>> 7) | ((wordX&0xFFFF) << (Short.SIZE - 7))) + wordY) ^ subkey[i]));
			wordY = (short)((((wordY&0xFFFF) << 2) | ((wordY&0xFFFF) >>> (Short.SIZE - 2))) ^ wordX);
		}
		short [] newWords = {wordX, wordY};
		Packing.unpackShortBigEndian(newWords, 0, text, 0, 2);
	}

	/*
	 * (non-Javadoc)
	 * @see BlockCipher#decrypt(byte[])
	 */
	
	public void decrypt(byte[] text) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This is the main method to test the cipher, it receives key plaintext from the comand line
	 * 
	 */
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BlockCipher cipher = new Encrypt();
		try{
			if(args.length !=2){
				throw new IllegalArgumentException();
			}
				byte[] plaintextZero = Hex.toByteArray(args[1]);
				byte[] keyZero = Hex.toByteArray(args[0]);
			//6574 694c
			//	1918 1110 0908 0100

				test (cipher, plaintextZero, keyZero);
		}catch(IllegalArgumentException iae){
			System.err.println("The number of arguments is not the expected or the arguments are illegal");
			System.err.println("The format is Java Encrypt <key> <plaintext>");
			System.exit(1);
		}
		
		}
/*
 * This method calls encrypt
 * 
 */
	private static void test
	(BlockCipher cipher,
	 byte[] plaintext,
	 byte[] key)
	{
	byte[] ciphertext = (byte[]) plaintext.clone();
	cipher.setKey (key);
	cipher.encrypt (ciphertext);
	System.out.println (Hex.toString (ciphertext));
	}
	

	
	

}
