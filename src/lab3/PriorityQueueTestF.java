

public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider(){
        return Stream.of(
                Arguments.arguments(new int[] {2,9,1,3},new int[] {1,4,5,9}),
                Arguments.arguments(new int[] {9,2,7,5},new int[] {2,3,1,9}),
                Arguments.arguments(new int[] {6,3,5,1},new int[] {2,4,6,8}),
                Arguments.arguments(new int[] {9,0,1,4},new int[] {1,5,3,2}),
                Arguments.arguments(new int[] {1,2,8,5},new int[] {1,0,0,0})
        );
    }
    @ParameterizedTest(
            name = "#{index} -Test with Argument={0},{1}"
    )
    @MethodSource({"stringIntAndListProvider"})
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        for(int i = 0; i < random_array.length; ++i) {test.add(random_array[i]);}

        for(int i = 0; i < random_array.length; ++i) {result[i] = (Integer)test.poll();}
        assertArrayEquals(correct_array, result);
    }

    @Test
    public void InitialCapacityTest() {
        Exception exception = (Exception)Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, (Comparator)null);
        });
    }

    @Test
    public void OfferTest() {
        Exception exception = (Exception)Assertions.assertThrows(NullPointerException.class, () -> {
            (new PriorityQueue()).offer((Object)null);
        });
    }

    @Test
    public void ForEachRemainingTest() {
        Exception exception = (Exception)Assertions.assertThrows(NullPointerException.class, () -> {
            (new PriorityQueue()).forEach((Consumer)null);
        });
    }
}
