package ben;


    public class InfernalRace1 {
        public  static void main(String[] args){
            Runner A = new Runner("A");
            Runner B = new Runner("B");
            A.start();
            B.start();

        } // end main
    } // end class InfernalRace1
    class Runner extends Thread {
        String name;
        Runner(String name) {
            super(name);
            this.name=name;
        }

        public void run() {
            long PedalStroke = 0;
            while (PedalStroke < 5000000) {
                PedalStroke++;
                System.out.printf("%d strokes count", PedalStroke);
                if ((PedalStroke % 500000) == 0) {
                    System.out.println("Runner " + name + " performs " + PedalStroke +
                            " pedal strokes.");
                } // end if
            } // end while
        }// end run
    }

