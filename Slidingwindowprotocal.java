package slidingwindowprotocal;
public class Slidingwindowprotocal {
    private int windowsize;
    private int[] frames;
    private boolean[] ack;
    public Slidingwindowprotocal(int windowsize,int framecount){
        this.windowsize=windowsize;
        this.frames=new int[framecount];
        this.ack=new boolean[framecount];
        for(int i=0;i<framecount;i++){
            frames[i]=i;
            ack[i]=false;
        }
    }
    
    public void sendframes(){
        int sendindex=0;
        while(sendindex<frames.length){
            for(int i=0;i<windowsize && (sendindex+i)<frames.length;i++){
                System.out.println("sending frame:"+frames[sendindex+i]);
            }
            for(int i=0;i<windowsize && (sendindex+i)<frames.length;i++){
                ack[sendindex+i]=receiveack(sendindex+i);
            }
            while(sendindex<frames.length&& ack[sendindex]){
                sendindex++;
            }
        } 
    }
    
    private boolean receiveack(int frames){
        System.out.println("Receving ack for frames:"+frames);
        return true;
    }

    public static void main(String[] args) {
        int windowsize=4;
        int framecount=10;
        Slidingwindowprotocal swp=new Slidingwindowprotocal(windowsize,framecount);
        swp.sendframes();
    }
    
}
