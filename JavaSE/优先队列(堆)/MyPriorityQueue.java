import java.util.Arrays;
/**
 * 自己实现一个优先队列
 * 采用大根堆的方式
 * 如果想要小根堆 修改 调整的方法中的判断形式即可
 */
public class MyPriorityQueue {
    private int[] elem;
    private int usedSize;

    public MyPriorityQueue(){
        this.elem = new int[10];
    }

    /**
     *  向下调整
     *  时间复杂度：O(logn)
     */
    public void adjustDown(int parent,int len){
        int child = 2*parent+1;
        //child < len 即不需要调整 也可以用循环的方式
        if(child < len){
            if(child + 1< len){
                child = this.elem[child]>this.elem[child+1]?child:child+1;
            }
            if(this.elem[parent] < this.elem[child]){
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                adjustDown(child,len);
            }
        }
    }

    /**
     * 向上调整（当添加元素时）
     * @param child
     */
    public void adjustUp(int child){
        int parent = (child-1)/2;
        while(child != 0){
            if(this.elem[parent] < this.elem[child]){
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }
    //创建大堆
    /**
     * 创建堆的时间复杂度：看起来像是O(logn)
     *                  但是数学公式推导结果是O(n)
     * @param array
     */

    public void createBigHeap(int... array){
        for(int i = 0;i < array.length;i++){
            this.elem[i] = array[i];
            this.usedSize++;
        }
        //从最后一颗子树开始向下调整
        for(int i = (this.usedSize-1-1)/2;i >=0 ;i--){
            adjustDown(i,this.usedSize);
        }
    }

    /**
     * 放到数组的最后一个位置，然后向上调整
     * @param value
     */
    public void add(int value){
        if(this.isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length );
        }
        this.elem[this.usedSize] = value;
        this.usedSize++;
        this.adjustUp(this.usedSize-1);
    }
    //返回对头元素
    public int peek(){
        return elem[0];
    }

    //出队
    public int poll(){
        int ret = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return ret;
    }
    
    //展示
    public void show(){
        for(int i = 0;i < this.usedSize;i++){
            System.out.print(this.elem[i] +   "  ");
        }
        System.out.println();
    }
    
    private boolean isFull(){
        return this.usedSize == this.elem.length;
    }
}