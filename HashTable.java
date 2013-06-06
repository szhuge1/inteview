
import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {

  String[] theArray;
	int arraySize;
	int itemsInArray;

	public static void main(String[] args){

		HashTable hashTable = new HashTable(31);
//		String[] elementsToAdd = { "1", "5", "17", "21", "26" };
		
		 String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				                 "235", "802", "900", "723", "699", "1", "16", "999", "890",
				                 "725", "998", "978", "988", "990", "989", "984", "320", "321",
				                 "400", "415", "450", "50", "660", "624" };

	     String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
	        		                "210", "240", "270", "300", "330", "360", "390", "420", "450",
	        		                "480", "510", "540", "570", "600", "989", "984", "320", "321",
	        		                "400", "415", "450", "50", "660", "624" };


		hashTable.hasHashFunction2(elementsToAdd3, hashTable.theArray);
		hashTable.displayTheStack();
	}

	public HashTable (int size){

		this.arraySize = size;
		this.theArray = new String[size];
		Arrays.fill(this.theArray, "-1");
	}

	public void hasHashFunction1(String[] stringsForArray, String[] theArray){

		for(int n=0; n<stringsForArray.length; n++){

			String newElementVal = stringsForArray[n];
			theArray[Integer.parseInt(newElementVal)] = newElementVal;
		}
	}

	public void hasHashFunction2(String[] stringsForArray, String[] theArray){

		for(int n=0; n<stringsForArray.length; n++){

			String newElementVal = stringsForArray[n];
            int arrayIndex = Integer.parseInt(newElementVal) % arraySize; 
            System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);

            // Cycle through the array until we find an empty space
            while (theArray[arrayIndex] != "-1") {
                ++arrayIndex; 
                System.out.println("Collision Try " + arrayIndex + " Instead");

                // If we get to the end of the array go back to index 0
                arrayIndex %= arraySize;
            }
            theArray[arrayIndex] = newElementVal;
		}
	}
	
	public String findKey(String key){
		
		int arrayIndexHash = Integer.parseInt(key) % 29;

		while(theArray[arrayIndexHash] != "-1"){

            if (theArray[arrayIndexHash] == key) {

                // Found the key so return it
                System.out.println(key + " was found in index " + arrayIndexHash);

                return theArray[arrayIndexHash];
            }
            ++arrayIndexHash;

            // If we get to the end of the array go back to index 0
            arrayIndexHash %= arraySize;
		}
		
		return null;
	}
	
	public boolean isPrime (int number){
		
		if(number % 2 == 0) return false;
		
		for(int i=3; i*i<=number ; i+=2){
			if(number % i ==0){
				return false;
			}
		}
		
		return true;
	}
	
	public int getNextPrime(int minNumberToCheck){

		for (int i = minNumberToCheck; true; i++) {

			if (isPrime(i)) return i;
		}
	}
	
    // Increase array size to a prime number
    public void increaseArraySize(int minArraySize) {

        // Get a prime number bigger than the array requested
        int newArraySize = getNextPrime(minArraySize);

        // Move the array into a bigger array with the larger prime size
        moveOldArray(newArraySize);
    }
    
    public void moveOldArray(int newArraySize) {

        String[] cleanArray = removeEmptySpacesInArray(theArray);

        theArray = new String[newArraySize];
        arraySize = newArraySize;

        fillArrayWithNeg1();

        hasHashFunction2(cleanArray, theArray);
    }
    
    public String[] removeEmptySpacesInArray(String[] arrayToClean) {

        ArrayList<String> stringList = new ArrayList<String>();

        for (String theString : arrayToClean)
            if (!theString.equals("-1") && !theString.equals(""))
                stringList.add(theString);

        return stringList.toArray(new String[stringList.size()]);
    }
    
    public void fillArrayWithNeg1() {

        Arrays.fill(theArray, "-1");
    }

    public void displayTheStack() {

        int increment = 0;

        int numberOfRows = (arraySize / 10) + 1;

        for (int m = 0; m < numberOfRows; m++) {

            increment += 10;

            for (int n = 0; n < 71; n++) System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++) System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                if (n >= arraySize) System.out.print("|      ");

                else if (theArray[n].equals("-1")) System.out.print("|      ");

                else System.out.print(String.format("| %3s " + " ", theArray[n]));
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();
        }
    }


}
