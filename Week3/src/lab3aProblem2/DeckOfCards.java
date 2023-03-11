// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards
{
   private Card deck[]; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator

   String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
           "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
   String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = 
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each Card, pick another random Card and swap them
      for ( int first = 0; first < deck.length; first++ ) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard

   private int[] totalHand(Card hand[]) {
      int[] facesCount = new int[13];
      for(int i=0; i<hand.length; i++) {
         for(int j=0; j<faces.length; j++) {
            if(hand[i].getFace().equals(faces[j])) {
               facesCount[j]++;
               break;
            }
         }
      }
      return facesCount;
   }

   private int checkTwo(Card hand[]) {
      int[] facesCount = totalHand(hand);
      int two = 0;
      for(int i=0; i<facesCount.length; i++) {
         if(facesCount[i]==2) two++;
      }
      return two; //0, 1 or 2
   }

   private int checkThree(Card hand[]) {
      int[] facesCount = totalHand(hand);
      for(int i=0; i<facesCount.length; i++) {
         if(facesCount[i]==3) return 1;
      }
      return 0; //0 or 1
   }

   public boolean pair(Card hand[]) {
      return checkTwo(hand)==1 && checkThree(hand)==0;
   }

   public boolean twoPairs(Card hand[]) {
      return checkTwo(hand)==2;
   }

   public boolean threeOfAKind(Card hand[]) {
      return checkTwo(hand)==0 && checkThree(hand)==1;
   }

   public boolean fourOfAKind(Card hand[]) {
      int[] facesCount = totalHand(hand);
      for(int i=0; i<facesCount.length; i++) {
         if(facesCount[i]==4) return true;
      }
      return false;
   }

   public boolean flush(Card hand[]) {
      String suit = hand[0].getSuit();
      for(int i=1; i<hand.length; i++) {
         if(!hand[i].getSuit().equals(suit)) return false;
      }
      return true;
   }

   public boolean straight() {
      //5 consecutive 1s, or 4 last 1s and one on first index (A, K, Q, J, 10)
      return false;
   }

   public boolean fullHouse(Card hand[]) {
      return checkTwo(hand)==1 && checkThree(hand)==1;
   }

} // end class DeckOfCards


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
