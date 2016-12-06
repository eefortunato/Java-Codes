import edu.rit.util.Hex;
import edu.rit.util.Packing;
/**
 * This is the Eecrypt.java class that implements the decryption algorithm for Speck32/64 block cipher
 * @author Eric Fortunato
 *
 */

public class Decrypt implements BlockCipher{

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
	
	}

	/*
	 * (non-Javadoc)
	 * @see BlockCipher#decrypt(byte[])
	 */
	public void decrypt(byte[] text) {
		// TODO Auto-generated method stub
		
		short wordX = Packing.packShortBigEndian(text, 0);
		short wordY = Packing.packShortBigEndian(text, 2);
				for(int i=21; i >= 0; i--){					
					
					
					wordY = (short)(wordX ^ wordY);
					wordY =	(short)(((wordY&0xFFFF) >>> 2)|((wordY&0xFFFF) << (Short.SIZE-2)));
					wordX = (short)(wordX ^ subkey[i]);
					wordX =	(short)	((((wordX-wordY)&0xFFFF) << 7) | (((wordX -wordY)&0xFFFF) >>> (Short.SIZE-7)));
					if(i >= 19){
						System.out.println(Hex.toString(wordX) + " X " + Hex.toString(wordY) + " Y "  + Hex.toString(subkey[i]) + " subkey ");	
					}	
				}
			short [] newWords= {wordX, wordY};
			Packing.unpackShortBigEndian(newWords, 0, text, 0, 2);
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BlockCipher cipher = new Decrypt();
		try{
			if(args.length !=2){
				throw new IllegalArgumentException();
			}
			byte[] keyZero = Hex.toByteArray(args[0]);
			byte[] plaintextZero = Hex.toByteArray(args[1]);


				test (cipher, plaintextZero, keyZero);
		}catch(IllegalArgumentException iae){
			System.err.println("The number of arguments is not the expected or the arguments are illegal");
			System.err.println("The format is Java Decrypt <key> <ciphertext>");
			System.exit(1);
		}
		
		}

	private static void test
	(BlockCipher cipher,
	 byte[] plaintext,
	 byte[] key)
	{
	byte[] ciphertext = (byte[]) plaintext.clone();
	cipher.setKey (key);
	cipher.decrypt(ciphertext);
	System.out.println (Hex.toString (ciphertext));
	}
	

}
