package explicativos;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class ErrorCollectorTest {


    @Test
    void teste() {

        String nome1 = "ed";
        String nome2 = "gar";
        String nome3 = nome1;

        //dessa forma é possivel observar todos os metodos que falaham e o porquê
        assertAll("erros ",
            () -> assertEquals(nome1, nome2),
            () -> assertNull(nome2),
            () -> assertNotEquals(nome3, nome1)
        );
    }
}
