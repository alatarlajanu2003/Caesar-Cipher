import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CaesarTest {
   private String inputString;
   private String expectedString;
   private Caesar caesar;
   
   @Parameters
   public static Collection strings() {
      return Arrays.asList(new Object[][] {
         { "HELLO", "IFMMP" },
         { "A", "B"},
         { "COOL", "DPPM"},
         { "BYE", "CZF"},
         { "SuPeR", "TvQfS"}
      });
   }

   @Before
   public void initialize() {
      caesar = new Caesar(1);
   }

   public CaesarTest(String inputString, String expectedString)
   {
      this.inputString = inputString;
      this.expectedString = expectedString;
   }

   @Test
   public void testCaesarEn() {
      assertEquals(expectedString, 
      caesar.cipher(inputString));
   }

    @Test
   public void testCaesarDec() {
      assertEquals(inputString, 
      caesar.decipher(expectedString));
   }
}
