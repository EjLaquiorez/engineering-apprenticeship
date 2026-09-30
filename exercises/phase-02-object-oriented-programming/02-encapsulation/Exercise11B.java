/*
 * Exercise 11B — Access Modifier Table
 *
 * Assume the classes are top-level classes. For protected, use the standard
 * Java rule, including access from subclasses.
 *
 * | Modifier  | Same class | Same package | Subclass | Other package |
 * |-----------|------------|--------------|----------|---------------|
 * | public    | ✅         | ✅           | ✅       | ✅            |
 * | protected | ✅         | ✅           | ✅       | ❌            |
 * | (none)    | ✅         | ✅           | ❌       | ❌            |
 * | private   | ✅         | ❌           | ❌       | ❌            |
 */
public class Exercise11B {

    static class TestClass {

        public int publicValue = 10;
        protected int protectedValue = 20;
        int packageValue = 30;
        private int privateValue = 40;
    }

    public static void main(String[] args) {

        TestClass test = new TestClass();

        // Test each field here
        System.out.println(test.publicValue);
        System.out.println(test.protectedValue);
        System.out.println(test.packageValue);
        // privateValue is accessible here because main is inside the enclosing class.
        // "private" restricts access to this class, not to public methods only.
        System.out.println(test.privateValue);
    }
}