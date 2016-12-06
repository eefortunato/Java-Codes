import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import edu.rit.util.Hex;
import edu.rit.util.Packing;


public class DecryptFile {

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
					
						
				}
			short [] newWords= {wordX, wordY};
			Packing.unpackShortBigEndian(newWords, 0, text, 0, 2);
	}
	
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		try{
			if (args.length != 3){
				throw new IllegalArgumentException();
			}
			else if(args[0].length()!=16){
				throw new Exception();
			}
			byte[] keyZero = Hex.toByteArray (args[0]);
			File ptfile = new File (args[2]);
			File ctfile = new File (args[1]);
			DecryptFile decryptor = new DecryptFile();
			decryptor.setKey (keyZero);
			InputStream ct = new BufferedInputStream (new FileInputStream (ctfile));
			OutputStream pt = new BufferedOutputStream (new FileOutputStream (ptfile));
			long fileLength = ctfile.length();
			byte [] theBytes=new byte [4];			
			int bytesRead=0;
			int bytesToAdd, t=0;
			while((bytesRead=ct.read(theBytes, 0, 4))!=-1){
				t+=bytesRead;
				if((fileLength-t) >= 4){
					decryptor.decrypt(theBytes);
					pt.write(theBytes);
					pt.flush();
				}
				else if((fileLength-t)==0){
					if((t&3)!=0){
						throw new IllegalArgumentException();
					}
					decryptor.decrypt(theBytes);
					if(theBytes[0]==Hex.toByte("80")){
						if(theBytes[1]!=00 || theBytes[2]!=00 || theBytes[3]!=00){
							throw new IllegalArgumentException();
							}
					}
					else if((theBytes[1]==Hex.toByte("80")) && theBytes[2]==00 && theBytes[3]==00){
						byte []withoutPadding= new byte[4];
						withoutPadding[0]=theBytes[0];
						withoutPadding[1]=0;
						withoutPadding[2]=0;
						withoutPadding[3]=0;
						pt.write(withoutPadding, 0, 1);
						pt.flush();
							}
					else if((theBytes[1]==Hex.toByte("80")) && (theBytes[2]!=00 || theBytes[3]!=00)){
							throw new IllegalArgumentException();
						}
					
					else if((theBytes[2]==Hex.toByte("80")) && theBytes[3]==00){
						byte []withoutPadding= new byte[4];
						withoutPadding[0]=theBytes[0];
						withoutPadding[1]= theBytes[1];
						withoutPadding[2]=0;
						withoutPadding[3]=0;
						pt.write(withoutPadding, 0, 2);
						pt.flush();
						}
					else if((theBytes[2]==Hex.toByte("80")) && theBytes[3]!=00){
							throw new IllegalArgumentException();
						}
					else if((theBytes[3]!=Hex.toByte("80"))){
								throw new IllegalArgumentException();
							}
					else if(theBytes[3]==Hex.toByte("80")){
						byte []withoutPadding= new byte[4];
						withoutPadding[0]=theBytes[0];
						withoutPadding[1]= theBytes[1];
						withoutPadding[2]= theBytes[2];
						withoutPadding[3]=0;
						pt.write(withoutPadding, 0, 3);
						pt.flush();
						}
				}			
			}			
			pt.close();
			ct.close();
		}catch(IllegalArgumentException iae){
			System.err.println("The number of arguments is not the expected or the arguments are illegal");
			System.err.println("The format is Java EncryptFile <key> <ctfile> <ptfile>");
			System.err.println ("<ctfile> = Ciphertext file name");
			System.err.println ("<ptfile> = Plaintext file name");
			System.err.println ("Key (16 hex digits)");
			System.exit(1);
		}catch(FileNotFoundException fnfe){
			System.err.println("Couldn't open the file");
			fnfe.getStackTrace();
			System.exit(1);
		}catch(IOException ioe){
			System.err.println("Couldn't write/read in/out the file");
			ioe.getStackTrace();
			System.exit(1);
		}catch(Exception e){
			System.err.println("Illegal size for key");
			System.exit(1);
		}

}

}
