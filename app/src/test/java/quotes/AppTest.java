/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

        @Test void testApi() {
            String API= "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

            assertTrue(App.onlineQuotes(API)!= null);
        }

    }

