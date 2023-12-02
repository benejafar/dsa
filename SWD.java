public class SWD {
    private int id[];
    private int sz[];
    private int actualList[];
    private int N;

    public void SuccessorWithDelete(int N){
        this.N = N;
        id = new int[N];
        sz = new int[N];
        actualList = new int[N];
        for(int i=0; i<N; i++){
            id[i] = i;
            sz[i] = 1;
            actualList[i] = i;
        }
    }

    // returns the root of the component the integer is in
    private int root(int i){
        while(id[i]!=i){

            i = id[i];
        }
        return i;
    }

    // weighted quick union
    public void union(Integer p, Integer q) {

        int pRoot = root(p);
        int qRoot = root(q);
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] =  qRoot;
            sz[qRoot] = sz[qRoot] + sz[pRoot];

        } else {
            id[qRoot] = pRoot;
            sz[pRoot] = sz[pRoot] + sz[qRoot];
            actualList[pRoot] = qRoot;              // this is the crucial step
        }
    }


    public void remove(int x){
        union(x, x+1);

    }

    public int successor(int x){
        return actualList[(root(x+1))];
    }
}
