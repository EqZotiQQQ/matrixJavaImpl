public class MyPair {
    protected int key;
    protected int value;
    public MyPair(int k, int v) {
        key = k;
        value = v;
    }
    public MyPair() {
        key = 0;
        value = 0;
    }
    public int getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
    public void setKey(int k) {
        key = k;
    }
    public void setValue(int v) {
        value = v;
    }
    @Override
    public String toString() {
        String str = "key: " + String.valueOf(key) + "; value: " + String.valueOf(value);
        return str;
    }
    //TODO hashcode
}
