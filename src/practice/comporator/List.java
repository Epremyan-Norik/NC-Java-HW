package practice.comporator;

public class List {
    private int value;
    private List next = null;

    public List(int value){
        this.value = value;
    }

    public List(int value, List list){
        this.value = value;
        this.next = list;
    }

    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public void setNext(List list){
        this.next = list;
    }

    public List getNext() {
        return next;
    }
}
