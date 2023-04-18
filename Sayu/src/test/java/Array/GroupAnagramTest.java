package Array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class GroupAnagramTest {
    @Test
    public void act() {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> actualList = new GroupAnagram(strings).play();

        List<List<String>> expectedList = new ArrayList<>() {{
            add(List.of("tan", "nat"));
            add(List.of("bat"));
            add(List.of("eat", "tea", "ate"));
        }};

        assertEquals(actualList, expectedList);
    }
}