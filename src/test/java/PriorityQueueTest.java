import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider(){
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{0, 3, 2}, new int[]{0, 2, 3}),
                Arguments.of(new int[]{5, 6, 2}, new int[]{2, 5, 6}),
                Arguments.of(new int[]{1, 2, 7}, new int[]{1, 2, 7}),
                Arguments.of(new int[]{4, 1, 2}, new int[]{1, 2, 4})
        );
    }
    @ParameterizedTest(name = "#{index} - Test with Argument = {0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueqe_Runtest(int [] r_array , int[] cor_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int [] result = new int[r_array.length];
        for(int i = 0 ; i < r_array.length;i++)
        {
            test.add(r_array[i]);
        }
        for(int i = 0 ; i < r_array.length;i++)
        {
            result[i] = test.poll();
        }
        assertArrayEquals(cor_array,result);
    }
    @Test
    public void Test_Exception_DoesNotHaveNext(){
        assertThrows(NoSuchElementException.class, ()->{
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            Iterator<Integer> iterator = test.iterator();
            iterator.next();
        });
    }
    @Test
    public void Test_Exception_IllegalArgument(){
        assertThrows(IllegalArgumentException.class, ()->{
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(0);
        });
    }

    @Test
    public void Test_Exception_NullPointer(){
        assertThrows(NullPointerException.class, ()->{
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            Integer i = null;
            test.add(i);
        });
    }
}
