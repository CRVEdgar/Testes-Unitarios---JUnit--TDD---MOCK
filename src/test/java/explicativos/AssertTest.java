package explicativos;

import entidades.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {

    @Test
    public void teste() {
        assertTrue(true); //verifica se o parametro é verdadeiro
        assertFalse(false); //verifica se o parametro é falso

        //comparação de numeros
        assertEquals(1,1, "Mensagem caso de erro"); //verifica se os parametros são iguais
        assertEquals(0.51, 0.51); //verifica se os parametros double são iguais
        assertEquals(Math.PI, 3.14, 0.01); //delta[0.01] indica a quantidade de digitos após a virgula devem ser considerados

        //comparacao de tipos primitivos - a comparação deve ser feita por objetos do mesmo tipo ou deve ser feito um wrap(cast)
        int i = 5;
        Integer i2 = 5;
        assertEquals(Integer.valueOf(i), i2);
        assertEquals(i, i2.intValue());

        //COMPARACAO DE STRING
        assertEquals("bola","bola");
        assertTrue("bola".equalsIgnoreCase("Bola")); //ignora case sensitive
        assertTrue("bola".startsWith("bo")); //compara por radical

        //COMPARACAO POR OBJETOS - é comparado se os objetos são a mesma instancia - exceto nos casos em que o objeto tiver uma classe de equals/hashcode
        Usuario u1 = new Usuario("user 1");
        Usuario u2 = new Usuario("user 1");
        Usuario u3 = u2;
        Usuario u4 = null;

        assertEquals(u1,u2);// - nesse caso iria falhar se o metodo equals nao estivesse implementado na classe Usuario
        assertSame(u3,u2); // compara se os objetos sao da mesma instancia
        assertNull(u4);

        //ASSERTIVAS DE NEGACAO
        assertNotEquals(1,2);
        assertNotSame(u1,u2);
        assertNotNull(u3);

    }
}
