package chap1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        id = new int[N];
        count = N;
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId)
            return;
        for(int i = 0; i < id.length; i++) {
            if(id[i] == qId) {
                id[i] = pId;
            }
        }
        count--;
    }



}
