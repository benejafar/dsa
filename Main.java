public class Main{
    public static void main(String[] args) {
        SuccessorWithDelete swd = new SuccessorWithDelete();
        swd.createList(10);
        swd.remove(5);
        swd.remove(6);
        System.out.println(swd.successor(5));
        // System.out.println(swd.successor(6));

        // SWD swd = new SWD();
        // swd.SuccessorWithDelete(10);
        // swd.remove(5);
        // swd.remove(6);
        // System.out.println(swd.successor(5));
    }
}