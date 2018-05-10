public class Test {

    @org.junit.Test
    public void test(){
        System.out.println(123444 & 15);
        System.out.println(1231212121 & 15);
        System.out.println(1235677 & 15);
        System.out.println(123435 & 15);
        System.out.println(1232342223 & 15);

        System.out.println( 2 & 15);
        System.out.println(10  & 15);
        System.out.println(15 & 15);
    }


}
@FunctionalInterface
interface Print{
    static String get(String str){
        return str;
    }
    void print();
}

