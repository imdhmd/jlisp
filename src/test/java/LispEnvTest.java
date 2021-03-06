import com.f1codz.jlisp.environment.LispEnv;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LispEnvTest {
    private LispEnv lispEnv;

    @Before
    public void setUp(){
        lispEnv = new LispEnv();
    }

    @Test
    public void shouldEvaluateListExpressionAndReturnResult_One() {
        String lisp = "(+ (+ 1 2 (+ 3 4)) 6)";

        String result = lispEnv.eval(lisp);

        assertEquals((Double) 16.0, Double.valueOf(result));
    }

    @Test
    public void shouldEvaluateListExpressionAndReturnResult_Two() {
        String lisp = "(+   'hello'    ', '   'world')";

        String result = lispEnv.eval(lisp);

        assertEquals("'hello, world'", result);
    }

    @Test
    public void shouldEvaluateListExpressionAndReturnResult_Three() {
        String lisp = "(* (* 1 2 (* 3 4)) 5)";

        String result = lispEnv.eval(lisp);

        assertEquals((Double) 120.0, Double.valueOf(result));
    }

    @Test
    public void shouldEvaluateListExpressionAndReturnResult_Four() {
        String lisp = "(- (- 1 2 (* 3 4)) 5)";
        Double expected = -18D;

        String result = lispEnv.eval(lisp);

        assertEquals(expected, Double.valueOf(result));

    }
    
    @Test
    public void shouldEvaluateListExpressionAndReturnResult_Five() {
        String lisp = "(/ 15 3)";
        String expected = "5";

        String result = lispEnv.eval(lisp);

        assertEquals(expected, result);
    }

    @Test
    public void shouldEvaluateListExpressionAndReturnResult_six() {
        String lisp = "(/ 15 27)";
        String expected = "5/9";

        String result = lispEnv.eval(lisp);

        assertEquals(expected, result);
    }
}
