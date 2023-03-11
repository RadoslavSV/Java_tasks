package Problem1;

public class DeckOfCardsTest
{
   public static void main( String args[] )
   {
      boolean _hearts = false, _diamonds = false, _spades = false, _clubs = false;
      int cnt = 0;
      while(!_diamonds || !_clubs || !_hearts || !_spades) {
         DeckOfCards myDeckOfCards = new DeckOfCards();
         myDeckOfCards.shuffle();
         Card currentCard = myDeckOfCards.dealCard();
         String currentSuit = currentCard.getSuit();

         if(currentSuit.equals("Clubs") && !_clubs) {
            System.out.printf("%s\n", currentCard);
            _clubs = true;
         } else if(currentSuit.equals("Diamonds") && !_diamonds) {
            System.out.printf("%s\n", currentCard);
            _diamonds = true;
         } else if(currentSuit.equals("Spades")  && !_spades) {
            System.out.printf("%s\n", currentCard);
            _spades = true;
         } else if(currentSuit.equals("Hearts") && !_hearts) {
            System.out.printf("%s\n", currentCard);
            _hearts = true;
         }

         cnt++;
      }

      System.out.printf("Number of picks: %d\n", cnt);

//      for ( int i = 0; i < 13; i++ )
//      {
//         System.out.printf( "%-20s%-20s%-20s%-20s\n",
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
//            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
//      }
   }
}


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
