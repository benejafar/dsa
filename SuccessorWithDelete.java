public class SuccessorWithDelete{

    private int[] id;
    private int[] sz;
    private int[] specialIdList;

    public void createList(int n){
        id = new int[n];
        sz = new int[n];
        specialIdList = new int[n];

        for(int i = 0 ; i < n ; i++){
            id[i] = i;
            sz[i] = 1;
            specialIdList[i] = i;
        }

    }

    private int findRoot(int a ){
        while(a != id[a]){
            a = id[id[a]];
        }
        return a;
    }

    public void successorWithDeleteUnion(int a, int b){
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(rootA == rootB) return ;

        if(sz[rootA] < sz[rootB]){
            id[rootA] = rootB;
            sz[rootB] = sz[rootB] + sz[rootA];
        }

        else{
            id[rootB] = rootA;
            sz[rootA] = sz[rootA] + sz[rootB];
            specialIdList[rootA] = rootB;
        }
    }

    public void remove(int x){
        successorWithDeleteUnion(x,x+1);
    }

    public int successor(int x){
        return specialIdList[findRoot(x)];
    }


}