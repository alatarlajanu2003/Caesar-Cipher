import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class CaesarTestHamcrest {
   private String inputString;
   private String expectedString;
   private Caesar caesar;
   private int n;
   
   @Parameters
   public static Collection strings() {
      return Arrays.asList(new Object[][] {
         { "HELLO", "IFMMP",1},
         { "A", "C", 2},
         { "COOL", "FRRO", 3},
         { "BYE", "FCI", 4},
         { "SuPeR", "TvQfS", 1}
      });
   }

      @Before
      public void initialize() {
      caesar = new Caesar(n);
   }

   public CaesarTestHamcrest(String inputString, String expectedString, int n)
   {
      this.inputString = inputString;
      this.expectedString = expectedString;
      this.n = n;
   }

      @Test
      public void testCaesarEn() 
      {
        assertThat(expectedString, 
        is(caesar.cipher(inputString)));
      }

      @Test
      public void testCaesarDec() 
      {
        assertThat(inputString, 
        is(caesar.decipher(expectedString)));
      }

    @Test(expected = IllegalArgumentException.class)
        public void testCaesarExceptions()
        {
        String s =";KJ";
        assertThat("hello", is(caesar.cipher(s)));
        s ="вщфыви";
        assertThat("hello", is(caesar.cipher(s)));
        }

}