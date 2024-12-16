class ChatAndLaunchTheParrot0 {
    public static void main(String args[]) {
    Parrot0 parrot = new Parrot0 ("coco",4);
    blabla();
    blabla();
    parrot.run ();
    for (int n=0; n<3; n++) { try
    {Thread.sleep(1000);}
    catch (InterruptedException e) {
        System.out.println (e.getMessage ());
        System.exit(1); }
        blabla (); } }// end main
     private static void blabla() {
System.out.println("blabla"); } }// end class
 class Parrot0 {
private String cri = null;
private int fois = 0;
public Parrot0(String s, int i) {
    cri = s;
    fois = i;
}
     public void run () {
    for (int n=0; n<fois; n++) {
        try {
            Thread.sleep (1000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
            System.exit(1); }
    }
     }

 // end class

class ChatAndLaunchTheParrot2{
    public static void main(String args[]) {
        Parrot2 parrot = new Parrot2 ("coco",10);
        parrot.start();
        for (int n=0; n<10; n++) {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) { }
            blabla();
        }
    }
    private static void blabla() {
        System.out.println("blabla");
    }
}
class Parrot2 extends Thread{
    private String cri = null;
    private int fois = 0; public Parrot2 (String s, int i) {
        cri = s;
        fois = i;
    }
    public void run ( ){
        for (int n=0; n<fois; n++) {
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) { }
            System.out.println (cri);
        }
    }
}

class ChatAndLaunchTheParrot7 {
    public static void main(String args[]) {
        Parrot7 parrot = new Parrot7("coco",10);
        parrot.start();
        for (int n=0; n<10; n++) blabla();
    }
    private static void blabla() { System.out.println("blabla"); }
}
class Parrot7 extends Thread {
    private String cri = null;
    private int fois = 0;
    public Parrot7(String s, int i) {
        cri = s;
        fois = i;
    }
    public void repeter() { System.out.println(cri); }
    public void run() {
        for (int n=0; n<fois; n++) repeter();
    }
}

