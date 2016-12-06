
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.rit.util.Hex;
import edu.rit.util.Packing;


public class Attack {

	

	private static short subkeywinner = 0;
	private static short subkey2winner = 0;
	private static short subkey3winner = 0;
	private static short subkeycombinations;
	private static short subkey2combinations;
	private static short subkey3combinations;
	private static short [] subkeys = new short[3];
	
	
	private static int minourcounter=0;
	
	
	
	public static boolean checkSubkey(short [] combinations, ArrayList<String> plaintText, ArrayList<String> cipherText){
		byte [] plain2= new byte[4];
		short guessX=0, guessY=0;
		minourcounter=0;
		for(int index=0; index < plaintText.size(); index++){
			
			plain2 = Hex.toByteArray(plaintText.get(index));
			
				guessX=Packing.packShortBigEndian(plain2, 0);
				guessY=Packing.packShortBigEndian(plain2, 2);
				for(int k=0; k <= 2; k++){
					guessX = (short)((((((guessX&0xFFFF) >>> 7) | ((guessX&0xFFFF) << (Short.SIZE - 7))) + guessY) ^ combinations[k]));
					guessY = (short)((((guessY&0xFFFF) << 2) | ((guessY&0xFFFF) >>> (Short.SIZE - 2))) ^ guessX);
				
				}
				if((Hex.toString(guessX)+Hex.toString(guessY)).equals(cipherText.get(index))){											
					minourcounter++;											
				
				}
				if(minourcounter==cipherText.size()){
					
					return true;
				
				}
															
				
			
			
		}
		return false;
		
	}
	
	public static void guessSubkey(String plaintText, String cipherText, ArrayList<String> plain, ArrayList<String> ciphers)throws Exception{
		
	
		byte [] plaint = new byte[4];
		byte [] ciphert = new byte[4];
		
			plaint = Hex.toByteArray(plaintText);
			if(Hex.toString(plaint).length()!=8){
				throw new Exception();
			}
			short guessX=Packing.packShortBigEndian(plaint, 0);
			short guessY=Packing.packShortBigEndian(plaint, 2);
			short initialX= guessX;
			short initialY= guessY;
			ciphert = Hex.toByteArray(cipherText);
			if(Hex.toString(ciphert).length()!=8){
				throw new Exception();
			}
			short guessZ=Packing.packShortBigEndian(ciphert, 0);
			short guessA=Packing.packShortBigEndian(ciphert, 2);
			short guessY2=0;
			short guessX1=0;
			short guessY1=0;
			short guessX2=0;
			guessY2= (short)((((guessZ ^ guessA)&0xFFFF) >>> 2) |(((guessZ ^ guessA)&0xFFFF) << (Short.SIZE - 2)));
			for(int j= -32768; j < 32767; j++){										
					subkeycombinations = (short)j;
							
							guessX1=(short)((((((initialX&0xFFFF) >>> 7) | ((initialX&0xFFFF) << (Short.SIZE - 7))) + initialY) ^ subkeycombinations));		
							guessY1=(short)((((initialY&0xFFFF) << 2) | ((initialY&0xFFFF) >>> (Short.SIZE - 2))) ^ guessX1);
							guessX2=(short)((((guessY1&0xFFFF) << 2 ) |((guessY1&0xFFFF) >>> (Short.SIZE-2))) ^  guessY2);	
								subkey2combinations=(short) (((((guessX1&0xFFFF) >>> 7) |((guessX1&0xFFFF) << (Short.SIZE-7))) + guessY1) ^ guessX2);
								subkey3combinations= (short) (((((guessX2&0xFFFF) >>> 7) |((guessX2&0xFFFF) << (Short.SIZE-7))) + guessY2) ^ guessZ);
								subkeys[0]=subkeycombinations;
								subkeys[1]=subkey2combinations;
								subkeys[2]=subkey3combinations;
								if(checkSubkey(subkeys, plain, ciphers)){
									subkeywinner= subkeys[0];
									subkey2winner=subkeys[1];
									subkey3winner=subkeys[2];
								}					
			}
		}		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length !=1){
			throw new IllegalArgumentException();
		}
		File pairsfile = new File (args[0]);
		Scanner pt=null;
		try {
			pt = new Scanner(pairsfile);
		
		
		ArrayList<String> pairs = new ArrayList<String>();
		ArrayList<String> plain = new ArrayList<String>();
		ArrayList<String> cipher = new ArrayList<String>();
		String [] withoutSpaces = new String[2];
		
		int filecounter=0;
		while(pt.hasNextLine()){
			pairs.add(pt.nextLine());
			withoutSpaces= pairs.get(filecounter).split("\\s+");
			plain.add(withoutSpaces[0]);
			cipher.add(withoutSpaces[1]);
			filecounter++;
		}
		for(int i=0; i < plain.size(); i++){
			guessSubkey(plain.get(i), cipher.get(i), plain, cipher);
		}

			System.out.println(Hex.toString(subkeywinner));
			System.out.println(Hex.toString(subkey2winner));
			System.out.println(Hex.toString(subkey3winner));
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't open the file");
			e.getStackTrace();
			System.exit(1);
		}catch(IllegalArgumentException iae){
				System.err.println("The number of arguments is not the expected or the arguments are illegal");
				System.err.println("The format is Java Attack <file>");
				System.err.println ("<file> = file with plaintext and ciphertext pairs");
				System.exit(1);
			}catch(IOException ioe){
				System.err.println("Couldn't write/read in/out the file");
				ioe.getStackTrace();
				System.exit(1);
			}catch(Exception e){
				System.err.println("Illegal size for plaintext/ciphertext");
				System.exit(1);
			}
		
	}

}

